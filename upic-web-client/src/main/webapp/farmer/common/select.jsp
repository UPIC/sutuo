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
<link rel="stylesheet" href="${upic}/assets/css/city1.css" />
<script type="text/javascript" src="${upic}/assets/js/jquery.min.js"></script>
<script src="${upic}/assets/js/amazeui.js">
	
</script>
<script
	src="http://api.map.baidu.com/api?v=2.0&ak=Nw2KfqchH0PuDpIcuVbtx6Tk3xzaCMXR"
	type="text/javascript"></script>
<title></title>
</head>
<body>
	<header data-am-widget="header" class="am-header">
	<div class="am-header-left am-header-nav">
		<a href="javascript:history.go(-1);"><i
			class="am-icon-chevron-left"></i></a>
	</div>
	<h1 class="am-header-title">选择城市</h1>

	<div class="am-header-right am-header-nav"></div>
	</header>
	<div class="box">

		<div class="currcity">
			<div class="currcity-title">
				<span class="currity-span">当前定位城市：</span> <a class="currcity-link"
					id="Id1" onclick="loads();">杭州</a>
			</div>
		</div>
		<div class="list">

			<c:forEach items="${listBy}" var="listBy" varStatus="list">
				<li><a href="${ctx}/init/initSelect.do?city=${listBy.cityName}">${listBy.cityName}</a></li>
			</c:forEach>
		</div>
	</div>
</body>
<script type="text/javascript">
	function getLocation() {
		var options = {
			enableHighAccuracy : true,
			maximumAge : 1000
		}
		if (navigator.geolocation) {
			//浏览器支持geolocation
			navigator.geolocation.getCurrentPosition(onSuccess, onError,
					options);
		} else {
			//浏览器不支持geolocation
			alert('您的浏览器不支持地理位置定位');
		}
	}

	//成功时
	function onSuccess(position) {
		//返回用户位置
		//经度
		var longitude = position.coords.longitude;
		//纬度
		var latitude = position.coords.latitude;
		// 		alert('经度' + longitude + '，纬度' + latitude);
		//根据经纬度获取地理位置，不太准确，获取城市区域还是可以的
		var map = new BMap.Map("allmap");
		var point = new BMap.Point(longitude, latitude);
		var gc = new BMap.Geocoder();
		gc.getLocation(point, function(rs) {
			var addComp = rs.addressComponents;
			// 		alert(addComp.province + ", " + addComp.city + ", "
			// 				+ addComp.district + ", " + addComp.street + ", "
			// 				+ addComp.streetNumber);
// 			districts = addComp.city;

			$("#Id1").html(addComp.city);
		});
	}
	//失败时
	function onError(error) {
		switch (error.code) {
		case 1:
			alert("位置服务被拒绝");
			break;

		case 2:
			alert("暂时获取不到位置信息");
			break;

		case 3:
			alert("获取信息超时");
			break;

		case 4:
			alert("未知错误");
			break;
		}
	}
	window.onload = getLocation;

	function loads() {
		var citys = $.trim($("#Id1").text());
		location.href = "${ctx}/init/initSelect.do?city=" + citys;
	}
</script>
</html>