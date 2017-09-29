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
<link rel="stylesheet" href="${upic}/assets/css/single.css">
<link rel="stylesheet" type="text/css"
	href="${upic}/assets/css/style.css" />
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
	var ctx = '${ctx}';
	var cityName = "${cityName}";
	var keywords = "${keyWord}";
	var themes = "${theme}";
	var projects = "${project}";
	var searchUrl = "${searchClass}";
	function loadSearch(keyword) {
		location.href = '${ctx}/search/forwordSearch/${city}/' + keyword
				+ '.do';
	}
</script>
<script type="text/javascript" src="${upic}/assets/js/single.js"></script>
</head>
<body>
	<header data-am-widget="header" class="am-header ">
	<div class="am-header-left am-header-nav">
		<a href="${ctx}/init/initIndex.do" class=""> <i
			class="am-header-icon am-icon-chevron-left"></i>
		</a>
	</div>

	<div class="am-header-title" onclick="loadSearch('${keyWord}');">
		<input type="text" class="so" placeholder="${keyword}" />
	</div>
	<div class="am-header-right am-header-nav">
		<a href="#right-link" class=""> <span class="am-header-nav-title">
				搜索 </span>
		</a>
	</div>
	</header>

	<div class="am-tab-panel" id="main-two">
		<div id="two">
			<nav data-am-widget="menu" class="am-menu  am-menu-default"> <a
				href="javascript: void(0)" class="am-menu-toggle"> <i
				class="am-menu-toggle-icon am-icon-bars"></i>
			</a>


			<ul class="am-menu-nav am-avg-sm-3">
				<li class="am-parent"><a href="##" class="">玩乐</a>
					<ul id="model1" class="am-menu-sub am-collapse  am-avg-sm-2 ">
						<li class="choice"><div data-am-widget="tabs"
								class="am-tabs am-tabs-default">
								<ul class="am-tabs-nav am-cf">
									<li class="am-active"><a href="[data-tab-panel-0]">主题</a></li>
									<li class=""><a href="[data-tab-panel-1]">项目</a></li>
								</ul>
								<div class="am-tabs-bd">
									<div data-tab-panel-0 class="am-tab-panel am-active">
										<div class="am-panel-group" id="accordion">
										<div class="check  check-active theme" id="empty">不限</div>
											<c:forEach items="${themetzService }" var="listTheme">
													<div class="check theme" id="${listTheme.themetz}">${listTheme.themetz}</div>		
													
											</c:forEach>
<!-- 											<div class="check  check-active shop time" id="empty">时间不限</div> -->
<!-- 											<div class="check shop time" id="weekend">本周末</div> -->
<!-- 											<div class="check shop time" id="sevenDays">七天内</div> -->
<!-- 											<div class="check shop time" id="onemonth">7-30天</div> -->
<!-- 											<div class="check shop time" id="Amonthlater">30天后</div> -->

											<div class="am-btn-group">
												<button type="button" class="am-btn reset">重置</button>
												<button type="button" class="am-btn sure" id="Oktheme">确定</button>
											</div>
										</div>
									</div>
									<div data-tab-panel-1 class="am-tab-panel ">
										<div class="am-panel-group" id="accordion">
											<div class="check  check-active project" id="empty">不限</div>
											<c:forEach items="${secondProject }" var="listPro">
											<div class="check project" id="${listPro.project }">${listPro.project }</div>
											</c:forEach>

											<div class="am-btn-group">
												<button type="button" class="am-btn reset">重置</button>
												<button type="button" class="am-btn sure" id="OkProject">确定</button>
											</div>
											
										</div>
									</div>
								</div>
							</div></li>
					</ul></li>
				<li class="am-parent"><a href="##" class="">分类筛选</a>
					<ul id="model" class="am-menu-sub am-collapse  am-avg-sm-3 a">
						<li class="timer"><span class="am-icon-clock-o"></span><span
							class="span-two">时段</span></li>

						<li class="cl">
							<div class="check  check-active shop time" id="empty">时间不限</div>
							<div class="check shop time" id="weekend">本周末</div>
							<div class="check shop time" id="sevenDays">七天内</div>
							<div class="check shop time" id="onemonth">7-30天</div>
							<div class="check shop time" id="Amonthlater">30天后</div>
						</li>
						<li class="timer"><span class="am-icon-location-arrow"></span><span
							class="span-two">生态圈</span></li>
						<li class="cl">
							<div class="check check-active shop district"
								id="district_empty">全部</div> <c:forEach items="${district }"
								var="district">
								<div class="check shop district" id="${district.districtName}">${district.districtName}</div>
							</c:forEach>
						</li>


						<li class="timer"><span class="am-icon-group"></span><span
							class="span-two">人数</span></li>
						<li class="peop-bd">
							<table class="peop">
								<tr class="chchch">
									<div class="check check-active shop people" id="shoppeo_empty">不限</div>
									<div class="check shop people" id="shoppeo_1">1</div>
									<div class="check shop people" id="shoppeo_2">2</div>
									<div class="check shop people" id="shoppeo_3">5</div>
									<div class="check shop people" id="shoppeo_4">10人以上</div>
									<div class="check shop people" id="shoppeo_5">20人以上</div>
									<div class="check shop people" id="shoppeo_6">30人以上</div>
								</tr>
							</table>
						</li>

						<li class="btn-gr">

							<div class="am-btn-group">
								<button type="button" class="am-btn reset">重置</button>
								<button type="button" class="am-btn sure" id="OkShop">确定</button>
							</div>
						</li>
					</ul></li>
				<li class="am-parent"><a href="#c3" class="">人气最高</a>
					<ul class="am-menu-sub am-collapse  am-avg-sm-4 ">
						<li class="line"><a href="##" class="line line-active shop"
							id="shop_1"><span class="am-icon-arrows-v"></span>智能排序</a></li>
						<li class="line"><a href="##" class="line shop" id="shop_2"><span
								class="am-icon-map-marker"></span>离我最近</a></li>
						<li class="line"><a href="##" class="line shop" id="shop_3"><span
								class="am-icon-gift"></span>最新上线</a></li>
						<li class="line"><a href="##" class="line shop" id="shop_4"><span
								class="am-icon-fire"></span>人气最高</a></li>
						<li class="line"><a href="##" class="line shop" id="shop_5"><span
								class="am-icon-sort-amount-desc"></span>价格最低</a></li>
						<li class="line"><a href="##" class="line shop" id="shop_6"><span
								class="am-icon-sort-amount-asc"></span>价格最高</a></li>
					</ul></li>
			</ul>

			</nav>

			<!-- 放置shop栏目 -->
			<div id="shopIn"></div>
			<div id="notAnyMoreShop" style="text-align: center; margin-top: 20px">沒有更多了</div>
		</div>
	</div>

</body>
</html>