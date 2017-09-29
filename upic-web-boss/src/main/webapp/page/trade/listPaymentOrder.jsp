<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);"
		action="order_listOrder.action" method="post">
		<%@include file="/page/inc/pageForm.jsp"%>
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>订单号： <input type="text" name="orderId"
						value="${order.orderId}" />
					</td>
					<td>商户号： <input type="text" name="storeNumber"
						value="${order.storeNumber}" />
					</td>
					<td>状态： <select name="status">
							<option value="">请选择</option>
							<c:forEach items="${statusEnums}" var="statusVar">
								<option value="${statusVar.key}"
									<c:if test="${order.status == statusVar.key}"> selected="selected"</c:if>>${statusVar.value.desc}</option>
							</c:forEach>
					</select>
					</td>
					<td>订单类型： <select name="orderClass">
							<option value="">请选择</option>
							<c:forEach items="${shopClass}" var="statusVar">
								<option value="${statusVar.key}"
									<c:if test="${order.orderClass == statusVar.key}"> selected="selected"</c:if>>${statusVar.value.desc}</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td>下单开始日期:<input type="text" name="orderDateBegin"
						value="${order.orderDateBegin}" class="date textInput readonly"
						readonly="true">
					</td>
					<td>下单结束日期:<input type="text" name="orderDateEnd"
						value="${order.orderDateEnd}" class="date textInput readonly"
						readonly="true">
					</td>
					<td>支付方式： <select name="payWay">
							<option value="">请选择</option>
							<c:forEach items="${payWayNameEnums}" var="payWayNameVar">
								<option value="${payWayNameVar.value.desc}"
									<c:if test="${order.payWay == payWayNameVar.value.desc}"> selected="selected"</c:if>>${payWayNameVar.value.desc}</option>
							</c:forEach>
					</select>
					</td>
					<td>支付类型： <select name="payType">
							<option value="">请选择</option>
							<c:forEach items="${payTypeNameEnums}" var="payTypeNameVar">
								<option value="${payTypeNameVar.value.desc}"
									<c:if test="${order.payType == payTypeNameVar.value.desc}"> selected="selected"</c:if>>${payTypeNameVar.value.desc}</option>
							</c:forEach>
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
	<table class="table" targetType="navTab" asc="asc" desc="desc"
		width="100%" layoutH="131">
		<thead>
			<tr>
				<th width="5%">序号</th>
				<th width="9%">商户编号</th>
				<th width="9%">商户订单号</th>
				<th width="5%">订单类型</th>
				<th width="6%">订单金额</th>
				<th width="6%">状态</th>
				<th width="6%">下单日期</th>
				<th width="9%">下单时间</th>
				<th width="6%">支付方式</th>
				<th width="6%">支付类型</th>
				<th width="6%">操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="recordList" status="st">
				<tr target="sid_user" rel="${id}">
					<td>${st.index+1}</td>
					<td>${storeNumber}</td>
					<td>${orderId}</td>
					<td><c:if test="${orderClass eq 'FARM'}">实体商品</c:if> <c:if
							test="${orderClass eq 'TICKET'}">虚拟商品</c:if></td>
					<td><fmt:parseNumber type="number" pattern="#,#00.0#">${totalPrice}</fmt:parseNumber>
					</td>
					<td><c:forEach items="${statusEnums}" var="statusVar">
							<c:if test="${status == statusVar.key}">${statusVar.value.desc}</c:if>
						</c:forEach></td>
					<td><fmt:formatDate value="${createTime}" pattern="yyyy-MM-dd" />
					<td><fmt:formatDate value="${createTime}"
							pattern="yyyy-MM-dd HH:mm:ss" />
					<td>${payWay}</td>
					<td>${payType}</td>
					<td>[<a href="order_seeOrderDetials.action?orderId=${orderId}"
						title="查看" target="dialog" width="550" height="300" rel="input"
						style="color: blue">查看</a>]
					</td>
				</tr>
			</s:iterator>
			    <c:if test="${totalCount==0}"><tr><td>暂无数据</td></tr></c:if>
		</tbody>
	</table>
	<%@include file="/page/inc/pageBar.jsp"%>
</div>
