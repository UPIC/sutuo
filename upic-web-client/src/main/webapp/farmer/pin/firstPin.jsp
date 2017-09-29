<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>品农</title>
<script src="${upic}/assets/js/jquery.min.js"></script>
<script src="${upic}/assets/js/amazeui.min.js"></script>
<link rel="stylesheet" href="${upic}/assets/css/amazeui.min.css">
<link rel="stylesheet" href="${upic}/assets/css/farm.css">

</head>
<body>

	<div class="am-form-group am-form-icon">
		<i class="am-icon-search"></i> <input type="text"
			class="am-form-field" placeholder="搜索美食、攻略、游记">
	</div>
	<!-- <div class="line"></div> -->
	<div class="clear"></div>

<!-- 	<ul class="am-nav am-nav-tabs  am-nav-justify"> -->
<%-- 		<li><a href="${ctx}/init/initIndex.do">玩乐</a></li> --%>
<!-- 		<li class="am-active"><a href="#">品农</a></li> -->
<!-- 	</ul> -->

	<div class="clear"></div>
	<!--banner-->
	<div class="am-slider am-slider-default" data-am-flexslider
		id="demo-slider-0">
		<ul class="am-slides">
			<c:forEach items="${mainPic }" var="list">
				<li><c:if test="${!empty list.forwordType }">
						<a href="${list.forwordId}">
					</c:if><img src="${list.url }" /> <c:if
						test="${!empty list.forwordType }">
						</a>
					</c:if></li>
			</c:forEach>
		</ul>
	</div>

	<div class="clear"></div>
	<div class="center-line">
		<ul class="center-list ">
			<div class="clear"></div>
			<c:forEach items="${themePn}" var="list">
				<li><a
					href="${ctx}/pin/readyLoadContents.do?themeName=${list.themePn}"><img
						src="${list.themePnPic}" /></a><br /> <span>${list.themePn}</span></li>
			</c:forEach>
			<%-- 			<li><img src="${upic}/assets/i/img/food.png"><br /> <span>美食</span></li> --%>
			<%-- 			<li><img src="${upic}/assets/i/img/perfect.png"><br /> <span>玩美</span></li> --%>
			<%-- 			<li><img src="${upic}/assets/i/img/sleep.png"><br /> <span>民宿</span></li> --%>
			<%-- 			<li><img src="${upic}/assets/i/img/outside.png"><br /> <span>户外体验</span></li> --%>
		</ul>
		<div class="clear"></div>
	</div>

	<div class="clear"></div>

	<!-- 热门主题 -->
	<div class="center-box">
		<div class="head">
			<img src="${upic}/assets/i/img/hot.png" class="head-img"> <span
				class="head-tit">热门主题</span> <span class="am-icon-angle-right"></span>
			<!-- 			<span class="span-right">查看更多</span> -->
		</div>
		<div class="clear"></div>
		<div class="run-box am-scrollable-horizontal">
			<ul
				class="am-tabs-nav am-nav am-nav-tabs am-nav-justify first-nav shop-nav  am-text-nowrap am-scrollable-horizontal"
				id="index-nav">
				<c:forEach items="${hotThemePn }" var="list">
					<a href="${ctx}/pin/readyLoadContents.do?hotTheme=${list.hotThemePn}"><li><div class="running-box">
							<img src="${list.hotThemePnPic}">
						</div>
						<div class="img-tit">${list.hotThemePn}</div></li>
					</a>
				</c:forEach>
			</ul>
		</div>
		<div class="clear"></div>
	</div>

	<div class="line"></div>
	<c:forEach items="${allSin}" var="list" begin="0" end="1">
		<div class="center-box">
			<div class="head">
				<img src="${list.pic}" class="head-img"> <span
					class="head-tit">${list.signPn }</span> <span
					class="am-icon-angle-right"></span> <a
					href="${ctx}/pin/readyLoadContents.do?linkId=${list.id}"><span
					class="span-right">查看更多</span></a>
			</div>

			<div class="clear"></div>
			<div>
				<ul class="box-ul">
					<c:forEach items="${content}" var="content">
						<c:if test="${list.id eq content.signPnId}">
							<li><img src="${content.pic }">
								<div class="box-font">${content.articalName}</div></li>
						</c:if>
					</c:forEach>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
		<div class="line"></div>
	</c:forEach>

	<c:forEach items="${allSin}" var="list" begin="2">
		<div class="center-box">
			<div class="head">
				<img src="${list.pic}" class="head-img"> <span
					class="head-tit">${list.signPn }</span> <span
					class="am-icon-angle-right"></span> <a
					href="${ctx}/pin/readyLoadContents.do?linkId=${list.id}"><span
					class="span-right">查看更多</span></a>
			</div>
			<div class="clear"></div>
			<div>
				<ul class="box-ul1">
					<c:forEach items="${content}" var="content">
						<c:if test="${list.id eq content.signPnId}">
							<li><img src="${content.pic }">
								<div class="box-font">${content.articalName}</div></li>
						</c:if>
					</c:forEach>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
		<div class="line"></div>
	</c:forEach>
	<div class="center-box1">
		<div class="head">
			<img src="${upic}/assets/i/img/travel.png" class="head-img"> <span
				class="head-tit">旅行的故事</span> <span class="am-icon-angle-right"></span>
			<a href="${ctx}/pin/readyLoadContents.do?themeName=empty"><span class="span-right">查看更多</span></a>
		</div>
		<div class="clear"></div>
		<div>
			<ul class="box-ul2">
				<c:forEach items="${typePn}" var="list">
					<a href="${ctx}/pin/getByNumber/${list.id}.do"><li><div>
								<img src="${list.picUrl}">
								<div class="bottom-font">${list.articName }</div>
							</div>

							<div class="gray">${list.title }</div> <!-- <div class="label"></div> -->
					</li> </a>
				</c:forEach>
			</ul>
		</div>
		<div class="clear"></div>
	</div>
</body>
</html>