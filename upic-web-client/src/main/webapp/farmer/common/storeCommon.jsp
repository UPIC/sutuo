<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	  <div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default "
		id="">
		<ul class="am-navbar-nav am-cf am-avg-sm-4"
			style="background-color: white">
			<li><a href="${ctx}/store/${storeNumber}/searchBySM.do" class=""> <span
					class="am-navbar-label" style="color: #3BC89C"><i
						class="am-icon-home "></i>首页</span>
			</a></li>
			<li><a href="${ctx}/${storeNumber}/searchGoodShopByThemAndStoreNumber.do" class=""> <span
					class="am-navbar-label" style="color: #B6B6B6"><i
						class="am-icon-list"></i>分类</span>
			</a></li>
			<li><a href="dynamic.html" class=""> <span
					class="am-navbar-label" style="color: #B6B6B6"><i
						class="am-icon-file-sound-o"></i>动态</span>
			</a></li>
		</ul>
	</div>
</body>
</html>