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
<link rel="stylesheet" href="${upic}/assets/css/my.css" />
<script type="text/javascript" src="${upic}/assets/js/jquery.min.js"></script>
<script src="${upic}/assets/js/amazeui.js">
</script>
<title></title>
</head>
<body>
	<header data-am-widget="header" class="am-header">
	<div class="am-header-left am-header-nav">
		<a href="home.html" class=""> <i
			class="am-header-icon am-icon-chevron-left"></i>
		</a>
	</div>
	<h1 class="am-header-title">
		<img class="am-circle" src="${user.headImagUrl }" /><br /> <span>${user.nickName }<i
			class="am-icon-angle-right"></i></span>
	</h1>
	<div class="am-header-right am-header-nav">

		<a href="#cart-link" class=""> <i
			class="am-header-icon am-icon-cog"></i>
		</a>
	</div>
	</header>
	<div class="box1">
		<ul>
			<li><a href="invite.html"> <i
					class="am-icon-envelope-o am-icon-sm"></i><br /> <span>邀请有礼</span>
			</a></li>
			<li><a href="${upic}/person/collection.jsp"> <i
					class="am-icon-heart-o am-icon-sm"></i><br /> <span>我的收藏</span>
			</a></li>
			<li><a href="order.html"> <i class="am-icon-book am-icon-sm"></i><br />
					<span>我的订单</span>
			</a></li>
			<li><a href="money.html"> <i
					class="am-icon-credit-card am-icon-sm"></i><br /> <span>我的钱包</span>
			</a></li>
			<li><a href="erweima.html"> <i class="am-icon-th am-icon-sm"></i><br />
					<span>消费券</span>
			</a></li>
		</ul>
	</div>
	<div class="box2">

		<div class="txt">必备工具</div>
		<div class="ul">
			<ul class="ul1">
				<li><img src="${upic}/assets/i/m2.png" /><br /> <span>购物车</span></li>
				<li><img src="${upic}/assets/i/m3.png" /><br /> <span>关注</span></li>
				<li><img src="${upic}/assets/i/m4.png" /><br /> <span>足迹</span></li>
				<li><img src="${upic}/assets/i/m5.png" /><br /> <span>会员中心</span></li>
			</ul>

			<ul class="ul2">
				<li><img src="${upic}/assets/i/m6.png" /><br /> <span>我的小蜜</span></li>
				<li><img src="${upic}/assets/i/m7.png" /><br /> <span>快递</span></li>
				<li><img src="${upic}/assets/i/m8.png" /><br /> <span>商店</span></li>
				<li><img src="${upic}/assets/i/m2.png" /><br /> <span>购物车</span></li>
			</ul>

			<ul class="ul3">
				<li><img src="${upic}/assets/i/m2.png" /><br /> <span>购物车</span></li>
				<li><img src="${upic}/assets/i/m2.png" /><br /> <span>购物车</span></li>
				<li><img src="${upic}/assets/i/m2.png" /><br /> <span>购物车</span></li>
				<li><img src="${upic}/assets/i/m2.png" /><br /> <span>购物车</span></li>
			</ul>

		</div>
	</div>
	<!-- 	<div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default" -->
	<!-- 		id=""> -->
	<!-- 		<ul class="am-navbar-nav am-cf am-avg-sm-4" -->
	<!-- 			style="background-color: white"> -->
	<!-- 			<li style="background-color: white"><a href="home.html" class=""> -->
	<!-- 					<img src="${upic}/assets/i/p2.png" /> <span class="am-navbar-label" -->
	<!-- 					style="color: black">首页</span> -->
	<!-- 			</a></li> -->
	<!-- 			<li style="background-color: white"><a href="classify.html" -->
	<!-- 				class=""> <img src="${upic}/assets/i/p4.png" /> <span -->
	<!-- 					class="am-navbar-label" style="color: black">分类</span> -->
	<!-- 			</a></li> -->
	<!-- 			<li style="background-color: white"><a href="" class=""> <img -->
	<!-- 					src="${upic}/assets/i/logo.png" style="height: 40px; width: 50px" /> -->
	<!-- 			</a></li> -->
	<!-- 			<li style="background-color: white"><a href="" class=""> <img -->
	<!-- 					src="${upic}/assets/i/p5.png" /> <span class="am-navbar-label" -->
	<!-- 					style="color: black">心愿</span> -->
	<!-- 			</a></li> -->
	<!-- 			<li style="background-color: white"><a href="my.html" class=""> -->
	<!-- 					<img src="${upic}/assets/i/p6.png" /> <span class="am-navbar-label" -->
	<!-- 					style="color: black">我的</span> -->
	<!-- 			</a></li> -->

	<!-- 		</ul> -->
	<!-- 	</div> -->
	<%@ include file="../common/common.jsp"%>
</body>
</html>