package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IThemetzDao;
import com.upic.po.Themetz;
import com.upic.service.IThemetzService;

@Service("themetzService")
public class ThemetzService implements IThemetzService {
	@Autowired
	private IThemetzDao themetzDao;

	@Override
	public Themetz getById(long id) {
		return themetzDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return themetzDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return themetzDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<Themetz> listBy(Map<String, Object> paramMap) {
		return themetzDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return themetzDao.listBy(paramMap, sqlId);
	}

	@Override
	public Themetz getBy(Map<String, Object> paramMap) {
		return themetzDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return themetzDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return themetzDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(Themetz themetz) {
		return themetzDao.insert(themetz);
	}

	@Override
	public long update(Themetz themetz) {
		return themetzDao.update(themetz);
	}
}
