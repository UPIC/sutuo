<%-- 权限模块:权限（功能点）管理:分页查看页面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);"
		action="#" method="post">
		<!-- 分页表单参数 -->
		<%@include file="/page/inc/pageForm.jsp"%>
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<li><a href="signPnLink_readyInsert.action" title="添加"
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
				<th>标签名</th>
				<th>上架时间</th>
				<th>图片</th>
				<th>标题</th>
				<th>文章名</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="recordList" status="st">
				<tr target="sid_user" rel="${id}">
					<td>${st.index+1}</td>
					<td>${signPn}</td>
					<td><fmt:formatDate value="${createTime }"
							pattern="yyyy-MM-dd" /></td>
					<td><img src="${pic}" style="height: 100px; width: 100px;" /></td>
					<td>${title}</td>
					<td>${articalName}</td>
					<td>[<a href="signPnLink_readyUpdate.action?id=${id}" title="更新"
						target="dialog" width="550" height="300" rel="input"
						style="color: blue">更新</a>]&nbsp;&nbsp; [<a
						href="signPnLink_deleteSinPnLink.action?id=${id}" title="确认【删除】"
						target="ajaxTodo" style="color: blue">删除</a>]
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<!-- 分页条 -->
	<%@include file="/page/inc/pageBar.jsp"%>
</div>
