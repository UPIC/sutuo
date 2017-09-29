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
<link rel="stylesheet" href="${upic}/assets/css/commont.css" />
<script type="text/javascript" src="${upic}/assets/js/jquery.min.js"></script>
<script src="${upic}/assets/js/amazeui.js">
</script>
<script type="text/javascript" src="${upic}/assets/js/weixin.js"></script>
<title></title>
</head>
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
	var typeId = "${typeId}";
	var objId = '${objId}';
	var ctx = '${ctx}';
	function addComment() {
		if($("#content").val()==null||$("#content").val()==""||$("#content").val()==''){
			return;
		}
		$.ajax({
			type : "POST",
			url : "${ctx}/comment/addComment/" + typeId + "/" + objId + ".do",
			dataType : "json",// (可以不写,默认)
			beforeSend : function(XMLHttpRequest) {
				progress.inc();
			},
			data:{
				content:$("#content").val()
			},
			success : function(datas, textStatus) {
				if (datas.status == "success") {
					alert(datas.content);
					self.location = document.referrer;
				} else if (datas.status == "error") {
					alert(datas.content);
					return;
				}
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
</script>
<%-- <script src="${upic}/assets/js/comment.js"></script> --%>
<body>
	<div class="headerbox">
		<header data-am-widget="header" class="am-header ">
		<div class="am-header-left am-header-nav">
			<a href="javascript:history.go(-1);" class="" style="color: gray"> 取消 </a>
		</div>

		<div class="am-header-title" style="color: black">发布瞬间</div>

		<div class="am-header-right am-header-nav">
			<a href="#" onclick="addComment()" class=""
				style="color: gray"> 发布 </a>
		</div>
		</header>
	</div>
	<div class="main">
		<textarea id="content" s tyle="width: 100%; height: 100%" rows="5"></textarea>
		<!--<div class="am-form-group">
            <img src="assets/i/2.jpg" style="width:100px; height:100px" />
            <img src="assets/i/3.jpg" style="width:100px; height:100px" />
        </div>
        <div class="say">
            请至少选择一张照片
        </div>-->

	</div>
	<div class="share">
		<ul>
			<li>同步至</li>
			<li><img src="${upic}/assets/i/QQ.png" width="20" height="20" /></li>
			<li><img src="${upic}/i/wei.png" width="20" height="20" /></li>
			<li><img src="${upic}/i/quan.png" width="20" height="20" /></li>
		</ul>
	</div>
</body>
</html>