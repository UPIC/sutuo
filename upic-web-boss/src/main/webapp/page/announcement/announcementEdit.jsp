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
	<form id="form" method="post" action="announ_updateAnnouncement.action"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="60">
			<input type="hidden" id="id" name="id" value="${announcement.id}" />
			<input type="hidden" id="status" name="status"
				value="${announcement.status}" /> <input type="hidden"
				id="createTime" name="createTime" value="${announcement.createTime}" />
			<input type="hidden" id="version" name="version"
				value="${announcement.version}" />
			<p style="width: 99%">
				<label>标题：</label> <input name="title" value="${announcement.title}"
					cssClass="required" size="60">
			</p>
				<p style="width: 99%">
				<label>链接地址：</label> <input name="contenetUrl" value="${announcement.contenetUrl}"
					cssClass="required" size="60">
			</p>
			<p style="width: 99%">
				<label>状态：</label>
				<c:choose>
					<c:when test="${announcement.status eq 100}">上架中</c:when>
					<c:when test="${announcement.status eq 101}">未上架</c:when>
					<c:otherwise>--</c:otherwise>
				</c:choose>
			</p>

			<p style="width: 99%">
				<label>内容编辑：</label>
				<textarea class="editor" name="content"
					style="width: 500px; height: 500px">${announcement.content}</textarea>
			</p>
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
