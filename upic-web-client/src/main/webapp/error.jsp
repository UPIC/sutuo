<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var progress = $.AMUI.progress;

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
</head>
<body>${exception.message}
</body>
</html>

