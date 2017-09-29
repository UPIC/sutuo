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
<link rel="icon" sizes="192x192"
	href="${upic}/assets/i/app-icon72x72@2x.png">

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
<link rel="stylesheet" type="text/css"
	href="${upic}/assets/css/main2.css" />
<style type="text/css">
#big-cn-top {
	background-image: url(${upic}/assets/i/img/blog05.jpg);
	background-size: 100%;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<header data-am-sticky> <img
		src="${upic}/assets/i/img/logo.png" class="logo"> <a
		href="search.html"><input type="text" name="" class="search"></a>
	<img src="${upic}/assets/i/img/user.png" class="user-sm"> </header>
	<div id="img-round">
		<div class="am-slider am-slider-default" data-am-flexslider
			id="demo-slider-0">
			<div class="am-slider am-slider-default" data-am-flexslider
				id="demo-slider-0">
				<ul class="am-slides">
					<li><img src="${upic}/assets/i/a17.png" /></li>

				</ul>
			</div>
		</div>
	</div>
	<div></div>
	<div class="box1">
		<article> <img src=${upic}/assets/i/orang.png class="img" />
		<p>
			<span class="name">${storeDetials.storeName}</span><br />人均：${storeDetials.avgCost}元<br />农庄 | ：${storeDetials.storeName} |
		</p>
		<p class="pp">
			<i class="am-icon-star"></i> ${allNum}人收藏
		</p>
		</article>
	</div>
	<div class="box2">
		<span>${storeDetials.detailAddress}</span><img src="${upic}/assets/i/local.png" />
		<p>
			<span>${storeDetials.phone}</span><img src="${upic}/assets/i/phone.png" />
		</p>
	</div>
	<div style="height: 1400px; background-color: white">
		<article> <img src=${upic}/assets/i/art2.png />
		<span>活动详情</span>
		<p>整个南极大陆被一个巨大的冰盖所覆盖，平均海拔为2350米。南极洲是由冈瓦纳大陆分离解体而成，是世界上最高的大陆。南极横断山脉将南极大陆分成东西两部分。这两部分在地理和地质上差别很大。</p>
		<a href="activity.html"><p class="pp" style="margin-top: 15px">
				完整活动详情 <i class="am-icon-chevron-right"></i>
			</p></a> </article>
		${storeDetials.storeBrief }
	</div>
	<div class="am-navbar am-cf am-navbar-default "
		data-am-offcanvas="{target: '#doc-oc-demo3'}"
		style="margin-bottom: 60px; padding-right: 10px;">
		<img class="fenglei" src="${upic}/assets/i/img/fenglei1.png">
	</div>


	<div id="doc-oc-demo3" class="am-offcanvas">
		<div class="am-offcanvas-bar am-offcanvas-bar-flip">
			<div class="am-offcanvas-content">
				<ul>
					<li><img src="${upic}/assets/i/img/eat (2).png""></li>
					<li><img src="${upic}/assets/i/img/sleep.png"></li>
					<li><img src="${upic}/assets/i/img/fun.png"></li>
					<li><img src="${upic}/assets/i/img/shop.png"></li>
					<li><img src="${upic}/assets/i/img/yu.png"></li>
				</ul>
			</div>
		</div>
	</div>
	<%@ include file="../common/storeCommon.jsp"%>
</body>
</html>