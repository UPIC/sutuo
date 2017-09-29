<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);"
		action="browseRecords_listBrowseRecords.action" method="post">
		<%@include file="/page/inc/pageForm.jsp"%>
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>openId： <input type="text" name="openId"
						value="${browseRecords.openId}" />
					</td>
					<td>商户编号： <input type="text" name="storeNumber"
						value="${browseRecords.storeNumber}" />
					</td>
					<td>商品编号： <input type="text" name="shopNumber"
						value="${browseRecords.shopNumber}" />
					</td>
				</tr>
				<tr>
					<td>商品主题： <select name="shopTheme">
							<option value="">请选择</option>
							<c:forEach items="${shopThemeList}" var="statusVar">
								<option value="${statusVar.theme}"
									<c:if test="${browseRecords.shopTheme == statusVar.theme}"> selected="selected"</c:if>>${statusVar.theme}</option>
							</c:forEach>
					</select>
					</td>
					<td>商品（虚拟、实体）： <select name="shopClass">
							<option value="">请选择</option>
							<c:forEach items="${shopClassList}" var="statusVar">
								<option value="${statusVar.key}"
									<c:if test="${shop.shopClass == statusVar.key}"> selected="selected"</c:if>>${statusVar.value.desc}</option>
							</c:forEach>
					</select>
					</td>
					<td>浏览开始日期:<input type="text" name="orderDateBegin"
						value="${browseRecords.orderDateBegin}"
						class="date textInput readonly" readonly="true">
					</td>
					<td>浏览结束日期:<input type="text" name="orderDateEnd"
						value="${browseRecords.orderDateEnd}"
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
				<th width="6%">查看商品</th>
				<th width="5%">查看时间</th>
				<th width="5%">商户编号</th>
				<th width="5%">商品编号</th>
				<th width="5%">商品类型</th>
				<th width="5%">商品主题</th>
				<th width="5%">商品种类</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="recordList" status="st">
				<tr>
					<td>${st.index+1}</td>
					<td><img src="${userLogo}" style="height: 25px; width: 25px;"></td>
					<!--         <td> -->
					<%--           <fmt:parseNumber type="number" pattern="#,#00.0#">${price}</fmt:parseNumber> --%>
					<!--         </td> -->

					<td>${openId}</td>
					<td>${userName}</td>
					<td>${shopName}</td>
					<td><fmt:formatDate value="${createTime}"
							pattern="yyyy-MM-dd HH:mm:ss" />
					<td>${storeNumber }</td>
					<td>${shopNumber }</td>
					<td>${shopType }</td>
					<td>${shopTheme }</td>
					<td><c:if test="${shopClass eq 'FARM'}">实体商品</c:if> <c:if
							test="${shopClass eq 'TICKET'}">虚拟商品</c:if></td>
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
