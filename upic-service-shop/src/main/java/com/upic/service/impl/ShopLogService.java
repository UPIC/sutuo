package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IShopLogDao;
import com.upic.po.ShopLog;
import com.upic.service.IShopLogService;

@Service("shopLogService")
public class ShopLogService implements IShopLogService {
	@Autowired
	private IShopLogDao shopLogDao;

	@Override
	public ShopLog getById(long id) {
		return shopLogDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return shopLogDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return shopLogDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<ShopLog> listBy(Map<String, Object> paramMap) {
		return shopLogDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return shopLogDao.listBy(paramMap, sqlId);
	}

	@Override
	public ShopLog getBy(Map<String, Object> paramMap) {
		return shopLogDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return shopLogDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return shopLogDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(ShopLog shopLog) {
		return shopLogDao.insert(shopLog);
	}

	@Override
	public long update(ShopLog shopLog) {
		return shopLogDao.update(shopLog);
	}
}
