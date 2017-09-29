package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IShopSignDao;
import com.upic.po.ShopSign;
import com.upic.service.IShopSignService;

@Service("shopSignService")
public class ShopSignService implements IShopSignService {
	@Autowired
	private IShopSignDao shopSignDao;

	@Override
	public ShopSign getById(long id) {
		return shopSignDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return shopSignDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return shopSignDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<ShopSign> listBy(Map<String, Object> paramMap) {
		return shopSignDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return shopSignDao.listBy(paramMap, sqlId);
	}

	@Override
	public ShopSign getBy(Map<String, Object> paramMap) {
		return shopSignDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return shopSignDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return shopSignDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(ShopSign shopSign) {
		return shopSignDao.insert(shopSign);
	}

	@Override
	public long update(ShopSign shopSign) {
		return shopSignDao.update(shopSign);
	}
}
