<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);"
		action="access_listAccessList.action" method="post">
		<%@include file="/page/inc/pageForm.jsp"%>
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>访问开始日期:<input type="text" name="orderDateBegin"
						value="${access.orderDateBegin}" class="date textInput readonly"
						readonly="true">
					</td>
					<td>访问结束日期:<input type="text" name="orderDateEnd"
						value="${access.orderDateEnd}" class="date textInput readonly"
						readonly="true">
					</td>
					<td>访问类型: <select name="type">
							<option value="">请选择</option>
							<c:forEach items="${AccessEnumList}" var="statusVar">
								<option value="${statusVar.desc}"
									<c:if test="${access.type == statusVar.desc}"> selected="selected"</c:if>>${statusVar.desc}</option>
							</c:forEach>
					</select>
					</td>
					<td>商品名称：<input type="text" name="shopName"
						value="${access.shopName}" size="30" alt="模糊查询" />
					</td>
					<td>商品编号：<input type="text" name="shopNumber"
						value="${access.shopNumber}" size="30" alt="模糊查询" />
					</td>
					
				</tr>
				<tr>
				<td>商家编号：<input type="text" name="storeNumber"
						value="${access.storeNumber}" size="30" alt="模糊查询" />
					</td>
					<td>省： <select name="privince" id="province">
							<option value="">请选择</option>
							<c:forEach items="${province}" var="statusVar">
								<option value="${statusVar.id}"
									<c:if test="${access.privince == statusVar.provinceName}"> selected="selected"</c:if>>${statusVar.provinceName}</option>
							</c:forEach>
					</select>
					</td>
					<td>市： <select name="city" id="city">
							<option value="">请选择</option>
					</select>
					</td>
					<td>区： <select name="county" id="district">
							<option value="">请选择</option>
					</select>
					</td>
					<td>
						<div class="buttonActive">
							<div class="buttonContent">
								<button title="查询" type="submit">查&nbsp;询</button>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>
<div class="pageContent" style="overflow: scroll;">
	<table class="table" width="100%" layoutH="300">
		<thead>
			<tr>
				<th width="5%">序号</th>
				<th width="5%">类型</th>
				<th width="9%">商品名</th>
				<th width="5%">商品编号</th>
				<th width="5%">商店名</th>
				<th width="5%">商店编号</th>
				<th width="5%">省</th>
				<th width="5%">市</th>
				<th width="5%">区</th>
				<th width="5%">访问时间</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="recordList" status="st">
				<tr>
					<td>${st.index+1}</td>
					<td>${type}</td>
					<td>${shopName}</td>
					<td>${shopNumber}</td>
					<td>${storeName}</td>
					<td>${storeNumber}</td>
					<td>${privince}</td>
					<td>${city}</td>
					<td>${county}</td>
					<td><fmt:formatDate value="${createTime}"
							pattern="yyyy-MM-dd HH:mm:ss" />
				</tr>
			</s:iterator>
			<c:if test="${pageBean.totalCount==0}">
				<tr>
					<td>暂无数据</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	<%@include file="/page/inc/pageBar.jsp"%>
</div>
<script type="text/javascript">
	function submitForms() {
		var province = $("#province").find("option:selected").text()
		var district = $("#district").find("option:selected").text();
		if (province == '请选择') {
			province = "";
		}
		if (district == '请选择') {
			district = ""
		}
		var city = $("#city").find("option:selected").text();
		if (city == '请选择') {
			city = "";
		}
		$("#province").find("option:selected").val(province);
		$("#district").find("option:selected").val(district);
		$("#city").find("option:selected").val(city);
		$("#pagerForm").submit();
	}
	$(document)
			.ready(
					function() {
						//获取城市
						$('#province')
								.change(
										function() {
											var p1 = $(this).children(
													'option:selected').val();//这就是selected的值
											$("#district")
													.html(
															"<option selected='selected' value='请选择'>请选择</option>");
											$
													.ajax({
														type : "POST",
														url : "ajax_getAllCity.action",
														dataType : "json",// (可以不写,默认)
														data : {
															provinceId : p1
														},
														beforeSend : function(
																XMLHttpRequest) {
														},
														success : function(
																datas,
																textStatus) {
															htmls = "<option selected='selected' value='请选择'>请选择</option>";
															datas = eval('('
																	+ datas
																	+ ')');
															for (var i = 0; i < datas.length; i++) {
																htmls += "<option  value='"+datas[i].id+"'>"
																		+ datas[i].cityName
																		+ "</option>";
															}
															$("#city").html(
																	htmls);
														},
														complete : function(
																XMLHttpRequest,
																textStatus) {
														},
														error : function() {
														}
													});
										})
						//获取区域
						$('#city')
								.change(
										function() {
											var p1 = $(this).children(
													'option:selected').val();//这就是selected的值
											// 							$("#district").html("<option selected='selected' value='请选择'>请选择</option>");
											$
													.ajax({
														type : "POST",
														url : "ajax_getAllDistrict.action",
														dataType : "json",// (可以不写,默认)
														data : {
															cityId : p1
														},
														beforeSend : function(
																XMLHttpRequest) {
														},
														success : function(
																datas,
																textStatus) {
															htmls = "<option selected='selected' value='请选择'>请选择</option>";
															datas = eval('('
																	+ datas
																	+ ')');
															for (var i = 0; i < datas.length; i++) {
																htmls += "<option  value='"+datas[i].id+"'>"
																		+ datas[i].districtName
																		+ "</option>";
															}
															$("#district")
																	.html(htmls);
														},
														complete : function(
																XMLHttpRequest,
																textStatus) {
														},
														error : function() {
														}
													});
										})
					})
</script>