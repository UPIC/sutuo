//package com.upic.lucne.po;
//
///**
// * 搜索中央处理器（包括2级页面查询、活动查询、圈子查询等）变性类
// * @author Administrator
// *
// * @param <T>
// */
//public class CenterSearch<T> {
//	/**需要查询的类名**/
//	private String searchClass;
//	/**需要查询的类**/
//	private T t;
//	/**必要时进行描述**/
//	private String desc;
//	/**请求返回类型**/
//	private String returnType; 
//	/**当前页数**/
//	private String pageNumStr;
//	/**需要查询的条数**/
//	private String numPerPageStr;
//	/**排序方法名**/
//	private int method;
//	/**时间段ID**/
//	private String timeId;
//	/**精度**/
//	private String x;
//	/**维度**/
//	private String y;
//	/**扩展字段1**/
//	private String field1;
//	/**扩展字段2**/
//	private String field2;
//	/**扩展字段3**/
//	private String field3;
//	/**扩展字段4**/
//	private String field4;
//	/**扩展字段5**/
//	private String field5;
//	public String getSearchClass() {
//		return searchClass;
//	}
//	public void setSearchClass(String searchClass) {
//		this.searchClass = searchClass;
//	}
//	public T getT() {
//		return t;
//	}
//	public void setT(T t) {
//		this.t = t;
//	}
//	public String getDesc() {
//		return desc;
//	}
//	public void setDesc(String desc) {
//		this.desc = desc;
//	}
//	public String getReturnType() {
//		return returnType;
//	}
//	public void setReturnType(String returnType) {
//		this.returnType = returnType;
//	}
//	public String getField1() {
//		return field1;
//	}
//	public void setField1(String field1) {
//		this.field1 = field1;
//	}
//	public String getField2() {
//		return field2;
//	}
//	public void setField2(String field2) {
//		this.field2 = field2;
//	}
//	public String getField3() {
//		return field3;
//	}
//	public void setField3(String field3) {
//		this.field3 = field3;
//	}
//	public String getField4() {
//		return field4;
//	}
//	public void setField4(String field4) {
//		this.field4 = field4;
//	}
//	public String getField5() {
//		return field5;
//	}
//	public void setField5(String field5) {
//		this.field5 = field5;
//	}
//	public String getPageNumStr() {
//		return pageNumStr;
//	}
//	public void setPageNumStr(String pageNumStr) {
//		this.pageNumStr = pageNumStr;
//	}
//	public String getNumPerPageStr() {
//		return numPerPageStr;
//	}
//	public void setNumPerPageStr(String numPerPageStr) {
//		this.numPerPageStr = numPerPageStr;
//	}
//	public CenterSearch(String searchClass, T t, String desc, String returnType, String field1, String field2,
//			String field3, String field4, String field5) {
//		super();
//		this.searchClass = searchClass;
//		this.t = t;
//		this.desc = desc;
//		this.returnType = returnType;
//		this.field1 = field1;
//		this.field2 = field2;
//		this.field3 = field3;
//		this.field4 = field4;
//		this.field5 = field5;
//	}
//	public CenterSearch() {
//		super();
//	}
//	public int getMethod() {
//		return method;
//	}
//	public void setMethod(int method) {
//		this.method = method;
//	}
//	public String getTimeId() {
//		return timeId;
//	}
//	public void setTimeId(String timeId) {
//		this.timeId = timeId;
//	}
//	public String getX() {
//		return x;
//	}
//	public void setX(String x) {
//		this.x = x;
//	}
//	public String getY() {
//		return y;
//	}
//	public void setY(String y) {
//		this.y = y;
//	}
//
//}
