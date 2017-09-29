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
	<form id="form" method="post" action="themePn_updateActiveArea.action"
		class="pageForm required-validate" enctype="multipart/form-data"
		onsubmit="return iframeCallback(this);">
		<div class="pageFormContent" layoutH="60">
			<p style="width: 99%">
				<label>图片编号：</label>${themePn.num}<input name="num" value="${themePn.num}"
					type="number" cssClass="required" />
			</p>
				<p style="width: 99%">
				<label>标题：</label>${themePn.themePn}<input name="themePn" value="${themePn.themePn}"
					 cssClass="required" />
			</p>
			<p style="width: 99%">
				<label>图片文件：</label><img src="${themePn.themePnPic}" /> <input name="files"
					 type="file" />
			</p>
			<input type="hidden" name="id" value="${themePn.id}">
<%-- 		<input type="hidden" name="status" value="${themePn.status}"> --%>
		<input type="hidden" name="themePnPic" value="${themePn.themePnPic}">
		</div>
		<div class="formBar">
			<ul>
				<li><div class="button">
						<div class="buttonContent">
							<button type="button" onclick="submitForm();">更新</button>
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
			$("#form").submit();
			$.pdialog.closeCurrent();
		}
	</script>
</div>
