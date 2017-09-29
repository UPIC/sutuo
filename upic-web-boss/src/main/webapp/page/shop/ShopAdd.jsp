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
	<form id="form" method="post" action="shop_insertShopData.action"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="60">
			<p style="width: 99%">
				<label>商品名称：</label> <input name="shopName" value=""
					cssClass="required" minlength="1"  size="30" />
			</p>
			<p style="width: 99%">
				<label>商品促销价：</label> <input name="shopPrice" value=""
					cssClass="required" minlength="3" maxlength="30" size="30" />元
			</p>
			<p style="width: 99%">
				<label>商品原价：</label> <input name="primeCost"
					 cssClass="required" minlength="3"
					maxlength="30" size="30" />元
			</p>
			<p style="width: 99%">
				<label>商品类型：</label> <select id="sel" name="shopType">
					<option selected="selected" value="1">请选择</option>
					<c:forEach items="${shopType}" var="list">
						<option value="${list.typeName }">${list.typeName }</option>
					</c:forEach>
				</select>
			</p>
			<p style="width: 99%">
				<label>库存：</label> <input name="inventory" cssClass="required"
					minlength="3" maxlength="30" size="30" />
			</p>
			<p style="width: 99%">
				<label>购买最小数额：</label> <input name="limitCount" cssClass="required"
					 size="30" />
			</p>
			<p style="width: 99%">
				<label>规格：</label> <input name="format" cssClass="required"
					minlength="3" maxlength="30" size="30" />
			</p>
			<p style="width: 99%">
				<label>产地：</label> <input name="placeOfOrigin" cssClass="required"
					minlength="3" maxlength="30" size="30" />
			</p>
			<p style="width: 99%">
				<label>保质期：</label> <input name="qualityGuaranteePeriod"
					cssClass="required" minlength="3" maxlength="30" size="30" />
			</p>
			<p style="width: 99%">
				<label>食品添加剂：</label> <input name="foodAddiitive"
					cssClass="required" minlength="3" maxlength="30" size="30" />
			</p>
			<p style="width: 99%">
				<label>存储温度：</label> <input name="storageTemp" cssClass="required"
					minlength="3" maxlength="30" size="30" />
			</p>
			<p style="width: 99%">
				<label>标题：</label> <input name="shopTitle" value=""
					cssClass="required"  size="60">
			</p>
			<p style="width: 99%">
				<label>照片：</label> <input id="cardFront1" type="file" name="file" />
			<div id="message"></div>
			</p>
			<p style="width: 100%">
				<label>内容编辑：</label>
				<textarea class="editor" name="content"
					style="width: 500px; height: 500px"></textarea>
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
				alert("请选择商品类型");
				return false;
			}
			$("#form").submit();
			$.pdialog.closeCurrent();
		}
	</script>
</div>
