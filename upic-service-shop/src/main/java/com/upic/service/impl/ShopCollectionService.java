package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IShopCollectionDao;
import com.upic.po.ShopCollection;
import com.upic.service.IShopCollectionService;

@Service("shopCollectionService")
public class ShopCollectionService implements IShopCollectionService {
	@Autowired
	private IShopCollectionDao shopCollectionDao;

	@Override
	public ShopCollection getById(long id) {
		return shopCollectionDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return shopCollectionDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return shopCollectionDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<ShopCollection> listBy(Map<String, Object> paramMap) {
		return shopCollectionDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return shopCollectionDao.listBy(paramMap, sqlId);
	}

	@Override
	public ShopCollection getBy(Map<String, Object> paramMap) {
		return shopCollectionDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return shopCollectionDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return shopCollectionDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(ShopCollection myCollection) {
		return shopCollectionDao.insert(myCollection);
	}

	@Override
	public long update(ShopCollection myCollection) {
		return shopCollectionDao.update(myCollection);
	}
}
