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
	<form id="form" method="post" action="activityArea_updateActiveArea.action"
		class="pageForm required-validate" enctype="multipart/form-data"
		onsubmit="return iframeCallback(this);">
		<div class="pageFormContent" layoutH="60">
			<p style="width: 99%">
				<label>图片编号：</label>${activityArea.activityAreaNum}<input name="activityAreaNum" value="${activityArea.activityAreaNum}"
					type="number" cssClass="required" />
			</p>
				<p style="width: 99%">
				<label>标题：</label>${activityArea.description}<input name="description" value="${activityArea.description}"
					 cssClass="required" />
			</p>
			<p style="width: 99%">
				<label>图片文件：</label><img src="${activityArea.picUrl}" style="width: 300px;height: 300px;"/> <input name="files"
					 type="file" value="${activityArea.picUrl}"/>
			</p>
			<p style="width: 99%">
				<label>跳转类型：</label>${activityArea.forwordType} <input name="forwordType"
					cssClass="required" maxlength="30" size="30" value="${activityArea.forwordType}" />
			</p>
			<p style="width: 99%">
				<label>跳转ID：</label>${activityArea.forwordId}
				<input name="forwordId" cssClass="required" value="${activityArea.forwordId}"/>
				</p>
			<input type="hidden" name="id" value="${activityArea.id}">
		<input type="hidden" name="status" value="${activityArea.status}">
		<input type="hidden" name="version" value="${activityArea.version}">
		<input type="hidden" name="picUrl" value="${activityArea.picUrl}">
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
