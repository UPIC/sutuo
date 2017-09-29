<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);"
		action="announ_listAnnouncement.action" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>标题名： <input type="text" name="title" value="${title}" />
					</td>
					<td>
						<div class="buttonActive">
							<div class="buttonContent">
								<button title="查询" type="submit">查&nbsp;询</button>
							</div>
						</div>
						<a href="announ_insertReady.action" title="查看" target="dialog" width="550" height="300" rel="input"  style="color:blue">添加商品</a>
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
				<th width="10%">序号</th>
				<th width="10%">公告标题</th>
				<th width="10%">创建时间</th>
				<th width="10%">公告状态</th>
				<th width="10%">操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="recordList" status="st">
				<tr>
					<td>${st.index+1}</td>
					<td>${title }</td>
					<td><fmt:formatDate value="${createTime }"
							pattern="yyyy-MM-dd" /></td>
					<td>${status}</td>
					<td>[<a href="announ_readyUpdate.action?id=${id}"
						title="查看" target="dialog" width="550" height="300" rel="input"
						style="color: blue">查看</a>] <c:if test="${status==100}">
								&nbsp;[<a
								href="announ_changeStatusByAnnouncement.action?id=${id}&status=${status}"
								title="下架【${title }】" target="ajaxTodo" style="color: blue">下架</a>]
								</c:if> <c:if test="${status==101}">
								&nbsp;[<a
								href="announ_changeStatusByAnnouncement.action?id=${id}&status=${status}"
								title="上架【${title }】" target="ajaxTodo" style="color: blue">激活</a>]
								</c:if> [<a href="announ_deleteAnnouncement.action?id=${id}" title="删除"
						target="dialog" width="550" height="300" rel="input"
						style="color: blue">刪除</a>]
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
