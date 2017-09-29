<%-- 权限模块:权限（功能点）管理:分页查看页面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);"
		action="youxuan_listYouXuan.action" method="post">
		<!-- 分页表单参数 -->
		<%@include file="/page/inc/pageForm.jsp"%>
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>商品编号：<input type="text" name="shopNumber"
						value="${youXuan.shopNumber}" size="30" alt="模糊查询" />
					</td>
					<td>省： <select name="provinceName" id="province">
							<option value="">请选择</option>
							<c:forEach items="${province}" var="statusVar">
								<option value="${statusVar.id}"
									<c:if test="${youXuan.provinceName == statusVar.provinceName}"> selected="selected"</c:if>>${statusVar.provinceName}</option>
							</c:forEach>
					</select>
					</td>
					<td>市： <select name="city" id="city">
							<option value="">请选择</option>
					</select>
					</td>
					<td>区： <select name="districtName" id="district">
							<option value="">请选择</option>
					</select>
					</td>

				</tr>
				<tr>
					<td>商家编号：<input type="text" name="storeNumber"
						value="${youXuan.storeNumber}" size="30" alt="模糊查询" />
					</td>
					<td>商家名：<input type="text" name="storeName"
						value="${youXuan.storeNumber}" size="30" alt="模糊查询" />
					</td>
					<td>
						<div class="subBar">
							<ul>
								<li><div class="buttonActive">
										<div class="buttonContent">
											<!-- 											<button type="submit">查询</button> -->
											<button onClick="submitForms()">查询</button>
										</div>
									</div></li>
								<li><a href="youxuan_readyInsert.action" title="查看"
									target="dialog" width="550" height="300" rel="input"
									style="color: blue">优选添加</a></li>
							</ul>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>
<div class="pageContent">
	<table class="table" targetType="navTab" asc="asc" desc="desc"
		width="100%" layoutH="131">
		<thead>
			<tr>
				<th>序号</th>
				<th>商品名字</th>
				<th>商品编号</th>
				<th>商家名</th>
				<th>商家编号</th>
				<th>省</th>
				<th>市</th>
				<th>区</th>
				<th>添加时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="recordList" status="st">
				<tr target="sid_user" rel="${id}">
					<td>${st.index+1}</td>
					<td>${shopName}</td>
					<td>${shopNumber}</td>
					<td>${storeName}</td>
					<td>${storeNumber}</td>
					<td>${provinceName}</td>
					<td>${city}</td>
					<td>${districtName}</td>
					<td><fmt:formatDate value="${createTime }"
							pattern="yyyy-MM-dd" /></td>
					<td>[<a href="youxuan_readyUpdate.action?id=${id}" title="查看"
						target="dialog" width="550" height="300" rel="input"
						style="color: blue">查看</a>]&nbsp;&nbsp; [<a
						href="youxuan_deleteByYouXuanId.action?id=${id}"
						title="删除【${theme }】" target="ajaxTodo" style="color: blue">删除</a>]&nbsp;&nbsp;
						<c:if test="${you_Status==100}">[<a
								href="youxuan_changeStatus.action?id=${id}&you_Status=101"
								title="确认【下架】" target="ajaxTodo" style="color: blue">下架</a>]</c:if> <c:if
							test="${you_Status==101}">[<a
								href="youxuan_changeStatus.action?id=${id}&you_Status=100"
								title="确认【恢复冻结】" target="ajaxTodo" style="color: blue">上架</a>]</c:if>
					</td>
				</tr>
			</s:iterator>

		</tbody>
	</table>
	<!-- 分页条 -->
	<%@include file="/page/inc/pageBar.jsp"%>
</div>
<script type="text/javascript">
	function submitForms() {
		var province=$("#province").find("option:selected").text()
		var district=$("#district").find("option:selected").text();
		if (province == '请选择') {
			province="";
		}
		if ( district == '请选择') {
			district=""
		}
		var city = $("#city").find("option:selected").text();
		if (city == '请选择') {
			city="";
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
