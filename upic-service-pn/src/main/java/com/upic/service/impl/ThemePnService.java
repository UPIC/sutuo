package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IThemePnDao;
import com.upic.po.ThemePn;
import com.upic.service.IThemePnService;

@Service("themePnService")
public class ThemePnService implements IThemePnService {
	@Autowired
	private IThemePnDao themePnDao;

	@Override
	public ThemePn getById(long id) {
		return themePnDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return themePnDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return themePnDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<ThemePn> listBy(Map<String, Object> paramMap) {
		return themePnDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return themePnDao.listBy(paramMap, sqlId);
	}

	@Override
	public ThemePn getBy(Map<String, Object> paramMap) {
		return themePnDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return themePnDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return themePnDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(ThemePn themetzFirst) {
		return themePnDao.insert(themetzFirst);
	}

	@Override
	public long update(ThemePn themetzFirst) {
		return themePnDao.update(themetzFirst);
	}
}
