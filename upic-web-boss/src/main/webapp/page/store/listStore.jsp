<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);"
		action="store_listStore.action" method="post">
		<%@include file="/page/inc/pageForm.jsp"%>
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>商户编号： <input type="text" name="storeNumber"
						value="${store.storeNumber}" />
					</td>
					<td>商户名： <input type="text" name="storeName"
						value="${store.storeName}" />
					</td>
					<td>商户状态： <select name="status">
							<option value="">请选择</option>
							<c:forEach items="${StoreStatusEnum}" var="statusVar">
								<option value="${statusVar.key}"
									<c:if test="${store.status == statusVar.key}"> selected="selected"</c:if>>${statusVar.value.desc}</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td>申请开始日期:<input type="text" name="orderDateBegin"
						value="${store.orderDateBegin}" class="date textInput readonly"
						readonly="true">
					</td>
					<td>申请结束日期:<input type="text" name="orderDateEnd"
						value="${store.orderDateEnd}" class="date textInput readonly"
						readonly="true">
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
	<table class="table" width="100%" layoutH="135">
		<thead>
			<tr>
				<th width="5%">序号</th>
				<th width="9%">商户编号</th>
				<th width="5%">商户名</th>
				<th width="5%">申请时间</th>
				<th width="6%">联系人</th>
				<th width="6%">手机号</th>
				<th width="3%">省</th>
				<th width="3%">市</th>
				<th width="3%">区</th>
				<th width="6%">详细地址</th>
				<th width="6%">状态</th>
				<th width="3%">操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="recordList" status="st">
				<tr>
					<td>${st.index+1}</td>
					<td>${storeNumber}</td>
					<!--         <td> -->
					<%--           <fmt:parseNumber type="number" pattern="#,#00.0#">${price}</fmt:parseNumber> --%>
					<!--         </td> -->

					<td>${storeName}</td>
					<td><fmt:formatDate value="${createTime}"
							pattern="yyyy-MM-dd HH:mm:ss" />
					<td>${linkName}</td>
					<td>${phone}</td>
					<td>${provinceName}</td>
					<td>${cityName}</td>
					<td>${districtName}</td>
					<td>${detailAddress}</td>
					<td><c:forEach items="${StoreStatusEnum}" var="statusVar">
									<c:if test="${status == statusVar.key}">${statusVar.value.desc} </c:if>
							</c:forEach></td>
					<td><c:if test="${status eq 'NO_ACTIVE' }">[<a href="store_changeStatus.action?id=${id}&status=SUCCESS" title="确认【激活】" target="ajaxTodo" style="color: blue">激活</a>]</c:if>
					<c:if test="${status eq 'SUCCESS' }">[<a href="store_changeStatus.action?id=${id}&status=NO_ACTIVE" title="确认【冻结】" target="ajaxTodo" style="color: blue">冻结</a>]</c:if>
					<c:if test="${status eq 'WAITING_CHECK' }">[<a href="store_changeStatus.action?id=${id}&status=SUCCESS" title="确认【通过】" target="ajaxTodo" style="color: blue">通过</a>]
					[<a href="store_changeStatus.action?id=${id}&status=REJECT" title="确认【不通过】" target="ajaxTodo" style="color: blue">不通过</a>]
					</c:if>
						 [<a
						href="store_seeStoreDetials.action?id=${id}"
						title="查看" target="dialog" width="550" height="300" rel="input"
						style="color: blue">查看</a>]</td>
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
