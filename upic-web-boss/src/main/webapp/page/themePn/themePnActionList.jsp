<%-- 权限模块:权限（功能点）管理:分页查看页面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);"
		action="themePn_listActiveArea.action" method="post">
		<!-- 分页表单参数 -->
		<%@include file="/page/inc/pageForm.jsp"%>
		<div class="searchBar">
			<table class="searchContent">
				<tr>
				<li><a href="themePn_readyInsert.action" title="添加"
									target="dialog" width="550" height="300" rel="input"
									style="color: blue">按钮添加</a></li>
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
				<th>图片编号</th>
				<th>上架时间</th>
				<th>图片</th>
				<th>标题</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="recordList" status="st">
				<tr target="sid_user" rel="${id}">
					<td>${st.index+1}</td>
					<td>${num }</td>
					<td><fmt:formatDate value="${createTime }"
							pattern="yyyy-MM-dd" /></td>
					<td><img src="${themePnPic}"/></td>
					<td>${themePn}</td>
					<td>
						[<a href="themePn_readyUpdate.action?id=${id}" title="查看"
						target="dialog" width="550" height="300" rel="input"
						style="color: blue">查看</a>]&nbsp;&nbsp;
						[<a href="themePn_deleteByActiveAreaId.action?id=${id}"
								title="确认【删除】" target="ajaxTodo" style="color: blue">删除</a>]
						</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<!-- 分页条 -->
	<%@include file="/page/inc/pageBar.jsp"%>
</div>
