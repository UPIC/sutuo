package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IShopActivityDao;
import com.upic.po.ShopActivity;
import com.upic.service.IShopActivityService;

@Service("shopActivityService")
public class ShopActivityService implements IShopActivityService {
	@Autowired
	private IShopActivityDao shopActivityDao;

	@Override
	public ShopActivity getById(long id) {
		return shopActivityDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return shopActivityDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return shopActivityDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<ShopActivity> listBy(Map<String, Object> paramMap) {
		return shopActivityDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return shopActivityDao.listBy(paramMap, sqlId);
	}

	@Override
	public ShopActivity getBy(Map<String, Object> paramMap) {
		return shopActivityDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return shopActivityDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return shopActivityDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(ShopActivity shopActivity) {
		return shopActivityDao.insert(shopActivity);
	}

	@Override
	public long update(ShopActivity shopActivity) {
		return shopActivityDao.update(shopActivity);
	}
}
