package com.upic.common.entity;

import java.io.Serializable;
/***
 * 二级菜单页搜索（农庄、单品）
 * @author DTZ
 *
 */
public class SearchPo implements Serializable{

	/**查找类型 1、农庄 2、单品**/
	
	private  String searchType;
	/**主题 项目**/
	private String playType;
	/**一级栏目**/
	private String firstTypeName;
	/**一级栏目Id**/
	private String firstTypeId;
	/**二级栏目**/
	private String secondTypeName;
	/**二级栏目ID**/
	private String secondTypeId;
	/**生态圈**/
	private String biosphere;
	
	/**城市**/
	private String city;
	/**主题（吃、住、游、购、娱）**/
	private String themeName;
	/**标签（烧烤什么的）**/
	private String shopTheme;
	/**主题（亲子、。。。）**/
	private String themetzShop;
	/**项目 烧烤**/
	private String projectShop;
	/**扩展字段1**/
	private String field1;
	/**扩展字段2**/
	private String field2;
	/**扩展字段3**/
	private String field3;
	/**扩展字段4**/
	private String field4;
	/**扩展字段5**/
	private String field5;
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getPlayType() {
		return playType;
	}
	public void setPlayType(String playType) {
		this.playType = playType;
	}
	public String getFirstTypeName() {
		return firstTypeName;
	}
	public void setFirstTypeName(String firstTypeName) {
		this.firstTypeName = firstTypeName;
	}
	public String getFirstTypeId() {
		return firstTypeId;
	}
	public void setFirstTypeId(String firstTypeId) {
		this.firstTypeId = firstTypeId;
	}
	public String getSecondTypeName() {
		return secondTypeName;
	}
	public void setSecondTypeName(String secondTypeName) {
		this.secondTypeName = secondTypeName;
	}
	public String getSecondTypeId() {
		return secondTypeId;
	}
	public void setSecondTypeId(String secondTypeId) {
		this.secondTypeId = secondTypeId;
	}
	public String getBiosphere() {
		return biosphere;
	}
	public void setBiosphere(String biosphere) {
		this.biosphere = biosphere;
	}
	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public String getField2() {
		return field2;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	public String getField3() {
		return field3;
	}
	public void setField3(String field3) {
		this.field3 = field3;
	}
	public String getField4() {
		return field4;
	}
	public void setField4(String field4) {
		this.field4 = field4;
	}
	public String getField5() {
		return field5;
	}
	public void setField5(String field5) {
		this.field5 = field5;
	}
	public SearchPo(String searchType, String playType, String firstTypeName, String firstTypeId, String secondTypeName,
			String secondTypeId, String timeId, String biosphere, String peopleNum, String method, String x, String y,
			String field1, String field2, String field3, String field4, String field5) {
		super();
		this.searchType = searchType;
		this.playType = playType;
		this.firstTypeName = firstTypeName;
		this.firstTypeId = firstTypeId;
		this.secondTypeName = secondTypeName;
		this.secondTypeId = secondTypeId;
		this.biosphere = biosphere;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}
	public SearchPo() {
		super();
	}
	public String getThemeName() {
		return themeName;
	}
	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}
	public String getShopTheme() {
		return shopTheme;
	}
	public void setShopTheme(String shopTheme) {
		this.shopTheme = shopTheme;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getThemetzShop() {
		return themetzShop;
	}
	public void setThemetzShop(String themetzShop) {
		this.themetzShop = themetzShop;
	}
	public String getProjectShop() {
		return projectShop;
	}
	public void setProjectShop(String projectShop) {
		this.projectShop = projectShop;
	}
	
}
