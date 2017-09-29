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
	<form id="form" method="post" action="shopType_insertData.action"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="60">
		<p style="width: 99%">
				<label>一级类型名称：</label> <select name="firstTypeId">
					<option value="">请选择</option>
					<c:forEach items="${firstList}" var="statusVar">
						<option value="${statusVar.id}">${statusVar.firstType}</option>
					</c:forEach>
				</select>
			</p>
			<p style="width: 99%">
				<label>类型名称：</label> <input name="typeName" value=""
					cssClass="required" minlength="2" maxlength="15" size="30"
					 />
			</p>
			
		<div class="formBar">
			<ul>
				<li><div class="button">
						<div class="buttonContent">
							<button type="button" onclick="submitForm();">添加</button>
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
	function submitForm(){
		$("#form").submit();	
		$.pdialog.closeCurrent();
	}
	</script>
</div>
