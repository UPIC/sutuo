package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IShopTypeDao;
import com.upic.po.ShopType;
import com.upic.service.IShopTypeService;

@Service("shopTypeService")
public class ShopTypeService implements IShopTypeService {
	@Autowired
	private IShopTypeDao shopTypeDao;

	@Override
	public ShopType getById(long id) {
		return shopTypeDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return shopTypeDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return shopTypeDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<ShopType> listBy(Map<String, Object> paramMap) {
		return shopTypeDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return shopTypeDao.listBy(paramMap, sqlId);
	}

	@Override
	public ShopType getBy(Map<String, Object> paramMap) {
		return shopTypeDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return shopTypeDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return shopTypeDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(ShopType shopType) {
		return shopTypeDao.insert(shopType);
	}

	@Override
	public long update(ShopType shopType) {
		return shopTypeDao.update(shopType);
	}
}
