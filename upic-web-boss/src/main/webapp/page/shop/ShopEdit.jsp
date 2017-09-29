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
				<label>商品名称：</label>${shop.shopName}
			</p>
			<p style="width: 99%">
				<label>商品编号：</label>${shop.shopNumber}
			</p>
			<p style="width: 99%">
				<label>商户编号：</label>${shop.storeNumber}
			</p>
			<p style="width: 99%">
				<label>商品名称：</label>${shop.shopName}
			</p>
			<p style="width: 99%">
				<label>商品促销价：</label>${shop.shopPrice}元</p>
			<p style="width: 99%">
				<label>商品原价：</label> ${shop.primeCost}元
			</p>
			<p style="width: 99%">
				<label>商品类型：</label>${shop.shopType}
			</p>
			<p style="width: 99%">
				<label>库存：</label> ${shop.inventory}
			</p>
			<p style="width: 99%">
				<label>购买最小数额：</label> ${shop.limitCount}
			</p>
<!-- 			<p style="width: 99%"> -->
<%-- 				<label>规格：</label> ${shop.format} --%>
<!-- 			</p> -->
			<p style="width: 99%">
				<label>标题：</label> ${shop.shopTitle}
			</p>
			
			
			<c:if test="${shop.shopClass eq 'FARM' }">
				<p style="width: 99%">
					<label>产地：</label> ${shopDetials.placeOfOrgin}
				</p>
				<p style="width: 99%">
					<label>保质期：</label> ${shopDetials.qualityGuaranteePeriod}
				</p>
				<p style="width: 99%">
					<label>食品添加剂：</label> ${shopDetials.foodAddiitive}
				</p>
				<p style="width: 99%">
					<label>存储温度：</label> ${shopDetials.storageTemp}
				</p>
			</c:if>
			
			<c:if test="${shop.shopClass eq 'TICKET' }">
				<p style="width: 99%">
					<label>活动开始时间：</label> <fmt:formatDate value="${shopDetials.startTime }"
							pattern="yyyy-MM-dd" />
				</p>
				<p style="width: 99%">
					<label>活动结束时间：</label><fmt:formatDate value="${shopDetials.endTime }"
							pattern="yyyy-MM-dd" />
				</p>
				<p style="width: 99%">
					<label>活动规则：</label> ${shopDetials.relus}
				</p>
				<p style="width: 99%">
					<label>购买须知：</label> ${shop.purchaseNotes}
				</p>
			</c:if>
			
			<p style="width: 99%">
				<label>总销量：</label> ${all}
			</p>
			<p style="width: 99%">
				<label>照片：</label>
				<c:forEach items="${ shopPic}" var="list">
					<img alt="" src="${list.picUrl}">
				</c:forEach>
			</p>
			<p style="width: 99%">
				<label>内容编辑：</label> ${shop.content}
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
