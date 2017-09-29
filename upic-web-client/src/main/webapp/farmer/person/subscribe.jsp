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
<link rel="stylesheet" href="${upic}/assets/css/yuyue.css" />
<script type="text/javascript" src="${upic}/assets/js/jquery.min.js"></script>
<script src="${upic}/assets/js/amazeui.js">
</script>
<script type="text/javascript">
	var ctx = '${ctx}';
	var obj = "${statusType}";
	var json = eval('(' + obj + ')');
	var p = new Object();
	for (var i = 0; i < json.length; i++) {
		p[json[i].id] = json[i].desc;
	}
</script>
<script src="${upic}/assets/js/subscribe.js"></script>
<title></title>
</head>

<body>
	<header data-am-widget="header" class="am-header">
	<div class="am-header-left am-header-nav">
		<a href="my.html" class="am-icon-arrow-left"> </a>
	</div>
	<h1 class="am-header-title">预约</h1>
	</header>
	<div data-am-widget="tabs" class="am-tabs am-tabs-d2">
		<ul class="am-tabs-nav am-cf">
			<li class="am-active"><a href="[data-tab-panel-0]">全部预约</a></li>
			<li class=""><a href="[data-tab-panel-1]">预约成功</a></li>
			<li class=""><a href="[data-tab-panel-2]">待确认</a></li>
			<li class=""><a href="[data-tab-panel-3]">无效预约</a></li>
		</ul>
		<div class="am-tabs-bd">
			<div data-tab-panel-0 class="am-tab-panel am-active" id="5">
			<div id="notAnyMore4" style="text-align: center; margin-top: 20px">沒有更多了</div>
					</div>
			<div data-tab-panel-1 class="am-tab-panel" id="6">
			<div id="notAnyMore5" style="text-align: center; margin-top: 20px">沒有更多了</div>
			</div>
			<div data-tab-panel-2 class="am-tab-panel" id="7">
			<div id="notAnyMore6" style="text-align: center; margin-top: 20px">沒有更多了</div>
			</div>
			<div data-tab-panel-3 class="am-tab-panel "></div>
		</div>
	</div>
</body>
</html>