<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
<head>
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
<script type="text/javascript" src="${upic}/assets/js/weixin.js"></script>
<link rel="stylesheet" href="${upic}/assets/css/amazeui.min.css">
<link rel="stylesheet" href="${upic}/assets/css/search.css">
<link rel="stylesheet" type="text/css"
	href="${upic}/assets/css/style.css" />

<style type="text/css">
#box {
	display: none;
}
</style>
</head>
<script type="text/javascript">
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
</script>
<body>
	<header>
	<form action="${ctx}/search/readyGetSearchData/${city}/1.do"
		class="am-form am-form-inline">
		<div class="am-form-group am-form-icon ">
			<i class="am-icon-search"></i> <input type="search"
				id="keyWord" name="keyWord"class="am-form-field" placeholder="${keyWord}"
				style="border-radius: 20px" id="show">
		</div>
		<span class="cal"><a href="javascript:history.go(-1);">取消</a></span>

	</form>
	</header>
	<div class="clear"></div>
	<div id="keywordDiv" class="bodybox">
		<div class="txt">热门搜索</div>

		<table>
			<c:forEach items="${ listKeyWord}" var="listKeyWord" varStatus="list">
				<c:if test="${list.index%3==0 }">
					<tr>
				</c:if>
				<td><a href="${ctx}/search/readyGetSearchData/${city}/1.do?keyWord=${listKeyWord.keyWord}">${listKeyWord.keyWord}</a></td>
				<c:if test="${(list.index+1)%3==0 }">
					</tr>
				</c:if>
			</c:forEach>
		</table>
	</div>
	<div id="box">
		<ul id="keyWords">
		</ul>
	</div>

	<script type="text/javascript">
		// 		function show() {
		// 			document.getElementById('box').style.display = 'block';
		// 		}
		// 		function dis() {
		// 			document.getElementById('box').style.display = 'none';
		// 		}
		var oldVal = "";
		$(function() {
			$('#keyWord').bind('input propertychange', function() {
				if ($.trim($(this).val()) == oldVal) {
					return;
				}
				oldVal = $.trim($(this).val());
				if ($(this).val().length > 0) {
					var o = document.getElementById("box").style.display;
					if (o == "none") {
						document.getElementById('box').style.display = 'block';
						document.getElementById('keywordDiv').style.display = 'none';
					}
				} else {
					document.getElementById('box').style.display = 'none';
					document.getElementById('keywordDiv').style.display = 'block';
				}
				getContentByKeyWord(oldVal);
			});
			
			document.getElementById('keywordDiv').style.display = 'block';
			document.getElementById('box').style.display = 'none';

		})
		function getContentByKeyWord(keyWord) {
			$
					.ajax({
						type : "POST",
						url : "${searchKeyWord}",
						dataType : "json",// (可以不写,默认)
						data : {
							keyWord : keyWord,
							city : '${city}'
						},
						success : function(datas, textStatus) {
							var htmls = "";
							for (var i = 0; i < datas.length; i++) {
								htmls += "<li><a href='${ctx}/search/readyGetSearchData/${city}/1.do?keyWord="+datas[i].keyWord+"'><i class='am-icon-search'></i> <span>"
										+ datas[i].keyWord + "</span>";
								htmls += "<div class='right'>点击查询</div></a></li>";
							}
							if (htmls == "") {
								htmls += "<li><a href='${ctx}/search/readyGetSearchData/${city}/1.do?keyWord="+oldVal+"'><i class='am-icon-search'></i> <span>搜索“"
										+ oldVal + "”</span>";
								htmls += "<div class='right'>点击查询</div></a></li>";
							}
							$("#keyWords").html(htmls);
						},
						error : function() {
							alert("加载失败请重试");
// 							progress.done(true);
						}
					});
		}
	</script>
</body>
</html>