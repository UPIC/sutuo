<%-- 权限模块:权限（功能点）管理:分页查看页面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);" action="classUpload_listAllClassUpload.action" method="post">
	<!-- 分页表单参数 -->
    <%@include file="/page/inc/pageForm.jsp"%>
	<div class="searchBar">
		<table class="searchContent">
			<tr>
			    <td>
					课程名称：<input type="text" name="className" value="${className}" size="30" alt="模糊查询"  />
				</td>
				<td>
					<div class="subBar">
						<ul>
							<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
						</ul>
					</div>
				</td>
			</tr>
		</table>
	</div>
	</form>
</div>
<div class="pageContent">
	<table class="table" targetType="navTab" asc="asc" desc="desc" width="100%" layoutH="131">
		<thead>
			<tr>
				<th>序号</th>
				<th>课程名称</th>
				<th>所在城市</th>
				<th>发布人</th>
				<th>是否委培</th>
				<th>委培对象</th>
				<th>课程价格（RMB）</th>
				<th>申请时间</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		    <s:iterator value="recordList" status="st">
				<tr target="sid_user" rel="${id}">
				    <td>${st.index+1}</td>
					<td>${classes.className }</td>
					<td>${classAddressCity }</td>
					<td>${uploadName}</td>
					<td><c:if test="${statusEntrustTrain == 100}">参与委培</c:if>
					<c:if test="${statusEntrustTrain == 101}">不参与委培</c:if>
					</td>
					<td><c:if test="${statusEntrustTrain == 100}">${enstrustName}</c:if>
					<c:if test="${statusEntrustTrain == 101}">无</c:if></td>
					<td>${classPrice }</td>
					<td>
						<fmt:formatDate value="${createTime }" pattern="yyyy-MM-dd"/>
					</td>
					<td><c:if test="${status == 100}">已通过</c:if>
					<c:if test="${status == 101}">未通过</c:if>
					<c:if test="${status == 102}">申请中</c:if>
					</td>
					<td>
						[<a href="classUpload_seeClassUploadDetials.action?id=${id}" title="查看" target="dialog" width="550" height="300" rel="input"  style="color:blue">查看</a>]&nbsp;&nbsp;
						<c:if test="${status == 100}">
								&nbsp;[<a href="classUpload_changeClassUploadStatus.action?id=${id}&status=${status}" title="通过【${unitName }】" target="ajaxTodo" style="color:blue">不通过</a>]
								</c:if>
								<c:if test="${status == 101}">
								&nbsp;[<a href="classUpload_changeClassUploadStatus.action?id=${id}&status=${status}" title="不通过【${unitName }】" target="ajaxTodo" style="color:blue">通过</a>]
								</c:if>
								<c:if test="${status == 102}">
								&nbsp;[<a href="classUpload_changeClassUploadStatus.action?id=${id}&status=${status}" title="不通过【${unitName }】" target="ajaxTodo" style="color:blue">通过</a>]
								</c:if>
								
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	
     <!-- 分页条 -->
    <%@include file="/page/inc/pageBar.jsp"%>
</div>
    