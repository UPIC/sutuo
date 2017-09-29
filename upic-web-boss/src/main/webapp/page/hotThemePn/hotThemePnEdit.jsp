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
	<form id="form" method="post" action="hotThemePn_updateHotThemePn.action"
		class="pageForm required-validate" enctype="multipart/form-data"
		onsubmit="return iframeCallback(this);">
		<div class="pageFormContent" layoutH="60">
			<p style="width: 99%">
				<label>标签编号：</label>${hotThemePn.num}<input name="num" value="${hotThemePn.num}"
					type="number" cssClass="required" />
			</p>
				<p style="width: 99%">
				<label>标题：</label>${hotThemePn.hotThemePn}<input name="hotThemePn" value="${hotThemePn.hotThemePn}"
					 cssClass="required" />
			</p>
			<p style="width: 99%">
				<label>图片文件：</label><img src="${hotThemePn.hotThemePnPic}" style="width: 300px;height: 300px;"/> <input name="file"
					 type="file" />
			</p>
			<input type="hidden" name="id" value="${hotThemePn.id}">
		<input type="hidden" name="status" value="${hotThemePn.status}">
		<input type="hidden" name="version" value="${hotThemePn.version}">
		<input type="hidden" name="hotThemePnPic" value="${hotThemePn.hotThemePnPic}">
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
