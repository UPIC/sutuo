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
<%-- <link rel="stylesheet" href="${upic}/assets/css/new.css" /> --%>
<script type="text/javascript" src="${upic}/assets/js/jquery.min.js"></script>
<script src="${upic}/assets/js/amazeui.js">
</script>
<script type="text/javascript" src="${upic}/assets/js/weixin.js"></script>
<title>${shopDetials.shopTitle}</title>
<script type="text/javascript">
	//获得浏览器版本
	var browser = {
		versions : function() {
			var u = navigator.userAgent, app = navigator.appVersion;
			return {//移动终端浏览器版本信息
				trident : u.indexOf('Trident') > -1, //IE内核
				presto : u.indexOf('Presto') > -1, //opera内核
				webKit : u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核
				gecko : u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, //火狐内核
				mobile : !!u.match(/AppleWebKit.*Mobile/i)
						|| !!u
								.match(/MIDP|SymbianOS|NOKIA|SAMSUNG|LG|NEC|TCL|Alcatel|BIRD|DBTEL|Dopod|PHILIPS|HAIER|LENOVO|MOT-|Nokia|SonyEricsson|SIE-|Amoi|ZTE/), //是否为移动终端
				ios : !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
				android : u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或者uc浏览器
				iPhone : u.indexOf('iPhone') > -1 || u.indexOf('Mac') > -1, //是否为iPhone或者QQHD浏览器
				iPad : u.indexOf('iPad') > -1, //是否iPad
				webApp : u.indexOf('Safari') == -1
			//是否web应该程序，没有头部与底部
			};
		}(),
		language : (navigator.browserLanguage || navigator.language)
				.toLowerCase()
	}
	$(function() {
		if (browser.versions.iPhone || browser.versions.iPad
				|| browser.versions.ios) {//苹果版
			$("#urls")
					.attr(
							"href",
							"baidumap://map/geocoder?address=${storeDetials.detailAddress}&src=webapp.geo.yourCompanyName.yourAppName");

		}
		if (browser.versions.android) {//安卓
			$("#urls")
					.attr("href",
							"bdapp:// map/geocoder?src=openApiDemo&address=${storeDetials.detailAddress}");
		}

	});
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
	var progress = $.AMUI.progress;
	var cityName = "${city}";
	var project = '${projects[0].project}';
	var searchUrl = "${searchClass}";
</script>
</head>
<body>
	<header data-am-widget="header" class="am-header">
	<div class="am-header-left am-header-nav">
		<a href="${ctx}/init/initIndex.do" class=""> <i
			class="am-header-icon am-icon-chevron-left"></i>
		</a>
	</div>

	<h1 class="am-header-title">
		商品详情 </a>
	</h1>

	<div class="am-header-right am-header-nav" data-am-widget="navbar">
		<li data-am-navbar-share><a href="###" class=""> <span
				class="am-icon-share-square-o"></span>

		</a></li>
		<!-- <i
			class="am-header-icon am-icon-external-link" data-am-navbar-share>data-am-navbar-share</i> -->
	</div>
	</header>

	<!-- 	<div class="am-slider am-slider-default" data-am-flexslider -->
	<!-- 		id="demo-slider-0"> -->

	<!-- 		<ul class="am-slides"> -->
	<%-- 			<c:forEach items="${shopPic}" var="list"> --%>
	<%-- 				<li><img src="${list.picUrl }" /></li> --%>
	<%-- 			</c:forEach> --%>
	<!-- 		</ul> -->

	<!-- 	</div> -->

	<div class="am-slider am-slider-default" data-am-flexslider
		id="demo-slider-0">
		<ul class="am-slides">
			<c:forEach items="${shopPic}" var="list">
				<li><img src="${list.picUrl }" /></li>
			</c:forEach>
		</ul>
	</div>

	<div class="part1">
		<span class="aa">${shopDetials.shopTitle}</span><br /> <span
			class="bb"><c:if test="${storeDetials.avgCost==0 }">人均：询价</c:if>
			<c:if test="${storeDetials.avgCost gt 0 }">人均：${storeDetials.avgCost}元</c:if>&nbsp;&nbsp;|&nbsp;&nbsp;|&nbsp;&nbsp;${storeDetials.districtName}</span><br />
<!-- 		<span class="bb"><i -->
<%-- 			class="am-icon-star <c:if test="${!empty isCollection }">iconActive</c:if>"></i> --%>
<%-- 			<div id="collection">${allNum}人收藏</div></span>--%><br /> 
			<div class="clear"></div>
		<div class="cc">
			<div class="cc-left">${storeDetials.detailAddress }</div>
			
			<div class="cc-right"><a id="urls"
				href="bdapp:// map/geocoder?src=openApiDemo&address=${storeDetials.detailAddress }">
	
				<i
				class="am-icon-location-arrow icon"></i></a> 
				<a
				href="tel:${storeDetials.phone }"><i class="am-icon-phone icon"></i></a>
				</div>
		<div class="clear"></div>
		</div>
	</div>
	<div class="part2">
		<span class="dd"><i class="am-icon-camera"></i>&nbsp;&nbsp;活动详情</span>
		<div class="activity1">
			<div class="one">
				<c:forEach items="${projects}" var="list">
					<i class="am-icon-yelp">${list.project }</i>
				</c:forEach>
			</div>
			<div class="two">
				<ul>
					<!-- 					<li class="li">采摘</li> -->
					<!-- 					<li>种植</li> -->
					<!-- 					<li>养生</li> -->
					<!-- 					<li>教育</li> -->
					<!-- 					<li>亲子</li> -->
				</ul>
			</div>
		</div>
		<div class="am-kai">
			${shopTicket.projectBrief }
			<!-- 			那时候刚好下着雨<br />柏油路面湿冷冷的<br />还闪烁着青、黄、红颜色的灯火 -->
		</div>
		<div class="three">
			<ul>
				<li><img src="${upic}/assets/i/c1.jpg" /></li>
				<li><img src="${upic}/assets/i/c2.jpg" /></li>
				<li><img src="${upic}/assets/i/c1.jpg" /></li>
			</ul>
			<ul>
				<li><img src="${upic}/assets/i/c3.jpg" /></li>
				<li><img src="${upic}/assets/i/c4.jpg" /></li>
				<li><img src="${upic}/assets/i/c1.jpg" /></li>
			</ul>
		</div>
		<p>
			<a class="four"
				href="${ctx}/shop/searchShopDetials/${shopDetials.shopNumber}.do">查看详情<i
				class="am-icon-chevron-right"></i></a>
		</p>
	</div>
	<div class="part2">
		<span class="dd"><i class="am-icon-thumbs-up"></i>&nbsp;&nbsp;商家动态</span>
		<div class="ee am-kai">最快、最详细、最火爆的活动</div>
		<div class="ff">
			<fmt:formatDate value="${lastLog.createTime}" />
		</div>
		<div class="am-kai">${lastLog.title }</div>
		<div class="four">
			<c:if test="${!empty lastLog}">
				<a href="${ctx}/log/getLog/${lastLog.logNumber}.do">进入活动 >></a>
			</c:if>
			<c:if test="${empty lastLog}">商家太懒了 什么的都没有写- -!</c:if>
		</div>
		<c:if test="${!empty lastLog}">
			<img class="am-radius" alt="140*140" src="${lastLog.pic}" width="300"
				height="150" />
		</c:if>
		<c:if test="${empty lastLog}">
			<img class="am-radius" alt="140*140" src="${upic}/assets/i/bg2.jpg"
				width="300" height="150" />
		</c:if>
		<p class="four">
			<c:if test="${!empty lastLog}">
				<a class="four" href="${ctx}/log/loadLog/${storeDetials.id}.do">查看更多动态<i
					class="am-icon-chevron-right"></i></a>
			</c:if>
			<c:if test="${empty lastLog}">不好意思，没有更多了- -!<i
					class="am-icon-chevron-right"></i>
			</c:if>
		</p>
	</div>
<!-- 	<div class="part4"> -->
<!-- 		<div class="part4-header"> -->
<!-- 			<span class="dd"><i class="am-icon-thumbs-up"></i>&nbsp;&nbsp;话题评论</span><br /> -->
<%-- 			<span class="smalldd">${allComment}条评论</span> --%>
<!-- 		</div> -->
<!-- 			<div class="part4-main"> -->
<%-- 		<c:forEach items="${comment }" var="list"> --%>


<!-- 				<div class="big-main"> -->
<!-- 						<div class="part4-left"> -->
<%-- 								<img class="am-circle" src="${list.pic }" width="50" height="50" /> --%>
<!-- 						</div> -->
<!-- 						<div class="part4-right"> -->
<!-- 						   <div class="username"> -->
<%-- 						         <div class="nameleft">${list.nickName}</div> --%>
<%-- 						         <div class="timeright"><fmt:formatDate --%>
<%-- 									value="${list.createTime}" /></div> --%>
<!-- 						   </div> -->
<!-- 						   <div class="usermessage"> -->
<%-- 						   ${list.content} --%>
<!-- 						   </div>   -->
<!-- 						</div> -->
<!-- 					<div class="clear"></div> -->
<!-- 				</div> -->

			
<%-- 		</c:forEach> --%>
<!-- 			<div class="main3"> -->
<!-- 					<p style="margin-top: 20px"> -->
<!-- 						<a class="four" -->
<%-- 							href="${ctx}/comment/forwordPageToGetComment/1/${shopDetials.id}.do">查看更多评论<i --%>
<!-- 							class="am-icon-chevron-right"></i></a> -->
<!-- 					</p> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 	</div> -->
	<div class="part3">
		<span class="dd"><i class="am-icon-envelope-o"></i>&nbsp;&nbsp;提醒事项</span>
		<div class="ee">${shopTicket.relus }</div>
		<!-- 		<div class="ff">时间12.12--2.1</div> -->
	</div>
	<div class="part5">
		<article> <span class="dd"><i class="am-icon-heart"></i>&nbsp;&nbsp;猜你喜欢</span>
		</article>

		<div id="youLike" style="padding-bottom: 20px"></div>
	</div>

	<div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default "
		id="">
		<ul class="am-navbar-nav am-cf am-avg-sm-4">
<%-- 			<li><a href="${ctx}/comment/forwordPage/1/${shopDetials.id}.do" --%>
<!-- 				class=""> <i class="am-navbar-label am-icon-pencil"></i> <span -->
<!-- 					class="am-navbar-label">写评论</span> -->
<!-- 			</a></li> -->
<li><a href="#" onclick="ERROR()"
				class=""> <i class="am-navbar-label am-icon-pencil"></i> <span
					class="am-navbar-label">写评论</span>
			</a></li>
			<li><a href="tel:${storeDetials.phone }" class="order">

					<button type="button" class="am-btn am-btn-danger"
						style="margin-top: 10px">立即预约</button>
			</a></li>

		</ul>
	</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		//收藏按钮点击
		$(".am-icon-star").click(function() {
			var url = "";
			var status = "";
			if ($(this).hasClass('iconActive')) {
				url = "${ctx}/collection/cancel/1/${shopDetials.id}.do";
				status = "cancel";
			} else {
				status = "add";
				url = "${ctx}/collection/addCollection/1/${shopDetials.id}.do";
			}
			changeStatus(url, status);
		})
		getByAjax();
	})
	var centerSearchShop = {
		keyWord : "",
		searchClass : "SearchPo",
		t : "",
		desc : "",
		returnType : "shop",
		pageNumStr : 1,
		numPerPageStr : 3,
		method : "1",
		timeId : "",
		peopleNum : "",
		x : "",
		y : "",
		field1 : "",
		field2 : "",
		field3 : "",
		field4 : "",
		field5 : ""
	};

	var searchPoShop = {
		searchType : "",
		playType : "",
		firstTypeName : "",
		firstTypeId : "",
		secondTypeName : "",
		secondTypeId : "",
		biosphere : "",
		city : cityName,
		themeName : "",// 吃住游购娱
		shopTheme : "",// 主烧烤
		themetzShop : "",// 主题 亲子
		projectShop : project,// 项目 吃住游购娱
		field1 : "",
		field2 : "",
		field3 : "",
		field4 : "",
		field5 : ""
	};
	var isFlagShop = true;
	function getByAjax() {
		if (!isFlagShop) {
			return;
		}
		centerSearchShop.t = JSON.stringify(searchPoShop);
		var datas = JSON.stringify(centerSearchShop);
		$
				.ajax({
					type : "POST",
					url : searchUrl,
					dataType : "json",// (可以不写,默认)
					data : {
						data : datas
					},
					beforeSend : function(XMLHttpRequest) {
						progress.inc();
					},
					success : function(datas, textStatus) {
						var data = datas.recordList;
						// 如果为空了
						var htmls = "";
						for (var i = 0; i < data.length; i++) {
							if (data[i].shopNumber == '${shopDetials.shopNumber}') {
								continue;
							}
							htmls += "<a href='${ctx}/shop/searchBySN.do?shopNumber="
									+ data[i].shopNumber
									+ "'><div class='bg-wh'><ul id='tb-one'><div class='clear'>";
							htmls += "<li><img class='am-radius' alt='140*140' src='"+ data[i].shopHeadPic + "'></li>";
							htmls += "<li class='td-sd'><div class='tt'>"
									+ data[i].shopName
									+ "</div> <span class='place'>"
									+ data[i].city + "·" + data[i].district
									+ "</span><div>";
							htmls += "<span class='people'>";
							if (data[i].shopPrice == 0) {
								htmls += "询价";
							} else {
								if (data[i].peopleNum == 1) {
									htmls += data[i].shopPrice + "元/人";
								} else {
									htmls += data[i].shopPrice + "元/"
											+ data[i].peopleNum + "人";
								}
							}
							htmls+="</span></div></li></ul></div></a>";
						}
						$("#youLike").html(htmls);
						isFlagShop = false;
					},
					complete : function(XMLHttpRequest, textStatus) {
						progress.done(true);
					},
					error : function() {
						alert("加载失败请重试");
						progress.done(true);
					}
				});
	}
	function changeStatus(url, status) {
		$.ajax({
			type : "POST",
			url : url,
			dataType : "json",// (可以不写,默认)
			beforeSend : function(XMLHttpRequest) {
				// 				progress.inc();
			},
			success : function(datas, textStatus) {
				if (datas.status == "error") {
					alert(datas.content);
				} else if (datas.status == "success") {
					$("#collection").text(datas.content+"人收藏");
					if (status == "add") {
						$(".am-icon-star").addClass("iconActive");
					} else {
						$(".iconActive").removeClass("iconActive");
					}
				}

			},
			complete : function(XMLHttpRequest, textStatus) {
				// 				progress.done(true);
			},
			error : function() {
				alert("操作异常，请刷新页面重试。");
				// 				progress.done(true);
			}
		});
	}
	function ERROR(){
		alert("此功能暂未开放，请耐心等待哦~");
	}
</script>
</html>