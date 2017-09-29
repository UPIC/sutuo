<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);"
		action="user_listUserList.action" method="post">
		<%@include file="/page/inc/pageForm.jsp"%>
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>openId： <input type="text" name="openId"
						value="${user.openId}" />
					</td>
					<td>注册开始日期:<input type="text" name="orderDateBegin"
						value="${user.orderDateBegin}" class="date textInput readonly"
						readonly="true">
					</td>
					<td>注册结束日期:<input type="text" name="orderDateEnd"
						value="${user.orderDateEnd}" class="date textInput readonly"
						readonly="true">
					</td>
				</tr>
				<tr>
					<td>最后登入开始日期:<input type="text" name="userLoginDateBegin"
						value="${user.userLoginDateBegin}"
						class="date textInput readonly" readonly="true">
					</td>
					<td>最后登入结束日期:<input type="text" name="userLoginDateEnd"
						value="${user.userLoginDateEnd}"
						class="date textInput readonly" readonly="true">
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
				<th width="5%">用户头像</th>
				<th width="9%">openId</th>
				<th width="5%">用户名</th>
				<th width="5%">性别</th>
				<th width="5%">手机号</th>
				<th width="5%">国家</th>
				<th width="5%">省</th>
				<th width="5%">市</th>
				<th width="5%">注册时间</th>
				<th width="5%">最后登入时间</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="recordList" status="st">
				<tr>
					<td>${st.index+1}</td>
					<td><img src="${headImagUrl}" style="height: 25px; width: 25px;"></td>
					<!--         <td> -->
					<%--           <fmt:parseNumber type="number" pattern="#,#00.0#">${price}</fmt:parseNumber> --%>
					<!--         </td> -->

					<td>${openId}</td>
					<td>${userName}</td>
					<td>${sex}</td>
					<td>${phoneNum}</td>
					<td>${country}</td>
					<td>${province}</td>
					<td>${city}</td>
					<td><fmt:formatDate value="${createTime}"
							pattern="yyyy-MM-dd HH:mm:ss" />
					<td><fmt:formatDate value="${lastLoginTime}"
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
