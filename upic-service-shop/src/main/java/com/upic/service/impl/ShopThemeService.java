package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IShopThemeDao;
import com.upic.po.ShopTheme;
import com.upic.service.IShopThemeService;

@Service("shopThemeService")
public class ShopThemeService implements IShopThemeService {
	@Autowired
	private IShopThemeDao shopThemeDao;

	@Override
	public ShopTheme getById(long id) {
		return shopThemeDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return shopThemeDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return shopThemeDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<ShopTheme> listBy(Map<String, Object> paramMap) {
		return shopThemeDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return shopThemeDao.listBy(paramMap, sqlId);
	}

	@Override
	public ShopTheme getBy(Map<String, Object> paramMap) {
		return shopThemeDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return shopThemeDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return shopThemeDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(ShopTheme shopTheme) {
		return shopThemeDao.insert(shopTheme);
	}

	@Override
	public long update(ShopTheme shopTheme) {
		return shopThemeDao.update(shopTheme);
	}
}
