package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IThemetzFirstDao;
import com.upic.po.ThemetzFirst;
import com.upic.service.IThemetzFirstService;

@Service("themetzFirstService")
public class ThemetzFirstService implements IThemetzFirstService {
	@Autowired
	private IThemetzFirstDao themetzFirstDao;

	@Override
	public ThemetzFirst getById(long id) {
		return themetzFirstDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return themetzFirstDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return themetzFirstDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<ThemetzFirst> listBy(Map<String, Object> paramMap) {
		return themetzFirstDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return themetzFirstDao.listBy(paramMap, sqlId);
	}

	@Override
	public ThemetzFirst getBy(Map<String, Object> paramMap) {
		return themetzFirstDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return themetzFirstDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return themetzFirstDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(ThemetzFirst themetzFirst) {
		return themetzFirstDao.insert(themetzFirst);
	}

	@Override
	public long update(ThemetzFirst themetzFirst) {
		return themetzFirstDao.update(themetzFirst);
	}
}
