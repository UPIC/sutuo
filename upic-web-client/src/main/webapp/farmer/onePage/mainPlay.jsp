<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<c:set value="1" var="menuId" scope="page" />
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
<link rel="stylesheet" href="${upic}/assets/css/home.css" />
<script type="text/javascript" src="${upic}/assets/js/jquery.min.js"></script>
<%-- <script type="text/javascript" src="${upic}/assets/js/weixin.js"></script> --%>
<script src="${upic}/assets/js/amazeui.js">
	
</script>
<title>我在这里等你</title>
</head>
<c:set value="0" var="nums" />
<c:set value="0" var="number" />
<script
	src="http://api.map.baidu.com/api?v=2.0&ak=Nw2KfqchH0PuDpIcuVbtx6Tk3xzaCMXR"
	type="text/javascript"></script>

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
	function TITLE(){
		alert("此功能将在五月中旬开放，敬请期待哦~");
	}
</script>

<body>

	<header data-am-widget="header" class="am-header ">
	<div class="am-header-left am-header-nav">
		<a href="${ctx}/init/cityWithoutQu.do" class="">
			<div class="am-header-nav-title" id="citys">
				${city} <i class="am-header-icon am-icon-chevron-down am-icon-xs"></i>
			</div>
		</a>
	</div>

	<div class="am-header-title">

		<div class="am-u-lg-6" onclick="loadSearch('${keyWord}');">
			<div class="am-form-group am-form-icon">
				<i class="am-icon-search"></i> <input type="text"
					class="am-form-field">
			</div>
		</div>

	</div>

	<div class="am-header-right am-header-nav">
		<a href="#right-link" class=""> <span class="am-header-nav-title">
				搜索</span> <i class="am-header-icon am-icon-chevron-right"></i>
		</a>
	</div>
	</header>


	<!--<div class="abc">
        <ul class="am-nav am-nav-tabs">
            <li class="am-active aa"><a href="#" class="aaa">玩乐</a></li>
            <li><a href="#" class="aaa">教育</a></li>
            <li><a href="#" class="aaa">出行圈</a></li>
            
        </ul>
    </div>-->
	<%-- <div>
		<ul class="am-nav am-nav-tabs am-nav-justify">
			<li class="am-active"><a href="#">玩乐</a></li>
			<li class="china" style="background-image: url(assets/i/china.jpg)"><a
				href="${ctx}/pin/initIndex.do">品农</a></li>
			<!-- 			<li><a href="home2.html">出行圈</a></li> -->
		</ul>
	</div> --%>

	<div class="bb">

		<div class="am-slider am-slider-default" data-am-flexslider
			id="demo-slider-0">
			<ul class="am-slides">
				<c:forEach items="${mainPic}" var="pic">
					<li><a
						href='<c:if test="${ empty pic.forwordType}">#</c:if>
					<c:if test="${ ! empty pic.forwordType}">${pic.forwordId}</c:if>
					'><img
							src="${pic.url}" /></a></li>
				</c:forEach>
				<%--             <li><img src="${upic}/assets/i/pic1.jpg" /></li> --%>
				<%--             <li><img src="${upic}/assets/i/pic2.jpg" /></li> --%>
			</ul>
		</div>
		<div class="clear"></div>
		<div class="">
			<ul>
				<c:forEach items="${themeArea}" var="list" begin="0" end="4">
					<c:if test="${list.description eq '品农' }">
						<li class="middle">
							<%-- 						<a href="${ctx}/pin/initIndex.do"> <img --%> <%-- 								src="${list.picUrl }" /><br /> <span class="text"> --%>
							<%-- 									${list.description }</span> --%> <!-- 						</a> -->
							<a href="#" onclick="TITLE();"> <img src="${list.picUrl }" /><br />
								<span class="text"> ${list.description }</span>
						</a>
						</li>
					</c:if>
					<c:if test="${list.description ne '品农' }">
						<li class="middle"><a
							href="${ctx}/search/readyGetSearchData/${city}/1.do?theme=${list.description }&keyWord=empty">
								<img src="${list.picUrl }" /><br /> <span class="text">
									${list.description }</span>
						</a></li>
					</c:if>
				</c:forEach>

				<%-- 				<a onClick="loadNeed(1)"><li class="middle"><img src="${upic}/assets/i/p7.png" /><br /> --%>
				<!-- 					<span class="text">附近</span></li></a> -->
				<%-- 				<li class="middle"><img src="${upic}/assets/i/p8.png" /><br /> --%>
				<!-- 					<span class="text">最热</span></li> -->
				<!-- 				<li class="middle"><a href="single.html"> <img -->
				<%-- 						src="${upic}/assets/i/p9.png" /><br /> <span class="text">周末</span> --%>
				<!-- 				</a></li> -->
				<%-- 				<li class="middle"><img src="${upic}/assets/i/p10.png" /><br /> --%>
				<!-- 					<span class="text">发布</span></li> -->
				<%-- 				<li class="middle"><img src="${upic}/assets/i/p11.png" /><br /> --%>
				<!-- 					<span class="text">熟人圈</span></li> -->
			</ul>
			<%-- <ul>
				<c:forEach items="${themeArea}" var="list" begin="5" end="9">
					<li class="middle"><a
						href="${ctx}/search/readyGetSearchData/${city}/1.do?project=${list.description }&keyWord=empty">
							<img src="${list.picUrl }" /><br /> <span class="text">
								${list.description }</span>
					</a></li>
				</c:forEach>
			</ul> --%>
		</div>
	</div>


	<table class="am-table am-table-bordered">

		<tr>
			<c:forEach items="${activityArea}" var="area" begin="0" end="1">
				<td><a href="${area.forwordId}"><img class="am-circle"
						src="${area.picUrl}" />
						<div class="textarea">${area.description}</div></a></td>
			</c:forEach>
			<!-- 			<td><a href="detail3.html"><img class="am-circle" -->
			<%-- 								src="${upic}/assets/i/t2.jpg" /> --%>
			<!-- 				<div class="textarea">热门团购低到你无法想象</div></a></td> -->

		</tr>
		<tr>
			<c:forEach items="${activityArea}" var="area" begin="2" end="3">
				<td><a href="${area.forwordId}"><img class="am-circle"
						src="${area.picUrl}" />
						<div class="textarea">${area.description}</div></a></td>
			</c:forEach>
			<!-- 						<td><a href="detail3.html"><img class="am-circle" -->
			<%-- 								src="${upic}/assets/i/t3.jpg" /> --%>
			<!-- 							<div class="textarea">节日狂欢嗨爆全场</div></a></td> -->
			<!-- 						<td><a href="detail3.html"><img class="am-circle" -->
			<%-- 								src="${upic}/assets/i/t4.jpg" /> --%>
			<!-- 							<div class="textarea">邀请有礼</div></a></td> -->

		</tr>


	</table>
	<div class="clear"></div>

	<c:forEach items="${moduleList}" var="list">
		<div class="clear"></div>
		<div class="box1">
			<div class="area">
				<span class="high">${list.moduleName }</span><br /> <span
					class="baby">${list.title}</span>
			</div>
			<c:if test="${!empty list.pic }">
				<div class="center-img">
					<img src="${list.pic}" />
			</c:if>
		</div>
		<div class="clear"></div>
		<c:if test="${list.field1 eq '1'}">
			<div class="box2">
				<ul class="nochange">
					<c:forEach items="${youXuan}" var="youxuan">
						<c:if test="${youxuan.moduleListId eq list.id}">
							<c:set value="${number+1}" var="number" />
							<li class="td"><a
								href="${ctx}/shop/searchBySN.do?shopNumber=${youxuan.shopNumber}"><img
									src="${youxuan.pic }" /><br />
									<div class="ttex">${youxuan.shopName }</div>
									<div class="small">
<%-- 										<c:if test="${youxuan.price == 0 }">询价</c:if> --%>
<%-- 										<c:if test="${youxuan.price gt 0 }">${youxuan.price }元/<c:if --%>
<%-- 												test="${youxuan.peopleNum gt 0}">${youxuan.peopleNum }</c:if>人</c:if> --%>
									</div>
									</a></li>
						</c:if>
					</c:forEach>
				</ul>
				<div class="foot">${number}个套餐
					<i class="am-icon-angle-right"></i>
				</div>
			</div>
		</c:if>



		<c:if test="${list.field1 eq '2'}">
			<div class="am-slider am-slider-default" data-am-flexslider
				id="demo-slider-0">
				<ul class="am-slides">

					<c:forEach items="${youXuan}" var="youxuan" varStatus="i">
						<c:if test="${youxuan.moduleListId eq list.id}">
							<c:set value="${nums+1}" var="nums" />
							<c:if test="${nums+1%2==0 }">
								<li>
							</c:if>
							<div class="run-box">
								<img src="${youxuan.pic }" />
								<div class="ttex">${youxuan.shopName }</div>
								<div class="small">
<%-- 									<c:if test="${youxuan.price == 0 }">询价</c:if> --%>
<%-- 									<c:if test="${youxuan.price gt 0 }">${youxuan.price }元/<c:if --%>
<%-- 											test="${youxuan.peopleNum gt 0}">${youxuan.peopleNum }</c:if>人</c:if> --%>
								</div>
							</div>
							<c:if test="${nums%2==0 }">
								</li>
							</c:if>
						</c:if>
					</c:forEach>
				</ul>
			</div>
		</c:if>
		<div class="bg"></div>
	</c:forEach>

	<div class="box1">
		<div class="area">
			<span class="high">优选</span><br /> <span class="baby">高品位 高颜值</span>
		</div>
	</div>
	<div class="libox">

		<ul id="liboxs">
		</ul>
	</div>

	<div id="notAnyMore" style="text-align: center;">沒有更多了</div>
	<%@ include file="../common/common.jsp"%>

</body>
<script type="text/javascript">
	var isCanGet = true;
	var progress = $.AMUI.progress;
	var pageNum = 0;
	var numPerPage = 10;
	var pageCount = 0;
	// 	var urls = "${searchFarmer}";
	function reget(citys, pageNums) {
		if (pageNum + 1 == pageCount) {

			return;
		}
		if (pageCount == -1) {
			return;
		}
		if (!isCanGet) {
			return;
		}
		isCanGet = false;
		$
				.ajax({
					type : "POST",
					url : "${ctx}/search/searchBySM.do",
					dataType : "json",//(可以不写,默认)
					data : {
						type : "shop",
						pageNumStr : pageNums + 1,
						numPerPageStr : numPerPage,
						method : 1,
						city : '${city}'
					},
					beforeSend : function(XMLHttpRequest) {
						progress.inc();
					},
					success : function(datas, textStatus) {
						// 						var datas=eval("(" + datass + ")");
						pageCount = datas.pageCount;
						if (pageCount == 0 || pageCount == 1) {
							pageCount = -1;
						}
						var htmls = "";
						var data = datas.recordList;
						for (var i = 0; i < data.length; i++) {
							htmls += "<a href='${ctx}/shop/searchBySN.do?shopNumber="
									+ data[i].shopNumber + "'>"
							htmls += "<li class='shop'>";
							htmls += "<div class='left'>";
							htmls += "<img class='am-radius' alt='140*140'  src='"+data[i].shopHeadPic+"' width='120' height='90' /> </div>";
							htmls += "<div class='right'>" + data[i].shopTitle
									+ "<br /><span class='one'>" + data[i].city
									+ "·" + data[i].district + "</span><br />";
							htmls += "<span class='two'> ";
// 							if (data[i].shopPrice == 0) {
// 								htmls += "询价";
// 							} else {
// 								if (data[i].peopleNum == 1) {
// 									htmls += data[i].shopPrice + "元/人";
// 								} else {
// 									htmls += data[i].shopPrice + "元/"
// 											+ data[i].peopleNum + "人";
// 								}
// 							}
							htmls += "</br></span>";
							if (data[i].project != "isEmpty") {
								var a = data[i].project.split(",");
								htmls += "<div class='three-big'>"
								for (var j = 0; j < a.length; j++) {
									if (a[j] != "" && a[j] != '') {

										htmls += "<div class='three'>";
										htmls += a[j];
										htmls += "</div> ";
									}
								}
								htmls += "</div>";
							}
							htmls += "</div> </li></a>";
						}
						$("#liboxs").append(htmls);
						pageNum++;
						isCanGet = true;
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

	var totalheight = 0;//定义一个总的高度变量
	$(window).scroll(
			function() {
				totalheight = parseFloat($(window).height())
						+ parseFloat($(window).scrollTop());//浏览器的高度加上滚动条的高度
				if ($(document).height() <= totalheight) //当文档的高度小于或者等于总的高度的时候，开始动态加载数据
				{
					if (pageNum + 1 == pageCount) {
						$("#notAnyMore").show();
						return;
					}
					if (isCanGet) {
						reget('${city}', pageNum);
					}
				}
			});

	function loadNeed(obj) {
		location.href = '${ctx}/search/readyGetSearchData/' + citys.city + '/'
				+ obj + '.do';
	}
	$(function() {
		reget('${city}', pageNum);
	})
	function loadSearch(keyword) {
		location.href = '${ctx}/search/forwordSearch/${city}/' + keyword
				+ '.do';
	}
</script>
</html>