<%-- 权限模块:操作员管理:添加或修改页面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<style>
<!--
.pageFormContent fieldset label{
	width: 200px;
}
-->
</style>
<div class="pageContent">
	<form id="form" method="post" action="teacher_editteacher.action" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="60">
		    <input type="hidden" name="navTabId" value="listPmsOperator">
			<input type="hidden" name="callbackType" value="closeCurrent">
			<input type="hidden" name="forwardUrl" value="">
			<s:hidden id="id" name="id" />
			<s:hidden id="userId" name="userId" />
			<p style="width:99%">
				<label>教师名称：</label>
				<input name="teacherName" value="${teacher.teacherName}" cssClass="required" minlength="2" maxlength="15" size="30" readonly="true"/>
			</p>
			<p style="width:99%">
				<label>身份证号：</label>
				<input name="teacherAddressDetailedAddress" value="${teacher.idCard}" cssClass="required" readonly="true" minlength="3" maxlength="30" size="30" />
			</p>
			<p style="width:99%">
				<label>手机号码：</label>
				<input name="mobileNo" cssClass="required mobile" value="${teacher.phoneNumber }"  maxlength="12" size="30" readonly="readonly"/>
			</p>
				<p style="width:99%">
				<label>邮箱：</label>
				<input name="mobileNo" cssClass="required mobile" value="${teacher.email }"  maxlength="12" size="30" readonly="readonly"/>
			</p>
			<p style="width:99%">
				<label>状态：</label>
				<c:choose>
					<c:when test="${teacher.status eq 100}">激活</c:when>
					<c:when test="${teacher.status eq 101}">冻结</c:when>
					<c:when test="${teacher.status eq 102}">申请中</c:when>
					<c:otherwise>--</c:otherwise>
				</c:choose>
			</p>
				<p style="width:99%">
				<label>照片：</label>
				<img alt="" src="${teacher.teacherPicture}" >
			</p>
				<p style="width:99%">
				<label>身份证：</label>
				<img alt="" src="${teacher.picture}" >
			</p>
			
				<p style="width:99%">
				<label>教师资格证：</label>
				<img alt="" src="${teacher.teacherCertification}" >
			</p>
			
			
		</div>
		<div class="formBar">
			<ul>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">确定</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
