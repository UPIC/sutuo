<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="${upic}/assets/css/amazeui.min.css">
<script type="text/javascript" src="${upic}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${upic}/assets/js/amazeui.js"></script>
<link rel="stylesheet" href="${upic}/assets/css/event-details.css">
<script type="text/javascript" src="${upic}/assets/js/weixin.js"></script>
<style type="text/css">
</style>
<title>${shop.shopName }</title>
<script type="text/javascript">
	//调整适应度
	var phoneWidth = parseInt(window.screen.width);
	var phoneScale = phoneWidth / 375;
	var ua = navigator.userAgent;
	if (/Android (\d+\.\d+)/.test(ua)) {
		var version = parseFloat(RegExp.$1);
		if (version > 2.3) {
			document
					.write('<meta name="viewport" content="width=375, minimum-scale = '+phoneScale+', maximum-scale = '+phoneScale+', target-densitydpi=device-dpi">');
		} else {
			document
					.write('<meta name="viewport" content="width=375, target-densitydpi=device-dpi">');
		}
	} else {
		document
				.write('<meta name="viewport" content="width=375, user-scalable=no, target-densitydpi=device-dpi">');
	}
</script>
</head>
<body>
	<header data-am-widget="header" class="am-header am-header-default">
	<div class="am-header-left am-header-nav"></div>

	<h1 class="am-header-title">
		<a href="#title-link" class=""> 活动详情 </a>
	</h1>

	<div class="am-header-right am-header-nav"></div>
	</header>
	<div class="clear"></div>
	<div class="content">${shop.content}</div>
		<div class="bottom">
			<a href="javascript:history.go(-1);"><img src="${upic}/assets/i/cancle3.png"></a>
		</div>
	<div class="clear"></div>
</body>
</html>