package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IThemetzStoreDao;
import com.upic.po.ThemetzStore;
import com.upic.service.IThemetzStoreService;

@Service("themetzStoreService")
public class ThemetzStoreService implements IThemetzStoreService {
	@Autowired
	private IThemetzStoreDao themetzStoreDao;

	@Override
	public ThemetzStore getById(long id) {
		return themetzStoreDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return themetzStoreDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return themetzStoreDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<ThemetzStore> listBy(Map<String, Object> paramMap) {
		return themetzStoreDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return themetzStoreDao.listBy(paramMap, sqlId);
	}

	@Override
	public ThemetzStore getBy(Map<String, Object> paramMap) {
		return themetzStoreDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return themetzStoreDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return themetzStoreDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(ThemetzStore themetzStore) {
		return themetzStoreDao.insert(themetzStore);
	}

	@Override
	public long update(ThemetzStore themetzStore) {
		return themetzStoreDao.insert(themetzStore);
	}
}
