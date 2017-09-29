<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>

<div class="pageHeader">
  <form id="pagerForm" onsubmit="return navTabSearch(this);" action="reTrad_listPaymentRecord.action"
        method="post">
          <%@include file="/page/inc/pageForm.jsp"%>
    <div class="searchBar">
      <table class="searchContent">
        <tr>
          <td>商户编号：
            <input type="text" name="merchantNo" value="${paymentOrderQueryVo.merchantNo}" />
          </td>
          <td>商户名称：
            <input type="text" name="merchantName" value="${paymentOrderQueryVo.merchantName}" />
          </td>
          <td>商户订单号：
            <input type="text" name="merchantOrderNo" value="${paymentOrderQueryVo.merchantOrderNo}" />
          </td>
          <td>状态：

            <select name="status" >
              <option value="" >请选择</option>
              <c:forEach items="${statusEnums}" var="statusVar">
                <option value="${statusVar.key}"
                        <c:if test="${paymentOrderQueryVo.status == statusVar.key}"> selected="selected"</c:if>
                        >${statusVar.value.desc}</option>
              </c:forEach>
            </select>
          </td>
          <td>资金流入类型：
            <select name="fundIntoType" >
              <option value="" >请选择</option>
              <c:forEach items="${fundIntoTypeEnums}" var="fundIntoTypeVar">
                <option value="${fundIntoTypeVar.key}"
                        <c:if test="${paymentOrderQueryVo.fundIntoType == fundIntoTypeVar.key}"> selected="selected"</c:if>
                        >${fundIntoTypeVar.value.desc}</option>
              </c:forEach>
            </select>
          </td>
        </tr>
        <tr>
          <td>
            下单开始日期:<input type="text" name="orderDateBegin" value="${paymentOrderQueryVo.orderDateBegin}" class="date textInput readonly" readonly="true">
          </td>
          <td>
            下单结束日期:<input type="text" name="orderDateEnd" value="${paymentOrderQueryVo.orderDateEnd}" class="date textInput readonly" readonly="true">
            <td>支付方式：
            <select name="payWayName" >
              <option value="" >请选择</option>
              <c:forEach items="${payWayNameEnums}" var="payWayNameVar">
                <option value="${payWayNameVar.value.desc}"
                        <c:if test="${paymentOrderQueryVo.payWayName == payWayNameVar.value.desc}"> selected="selected"</c:if>
                        >${payWayNameVar.value.desc}</option>
              </c:forEach>
            </select>
          </td>
          <td>支付类型：
            <select name="payTypeName" >
              <option value="" >请选择</option>
              <c:forEach items="${payTypeNameEnums}" var="payTypeNameVar">
                <option value="${payTypeNameVar.value.desc}"
                        <c:if test="${paymentOrderQueryVo.payTypeName == payTypeNameVar.value.desc}"> selected="selected"</c:if>
                        >${payTypeNameVar.value.desc}</option>
              </c:forEach>
            </select>
          </td>
          <td>
            <div class="buttonActive">
              <div class="buttonContent">
                <button title="查询" type="submit">查&nbsp;询</button>
              </div>
            </div>
          </td>
          </td>
        </tr>
     
      </table>
    </div>
  </form>
</div>
<div class="pageContent" style="overflow: scroll;">
  <table class="table" width="100%" layoutH="135">
    <thead>
    <tr>
      <th width="3%">序号</th>
      <th width="4%">商家名称</th>
      <th width="7%">商户订单号</th>
      <th width="4%">创建时间</th>
      <th width="4%">业务类型</th>
      <th width="4%">支付方式</th>
      <th width="4%">支付类型</th>
<!--       <th width="9%">支付流水号</th> -->
      <th width="7%">银行订单号</th>
      <th width="4%">订单金额</th>
      <th width="5%">状态</th>
      <th width="6%">成功支付时间</th>
    </tr>
    </thead>
    <tbody>
   
     <s:iterator value="recordList" status="st">
      <tr>
        <td>${st.index+1}</td>
        <td>${merchantName}</td>
        <td>${merchantOrderNo}</td>
        <td><fmt:formatDate value="${createTime}"
                            pattern="yyyy-MM-dd HH:mm:ss" /></td>
        <td>
          <c:forEach items="${trxTypeEnums}" var="trxTypeVar">
            <c:if test="${trxType == trxTypeVar.key}">${trxTypeVar.value.desc}</c:if>
          </c:forEach>
        </td>
        <td>${payWayName}</td>
        <td>${payTypeName}</td>
<%--         <td>${trxNo}</td> --%>
        <td>${bankOrderNo}</td>
        <td>
          <fmt:parseNumber type="number" pattern="#,#00.0#">${orderAmount}</fmt:parseNumber>
        </td>
        <td>
          <c:forEach items="${statusEnums}" var="statusVar">
            <c:if test="${status == statusVar.key}">${statusVar.value.desc}</c:if>
          </c:forEach>
        </td>
        <td><fmt:formatDate value="${paySuccessTime}"
        pattern="yyyy-MM-dd HH:mm:ss" /></td>
        </td>
      </tr>
   </s:iterator>
    <c:if test="${pageBean.totalCount==0}"><tr><td>暂无数据</td></tr></c:if>
    </tbody>
  </table>
  <%@include file="/page/inc/pageBar.jsp" %>
<%--    <s:debug>调试</s:debug> --%>
</div>
