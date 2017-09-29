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
	<form id="form" method="post" action="shop_updateData.action"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="60">
			<p style="width: 99%">
				<label>商户编号：</label> <input name="storeNumber" value="${store.storeNumber}"
					cssClass="required" minlength="1"  size="30" readonly="readonly"/>
			</p>
			<p style="width: 99%">
				<label>商户名：</label> <input name="storeName"
					value="${store.storeName}" cssClass="required" minlength="3"
					maxlength="30" size="30" readonly="readonly"/>
			</p>
			<p style="width: 99%">
				<label>公司名称：</label> <input name="companyName"
					value="${store.companyName}" cssClass="required" minlength="3"
					maxlength="30" size="30" readonly="readonly"/>
			</p>
			<p style="width: 99%">
				<label>联系人：</label> 
				<input name="linkName"
					value="${store.linkName}" cssClass="required" minlength="3"
					maxlength="30" size="30" readonly="readonly"/>
			</p>
			<p style="width: 99%">
				<label>联系人手机号：</label> <input name="phone" value="${store.phone}"
					cssClass="required" minlength="3" maxlength="30" size="30" readonly="readonly"/>
			</p>
			<p style="width: 99%">
				<label>主营业商品：</label> <input name="mainShops" cssClass="required"
					 size="30" value="${store.mainShops}"readonly="readonly" />
			</p>
			<p>
			<label>类型</label>
			</p>
			<p style="width: 99%">
				<label>省：</label> <input name="provinceName" value="${store.provinceName}"
					cssClass="required" minlength="3" maxlength="30" size="30" readonly="readonly"/>
			</p>
			<p style="width: 99%">
				<label>市：</label> <input name="cityName"
					value="${store.cityName}" cssClass="required" minlength="3"
					maxlength="30" size="30" readonly="readonly"/>
			</p>
			<p style="width: 99%">
				<label>区：</label> <input name="districtName"
					value="${store.districtName}" cssClass="required"
					minlength="3" maxlength="30" size="30" readonly="readonly" />
			</p>
			<p>
			<label>标签</label>
			<c:forEach items="${storeSinLink}" var="list">
				${list.storeSign}
			</c:forEach>
			</p>
			<p style="width: 99%">
				<label>公司简介：</label> 
				${store.storeBrief}
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="button">
						<div class="buttonContent">
							<button type="button" class="close">确定</button>
						</div>
					</div></li>
			</ul>
		</div>
	</form>
</div>
