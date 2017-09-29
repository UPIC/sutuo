package com.upic.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.document.Document;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanClause.Occur;

import com.upic.common.entity.CenterSearch;
import com.upic.common.entity.SearchPo;
import com.upic.common.entity.ShowShop;
import com.upic.common.entity.ShowStore;
import com.upic.common.page.PageBean;
import com.upic.lucene.emuns.SearchTypeEnum;
/**
 * 
 * @author DTZ
 *
 */
public class ParseUtils {
	private static Log log = LogFactory.getLog(ParseUtils.class);

	/**
	 * 对json数据分拣成键值对形式放在map中
	 * 
	 * @param bean
	 * @return
	 */
	public static Map<String, Map<String, BooleanClause.Occur>> getMapFromBean(Object bean) {
		Field[] fields = bean.getClass().getDeclaredFields();
		Map<String, Map<String, BooleanClause.Occur>> result = new HashMap<String, Map<String, BooleanClause.Occur>>();
		for (Field f : fields) {
			if (getFieldValueByName(f.getName(), bean).toString() == null
					|| getFieldValueByName(f.getName(), bean).toString().isEmpty()) {
				continue;
			}
			String key = f.getName();
			Map<String, BooleanClause.Occur> value = new HashMap<String, BooleanClause.Occur>();
			value.put(getFieldValueByName(key, bean).toString(), BooleanClause.Occur.MUST);
			result.put(key, value);
		}
		return result;
	}

	/**
	 * 根据分拣的map分建成List<Object>
	 * 
	 * @param map
	 * @return
	 */
	public static List<Object> getToListFromMapBeanField(Map<String, Map<String, BooleanClause.Occur>> map,
			Object bean) {
		Set<String> set = map.keySet();
		List<Object> list = new ArrayList<Object>();
		String fields[] = new String[set.size()];
		String values[] = new String[set.size()];
		BooleanClause.Occur condi[] = new BooleanClause.Occur[set.size()];
		int i = 0;
		for (String s : set) {
			fields[i] = s;

			Map<String, Occur> map2 = map.get(s);
			Set<String> valueMapSet = map2.keySet();
			for (String valueKey : valueMapSet) {
				String value = getFieldValueByName(s, bean).toString();
				values[i] = value;
				condi[i++] = map2.get(valueKey);
			}
		}
		list.add(fields);
		list.add(values);
		list.add(condi);
		return list;
	}

	private static Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});
			return value;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * 分装实体类
	 * 
	 * @param docList
	 * @param t
	 * @return
	 */
	public static <T> PageBean getPageBeanByDocument(int numPage,int pageSize,List<Document> docList, CenterSearch<T> searchBean,HttpSession session) {
		int all=(Integer) session.getAttribute("allCount");
		PageBean page = new PageBean(numPage,pageSize,all);
		session.removeAttribute("allCount");
		if (docList == null) {
			return page;
		}
		List<Object> recordList = new ArrayList<Object>();
		for (Document doc : docList) {
			if (searchBean.getT() instanceof SearchPo) {
				SearchPo s = (SearchPo) searchBean.getT();
				Object result = getObjectBySearchType(searchBean.getReturnType(), doc);
				recordList.add(result);
			}
		}
		
		page.setRecordList(recordList);
		return page;
	}

	/**
	 * 根据不同返回类型封装不同的实体类
	 * 
	 * @param searchType
	 * @param doc
	 * @return
	 */
	private static Object getObjectBySearchType(String searchType, Document doc) {
		if (searchType.equals(SearchTypeEnum.SHOP.getDesc())) {
			ShowShop s=new ShowShop();
			s.setShopName(doc.get("shopName"));
			s.setShopNumber(doc.get("shopNumber"));
			s.setLastGroundingTime(new Date(Long.parseLong(doc.get("lastGroundingTime"))));
			s.setShopTitle(doc.get("shopTitle"));
			s.setShopPrice(doc.get("shopPrice"));
			s.setThemetz(doc.get("themetzShop"));
			s.setPeopleNum(Integer.parseInt(doc.get("peopleNum")));
			s.setCity(doc.get("city"));
			s.setDistrict(doc.get("biosphere"));
			s.setProject(doc.get("projectShop"));
			s.setShopHeadPic(doc.get("shopHeadPic"));
			return s;
		} else if (searchType.equals(SearchTypeEnum.FARME.getDesc())) {
			ShowStore s=new ShowStore();
			s.setBackPic(doc.get("backPic"));
			s.setStoreNumber(doc.get("storeNumber"));
			s.setStoreName(doc.get("storeName"));
			s.setCity(doc.get("city"));
			s.setStoreHeadPic(doc.get("storeHeadPic"));
			s.setTitle(doc.get("title"));
			s.setAvgCost(doc.get("avgCost"));
			return s;
		}
		return null;
	}

	public static String[] getAllSearchType(Object bean) {
		Field[] fields = bean.getClass().getDeclaredFields();
		String[] field = new String[fields.length];
		int i = 0;
		for (Field f : fields) {
			field[i++] = f.getName();
		}
		return field;
	}
}
