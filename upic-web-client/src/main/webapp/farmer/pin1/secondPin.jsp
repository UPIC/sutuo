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
<link rel="stylesheet" href="${upic}/assets/css/pin.css" />
<script type="text/javascript" src="${upic}/assets/js/jquery.min.js"></script>
<script src="${upic}/assets/js/amazeui.js">
	
</script>
<script type="text/javascript">
	var linksId = '${linkId}';
	var themesName = '${themeName}';
	var pageNumStrs = 1;
	var numPerPageStrs = 5;
	var pageCount = 0;
	var progress = $.AMUI.progress;
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
	<!-- 	<h1 class="am-header-title"> --> <!-- 		品 <span class="wen">文</span> -->
	<!-- 	</h1> -->
	<h1 class="am-header-title">
		<c:if test="${!empty linkId }">${linkName}</c:if>
		<c:if test="${!empty themeName }">${themeName}</c:if>
	</h1>
	<div class="am-header-right am-header-nav"></div>
	</header>
	<!-- 放置内容 -->
	<div id="content"></div>
</body>
<script type="text/javascript">
	function getContent() {
		if (pageCount == -1) {
			return;
		}
		if (pageCount != 0) {
			if (pageNumStrs + 1 > pageCount) {
				return;
			}
		}

		var urls = '';
		var obj = '';
		if (linksId == '' || linksId == "") {
			urls = '${ctx}/pin/getByThemeName.do';
			obj = themesName;
		} else if (themesName == '' || themesName == "") {
			urls = '${ctx}/pin/getByLinkId.do';
			obj = linksId;
		}
		$
				.ajax({
					type : "POST",
					url : urls,
					dataType : "json",// (可以不写,默认)
					data : {
						data : obj,
						pageNumStr : pageNumStrs,
						numPerPageStr : numPerPageStrs
					},
					beforeSend : function(XMLHttpRequest) {
						progress.inc();
					},
					success : function(datas, textStatus) {
						pageCount = datas.pageCount;
						if (pageCount == 0) {
							pageCount = -1;
						}
						var data = datas.recordList;
						addHtml(data);
						pageNumStrs++;
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
	function addHtml(data) {
		if(linksId == '' || linksId == ""){
			var htmls = '';
			for (var i = 0; i < data.length; i++) {
				htmls += "<a href='${ctx}/pin/getByNumber/"+data[i].id+".do'><div class='big'>";
				htmls += "<div class='box1'>2017年1月14日21：00</div>";
				htmls += "<div class='box2'>" + data[i].articName
						+ "</div>";
				htmls += "<img src='"+data[i].picUrl+"' height='180' />";
				htmls += "<div class='box3'>"
				data[i].title
				"</div>";
				htmls += "<div class='hr'></div><div class='box4'>阅读全文<i class='am-icon-chevron-right'></i></div></div></a>";
			}
			$("#content").append(htmls);
		}else if(themesName == '' || themesName == ""){
			var htmls = '';
			for (var i = 0; i < data.length; i++) {
				htmls += "<a href='${ctx}/pin/getByNumber/"+data[i].typePnId+".do'><div class='big'>";
				htmls += "<div class='box1'>2017年1月14日21：00</div>";
				htmls += "<div class='box2'>" + data[i].articalName
						+ "</div>";
				htmls += "<img src='"+data[i].pic+"' height='180' />";
				htmls += "<div class='box3'>"
				data[i].title
				"</div>";
				htmls += "<div class='hr'></div><div class='box4'>阅读全文<i class='am-icon-chevron-right'></i></div></div></a>";
			}
			$("#content").append(htmls);
		}
	}
	$(function() {
		getContent();
	})
	$(window).scroll(
			function() {
				totalheight = parseFloat($(window).height())
						+ parseFloat($(window).scrollTop());// 浏览器的高度加上滚动条的高度
				if ($(document).height() <= totalheight) // 当文档的高度小于或者等于总的高度的时候，开始动态加载数据
				{
					getContent();
				}
			});
</script>
</html>