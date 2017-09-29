<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);"
		action="express_listDelivery.action" method="post">
		    <%@include file="/page/inc/pageForm.jsp"%>
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>订单号： <input type="text" name="orderId"
						value="${express.orderId}" />
					</td>
					<td>商品名： <input type="text" name="shopName"
						value="${express.shopName}" />
					</td>
					<td>发货状态： <select name="deliveryStatus">
							<option value="">请选择</option>
							<c:forEach items="${statusEnums}" var="statusVar">
								<option value="${statusVar.key}"
									<c:if test="${express.deliveryStatus == statusVar.key}"> selected="selected"</c:if>>${statusVar.value.desc}</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td>下单开始日期:<input type="text" name="orderDateBegin"
						value="${express.orderDateBegin}" class="date textInput readonly"
						readonly="true">
					</td>
					<td>下单结束日期:<input type="text" name="orderDateEnd"
						value="${express.orderDateEnd}" class="date textInput readonly"
						readonly="true">
					</td>
					<td>
						<div class="buttonActive">
							<div class="buttonContent">
								<button title="查询" type="submit">查&nbsp;询</button>
							</div>
						</div>
					</td>
					<td><a href="##" onclick="douwnExcel()" title="确认【下载】"  style="color: blue">导出excel</a></td>
				</tr>
			</table>
		</div>
	</form>
</div>
<div class="pageContent" style="overflow: scroll;">
	<table class="table" width="100%" layoutH="135">
		<thead>
			<tr>
				<th width="5%">序号</th>
				<th width="9%">商户订单号</th>
				<th width="5%">收件人</th>
				<th width="6%">手机号</th>
				<th width="3%">邮编号</th>
				<th width="3%">省</th>
				<th width="3%">市</th>
				<th width="3%">区</th>
				<th width="6%">详细地址</th>
				<th width="6%">快递单号</th>
				<th width="6%">发货状态</th>
				<th width="3%">操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="recordList" status="st">
				<tr>
					<td>${st.index+1}</td>
					<td>${orderId}</td>
					<!--         <td> -->
					<%--           <fmt:parseNumber type="number" pattern="#,#00.0#">${price}</fmt:parseNumber> --%>
					<!--         </td> -->

					<td>${recipentsName}</td>
					<td>${phoneNum}</td>
					<td>${zipCode}</td>
					<td>${provinceName}</td>
					<td>${cityName}</td>
					<td>${districtName}</td>
					<td>${addressDetils}</td>
					<td><c:if test="${deliveryStatus eq 'SENT_EXPERSS' }">${courierNumber}</c:if>
						<c:if test="${deliveryStatus eq 'NO_SENT_EXPERSS'}">
							<input id="${st.index+1}" type="text" name="courierNumber" />
						</c:if></td>
					<td><c:forEach items="${statusEnums}" var="statusVar">
							<c:if test="${deliveryStatus == statusVar.key}">${statusVar.value.desc}</c:if>
						</c:forEach></td>
					<td><c:if test="${deliveryStatus eq 'SENT_EXPERSS' }"></c:if>
						<c:if test="${deliveryStatus eq 'NO_SENT_EXPERSS' }">[<a
								href="##" onclick="submit('${orderId}','${st.index+1}')"
								title="确认【发货】"  style="color: blue">确认</a>]&nbsp;&nbsp;	
									</c:if>
									[<a href="order_seeDeliveryOrderDetials.action?orderId=${orderId}" title="查看" target="dialog" width="550" height="300" rel="input"  style="color:blue">查看</a>]
					</td>
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
	function submit(obj1, obj2) {
		var a = $("#" + obj2).val();
		if (a == '' || a == "" || a == null) {
			alert("订单号不能为空");
			return;
		}
		if (a.length < 9) {
			alert("订单号输入有误");
			return;
		}
		var b= "express_addDelivery.action?orderId=" + obj1
				+ "&courierNumber=" + a;
		ajaxTodo(b);
	}
	function douwnExcel(){
		var b="express_downLoadByContidions.action?"+$('#pagerForm').serialize();
// 		ajaxTodo(b);
		location.href=b;
	}
	
</script>
