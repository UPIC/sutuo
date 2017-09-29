package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IHotThemePnDao;
import com.upic.po.HotThemePn;
import com.upic.service.IHotThemePnService;

@Service("hotThemePnService")
public class HotThemePnService implements IHotThemePnService {
	@Autowired
	private IHotThemePnDao hotThemePnDao;

	@Override
	public HotThemePn getById(long id) {
		return hotThemePnDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return hotThemePnDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return hotThemePnDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<HotThemePn> listBy(Map<String, Object> paramMap) {
		return hotThemePnDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return hotThemePnDao.listBy(paramMap, sqlId);
	}

	@Override
	public HotThemePn getBy(Map<String, Object> paramMap) {
		return hotThemePnDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return hotThemePnDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return hotThemePnDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(HotThemePn hotThemePn) {
		return hotThemePnDao.insert(hotThemePn);
	}

	@Override
	public long update(HotThemePn hotThemePn) {
		return hotThemePnDao.update(hotThemePn);
	}
}
