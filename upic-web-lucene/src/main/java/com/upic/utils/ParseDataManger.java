package com.upic.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanClause.Occur;

import com.upic.common.entity.CenterSearch;
import com.upic.common.entity.SearchPo;
import com.upic.lucene.emuns.SearchTypeEnum;

import net.sf.json.JSONObject;

@SuppressWarnings("unchecked")
public class ParseDataManger {

	/**
	 * 分装查询属性、条件以及出查询重要性
	 * @param json
	 * @param c
	 * @return
	 */
	public static List<Object> getSearchArrays(String json,Class<? extends Object> c){
		JSONObject fromObject = JSONObject.fromObject(json);
		Object bean = JSONObject.toBean(fromObject, c);
		Map<String,Map<String, BooleanClause.Occur>> poMap=ParseUtils.getMapFromBean(bean);
		return ParseUtils.getToListFromMapBeanField(poMap,bean);
	}
	/**
	 * 
	 * @param <T>
	 * @param json
	 * @param c
	 * @return
	 */
	public static <T> CenterSearch<T> getSearchBean(String json,Class<? extends Object> c){
		JSONObject fromObject = JSONObject.fromObject(json);
		Object bean = JSONObject.toBean(fromObject, c);
		return (CenterSearch<T>) bean;
	}
	/**
	 * 
	 * @param json
	 * @param c
	 * @return
	 */
	public static <T> T getSearchInnerBean(T json,Class<? extends Object> c){
		JSONObject fromObject = JSONObject.fromObject(json);
		Object bean = JSONObject.toBean(fromObject, c);
		return  (T) bean;
	}
	/**
	 * 判断是否存在关键字，如果存在做相应处理
	 * @param searchBean
	 * @param string
	 * @return
	 */
	public static List<Object> jugeHaveKeyWord(CenterSearch<Object> searchBean, List<Object> string) {
		if(searchBean.getKeyWord()!=null && !searchBean.getKeyWord().isEmpty()){
			String [] arrFiled=(String[]) string.get(0);
			String [] arrQueries=(String[]) string.get(1);
			BooleanClause.Occur [] arrFlags=(Occur[]) string.get(2);
			String[] copyOfArrFiled = Arrays.copyOf(arrFiled, arrFiled.length+2);
//			String[] copyOfArrFiled = Arrays.copyOf(arrFiled, arrFiled.length+1);
			String[] copyOfArrQueries = Arrays.copyOf(arrQueries, arrQueries.length+2);
//			String[] copyOfArrQueries = Arrays.copyOf(arrQueries, arrQueries.length+1);
			BooleanClause.Occur[] copyOfArrFlags = Arrays.copyOf(arrFlags, arrFlags.length+2);
//			BooleanClause.Occur[] copyOfArrFlags = Arrays.copyOf(arrFlags, arrFlags.length+1);
			copyOfArrFiled[arrFiled.length]=SearchTypeEnum.SHOPTITLE.getDesc();
			copyOfArrFiled[arrFiled.length+1]=SearchTypeEnum.PROJECTSHOP.getDesc();
			copyOfArrQueries[arrQueries.length]=searchBean.getKeyWord();
			copyOfArrQueries[arrQueries.length+1]=searchBean.getKeyWord();
			copyOfArrFlags[arrFlags.length]=BooleanClause.Occur.SHOULD;
			copyOfArrFlags[arrFlags.length+1]=BooleanClause.Occur.SHOULD;
			string.clear();
			string.add(copyOfArrFiled);
			string.add(copyOfArrQueries);
			string.add(copyOfArrFlags);
		}
		return string;
	}
	public static String dealJson(String json) {
		CenterSearch<SearchPo> searchBean = ParseDataManger.getSearchBean(json, CenterSearch.class);
		JSONObject fromObject = JSONObject.fromObject(searchBean.getT());
		SearchPo bean = (SearchPo) JSONObject.toBean(fromObject, SearchPo.class);
		searchBean.setT(bean);
		if (!searchBean.getT().getCity().isEmpty() && searchBean.getT().getCity() != null) {
			String substring = searchBean.getT().getCity().substring(0, searchBean.getT().getCity().length() - 1);
			searchBean.getT().setCity(substring);
		}
		if (!searchBean.getT().getBiosphere().isEmpty() && searchBean.getT().getBiosphere() != null) {
			String substring = searchBean.getT().getBiosphere().substring(0, searchBean.getT().getCity().length() - 1);
			searchBean.getT().setBiosphere(substring);
		}
		return  JSONObject.fromObject(searchBean).toString();
	}
}
