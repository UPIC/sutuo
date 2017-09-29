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


<script type="text/javascript" src="${upic}/assets/js/jquery.min.js"></script>
<script src="${upic}/assets/js/amazeui.js">
	
</script>

<script type="text/javascript" src="${upic}/assets/js/amazeui.js"></script>
<script type="text/javascript" src="${upic}/assets/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="${upic}/assets/js/background-blur.min.js"></script>
<script type="text/javascript" src="${upic}/assets/js/index.js"></script>
<link rel="stylesheet" href="${upic}/assets/css/amazeui.min.css">

<link rel="stylesheet" href="${upic}/assets/css/amazeui.min.css" />
<link rel="stylesheet" href="${upic}/assets/css/me.css" />

<title></title>
<script type="text/javascript">
	$(document).ready(function() {
		$(".jubao").click(function() {
			$(".jubao").attr("class", "jubao-success");
		});
	});
</script>

</head>
<body>
	<header>
	<div class="avatar-holder">
		<div class="left">
			<i class="am-icon-chevron-left"></i>
		</div>
		<div class="avatar-container">
			<div class="avatar">
				<img src="${user.headImagUrl }" alt="" />
				<div class="name">${user.nickName }</div>

			</div>


		</div>

	</div>
	</header>


	<!--  
    <div class="main">
        <ul>
            <li>
                <img src="${upic}/assets/i/me1.png" /><br />
                足迹
            </li>
            <li>
                <img src="${upic}/assets/i/me2.png" /><br />
                关注
            </li>
            <li>
                <img src="${upic}/assets/i/me3.png" /><br />
                订单
            </li>
        </ul>
    </div>
-->
	<div class="gray"></div>


	<div class="list">
		<div class="line">
			<div class="content">
				<img src="${upic}/assets/i/me1.png" />足迹
			</div>
			<div class="icon">
				<i class="am-icon-angle-right"></i>
			</div>
		</div>

		<div class="line">
			<a href="${upic}/person/collection.jsp"><div class="content">
				<img src="${upic}/assets/i/me2.png" />我的收藏
			</div></a>
			<div class="icon">
				<i class="am-icon-angle-right"></i>
			</div>
		</div>
		<div class="line">
			<div class="content">
				<img src="${upic}/assets/i/line6.png" />关于我们
			</div>
			<div class="icon">
				<i class="am-icon-angle-right"></i>
			</div>
		</div>

		<div class="line">
			<div class="content">
				<img src="${upic}/assets/i/line7.png" />联系我们
			</div>
			<div class="icon">
				<i class="am-icon-angle-right"></i>
			</div>
		</div>
	</div>
	<div class="gray"></div>
	<div class="list">
		<div class="line">
			<div class="content">
				<img src="${upic}/assets/i/line8.png" />反馈
			</div>
			<div class="icon">
				<i class="am-icon-angle-right"></i>
			</div>
		</div>
	</div>
	<%@ include file="../common/common.jsp"%>
	
</body>
</html>