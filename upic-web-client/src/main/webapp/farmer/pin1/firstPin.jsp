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

<link rel="stylesheet" href="${upic}/assets/css/amazeui.min.css" />
<link rel="stylesheet" href="${upic}/assets/css/china.css" />
<script type="text/javascript" src="${upic}/assets/js/jquery.min.js"></script>
<script src="${upic}/assets/js/amazeui.js">
	
</script>
<title></title>
</head>
<body>


	<header data-am-widget="header" class="am-header ">
	<div class="am-header-left am-header-nav">
		<a href="#left-link" class=""> <span class="am-header-nav-title">
				<img src="${upic}/assets/i/img/logo2.jpg" class="logo"> </span> 
		</a>
	</div>

	<div class="am-header-title">

		<div class="am-u-lg-6">
			<div class="am-input-group">
				<span class="am-input-group-btn">
					<button class="am-btn am-btn-default am-round" type="button">
						<span class="am-icon-search"></span>
					</button>
				</span> <input type="text" class="am-form-field am-round">
			</div>
		</div>
	</div>
	<div class="am-header-right am-header-nav">
		<a href="#right-link" class=""> <span class="am-header-nav-title">
				搜索</span> <i class="am-header-icon am-icon-chevron-right"></i>
		</a>
	</div>
	</header>
	<div>
		<ul class="am-nav am-nav-tabs am-nav-justify">
			<li><a href="${ctx}/init/initIndex.do">玩乐</a></li>
			<li class="am-active"><a href="#">品农</a></li>
			<!-- 			<li><a href="home2.html">出行圈</a></li> -->
		</ul>
	</div>
	<div class="am-slider am-slider-default" data-am-flexslider
		id="demo-slider-0">
		<ul class="am-slides">
			<c:forEach items="${mainPic }" var="list">
				<li><c:if test="${!empty list.forwordType }">
						<a href="${list.forwordId}">
					</c:if><img src="${list.url }" />
				<c:if test="${!empty list.forwordType }">
						</a>
					</c:if></li>
			</c:forEach>
		</ul>
	</div>
	<div class="head">
		<ul>
			<c:forEach items="${themePn}" var="list">
				<li class="middle"><a href="${ctx}/pin/readyLoadContents.do?themeName=${list.themePn}"><img src="${list.themePnPic}" /><br /> <span
					class="text">${list.themePn}</span></a></li>
			</c:forEach>
		</ul>
	</div>
	<div class="body">
		<hr data-am-widget="divider" style=""
			class="am-divider am-divider-default" />
		<c:forEach items="${allSin}" var="list">
			<div class="two">
				<div class="tital">
					<span class="left"><i class="am-icon-newspaper-o"></i>
						${list.signPn }</span> <a
						href="${ctx}/pin/readyLoadContents.do?linkId=${list.id}"><span
						class="right">更多<i class="am-icon-chevron-right"></i></span></a>
				</div>

				<div class="main2">
					<ul>
						<c:forEach items="${content }" var="content">
							<c:if test="${list.id eq content.signPnId}">
								<li><a href="${ctx}/pin/getByNumber/${content.typePnId}.do"><img
										src="${content.pic }" /><br />
										<div class="txt">${content.articalName}</div></a></li>
							</c:if>
						</c:forEach>
					</ul>
				</div>
			</div>
			<hr data-am-widget="divider" style=""
				class="am-divider am-divider-default" />
		</c:forEach>
	</div>
</body>
</html>