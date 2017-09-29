<%-- 权限模块:操作员管理:添加或修改页面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<style>
<!--
.pageFormContent fieldset label {
	width: 200px;
}
-->
</style>
<!-- 商品状态 -->
<c:if test="${order.orderClass eq 'FARM' }">
	<div class="pageContent">
		<table class="table" width="100%" layoutH="135">
			<thead>
				<tr>
					<th width="5%">序号</th>
					<th width="5%">订单号</th>
					<th width="4%">商品编号</th>
					<th width="4%">商品名字</th>
					<th width="4%">商品数量</th>
					<th width="5%">商品单价</th>
					<th width="6%">商品种类</th>
					<th width="6%">商品规格</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="orderDetials" status="st">
					<tr>
						<td>${st.index+1}</td>
						<td>${orderId}</td>
						<td>${shopNumber}</td>
						<td>${shopName}</td>
						<td>${shopCount}</td>
						<td>${price}</td>
						<td>${shopType}</td>
						<td>${shopformat}</td>
					</tr>
				</s:iterator>
				<c:if test="${pageBean.totalCount==0}">
					<tr>
						<td>暂无数据</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>
</c:if>

<!-- 门票状态 -->
<c:if test="${order.orderClass eq 'TICKET' }">
	<div class="pageContent">
		<table class="table" width="100%" layoutH="135">
			<thead>
				<tr>
					<th width="5%">序号</th>
					<th width="5%">订单号</th>
					<th width="5%">商品编号</th>
					<th width="4%">预约人姓名</th>
					<th width="4%">预约人手机号</th>
					<th width="5%">预约总人数</th>
					<th width="5%">预约日期</th>
<!-- 					<th width="6%">预约申请时间</th> -->
					<th width="6%">预约状态</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="orderDetials" status="st">
					<tr>
						<td>${st.index+1}</td>
						<td>${orderId}</td>
						<td>${shopNum}</td>
						<td>${username}</td>
						<td>${phoneNumber}</td>
						<td><fmt:formatDate value="${dueTime}" pattern="yyyy-MM-dd" />
						<td>${shopCount}</td>
						<td><c:if test="${order.status eq 'TICKET' }">预约成功</c:if>
						<c:if test="${order.status eq 'WAIT_TICKET' }">申请预约中</c:if>
						<c:if test="${order.status eq 'TICKET_SPEND' }">已使用</c:if>
						<c:if test="${order.status eq 'USER_REJECT' }">用户已取消</c:if>
						
						</td>
						
<%-- 						<td>${createTime}</td> --%>
					</tr>
				</s:iterator>
				<c:if test="${pageBean.totalCount==0}">
					<tr>
						<td>暂无数据</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>
</c:if>

