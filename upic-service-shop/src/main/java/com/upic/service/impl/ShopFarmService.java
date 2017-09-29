package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IShopFarmDao;
import com.upic.po.ShopFarm;
import com.upic.service.IShopFarmService;

@Service("shopFarmService")
public class ShopFarmService implements IShopFarmService {
	@Autowired
	private IShopFarmDao shopFarmDao;

	@Override
	public ShopFarm getById(long id) {
		return shopFarmDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return shopFarmDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return shopFarmDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<ShopFarm> listBy(Map<String, Object> paramMap) {
		return shopFarmDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return shopFarmDao.listBy(paramMap, sqlId);
	}

	@Override
	public ShopFarm getBy(Map<String, Object> paramMap) {
		return shopFarmDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return shopFarmDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return shopFarmDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(ShopFarm shopFarm) {
		return shopFarmDao.insert(shopFarm);
	}

	@Override
	public long update(ShopFarm ShopFarm) {
		return shopFarmDao.update(ShopFarm);
	}
}
