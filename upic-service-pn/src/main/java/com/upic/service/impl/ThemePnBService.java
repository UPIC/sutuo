package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IThemePnBDao;
import com.upic.po.ThemePnB;
import com.upic.service.IThemePnBService;

@Service("themePnBService")
public class ThemePnBService implements IThemePnBService {
	@Autowired
	private IThemePnBDao themePnBDao;

	@Override
	public ThemePnB getById(long id) {
		return themePnBDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return themePnBDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return themePnBDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<ThemePnB> listBy(Map<String, Object> paramMap) {
		return themePnBDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return themePnBDao.listBy(paramMap, sqlId);
	}

	@Override
	public ThemePnB getBy(Map<String, Object> paramMap) {
		return themePnBDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return themePnBDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return themePnBDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(ThemePnB themePnB) {
		return themePnBDao.insert(themePnB);
	}

	@Override
	public long update(ThemePnB themePnB) {
		return themePnBDao.update(themePnB);
	}
}
