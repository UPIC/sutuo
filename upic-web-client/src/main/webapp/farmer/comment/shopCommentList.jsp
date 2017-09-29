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
<link rel="stylesheet" href="${upic}/assets/css/opinion.css" />
<script type="text/javascript" src="${upic}/assets/js/jquery.min.js"></script>
<script src="${upic}/assets/js/amazeui.js">
	
</script>
<title></title>
</head>
<script type="text/javascript">
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
	var progress = $.AMUI.progress;
	var typeId = "${typeId}";
	var objId = '${objId}';
	var ctx='${ctx}';
</script>
<script src="${upic}/assets/js/comment.js"></script>
<body>
	<header data-am-widget="header" class="am-header">
	<!-- <div class="am-header-left am-header-nav">
		<a href="opinion.html" class=""> <i
			class="am-header-icon am-icon-chevron-left"></i>
		</a>
	</div> -->
	<h1 class="am-header-title">${title}</h1>
	<!-- <div class="am-header-right am-header-nav">
		<i class="am-header-icon am-icon-share-square-o"></i>
	</div> -->
	</header>
	<div id="comment">
	</div>
	<div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default "
		id="aa">
		<ul class="am-navbar-nav am-cf am-avg-sm-4"
			style="background-color: white">

			<li><span class="am-navbar-label am-icon-pencil"><a href="${ctx}/shop/searchBySN.do?shopNumber=${shop.shopNumber}">进店</a></span></li>

			<li><a href="${ctx}/comment/forwordPage/${typeId}/${objId}.do">
					<button type="button" class="am-btn am-btn-danger">发布</button>
			</a></li>

		</ul>
	</div>
</body>

</html>