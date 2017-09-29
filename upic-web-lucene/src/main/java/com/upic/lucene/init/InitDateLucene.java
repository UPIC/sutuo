package com.upic.lucene.init;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.SortedDocValuesField;
import org.apache.lucene.document.SortedNumericDocValuesField;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.NumericUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.po.ProjectShop;
import com.upic.po.Shop;
import com.upic.po.ShopSignLink;
import com.upic.po.Store;
import com.upic.po.ThemetzShop;
import com.upic.po.ThemetzStore;
import com.upic.service.IProjectShopService;
import com.upic.service.IShopService;
import com.upic.service.IShopSignLinkService;
import com.upic.service.IShopThemeService;
import com.upic.service.IStoreService;
import com.upic.service.IThemetzShopService;
import com.upic.service.IThemetzStoreService;
import com.upic.shop.enums.ShopStatusEnum;


/**
 * 初始化索引
 * 
 * @author DTZ
 *
 */
public class InitDateLucene implements InitializingBean, ServletContextAware {

	@Autowired(required = false)
	private IShopService shopService;

	@Autowired(required = false)
	private IStoreService storeService;

//	@Autowired(required = false)
//	private IShopThemeService shopThemeService;
//
//	@Autowired(required = false)
//	private IShopSignLinkService shopSignLinkService;
	
	@Autowired
	private IProjectShopService projectShopService;
	
	@Autowired
	private IThemetzShopService themetzShopService;
	
	@Autowired
	private IThemetzStoreService themetzStoreService;

//	private IndexWriter indexWrtier = LuceneUtils.getIndexWrtier(LuceneUtils.f,
//			new IndexWriterConfig(LuceneUtils.analyzer));
	@Autowired
	private IndexWriter indexWrtier;
	@Override
	public void setServletContext(ServletContext servletContext) {
		try {
			indexWrtier.deleteAll();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Document doc = null;
		int pageNum = 1; // 当前页
		int numPerPage = 10; // 每页记录数
		PageParam pageParam = new PageParam(pageNum, numPerPage);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("status", ShopStatusEnum.ACTIVE.getValue());
		paramMap.put("shopClasses", "FARM");
		PageBean listPage = shopService.listPage(pageParam, paramMap);
		initData(listPage.getRecordList(), doc);
		for (int i = 2; i <= listPage.getPageCount(); i++) {
			pageParam = new PageParam(i, numPerPage);
			listPage = shopService.listPage(pageParam, paramMap);
			initData(listPage.getRecordList(), doc);
		}
		try {
			indexWrtier.forceMerge(1);
			indexWrtier.commit();
//			indexWrtier.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void afterPropertiesSet() throws Exception {

	}

	public void initData(List<Object> obj, Document doc) {
		for (int j = 0; j < obj.size(); j++) {
			doc = new Document();
			Shop shop = (Shop) obj.get(j);
			// 商品编号 （不参与评分）
			doc.add(new StoredField("shopNumber", shop.getShopNumber(),TextField.TYPE_STORED));
			// 商品名
			doc.add(new StoredField("shopName", shop.getShopName(),TextField.TYPE_STORED));
			doc.add(new SortedDocValuesField("shopName", new BytesRef(shop.getShopName())));
			// 商品标题
			doc.add(new StoredField("shopTitle", shop.getShopTitle(),TextField.TYPE_STORED));
			doc.add(new SortedDocValuesField("shopTitle", new BytesRef(shop.getShopTitle())));
			// 商品价格
			doc.add(new StoredField("shopPrice", shop.getShopPrice()));
			doc.add(new SortedNumericDocValuesField("shopPrice",
					NumericUtils.doubleToSortableLong(shop.getShopPrice())));
			// 最后上架时间
			doc.add(new StoredField("lastGroundingTime", shop.getLastGroundingTime().getTime()));
			doc.add(new SortedNumericDocValuesField("lastGroundingTime", shop.getLastGroundingTime().getTime()));
			// 主题（吃住游购娱）
			doc.add(new StoredField("themeName", shop.getThemeName(),TextField.TYPE_STORED));
			doc.add(new SortedDocValuesField("themeName", new BytesRef(shop.getThemeName())));
			// 获取商品标签（烧烤）
//			Map<String, Object> paramMapGetShopSignLink = new HashMap<String, Object>();
//			paramMapGetShopSignLink.put("shopId", shop.getId());
//			ShopSignLink shopSignLink = (ShopSignLink) shopSignLinkService.getBy(paramMapGetShopSignLink, "listAll");
//			doc.add(new StoredField("shopTheme", shopSignLink == null ? "isEmpty" : shopSignLink.getSignName(),TextField.TYPE_STORED));
//			//关键字查询时候需要用到
//			doc.add(new StoredField("shopThemeNeed", shopSignLink == null ? "isEmpty" : shopSignLink.getSignName(),TextField.TYPE_STORED));
//			if (shopSignLink != null) {
//				doc.add(new SortedDocValuesField("shopTheme", new BytesRef(shopSignLink.getSignName())));
//				//关键字查询时候需要用到
//				doc.add(new SortedDocValuesField("shopThemeNeed", new BytesRef(shopSignLink.getSignName())));
//			}
			//人次 不需要参与评分
			doc.add(new StoredField("peopleNum", shop.getAvgCost(),TextField.TYPE_STORED));
			//商品头像
			doc.add(new StoredField("shopHeadPic", shop.getHeadPic()==null?"isEmpty":shop.getHeadPic(),TextField.TYPE_STORED));
			//属于项目
			Map<String, Object> paramMapGetShopProject = new HashMap<String, Object>();
			paramMapGetShopProject.put("shopId", shop.getId());
//			ProjectShop projectShop=(ProjectShop) projectShopService.getBy(paramMapGetShopProject,"listAll");
			List<ProjectShop> projectShopList= projectShopService.listBy(paramMapGetShopProject);
			ProjectShop projectShop=null;
			if(projectShopList==null){
				projectShop=new ProjectShop();
				projectShop.setProject("isEmpty");
				doc.add(new StoredField("projectShop", projectShop.getProject(),TextField.TYPE_STORED));
				doc.add(new SortedDocValuesField("projectShop", new BytesRef(projectShop.getProject())));
			}else{
				StringBuffer sb=new StringBuffer();
				for(ProjectShop p:projectShopList){
					sb.append(p.getProject()+",");
				}
			doc.add(new StoredField("projectShop", sb.toString(),TextField.TYPE_STORED));
			doc.add(new SortedDocValuesField("projectShop", new BytesRef(sb.toString())));
			}
			
		
			// 获取商品主题（户外）
			Map<String, Object> paramMapGetShopTheme = new HashMap<String, Object>();
			paramMapGetShopTheme.put("shopId", shop.getId());
			ThemetzShop themetzShop = (ThemetzShop) themetzShopService.getBy(paramMapGetShopTheme, "listAll");
			if(themetzShop==null){
				themetzShop=new ThemetzShop();
				themetzShop.setThemetz("isEmpty");
			}
			doc.add(new StoredField("themetzShop", themetzShop.getThemetz(),TextField.TYPE_STORED));
			doc.add(new SortedDocValuesField("themetzShop", new BytesRef(themetzShop.getThemetz())));
			// 根据商家编号找商家
			Map<String, Object> paramMapGetStore = new HashMap<String, Object>();
			paramMapGetStore.put("storeNumber", shop.getStoreNumber());
			Store store = (Store) storeService.getBy(paramMapGetStore, "getByStoreNumber");
			//标题
			doc.add(new StoredField("title", store.getTitle()==null?" 高颜值，高品质的户外拓展体验":store.getAvgCost(),TextField.TYPE_STORED));
			// 存储商家编号，不评分
			doc.add(new StoredField("storeNumber", store.getStoreNumber(),TextField.TYPE_STORED));
			doc.add(new SortedDocValuesField("storeNumber", new BytesRef(store.getStoreNumber())));
			// 存储商家名,进行评分
			doc.add(new StoredField("storeName", store.getStoreName(),TextField.TYPE_STORED));
			doc.add(new SortedDocValuesField("storeName", new BytesRef(store.getStoreName())));
			// 主营项目
			doc.add(new StoredField("mainShops", store.getMainShops(),TextField.TYPE_STORED));
			doc.add(new SortedDocValuesField("mainShops", new BytesRef(store.getMainShops())));
			// 市
			doc.add(new StoredField("city", store.getCityName(),TextField.TYPE_STORED));
			doc.add(new SortedDocValuesField("city", new BytesRef(store.getCityName())));
			// 区
			doc.add(new StoredField("biosphere", store.getDistrictName(),TextField.TYPE_STORED));
			doc.add(new SortedDocValuesField("biosphere", new BytesRef(store.getDistrictName())));
			// 商家主题
			Map<String, Object> paramMapGetStoreTheme = new HashMap<String, Object>();
			paramMapGetShopTheme.put("storeId", store.getId());
			ThemetzStore themetzStore= (ThemetzStore) themetzStoreService.getBy(paramMapGetStoreTheme, "listAll");
			if(themetzStore==null){
				themetzStore=new ThemetzStore();
				themetzStore.setThemetz("isEmpty");
			}
			doc.add(new StoredField("themetzStore", themetzStore.getThemetz(),TextField.TYPE_STORED));
			doc.add(new SortedDocValuesField("themetzStore", new BytesRef(themetzStore.getThemetz())));
			// 商家标签。。。
			doc.add(new StoredField("avgCost",  store.getAvgCost()==null?"isEmpty":store.getAvgCost(),TextField.TYPE_STORED));
			//商店头像
			doc.add(new StoredField("storeHeadPic", store.getHeadPic()==null?"isEmpty":store.getHeadPic(),TextField.TYPE_STORED));
			doc.add(new StoredField("backPic", store.getBackPic()==null?"isEmpty":store.getBackPic(),TextField.TYPE_STORED));
			try {
				indexWrtier.addDocument(doc);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
