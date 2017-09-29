<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="${upic}/assets/css/chinadetail.css" />
<link rel="stylesheet" href="${upic}/assets/css/amazeui.min.css" />
<link rel="stylesheet" href="${upic}/assets/css/pin.css" />
<script type="text/javascript" src="${upic}/assets/js/jquery.min.js"></script>
<script src="${upic}/assets/js/amazeui.js">
	
</script>
<script type="text/javascript">
	var linksId = '${linkId}';
	var themesName = '${themeName}';
	var hotThemes = '${hotTheme}';
	var alls = '${all}';
	var pageNumStrs = 1;
	var numPerPageStrs = 5;
	var pageCount = 0;
	var progress = $.AMUI.progress;
	var ctx='${ctx}';
</script>
<title></title>
</head>
<body>
	<header data-am-widget="header" class="am-header">
	<div class="am-header-left am-header-nav">
		<a href="javascript:history.go(-1);" class=""> <i
			class="am-header-icon am-icon-chevron-left"></i>
		</a>

	</div>
	<!-- 	<h1 class="am-header-title"> --> <!-- 		品 <span class="wen">文</span> -->
	<!-- 	</h1> -->
	<h1 class="am-header-title">
		<c:if test="${!empty linkId }">${linkName}</c:if>
		<c:if test="${!empty themeName }">
		<c:if test="${themeName eq 'empty' }">旅行的故事</c:if>
		<c:if test="${themeName ne 'empty' }">${themeName}</c:if>
		</c:if>
		<c:if test="${!empty hotTheme }">${hotTheme}</c:if>
	</h1>
	<div class="am-header-right am-header-nav"></div>
	</header>
	<!-- 放置内容 -->
	<div id="content"></div>
</body>
<script type="text/javascript" src="${upic}/assets/js/secondPage.js"></script>
</html>