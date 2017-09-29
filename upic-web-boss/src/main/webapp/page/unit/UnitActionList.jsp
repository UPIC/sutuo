<%-- 权限模块:权限（功能点）管理:分页查看页面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);" action="unit_listAllUnit.action" method="post">
	<!-- 分页表单参数 -->
    <%@include file="/page/inc/pageForm.jsp"%>
	<div class="searchBar">
		<table class="searchContent">
			<tr>
			    <td>
					公司名称：<input type="text" name="unitName" value="${unitName}" size="30" alt="模糊查询"  />
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
				<th>公司名称</th>
				<th>所在城市</th>
				<th>申请人</th>
				<th>邮箱</th>
				<th>申请时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		    <s:iterator value="recordList" status="st">
				<tr target="sid_user" rel="${id}">
				    <td>${st.index+1}</td>
					<td>${unitName }</td>
					<td>${unitAddressCity}</td>
					<td>${linkManName} </td>
					<td>${email}</td>
					<td>
						<fmt:formatDate value="${createTime }" pattern="yyyy-MM-dd"/>
					</td>
					<td>
						[<a href="unit_seeUnitDetials.action?id=${id}" title="查看" target="dialog" width="550" height="300" rel="input"  style="color:blue">查看</a>]&nbsp;&nbsp;
						<c:if test="${status == 100}">
								&nbsp;[<a href="pms_changeOperatorStatus.action?id=${id}" title="冻结【${unitName }】" target="ajaxTodo" style="color:blue">冻结</a>]
								</c:if>
								<c:if test="${status == 101}">
								&nbsp;[<a href="pms_changeOperatorStatus.action?id=${id}" title="激活【${unitName }】" target="ajaxTodo" style="color:blue">激活</a>]
								</c:if>
								
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	
     <!-- 分页条 -->
    <%@include file="/page/inc/pageBar.jsp"%>
</div>
    