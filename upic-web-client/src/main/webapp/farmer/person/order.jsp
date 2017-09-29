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
<link rel="stylesheet" href="${upic}/assets/css/order.css" />
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
<script src="${upic}/assets/js/order.js"></script>
<title></title>
</head>
<body>
	<header data-am-widget="header" class="am-header">
	<div class="am-header-left am-header-nav">
		<a href="my.html" class=""> <i
			class="am-header-icon am-icon-chevron-left"></i>
		</a>
	</div>
	<h1 class="am-header-title"></h1>

	<div class="am-header-right am-header-nav"></div>
	</header>
	<div class="am-tabs" data-am-tabs>
		<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify" id="ul">
			<li class="am-active"><a href="#tab1">订单</a></li>
			<li><a href="#tab2">组局</a></li>
			<li><a href="#tab3">预约</a></li>
		</ul>
		<div class="am-tabs-bd">
			<div class="am-tab-panel am-fade am-in am-active" id="tab1">
				<div data-am-widget="tabs" class="am-tabs am-tabs-d2">
					<ul class="am-tabs-nav am-cf">
						<li class="am-active"><a href="[data-tab-panel-0]">全部订单</a></li>
						<li class=""><a href="[data-tab-panel-1]">购买成功</a></li>
						<li class=""><a href="[data-tab-panel-2]">未支付</a></li>
						<li class=""><a href="[data-tab-panel-3]">无效订单</a></li>
					</ul>
					<div class="am-tabs-bd">
						<div data-tab-panel-0 class="am-tab-panel am-active" id="1">


							<div class="box1">
								<div class="boxleft">无效预订</div>
								<div class="boxright">2016.12.12 12:30</div>
								<hr data-am-widget="divider" style=""
									class="am-divider am-divider-default" />
								<div class="box2">
									<div class="img">
										<img class="am-radius" alt="140*140"
											src="${upic}/assets/i/a14.png" width="150" height="100" />
									</div>
									<div class="txt">
										[组局]不限量任选农场娱乐项目农场自助
										<p>
											<span>份数：2份</span><br /> <span>总价：416元</span>
										</p>
									</div>
								</div>
							</div>
							<div id="notAnyMore1"
								style="text-align: center; margin-top: 20px">沒有更多了</div>
						</div>
						<div data-tab-panel-1 class="am-tab-panel " id="2">
							<div id="notAnyMore2"
								style="text-align: center; margin-top: 20px">沒有更多了</div>
						</div>
					</div>
					<div data-tab-panel-2 class="am-tab-panel " id="3">
						<div id="notAnyMore3" style="text-align: center; margin-top: 20px">沒有更多了</div>
					</div>
				</div>
				<div data-tab-panel-3 class="am-tab-panel " id="4">
					<div id="notAnyMore4" style="text-align: center; margin-top: 20px">沒有更多了</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<div class="am-tab-panel am-fade" id="tab2">
		<div class="box3">

			<div class="box4">
				<div class="img">
					<img class="am-radius" alt="140*140" src="${upic}/assets/i/a14.png"
						width="160" height="120" />
				</div>
				<div class="txt">
					不限量任选农场娱乐项目农场自助
					<p>
						<span>时间：2016.12.30 17：30</span> <span>份数：2份</span><br /> <span>总价：416元</span>
					</p>
				</div>
				<div class="box5">
					<span class="span1">组局已结束</span>
					<button type="button" class="am-btn am-radius">组局详情</button>
				</div>
			</div>
		</div>
	</div>
	<div class="am-tab-panel am-fade" id="tab3">
		<div data-am-widget="tabs" class="am-tabs am-tabs-d2">
			<ul class="am-tabs-nav am-cf">
				<li class="am-active"><a href="[data-tab-panel-0]">全部预约</a></li>
				<li class=""><a href="[data-tab-panel-1]">预约成功</a></li>
				<li class=""><a href="[data-tab-panel-2]">待确认</a></li>
				<li class=""><a href="[data-tab-panel-3]">无效预约</a></li>
			</ul>
			<div class="am-tabs-bd">
				<div data-tab-panel-0 class="am-tab-panel am-active">

					<div class="box1">
						<div class="boxleft">无效预约</div>
						<div class="boxright">2016.12.12 12:30</div>
						<hr data-am-widget="divider" style=""
							class="am-divider am-divider-default" />
						<div class="box2">
							<div class="img">
								<img class="am-radius" alt="140*140"
									src="${upic}/assets/i/a14.png" width="150" height="100" />
							</div>
							<div class="txt">
								[组局]不限量任选农场娱乐项目农场自助
								<p>
									<span>份数：2份</span><br /> <span>总价：416元</span>
								</p>
							</div>
						</div>
					</div>
					<div data-tab-panel-1 class="am-tab-panel "></div>
					<div data-tab-panel-2 class="am-tab-panel "></div>
					<div data-tab-panel-3 class="am-tab-panel "></div>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
</body>
</html>