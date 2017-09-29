package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IShopDao;
import com.upic.po.Shop;
import com.upic.service.IShopService;

@Service("shopService")
public class ShopService implements IShopService {
	@Autowired
	private IShopDao shopDao;

	@Override
	public Shop getById(long id) {
		return shopDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return shopDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return shopDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<Shop> listBy(Map<String, Object> paramMap) {
		return shopDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return shopDao.listBy(paramMap, sqlId);
	}

	@Override
	public Shop getBy(Map<String, Object> paramMap) {
		return shopDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return shopDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return shopDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(Shop shop) {
		return shopDao.insert(shop);
	}

	@Override
	public long update(Shop shop) {
		return shopDao.update(shop);
	}
}
