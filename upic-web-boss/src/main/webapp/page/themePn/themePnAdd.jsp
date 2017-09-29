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
	<form id="form" method="post" action="themePn_insert.action"
		class="pageForm required-validate"
		onsubmit="return iframeCallback(this);"
		enctype="multipart/form-data">
		<div class="pageFormContent" layoutH="60">
			<p style="width: 99%">
				<label>图片编号：</label> <input name="num" value="" type="number"
					cssClass="required" />
			</p>
			<p style="width: 99%">
				<label>标题名称：</label> <input name="themePn" value="" type="themePnNum"
					cssClass="required" />
			</p>
			<p style="width: 99%">
				<label>图片文件：</label>
					<input name="files" type="file" accept="image/*" class="valid" />
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
			$("#form").submit();
			$.pdialog.closeCurrent();
		}
		
	</script>
</div>
