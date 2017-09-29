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
<script src="${upic}/assets/js/amazeui.js">
	
</script>
<title></title>

</head>
<script
	src="http://api.map.baidu.com/api?v=2.0&ak=Nw2KfqchH0PuDpIcuVbtx6Tk3xzaCMXR"
	type="text/javascript"></script>

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
			<div class="am-input-group">
				<span class="am-input-group-btn">
					<button class="am-btn am-btn-default am-round" type="button">
						<span class="am-icon-search"></span>
					</button>
				</span> <input type="text" placeholder="${keyWord}" id="keyWord"
					class="am-form-field am-round">
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
						<li class="middle"><a
							href="${ctx}/pin/initIndex.do">
								<img src="${list.picUrl }" /><br /> <span class="text">
									${list.description }</span>
						</a></li>
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

	<div class="clear"></div>
	<div class="box1">
		<div class="area">
			<span class="high">亲子</span><br />
			<span class="baby">带上baby 去踏青</span>
		</div>
	</div>
	<%-- <div class="center-img"><img src="${upic}/assets/i/a.jpg" /></div> --%>
	<div class="clear"></div>
	<div class="box2">

		<ul class="nochange">
			<c:forEach items="${youxuan}" var="youxuan" begin="0" end="1">
				<li class="td"><a
					href="${ctx}/shop/searchBySN.do?shopNumber=${youxuan.shopNumber}"><img
						src="${youxuan.pic }" /><br />
						<div class="ttex">${youxuan.shopName }</div>
						<div class="small">${youxuan.price }元/${youxuan.peopleNum }人</div></a>
				</li>
			</c:forEach>


			<c:forEach items="${youxuan}" var="youxuan" begin="2" end="3">
				<li class="td"><a
					href="${ctx}/shop/searchBySN.do?shopNumber=${youxuan.shopNumber}"><img
						src="${youxuan.pic }" /><br />
						<div class="ttex">${youxuan.shopName }</div>
						<div class="small">${youxuan.price }元/${youxuan.peopleNum }人</div></a>
				</li>
			</c:forEach>
		</ul>



		<div class="foot">${fn:length(youxuan)}个套餐
			<i class="am-icon-angle-right"></i>
		</div>

	</div>
	<div class="bg"></div>

	<div class="clear"></div>
	<div class="box1">
		<div class="area">
			<span class="high">周末</span><br />
			<span class="baby">周末 High</span>
		</div>
	</div>
	<div class="center-img">
		<img src="${upic}/assets/i/a.jpg" />
	</div>
	<div class="clear"></div>
	<div class="box3">
		<div class="am-slider am-slider-default" data-am-flexslider
			id="demo-slider-0">
			<ul class="am-slides">
				<li><c:forEach items="${youxuan}" var="youxuan" begin="0"
						end="1">

						<ul>
							<li class="td"><a
								href="${ctx}/shop/searchBySN.do?shopNumber=${youxuan.shopNumber}"><img
									src="${youxuan.pic }" />
									<div class="ttex">${youxuan.shopName }</div>
									<div class="small">${youxuan.price }元/${youxuan.peopleNum }人</div></a>
							</li>
						</ul>
					</c:forEach></li>
				<li><c:forEach items="${youxuan}" var="youxuan" begin="0"
						end="1">

						<ul>
							<li class="td"><a
								href="${ctx}/shop/searchBySN.do?shopNumber=${youxuan.shopNumber}"><img
									src="${youxuan.pic }" />
									<div class="ttex">${youxuan.shopName }</div>
									<div class="small">${youxuan.price }元/${youxuan.peopleNum }人</div></a>
							</li>
						</ul>
					</c:forEach></li>
			</ul>
		</div>



	</div>



	<div class="bg"></div>
	<div class="box1">
		<div class="area">
			<span class="high">优选</span><br />
			<span class="baby">高品位 高颜值</span>
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
							htmls += "<span class='two'> ￥" + data[i].shopPrice
									+ "</span>";
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

					reget('${city}', pageNum);
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