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
	<form id="form" method="post" action="banner_updateMainImg.action"
		class="pageForm required-validate" enctype="multipart/form-data"
		onsubmit="return iframeCallback(this);">
		<div class="pageFormContent" layoutH="60">
			<p style="width: 99%">
				<label>图片编号：</label>${mainPic.picNumber}<input name="picNumber" value="${mainPic.picNumber}"
					type="number" cssClass="required" />
			</p>
			<p style="width: 99%">
				<label>图片文件：</label><img src="${mainPic.url}" style="width: 300px;height: 300px;"/> <input name="file"
					 type="file" />
			</p>
			<p style="width: 99%">
				<label>图片类型：</label>${mainPic.picType} <input name="picType" value="${mainPic.picType}"
					cssClass="required" maxlength="30" size="30" />
			</p>
			<p style="width: 99%">
				<label>跳转类型：</label>${mainPic.forwordType} <input name="forwordType" value="${mainPic.forwordType}"
					cssClass="required" maxlength="30" size="30" />
			</p>
			<p style="width: 99%">
				<label>跳转ID：</label>${mainPic.forwordId}</p>
			<input name="forwordId" cssClass="required"  value="${mainPic.forwordId}" />
		</div>
		<input type="hidden" name="id" value="${mainPic.id}">
		<input type="hidden" name="status" value="${mainPic.status}">
		<input type="hidden" name="url" value="${mainPic.url}">
		<input type="hidden" name="version" value="${mainPic.version}">
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
