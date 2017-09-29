<%-- 权限模块:权限（功能点）管理:分页查看页面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);"
		action="shop_listShop.action" method="post">
		<!-- 分页表单参数 -->
		<%@include file="/page/inc/pageForm.jsp"%>
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>商品名称：<input type="text" name="shopName"
						value="${shop.shopName}" size="30" alt="模糊查询" />
					</td>
					<td>商品编号：<input type="text" name="shopNumber"
						value="${shop.shopNumber}" size="30" alt="模糊查询" />
					</td>
					<td>商家编号：<input type="text" name="storeNumber"
						value="${shop.storeNumber}" size="30" alt="模糊查询" />
					</td>
					<td>商品类型： <select name="shopType">
							<option value="">请选择</option>
							<c:forEach items="${shopTypeList}" var="statusVar">
								<option value="${statusVar.typeName}"
									<c:if test="${shop.shopType == statusVar.typeName}"> selected="selected"</c:if>>${statusVar.typeName}</option>
							</c:forEach>
					</select>
					</td>
					<td>商品主题： <select name="themeName">
							<option value="">请选择</option>
							<c:forEach items="${shopThemeList}" var="statusVar">
								<option value="${statusVar.theme}"
									<c:if test="${shop.themeName == statusVar.theme}"> selected="selected"</c:if>>${statusVar.theme}</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<td>商品（虚拟、实体）： <select name="shopClass">
						<option value="">请选择</option>
						<c:forEach items="${shopClass}" var="statusVar">
							<option value="${statusVar.key}"
								<c:if test="${shop.shopClass == statusVar.key}"> selected="selected"</c:if>>${statusVar.value.desc}</option>
						</c:forEach>
				</select>
				</td>
				<td>上架开始日期:<input type="text" name="orderDateBegin"
					value="${shop.orderDateBegin}" class="date textInput readonly"
					readonly="true">
				</td>
				<td>上架结束日期:<input type="text" name="orderDateEnd"
					value="${shop.orderDateEnd}" class="date textInput readonly"
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
<div class="pageContent">
	<table class="table" targetType="navTab" asc="asc" desc="desc"
		width="100%" layoutH="131">
		<thead>
			<tr>
				<th>序号</th>
				<th>商品名称</th>
				<th>商品编号</th>
				<th>商户编号</th>
				<th>商品销售价</th>
				<th>商品原价</th>
				<th>商品类型</th>
				<th>上架时间</th>
				<th>状态</th>
				<th>商品种类</th>
				<th>商品主题</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="recordList" status="st">
				<tr target="sid_user" rel="${id}">
					<td>${st.index+1}</td>
					<td>${shopName }</td>
					<td>${shopNumber }</td>
					<td>${storeNumber }</td>
					<td>${shopPrice}</td>
					<td>${primeCost}</td>
					<td>${shopType}</td>
					<td><fmt:formatDate value="${lastGroundingTime }"
							pattern="yyyy-MM-dd" /></td>
					<td><c:if test="${shopClass eq 'FARM'}">实体商品</c:if> <c:if
							test="${shopClass eq 'TICKET'}">虚拟商品</c:if></td>
					<td>${themeName}</td>
					<td><c:if test="${status==100}">已上架</c:if> <c:if
							test="${status==102}">已强制冻结</c:if></td>

					<td><c:if test="${status==100}">[<a
								href="shop_changeStatusByShop.action?id=${id}&status=102"
								title="确认【强制冻结】" target="ajaxTodo" style="color: blue">强制冻结</a>]</c:if>
						<c:if test="${status==102}">[<a
								href="shop_changeStatusByShop.action?id=${id}&status=100"
								title="确认【恢复冻结】" target="ajaxTodo" style="color: blue">恢复冻结</a>]</c:if>
						[<a href="shop_seeShopDetials.action?id=${id}" title="查看"
						target="dialog" width="550" height="300" rel="input"
						style="color: blue">查看</a>]&nbsp;&nbsp;</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<!-- 分页条 -->
	<%@include file="/page/inc/pageBar.jsp"%>
</div>
