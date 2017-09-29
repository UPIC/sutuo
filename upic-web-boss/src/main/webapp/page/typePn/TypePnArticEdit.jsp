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
		action="typePn_updateArticOrSeeMeitu.action"
		class="pageForm required-validate" enctype="multipart/form-data"
		onsubmit="return iframeCallback(this);">
		<div class="pageFormContent" layoutH="60">
			<input type="hidden" name="id" value="${typePn.id }"> 
			<input type="hidden" name="articId" value="${articalPn.id }"> 
			<input type="hidden" name="typePn" value="${typePn.typePn }"> 
			<input type="hidden" name="status" value="${typePn.status }"> 
			<input
				type="hidden" name="picUrl" value="${typePn.picUrl}"> <input
				type="hidden" name="version" value="${typePn.version}">
		<p style="width: 99%">
				<label>文章标题：</label> <input name="title" value="${typePn.title }"
					cssClass="required" minlength="1"  size="30" />
			</p>
			<p style="width: 99%">
				<label>文章题目：</label> <input name="articName" value="${typePn.articName }"
					cssClass="required" minlength="1" maxlength="30" size="30" />
			</p>
			<p style="width: 99%">
				<label>作者：</label> <input name="author" value="${articalPn.author }"
					cssClass="required" minlength="1" maxlength="30" size="30" />
			</p>
				<p style="width: 99%">
				<label>文章主题：</label> <select id="sel" name="themeName">
					<c:forEach items="${themePn}" var="list">
						<option value="${list.themePn }"
							<c:if test="${list.themePn eq typePn.themeName}"> selected="selected"</c:if>>${list.themePn}</option>
					
					</c:forEach>
				</select>
			</p>
			<p style="width: 99%">
				<label>显示图片：</label> <input id="cardFront1" type="file" name="files" />
			<div id="message"></div>
			</p>
			<p style="width: 100%">
				<label>内容编辑：</label>
				<textarea class="editor" name="content"
					style="width: 500px; height: 500px">${articalPn.content }</textarea>
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