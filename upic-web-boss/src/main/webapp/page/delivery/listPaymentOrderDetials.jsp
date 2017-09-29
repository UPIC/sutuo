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
	  <table class="table" width="100%"  layoutH="135">
    <thead>
    <tr>
      <th width="5%">序号</th>
      <th width="4%">商品名字</th>
      <th width="9%">商品数量</th>
      <th width="5%">商品单价</th>
      <th width="6%">商品种类</th>
      <th width="6%">商品规格</th>
    </tr>
    </thead>
    <tbody>
     <s:iterator value="orderDetials" status="st">
      <tr>
        <td>${st.index+1}</td>
        <td>${shopName}</td>
        <td>${shopCount}</td>
         <td>${shopPrice}</td>
        <td>${shopType}</td>
        <td>${shopformat}</td>
      </tr>
    </s:iterator>
    <c:if test="${pageBean.totalCount==0}"><tr><td>暂无数据</td></tr></c:if>
    </tbody>
  </table>
</div>
