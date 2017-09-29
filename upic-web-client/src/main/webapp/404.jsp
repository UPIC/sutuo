<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>404</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <meta name="apple-mobile-web-app-title" content="Amaze UI" />

    <link rel="stylesheet" href="${ctx}/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="${ctx}/assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="${ctx}/assets/css/app.css">

</head>

<body data-type="widgets">
    <script src="${ctx}/assets/js/theme.js"></script>

        <!-- 内容区域 -->
        <div class="tpl-content-wrapper">



            <div class="row-content am-cf">
                <div class="widget am-cf">
                    <div class="widget-body">
                        <div class="tpl-page-state">
                            <div class="tpl-page-state-title am-text-center tpl-error-title">404</div>
                            <div class="tpl-error-title-info">Page Not Found</div>
                            <div class="tpl-page-state-content tpl-error-content">
                                <p>对不起,没有找到您所需要的页面</p>
                                <button type="button" onClick="returnPage()" class="am-btn am-btn-secondary am-radius tpl-error-btn">返回</button></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>

</body>
<script type="text/javascript">
function returnPage(){
	window.history.back(-1); 
}
</script>
</html>