<%-- 权限模块:操作员管理:添加或修改页面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<style>
<!--
.pageFormContent fieldset label {
	width: 200px;
}
-->
</style>
<div class="pageContent">
	<form id="form" method="post" action="typePn_createMeituTypePn.action"
		class="pageForm required-validate"
		enctype="multipart/form-data"
		onsubmit="return iframeCallback(this);">
		<div class="pageFormContent" layoutH="60">
			<p style="width: 99%">
				<label>文章标题：</label> <input name="title" value=""
					cssClass="required" minlength="1"  size="30" />
			</p>
			<p style="width: 99%">
				<label>文章题目：</label> <input name="articName" value=""
					cssClass="required" minlength="1" maxlength="30" size="30" />
			</p>
			<p style="width: 99%">
				<label>文章主题：</label> <select id="sel" name="themeName">
					<option selected="selected" value="1">请选择</option>
					<c:forEach items="${themePn}" var="list">
						<option value="${list.themePn }">${list.themePn }</option>
					</c:forEach>
				</select>
			</p>
			<p style="width: 99%">
				<label>显示图片：</label> <input id="cardFront1" type="file" name="files" />
			<div id="message"></div>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="button">
						<div class="buttonContent">
							<button type="button" onclick="submitForm();">保存</button>
						</div>
					</div></li>
				<li><div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div></li>
			</ul>
		</div>
	</form>
	<script type="text/javascript">
		function submitForm() {
			var s = $("#sel").val();
			if (s == 1) {
				alert("请选择文章主题");
				return false;
			}
			$("#form").submit();
			$.pdialog.closeCurrent();
		}
	</script>
</div>
