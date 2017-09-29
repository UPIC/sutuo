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

<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<script type="text/javascript" src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.js">
	
</script>
<title></title>
<style>
.detail {
	text-align: center;
	font-size: 20px;
	margin-top: 20px;
}

.io {
	width: 20px;
	vertical-align: center;
}

span {
	padding-top: 20px;
}

hr {
	width: 90%;
	color: black;
	size: 10;
	margin: 0 auto;
	margin-top: 10px;
	margin-bottom: 10px;
}

img {
	width: 90%;
}

.write {
	margin-left: 6%;
	margin-top: 10px;
}

h2 {
	margin: 10px;
}

h5 {
	margin: 10px;
}

.explanation {
	margin-left: 5%;
}

.delete {
	width: 15%;
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<div class="detail">
		<img src="assets/i/detail.png" class="io">&nbsp;<span
			class="activity">活动详情</span></span>
	</div>
	<hr />
	<div>
		<center>
			<img src="assets/i/do.png">
		</center>
	</div>
	<div class="write">1111</div>
	<div>
		<center>
			<img src="assets/i/dt.png">
		</center>
	</div>
	<div class="write">2222</div>
	<div class="explanation">
		<h2>活动说明：</h2>
		<h5>费用：389/人/小时</h5>
		<h5>需求：仅限有乘骑经验者使用</h5>
		<h5>需提前一天预约</h5>
	</div>
	<div>
		<center>
			<a href="buy.html"><img src="assets/i/delete.png" class="delete"></a>
		</center>
	</div>
</body>
</html>