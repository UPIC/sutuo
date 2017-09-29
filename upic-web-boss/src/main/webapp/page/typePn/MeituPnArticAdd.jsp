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
	<form id="form" method="post" action="typePn_getDetialsByTypePnId.action"
		class="pageForm required-validate"
		enctype="multipart/form-data"
		onsubmit="return iframeCallback(this);">
		<div class="pageFormContent" layoutH="60">
		<input type="hidden" value="${fatherId}" name="id">
			<p style="width: 99%">
				<label>编号：</label> <input name="num" value="" type="number"
					cssClass="required" />
			</p>
			<p style="width: 99%">
				<label>显示图片：</label> <input id="cardFront1" type="file" name="files" />
			<div id="message"></div>
			</p>
			<p style="width: 100%">
				<label>内容编辑：</label>
				<textarea  name="content"
					style="width: 500px; height: 500px" maxlength="250"></textarea>
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
