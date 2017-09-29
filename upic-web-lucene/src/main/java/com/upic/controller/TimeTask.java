package com.upic.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.SortedDocValuesField;
import org.apache.lucene.document.SortedNumericDocValuesField;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.NumericUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.po.ProjectShop;
import com.upic.po.Shop;
import com.upic.po.ShopLog;
import com.upic.po.Store;
import com.upic.po.ThemetzShop;
import com.upic.po.ThemetzStore;
import com.upic.service.IProjectShopService;
import com.upic.service.IShopLogService;
import com.upic.service.IShopService;
import com.upic.service.IStoreService;
import com.upic.service.IThemetzShopService;
import com.upic.service.IThemetzStoreService;
import com.upic.shop.enums.ShopLogEnum;
import com.upic.shop.enums.ShopStatusEnum;

/**
 * 定时任务（操作日志）
 * 
 * @author Administrator
 *
 */
@Component
public class TimeTask {
	@Autowired(required = false)
	private IShopService shopService;

	@Autowired(required = false)
	private IStoreService storeService;
	@Autowired
	private IProjectShopService projectShopService;

	@Autowired
	private IThemetzShopService themetzShopService;

	@Autowired
	private IThemetzStoreService themetzStoreService;

	@Autowired
	private IndexWriter indexWrtier;

	@Autowired
	private IShopLogService shopLogService;

	@Scheduled(fixedDelay = 1000*60*12)
	public void add() {
		Document doc = null;
		int pageNum = 1; // 当前页
		int numPerPage = 500; // 每页记录数
		PageParam pageParam = new PageParam(pageNum, numPerPage);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("consumptionStatus", ShopLogEnum.WAIT.getDesc());
		// paramMap.put("handleStatus", ShopLogEnum.ADD.getDesc());
		PageBean listPage = shopLogService.listPage(pageParam, paramMap);
		// initData(listPage.getRecordList(), doc);
		for (int i = 1; i <= listPage.getPageCount(); i++) {
			pageParam = new PageParam(i, numPerPage);
			listPage = shopLogService.listPage(pageParam, paramMap);
			initData(listPage.getRecordList(), doc);
		}
		try {
			indexWrtier.forceMerge(1);
			indexWrtier.commit();
			System.out.println("此次操作成功");
			// indexWrtier.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void initData(List<Object> obj, Document doc) {
		for (int j = 0; j < obj.size(); j++) {
			doc = new Document();
			ShopLog shopLog = (ShopLog) obj.get(j);
			Map<String, Object> paramMap = new HashMap<String, Object>();
			//添加
			if (shopLog.getHandleStatus().equals(ShopLogEnum.ADD.getDesc())) {
				paramMap.put("status", ShopStatusEnum.ACTIVE.getValue());
				paramMap.put("shopNumber", shopLog.getShopNumber());
				Shop shop = (Shop) shopService.getBy(paramMap, "getByStoreNumber");
				if (shop != null) {
					Document addShopDoc = addAndUpdateShopDoc(shop, doc);
					try {
						indexWrtier.addDocument(addShopDoc);
						System.out.println("成功添加:"+shop.getShopName());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				//更新
			} else if (shopLog.getHandleStatus().equals(ShopLogEnum.UPDATE.getDesc())) {
				paramMap.put("status", ShopStatusEnum.ACTIVE.getValue());
				paramMap.put("shopNumber", shopLog.getShopNumber());
				Shop shop = (Shop) shopService.getBy(paramMap, "getByStoreNumber");
				if (shop != null) {
					Document addAndUpdateShopDoc = addAndUpdateShopDoc(shop, doc);
					try {
						Term term = new Term("shopNumber", shopLog.getShopNumber());
						indexWrtier.updateDocument(term, addAndUpdateShopDoc);
						System.out.println("成功更新:"+shop.getShopName());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				//刪除
			} else if (shopLog.getHandleStatus().equals(ShopLogEnum.DROP.getDesc())) {
				try {
					indexWrtier.deleteDocuments(new Term("shopNumber", shopLog.getShopNumber()));
					System.out.println("成功删除:"+shopLog.getShopNumber());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			shopLog.setConsumptionStatus(ShopLogEnum.SUCCESS.getDesc());
			shopLogService.update(shopLog);
			System.out.println("shopLogService 更新成功");
		}
	}

	/**
	 * 添加和更新
	 * 
	 * @param shop
	 * @param doc
	 */
	private Document addAndUpdateShopDoc(Shop shop, Document doc) {
		// 商品编号 （不参与评分）
		doc.add(new StoredField("shopNumber", shop.getShopNumber(), TextField.TYPE_STORED));
		// 商品名
		doc.add(new StoredField("shopName", shop.getShopName(), TextField.TYPE_STORED));
		doc.add(new SortedDocValuesField("shopName", new BytesRef(shop.getShopName())));
		// 商品标题
		doc.add(new StoredField("shopTitle", shop.getShopTitle(), TextField.TYPE_STORED));
		doc.add(new SortedDocValuesField("shopTitle", new BytesRef(shop.getShopTitle())));
		// 商品价格
		doc.add(new StoredField("shopPrice", shop.getShopPrice()));
		doc.add(new SortedNumericDocValuesField("shopPrice", NumericUtils.doubleToSortableLong(shop.getShopPrice())));
		// 最后上架时间
		doc.add(new StoredField("lastGroundingTime", shop.getLastGroundingTime().getTime()));
		doc.add(new SortedNumericDocValuesField("lastGroundingTime", shop.getLastGroundingTime().getTime()));
		// 主题（吃住游购娱）
		doc.add(new StoredField("themeName", shop.getThemeName(), TextField.TYPE_STORED));
		doc.add(new SortedDocValuesField("themeName", new BytesRef(shop.getThemeName())));
		// 人次 不需要参与评分
		doc.add(new StoredField("peopleNum", shop.getAvgCost(), TextField.TYPE_STORED));
		// 商品头像
		doc.add(new StoredField("shopHeadPic", shop.getHeadPic() == null ? "isEmpty" : shop.getHeadPic(),
				TextField.TYPE_STORED));
		// 属于项目
		Map<String, Object> paramMapGetShopProject = new HashMap<String, Object>();
		paramMapGetShopProject.put("shopId", shop.getId());
		ProjectShop projectShop = (ProjectShop) projectShopService.getBy(paramMapGetShopProject, "listAll");
		if (projectShop == null) {
			projectShop = new ProjectShop();
			projectShop.setProject("isEmpty");
		}
		doc.add(new StoredField("projectShop", projectShop.getProject(), TextField.TYPE_STORED));
		doc.add(new SortedDocValuesField("projectShop", new BytesRef(projectShop.getProject())));

		// 获取商品主题（户外）
		Map<String, Object> paramMapGetShopTheme = new HashMap<String, Object>();
		paramMapGetShopTheme.put("shopId", shop.getId());
		ThemetzShop themetzShop = (ThemetzShop) themetzShopService.getBy(paramMapGetShopTheme, "listAll");
		if (themetzShop == null) {
			themetzShop = new ThemetzShop();
			themetzShop.setThemetz("isEmpty");
		}
		doc.add(new StoredField("themetzShop", themetzShop.getThemetz(), TextField.TYPE_STORED));
		doc.add(new SortedDocValuesField("themetzShop", new BytesRef(themetzShop.getThemetz())));
		// 根据商家编号找商家
		Map<String, Object> paramMapGetStore = new HashMap<String, Object>();
		paramMapGetStore.put("storeNumber", shop.getStoreNumber());
		Store store = (Store) storeService.getBy(paramMapGetStore, "getByStoreNumber");
		// 标题
		doc.add(new StoredField("title", store.getTitle() == null ? " 高颜值，高品质的户外拓展体验" : store.getAvgCost(),
				TextField.TYPE_STORED));
		// 存储商家编号，不评分
		doc.add(new StoredField("storeNumber", store.getStoreNumber(), TextField.TYPE_STORED));
		doc.add(new SortedDocValuesField("storeNumber", new BytesRef(store.getStoreNumber())));
		// 存储商家名,进行评分
		doc.add(new StoredField("storeName", store.getStoreName(), TextField.TYPE_STORED));
		doc.add(new SortedDocValuesField("storeName", new BytesRef(store.getStoreName())));
		// 主营项目
		doc.add(new StoredField("mainShops", store.getMainShops(), TextField.TYPE_STORED));
		doc.add(new SortedDocValuesField("mainShops", new BytesRef(store.getMainShops())));
		// 市
		doc.add(new StoredField("city", store.getCityName(), TextField.TYPE_STORED));
		doc.add(new SortedDocValuesField("city", new BytesRef(store.getCityName())));
		// 区
		doc.add(new StoredField("biosphere", store.getDistrictName(), TextField.TYPE_STORED));
		doc.add(new SortedDocValuesField("biosphere", new BytesRef(store.getDistrictName())));
		// 商家主题
		Map<String, Object> paramMapGetStoreTheme = new HashMap<String, Object>();
		paramMapGetShopTheme.put("storeId", store.getId());
		ThemetzStore themetzStore = (ThemetzStore) themetzStoreService.getBy(paramMapGetStoreTheme, "listAll");
		if (themetzStore == null) {
			themetzStore = new ThemetzStore();
			themetzStore.setThemetz("isEmpty");
		}
		doc.add(new StoredField("themetzStore", themetzStore.getThemetz(), TextField.TYPE_STORED));
		doc.add(new SortedDocValuesField("themetzStore", new BytesRef(themetzStore.getThemetz())));
		// 商家标签。。。
		doc.add(new StoredField("avgCost", store.getAvgCost() == null ? "isEmpty" : store.getAvgCost(),
				TextField.TYPE_STORED));
		// 商店头像
		doc.add(new StoredField("storeHeadPic", store.getHeadPic() == null ? "isEmpty" : store.getHeadPic(),
				TextField.TYPE_STORED));
		doc.add(new StoredField("backPic", store.getBackPic() == null ? "isEmpty" : store.getBackPic(),
				TextField.TYPE_STORED));
		return doc;
	}
	@Scheduled(fixedDelay = 1000*60*13)
	public void delete() {
		try{
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("consumptionStatus", ShopLogEnum.SUCCESS.getDesc());
		shopLogService.getBy(paramMap, "deleteByStatus");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
