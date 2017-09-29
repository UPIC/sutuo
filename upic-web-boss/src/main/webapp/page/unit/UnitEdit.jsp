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
	<form id="form" method="post" action="train_editTraining.action" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="60">
		    <input type="hidden" name="navTabId" value="listPmsOperator">
			<input type="hidden" name="callbackType" value="closeCurrent">
			<input type="hidden" name="forwardUrl" value="">
			<s:hidden id="id" name="id" />
			<s:hidden id="userId" name="userId" />
			<p style="width:99%">
				<label>公司名称：</label>
				<input name="unitName" value="${unit.unitName}" cssClass="required" minlength="2" maxlength="15" size="30" readonly="true"/>
			</p>
			<p style="width:99%">
				<label>公司地址：</label>
				<input name="unitAddressDetiledAddress" value="${unit.unitAddressDetiledAddress}" cssClass="required" readonly="true" minlength="3" maxlength="30" size="30" />
			</p>
			<p style="width:99%">
				<label>手机号码：</label>
				<input name="mobileNo" cssClass="required mobile" value="${unit.phoneNumber}" maxlength="12" size="30"  readonly="readonly"/>
			</p>
			<p style="width:99%">
				<label>邮箱：</label>
				<input name="mobileNo" cssClass="required mobile" value="${unit.email }"  maxlength="12" size="30" readonly="readonly"/>
			</p>
			<p style="width:99%">
				<label>法人代表：</label>
				<input name="mobileNo" cssClass="required mobile" value="${unit.linkManName }"  maxlength="12" size="30" readonly="readonly"/>
			</p>
				<p style="width:99%">
				<label>状态：</label>
				<c:choose>
					<c:when test="${unit.status eq 100}">激活</c:when>
					<c:when test="${unit.status eq 101}">冻结</c:when>
					<c:otherwise>--</c:otherwise>
				</c:choose>
			</p>
				<p style="width:99%">
				<label>营业执照（三证合一）：</label>
				<img alt="" src="${unit.threeCertficate}" >
			</p>
		</div>
			<div class="formBar">
			<ul>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
