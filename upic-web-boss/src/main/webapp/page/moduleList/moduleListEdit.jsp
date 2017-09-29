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
	<form id="form" method="post"
		action="moduleList_updateModuleList.action"
		class="pageForm required-validate" enctype="multipart/form-data"
		onsubmit="return iframeCallback(this);">
		<div class="pageFormContent" layoutH="60">
			<p style="width: 99%">
				<label>模版编号：</label>${moduleList.num}<input name="num"
					value="${moduleList.num}" type="number" cssClass="required" />
			</p>
			<p style="width: 99%">
				<label>图片文件：</label><img src="${moduleList.pic}"
					style="width: 300px; height: 300px;" /> <input name="file"
					type="file" />
			</p>
			<p style="width: 99%">
				<label>跳转地址：</label>${moduleList.forwordAddress} <input
					name="forwordAddress" value="${moduleList.forwordAddress}"
					cssClass="required" maxlength="30" size="30" />
			</p>
			<p style="width: 99%">
				<label>跳转类型：</label>${moduleList.forwordType} <input
					name="forwordType" value="${moduleList.forwordType}"
					cssClass="required" maxlength="30" size="30" />
			</p>
			<p style="width: 99%">
				<label>跳转ID：</label>${moduleList.forwordId}</p>
			<input name="forwordId" cssClass="required"
				value="${moduleList.forwordId}" />
		</div>
		<input type="hidden" name="id" value="${moduleList.id}"> <input
			type="hidden" name="status" value="${moduleList.status}"> <input
			type="hidden" name="url" value="${moduleList.pic}"> <input
			type="hidden" name="version" value="${moduleList.version}">
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
