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
<link rel="stylesheet" href="${upic}/assets/css/pindetail.css" />
<script type="text/javascript" src="${upic}/assets/js/jquery.min.js"></script>
<script src="${upic}/assets/js/amazeui.js">
	
</script>
<title></title>
</head>
<body>
	<header data-am-widget="header" class="am-header">
	<div class="am-header-left am-header-nav">
		<a href="javascript:history.go(-1);" class=""> <i
			class="am-header-icon am-icon-chevron-left"></i>
		</a>
	</div>
	<h1 class="am-header-title"></h1>
	<div class="am-header-right am-header-nav"></div>
	</header>

	<div class="am-slider am-slider-default" data-am-flexslider
		id="demo-slider-0">
		<ul class="am-slides">
		<c:forEach items="${meitu}" var="list" varStatus="data">
			<li><img src="${list.pic }" />
				<div class="box">
					<div class="tatil">
						<div class="left">${list.articName }</div>
						<div class="right">
							<span>${data.index+1}</span>/<c:out value="${fn:length(meitu)}"></c:out> 
						</div>
					</div>
					<div class="txt">
						${list.content }</div>
				</div></li>
				</c:forEach>
		</ul>
	</div>
<!-- 	<div class="foot am-navbar am-cf am-navbar-default" -->
<!-- 		data-am-widget="navbar"> -->
<!-- 		<div class="zuo"> -->
<!-- 			<input type="text" placeholder="快来评论吧....." /> -->
<!-- 		</div> -->
<!-- 		<div class="you"> -->
<!-- 			<ul> -->
<!-- 				<li><img src="${upic}/assets/i/li2.png" /></li> -->
<!-- 				<li><img src="${upic}/assets/i/qizhi.png" /></li> -->
<!-- 				<li><img src="${upic}/assets/i/share2.png" /></li> -->
<!-- 			</ul> -->
<!-- 		</div> -->
<!-- 	</div> -->
	<script>
		$(function() {
			var $slider = $('#demo-slider-0');
			var counter = 0;
			var countAll='${fn:length(meitu)}';
			var getSlide = function() {
				counter++;
				return '<li><img src="http://s.amazeui.org/media/i/demos/bing-'
						+ (Math.floor(Math.random() * parseInt(countAll)) + 1) + '.jpg" />'
						+ '<div class="am-slider-desc">动态插入的 slide ' + counter
						+ '</div></li>';
			};

			$('.js-demo-slider-btn').on(
					'click',
					function() {
						var action = this.getAttribute('data-action');
						if (action === 'add') {
							$slider.flexslider('addSlide', getSlide());
						} else {
							var count = $slider.flexslider('count');
							count > 1
									&& $slider.flexslider('removeSlide',
											$slider.flexslider('count') + 1);
						}
					});

		});
	</script>
</body>
</html>