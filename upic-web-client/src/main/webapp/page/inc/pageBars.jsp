<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<script type="text/javascript"
	src="${upic}/static.vyyouxue.com/v1.0/assets/js/page.js">
</script>
<div class="page">
<%-- 	<c:if test="${list.currentPage==1 and list.pageCount==1}"> --%>
<!-- 		<span class="disabled_page">首页</span> -->
<!-- 		<span class="disabled_page">上一页</span> -->
<!-- 		<a href="" class="active">1</a> -->
<%-- 	</c:if> --%>
	<c:if test="${list.currentPage >= 1}">
		<c:choose>
			<c:when test="${list.currentPage==1}">
				<span class="disabled_page">首页</span>
				<span class="disabled_page">上一页</span>
			</c:when>
			<c:otherwise>
				<a href="" onclick="doPage(1,0)">首页</a>
				<a href="" onclick="doPage(2,0)">上一页</a>
			</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="1" end="${list.pageCount}"
			varStatus="status">
			<c:choose>
				<c:when test="${list.currentPage == status.index }">
					<a href="#" class="active">${status.index}</a>
				</c:when>
				<c:otherwise>
					<a href="#" onclick='doPage(3,${status.index})'>${status.index}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${list.currentPage == list.pageCount }">
				<span class="disabled_page">下一页</span>
				<span class="disabled_page">末页</span>
			</c:when>
			<c:otherwise>
				<a href="#" onclick="doPage(4,0)">下一页</a>
				<a href="#" onclick="doPage(5,${list.pageCount})">末页</a>
			</c:otherwise>
		</c:choose>
	</c:if>
</div>
<input type="hidden" name=pageCount value="${list.pageCount}" />
<input type="hidden" id="currentPage" name=pageNumStr
	value="${list.currentPage}" />
<input type="hidden" name="numPerPage" value="${list.numPerPage}" />
<input type="hidden" name="keyword" id="keywords" value="${historyKeyword}">
<input type="hidden" name="type" id="types">
<input type="hidden" name="zone" id="zones">
