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
	<form id="form" method="post" action="youxuan_insert.action"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="60">
			<p style="width: 99%">
				<label>省：</label> <select name="provinceName" id="province1">
					<option value="">请选择</option>
					<c:forEach items="${province}" var="statusVar">
						<option value="${statusVar.id}"
							<c:if test="${youXuan.provinceName == statusVar.provinceName}"> selected="selected"</c:if>>${statusVar.provinceName}</option>
					</c:forEach>
				</select>
			</p>
			<p style="width: 99%">
				<label>市：</label> <select name="city" id="city1">
					<option value="">请选择</option>
				</select>
			</p>
			<p style="width: 99%">
				<label>区：</label> <select name="districtName" id="district1">
					<option value="">请选择</option>
				</select>
			</p>
			<p style="width: 99%">
				<label>农庄名：</label> <select name="storeNumber" id="store">
					<option value="">请选择</option>
				</select>
			</p>
			<p style="width: 99%">
				<label>优选产品名：</label> <select name="shopNumber" id="shop">
					<option value="">请选择</option>
				</select>
			</p>
			<p style="width: 99%">
				<label>序号：</label> <input type="number" name="num">
			</p>
			<p style="width: 99%">
				<label>模版选择：</label><select name="moduleListId" id="moduleListId">
					<option value="">请选择</option>
					<c:forEach items="${moduleList}" var="list">
					<option value="${list.id}">${list.moduleName}</option>
					</c:forEach>
				</select>
			</p>
			<input type="hidden" name="storeName" id="storeName"> <input
				type="hidden" name="shopName" id="shopName">
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
		function submitForm() {
			$("#storeName").find("option:selected").val(
					$("#storeName").find("option:selected").text());
			$("#shopName").find("option:selected").val(
					$("#shopName").find("option:selected").text());
			$("#province1").find("option:selected").val(
					$("#province1").find("option:selected").text());
			$("#district1").find("option:selected").val(
					$("#district1").find("option:selected").text());
			$("#city1").find("option:selected").val(
					$("#city1").find("option:selected").text());
			$("#form").submit();
			$.pdialog.closeCurrent();
		}
		$(document)
				.ready(
						function() {
							//获取城市
							$('#province1')
									.change(
											function() {
												var p1 = $(this).children(
														'option:selected')
														.val();//这就是selected的值
												$("#district")
														.html(
																"<option selected='selected' value='请选择'>请选择</option>");
												$
														.ajax({
															type : "POST",
															url : "ajax_getAllCity.action",
															dataType : "json",// (可以不写,默认)
															data : {
																provinceId : p1
															},
															beforeSend : function(
																	XMLHttpRequest) {
															},
															success : function(
																	datas,
																	textStatus) {
																htmls = "<option selected='selected' value='请选择'>请选择</option>";
																datas = eval('('
																		+ datas
																		+ ')');
																for (var i = 0; i < datas.length; i++) {
																	htmls += "<option  value='"+datas[i].id+"'>"
																			+ datas[i].cityName
																			+ "</option>";
																}
																$("#city1")
																		.html(
																				htmls);
															},
															complete : function(
																	XMLHttpRequest,
																	textStatus) {
															},
															error : function() {
															}
														});
											})
							//获取区域
							$('#city1')
									.change(
											function() {
												var p1 = $(this).children(
														'option:selected')
														.val();//这就是selected的值
												// 							$("#district").html("<option selected='selected' value='请选择'>请选择</option>");
												$
														.ajax({
															type : "POST",
															url : "ajax_getAllDistrict.action",
															dataType : "json",// (可以不写,默认)
															data : {
																cityId : p1
															},
															beforeSend : function(
																	XMLHttpRequest) {
															},
															success : function(
																	datas,
																	textStatus) {
																htmls = "<option selected='selected' value='请选择'>请选择</option>";
																datas = eval('('
																		+ datas
																		+ ')');
																for (var i = 0; i < datas.length; i++) {
																	htmls += "<option  value='"+datas[i].id+"'>"
																			+ datas[i].districtName
																			+ "</option>";
																}
																$("#district1")
																		.html(
																				htmls);
															},
															complete : function(
																	XMLHttpRequest,
																	textStatus) {
															},
															error : function() {
															}
														});
											})

							$('#district1')
									.change(
											function() {
												var p1 = $(this).children(
														'option:selected')
														.text();//这就是selected的值
												$
														.ajax({
															type : "POST",
															url : "ajax_getAllStoreByDistrict.action",
															dataType : "json",// (可以不写,默认)
															data : {
																district : p1
															},
															beforeSend : function(
																	XMLHttpRequest) {
															},
															success : function(
																	datas,
																	textStatus) {
																htmls = "<option selected='selected' value='请选择'>请选择</option>";
																datas = eval('('
																		+ datas
																		+ ')');
																for (var i = 0; i < datas.length; i++) {
																	htmls += "<option  value='"+datas[i].id+"_"+datas[i].storeNumber+"_"+datas[i].storeName+"'>"
																			+ datas[i].storeName
																			+ "</option>";
																}
																$("#store")
																		.html(
																				htmls);
															},
															complete : function(
																	XMLHttpRequest,
																	textStatus) {
															},
															error : function() {
															}
														});
											})
							$('#store')
									.change(
											function() {
												var p = $(this).children(
														'option:selected')
														.val();//这就是selected的值
												// 							$("#district").html("<option selected='selected' value='请选择'>请选择</option>");
												var p1 = p.split("_");
												$
														.ajax({
															type : "POST",
															url : "ajax_getAllShopByStoreNumber.action",
															dataType : "json",// (可以不写,默认)
															data : {
																storeNum : p1[1]
															},
															beforeSend : function(
																	XMLHttpRequest) {
															},
															success : function(
																	datas,
																	textStatus) {
																htmls = "<option selected='selected' value='请选择'>请选择</option>";
																datas = eval('('
																		+ datas
																		+ ')');
																for (var i = 0; i < datas.length; i++) {
																	htmls += "<option  value='"+datas[i].id+"_"+datas[i].shopNumber+"_"+datas[i].shopName+"'>"
																			+ datas[i].shopName
																			+ "</option>";
																}
																$("#shop")
																		.html(
																				htmls);
															},
															complete : function(
																	XMLHttpRequest,
																	textStatus) {
															},
															error : function() {
															}
														});
											})

						})
	</script>
</div>
