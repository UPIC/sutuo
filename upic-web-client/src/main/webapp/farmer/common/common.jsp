<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--引导 -->
<!-- 	<div class="navCir"> -->
<%-- 		<li class="${menuId==1 ?'active':'' }"><a href="${ctx}/init/initIndex.do"><i --%>
<!-- 				class="am-icon-home "></i>首页</a></li> -->
<%-- 		<li class="${menuId==2 ?'active':'' }"><a href="${ctx}/shop/getSort/a.do"><i class="am-icon-list"></i>分类</a></li> --%>
<%-- 		<li class="${menuId==3 ?'active':'' }"><a href="${ctx}/car/carList.do"><i --%>
<!-- 				class="am-icon-shopping-basket"></i>购物车</a></li> -->
<%-- 		<li class="${menuId==4 ?'active':'' }"><a href="${ctx}/orgin/person/home.jsp"><i class="am-icon-user"></i>我的</a></li> --%>
<!-- 	</div> -->
	
	   <div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default"
         id="">
        <ul class="am-navbar-nav am-cf am-avg-sm-4" style="background-color:white">
            <li style="background-color:white">
                <a href="${ctx}/init/initIndex.do" class="">
                    <img src="${upic}/assets/i/img/home.png" />
                    <span class="am-navbar-label" style="color:black">首页</span>
                </a>
            </li>
<!--             <li style="background-color:white"> -->
<!--                 <a href="" class=""> -->
<%--                     <img src="${upic}/assets/i/p4.png" /> --%>
<!--                     <span class="am-navbar-label" style="color:black">聚游</span> -->
<!--                 </a> -->
<!--             </li> -->
            <li style="background-color:white">
                <a href="" class="">
                    <img src="${upic}/assets/i/p1.png" style="height:40px; width:40px" />
                </a>
            </li>
<!--             <li style="background-color:white"> -->
<!--                 <a href="" class=""> -->
<%--                     <img src="${upic}/assets/i/p5.png" /> --%>
<!--                     <span class="am-navbar-label" style="color:black">心愿</span> -->
<!--                 </a> -->
<!--             </li> -->
<!--             <li style="background-color:white"> -->
<%--                 <a href="${ctx}/farmer/person/person.jsp" class=""> --%>
<%--                     <img src="${upic}/assets/i/img/person.png" /> --%>
<!--                     <span class="am-navbar-label" style="color:black">我的</span> -->
<!--                 </a> -->
<!--             </li> -->
            <li style="background-color:white">
                <a href="${ctx}/farmer/comment/userComment.jsp" class="">
                    <img src="${upic}/assets/i/img/person.png" />
                    <span class="am-navbar-label" style="color:black">反馈</span>
                </a>
            </li>

        </ul>
    </div>
</body>
</html>