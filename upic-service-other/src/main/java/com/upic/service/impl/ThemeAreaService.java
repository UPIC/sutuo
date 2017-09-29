package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IProjectDao;
import com.upic.dao.IThemeAreaDao;
import com.upic.po.Project;
import com.upic.po.ThemeArea;
import com.upic.service.IProjectService;
import com.upic.service.IThemeAreaService;

@Service("themeAreaService")
public class ThemeAreaService implements IThemeAreaService {
	@Autowired
	private IThemeAreaDao themeAreaDao;

	@Override
	public ThemeArea getById(long id) {
		return themeAreaDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return themeAreaDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return themeAreaDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<ThemeArea> listBy(Map<String, Object> paramMap) {
		return themeAreaDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return themeAreaDao.listBy(paramMap, sqlId);
	}

	@Override
	public ThemeArea getBy(Map<String, Object> paramMap) {
		return themeAreaDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return themeAreaDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return themeAreaDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(ThemeArea themeArea) {
		return themeAreaDao.insert(themeArea);
	}

	@Override
	public long update(ThemeArea themeArea) {
		return themeAreaDao.update(themeArea);
	}
}
