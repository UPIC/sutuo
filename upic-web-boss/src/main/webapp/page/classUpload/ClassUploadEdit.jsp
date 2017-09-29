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
				<label>课程名称：</label>
				<input name="classes.className" value="${classUpload.classes.className}" cssClass="required" minlength="2" maxlength="15" size="30" readonly="true"/>
			</p>
			<p style="width:99%">
				<label>课程介绍：</label>
				<input name="classBrief" value="${classUpload.classBrief}" cssClass="required" readonly="true" minlength="3" maxlength="30" size="30" />
			</p>
			<p style="width:99%">
				<label>预计报名开始时间：</label>
				<input name="startApplyTime" cssClass="required mobile" value="${classUpload.startApplyTime}" maxlength="12" size="30"  readonly="readonly"/>
			</p>
			<p style="width:99%">
				<label>预计报名结束时间：</label>
				<input name="endApplyTime" cssClass="required mobile" value="${classUpload.endApplyTime }"  maxlength="12" size="30" readonly="readonly"/>
			</p>
			<p style="width:99%">
				<label>预计开课时间：</label>
				<input name="startTime" cssClass="required mobile" value="${classUpload.startTime }"  maxlength="12" size="30" readonly="readonly"/>
			</p>
			<p style="width:99%">
				<label>课程价格：</label>
				<input name="classPrice" cssClass="required mobile" value="${classUpload.classPrice }"  maxlength="12" size="30" readonly="readonly"/>
			</p>
				<p style="width:99%">
				<label>状态：</label>
				<c:choose>
					<c:when test="${classUpload.status eq 100}">已通过</c:when>
					<c:when test="${unit.status eq 101}">未通过</c:when>
					<c:otherwise>--</c:otherwise>
				</c:choose>
			</p>
		</div>
			<div class="formBar">
			<ul>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
