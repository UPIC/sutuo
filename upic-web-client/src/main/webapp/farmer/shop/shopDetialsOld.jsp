<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title></title>

<!-- Set render engine for 360 browser -->
<meta name="renderer" content="webkit">

<!-- No Baidu Siteapp-->
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="icon" type="image/png" href="${upic}/assets/i/favicon.png">

<!-- Add to homescreen for Chrome on Android -->
<meta name="mobile-web-app-capable" content="yes">
<link rel="icon" sizes="192x192" href="${upic}/assets/i/app-icon72x72@2x.png">

<!-- Add to homescreen for Safari on iOS -->
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="apple-touch-icon-precomposed"
	href="${upic}/assets/i/app-icon72x72@2x.png">

<!-- Tile icon for Win8 (144x144 + tile color) -->
<meta name="msapplication-TileImage"
	content="${upic}/assets/i/app-icon72x72@2x.png">
<meta name="msapplication-TileColor" content="#0e90d2">
<script type="text/javascript" src="${upic}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${upic}/assets/js/amazeui.js"></script>
<link rel="stylesheet" href="${upic}/assets/css/amazeui.min.css">
<link rel="stylesheet" href="${upic}/assets/css/app.css">
<link rel="stylesheet" type="text/css" href="${upic}/assets/css/detials.css" />
<style type="text/css">
#big-cn-top {
	background-image: url(${upic}/assets/i/img/blog05.jpg);
	background-size: 100%;
	background-repeat: no-repeat;
}
</style>
</head>
<body>

	<!--<header data-am-sticky>
        <img src="${upic}/assets/i/img/logo.png" class="logo">
        <a href="search.html"><input type="text" name="" class="search"></a>
        <img src="${upic}/assets/i/img/user.png" class="user-sm">
    </header>-->




	<header data-am-widget="header" class="am-header ">
	<div class="am-header-left am-header-nav">
		<a href="javascript:history.go(-1);" class=""> <i
			class="am-header-icon am-icon-chevron-left"></i>
		</a>
	</div>

	<div class="am-header-title">${shopDetials.shopTitle }</div>

	<div class="am-header-right am-header-nav">
		<a href="javascript:history.go(-1);" class=""> </a>
	</div>
	</header>



	<div id="img-round">
		<div class="am-slider am-slider-default" data-am-flexslider
			id="demo-slider-0">
			<div class="am-slider am-slider-default" data-am-flexslider
				id="demo-slider-0">
				<ul class="am-slides">
				<c:forEach items="${shopPic}" var="list">
					<li><img src="${list.picUrl }" /></li>
				</c:forEach>
				</ul>
			</div>
		</div>
	</div>




	<div></div>

	<div class="box1">

		<article>
		<div class="aa">${shopDetials.shopTitle}</div>
		<img src=${upic}/assets/i/orang.png class="img" />
		<p>
			<span class="name"> ${storeDetials.storeName}</span><br />人均：${storeDetials.avgCost}元<br />
		</p>
		<p class="pp">
			<i class="am-icon-star"></i> ${allNum}人收藏
		</p>
		</article>

	</div>

	<div class="box2">
		<span>${storeDetials.detailAddress }</span><img src="${upic}/assets/i/local.png" />
		<p>
			<span>${storeDetials.phone }</span><img src="${upic}/assets/i/phone.png" />
		</p>
	</div>

	<div style="background-color: white">
		${shopDetials.content}
	</div>
</body>
</html>