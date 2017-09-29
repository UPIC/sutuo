<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />

<link rel="stylesheet" href="${upic}/assets/css/amazeui.min.css" />
<link rel="stylesheet" href="${upic}/assets/css/paper.css" />
<script type="text/javascript" src="${upic}/assets/js/jquery.min.js"></script>
<script src="${upic}/assets/js/amazeui.js">
	
</script>
<title>${artical.articName }</title>
</head>
<body>
	<header data-am-widget="header" class="am-header">
	<div class="am-header-left am-header-nav">
		<a href="javascript:history.go(-1);" class=""> <i
			class="am-header-icon am-icon-chevron-left"></i>
		</a>

	</div>

	<h1 class="am-header-title">文章详情</h1>

	<div class="am-header-right am-header-nav">

		<a href="#cart-link" class=""> <i
			class="am-header-icon am-icon-share-square-o"></i>
		</a>
	</div>
	</header>

	<div class="body">
		${artical.content }
	</div>
 <div class="foot">
<!--        <span>阅读  2016  &nbsp;   &nbsp;   <i class="am-icon-thumbs-o-up"></i>  6</span> -->
<!--        <span class="aa">投诉</span> -->
       <br>
       <c:if test="${ !empty artical.urlArtical}">
       <a href="${artical.urlArtical }">阅读原文</a>
       </c:if>
   </div>
</body>
</html>