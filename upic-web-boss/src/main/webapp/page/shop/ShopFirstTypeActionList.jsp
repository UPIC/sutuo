<%-- 权限模块:权限（功能点）管理:分页查看页面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);" action="shopFirstType_listShopFirstType.action" method="post" >
	<!-- 分页表单参数 -->
    <%@include file="/page/inc/pageForm.jsp"%>
	<div class="searchBar">
		<table class="searchContent">
			<tr>
			    <td>
					类型名称：<input type="text" name="firstType" value="${firstType.firstType}" size="30" alt="模糊查询"  />
				</td>
				<td>
					<div class="subBar">
						<ul>
							<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
							<li><a href="shopFirstType_goAdd.action" title="查看" target="dialog" width="550" height="300" rel="input"  style="color:blue">类型添加</a></li>
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
				<th>类型名</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		    <s:iterator value="recordList" status="st">
				<tr target="sid_user" rel="${id}">
				    <td>${st.index+1}</td>
					<td>${firstType}</td>
					<td>
						<fmt:formatDate value="${createTime }" pattern="yyyy-MM-dd"/>
					</td>
					<td>
						[<a href="shopFirstType_seeShopFirstTypeDetials.action?id=${id}" title="查看" target="dialog" width="550" height="300" rel="input"  style="color:blue">查看</a>]&nbsp;&nbsp;
						[<a href="shopFirstType_deleteShopFirstType.action?id=${id}"  title="删除【${theme }】" target="ajaxTodo" style="color:blue">删除</a>]&nbsp;&nbsp;		
					</td>
					
				</tr>
			</s:iterator>
			
		</tbody>
	</table>
     <!-- 分页条 -->
    <%@include file="/page/inc/pageBar.jsp"%>
</div>
    