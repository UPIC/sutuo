package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IThemetzShopDao;
import com.upic.po.ThemetzShop;
import com.upic.service.IThemetzShopService;

@Service("themetzShopService")
public class ThemetzShopService implements IThemetzShopService {
	@Autowired
	private IThemetzShopDao themetzShopDao;

	@Override
	public ThemetzShop getById(long id) {
		return themetzShopDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return themetzShopDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return themetzShopDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<ThemetzShop> listBy(Map<String, Object> paramMap) {
		return themetzShopDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return themetzShopDao.listBy(paramMap, sqlId);
	}

	@Override
	public ThemetzShop getBy(Map<String, Object> paramMap) {
		return themetzShopDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return themetzShopDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return themetzShopDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(ThemetzShop themetzShop) {
		return themetzShopDao.insert(themetzShop);
	}

	@Override
	public long update(ThemetzShop themetzShop) {
		return themetzShopDao.update(themetzShop);
	}
}
