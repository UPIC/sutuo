<%-- 权限模块:权限（功能点）管理:分页查看页面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);"
		action="typePn_listTypePn.action" method="post">
		<!-- 分页表单参数 -->
		<%@include file="/page/inc/pageForm.jsp"%>
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>文章编号：<input type="text" name="typePnNumber"
						value="${typePn.typePnNumber}" size="30" alt="模糊查询" />
					</td>
					<td>文章标题：<input type="text" name="title"
						value="${typePn.title}" size="30" alt="模糊查询" />
					</td>
					<td>文章主题： <select name="themeName">
							<option value="">请选择</option>
							<c:forEach items="${themePns}" var="statusVar">
								<option value="${statusVar.themePn}"
									<c:if test="${typePn.themeName == statusVar.themePn}"> selected="selected"</c:if>>${statusVar.themePn}</option>
							</c:forEach>
					</select>
					</td>
					<td>文章类型： <select name="typePn">
							<option value="">请选择</option>
							<c:forEach items="${typeClass}" var="statusVar">
								<option value="${statusVar.key}"
									<c:if test="${typePn.typePn == statusVar.key}"> selected="selected"</c:if>>${statusVar.value.desc}</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<td>上架开始日期:<input type="text" name="orderDateBegin"
					value="${typePn.orderDateBegin}" class="date textInput readonly"
					readonly="true">
				</td>
				<td>上架结束日期:<input type="text" name="orderDateEnd"
					value="${typePn.orderDateEnd}" class="date textInput readonly"
					readonly="true">
				</td>
				<td>
					<div class="buttonActive">
						<div class="buttonContent">
							<button title="查询" type="submit">查&nbsp;询</button>
						</div>
					</div>
				</td>
				<td><a href="typePn_readyInsertArtic.action" title="查看"
					target="dialog" width="550" height="300" rel="input"
					style="color: blue">添加文章</a></td>
				<td><a href="typePn_readyCreateMeituByTypePn.action" title="查看"
					target="dialog" width="550" height="300" rel="input"
					style="color: blue">创建美图模块</a></td>
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
				<th>文章编号</th>
				<th>文章标题</th>
				<th>文章名字</th>
				<th>文章主题</th>
				<th>文章类型</th>
				<th>文章图片</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="recordList" status="st">
				<tr target="sid_user" rel="${id}">
					<td>${st.index+1}</td>
					<td>${typePnNumber}</td>
					<td>${title}</td>
					<td>${articName}</td>
					<td>${themeName}</td>
					<td>${typePn}</td>
					<td><img src="${picUrl}" style="width: 100px; height: 100px;" /></td>
					<td><c:if test="${status==100}">已上架</c:if> <c:if
							test="${status==102}">已下架</c:if></td>

					<td><c:if test="${status==100}">[<a
								href="typePn_changeStatus.action?id=${id}&status=102"
								title="确认【强制冻结】" target="ajaxTodo" style="color: blue">强制冻结</a>]</c:if>
						<c:if test="${status==102}">[<a
								href="typePn_changeStatus.action?id=${id}&status=100"
								title="确认【恢复冻结】" target="ajaxTodo" style="color: blue">恢复冻结</a>]</c:if>
						[<a href="typePn_readyUpdate.action?id=${id}" title="查看"
						target="dialog" width="550" height="300" rel="input"
						style="color: blue">查看</a>]&nbsp;&nbsp; [<a
						href="typePn_deleteByActiveAreaId.action?id=${id}" title="确认【删除】"
						target="ajaxTodo" style="color: blue">删除</a>]&nbsp;&nbsp; <c:if
							test="${typePn eq '图片' }">[<a
								href="typePn_readyUpdateMeituTypePn.action?id=${id}" title="查看"
								target="dialog" width="550" height="300" rel="input"
								style="color: blue">更新模块</a>]</c:if></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<!-- 分页条 -->
	<%@include file="/page/inc/pageBar.jsp"%>
</div>
