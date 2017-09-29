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
<link rel="stylesheet" href="${upic}/assets/css/city.css" />
<link rel="stylesheet" href="${upic}/assets/css/z.css" />
<script type="text/javascript" src="${upic}/assets/js/jquery.min.js"></script>
<script src="${upic}/assets/js/amazeui.js">
	
</script>
<title></title>
</head>

<body>
	<header data-am-widget="header" class="am-header">
	<div class="am-header-left am-header-nav">
		<a href="china.html" class=""> <i
			class="am-header-icon am-icon-chevron-left" style="color: black"></i>
		</a>

	</div>

	<h1 class="am-header-title">选择城市</h1>

	<div class="am-header-right am-header-nav"></div>
	</header>





	<div id="currposition" class="currposition" style="display: none">
		猜您当前位于： <a class="j-posiname currposition-name" href=""></a>
	</div>
	<div class="currcity">
		<div class="currcity-title">
			<span class="currity-span">当前定位城市：</span> <a class="currcity-link"
				id="Id1">广州</a>
		</div>
		<!--<div class="currcity-field">-->
		<!--</div>-->
	</div>

	<div class="hot-cities">
		<div class="field"></div>
		<div class="letter" style="font-size: 16px">热门城市</div>
		<table class="sd-table tb-cities">
			<tbody>
				<tr>
					<td class="b-left-0">
						<div class="td-inner">
							<a href="index.html?id=长春">长春</a>
						</div>
					</td>
					<td>
						<div class="td-inner">
							<a href="index.html?id=成都">成都</a>
						</div>
					</td>
					<td>
						<div class="td-inner">
							<a href="index.html?id=哈尔滨">哈尔滨</a>
						</div>
					</td>
					<td class="b-right-0">
						<div class="td-inner">
							<a href="index.html?id=南京">南京</a>
						</div>
					</td>
				</tr>
				<tr>
					<td class="b-left-0">
						<div class="td-inner">
							<a href="index.html?id=郑州">郑州</a>
						</div>
					</td>
					<td>
						<div class="td-inner">
							<a href="index.html?id=合肥">合肥</a>
						</div>
					</td>
					<td>
						<div class="td-inner">
							<a href="index.html?id=大连">大连</a>
						</div>
					</td>
					<td class="b-right-0">
						<div class="td-inner">
							<a href="index.html?id=重庆">重庆</a>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="list">
		<c:forEach items="${words}" var="word">
			<div class="field">
				<div class="letter">${word.desc}</div>
				<table class="sd-table tb-cities">
					<tbody>
						<c:forEach items="${listBy}" var="listBy" varStatus="list">
							<c:if test="${word.desc eq  listBy.firstName}">
								<c:if test="${list.index % 4==0 }">
									<tr>
								</c:if>
								<td class="b-left-0">
									<div class="td-inner">
										<a href="${ctx}/init/initSelect.do?city=${listBy.cityName}">${listBy.cityName}</a>
									</div>
								</td>
								<c:if test="${(list.index+1) % 4==0 }">
									</tr>
								</c:if>
							</c:if>
						</c:forEach>
				</table>
			</div>
		</c:forEach>
	</div>
	<!-- 城市页增加下载App浮层-->
</body>
</html>
