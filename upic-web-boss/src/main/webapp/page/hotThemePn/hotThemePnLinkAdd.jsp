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
	<form id="form" method="post" action="hotThemePnLink_insertData.action"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);"
		>
		<div class="pageFormContent" layoutH="60">
			<p style="width: 99%">
				<label>文章选择：</label> <select id="sel" name="typePnId">
					<option selected="selected" value="x">请选择</option>
					<c:forEach items="${typePn}" var="list">
						<option value="${list.id }">${list.articName }</option>
					</c:forEach>
				</select>
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
		if (s == 'x') {
			alert("请选择文章主题");
			return false;
		}
		$("#form").submit();
		$.pdialog.closeCurrent();
	}
	</script>
</div>
