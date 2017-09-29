package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IReTradDao;
import com.upic.po.ReTrad;
import com.upic.service.IReTradService;

@Service("reTradService")
public class ReTradService implements IReTradService {
	@Autowired
	private IReTradDao reTradDao;

	@Override
	public ReTrad getById(long id) {
		return reTradDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return reTradDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return reTradDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<ReTrad> listBy(Map<String, Object> paramMap) {
		return reTradDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return reTradDao.listBy(paramMap, sqlId);
	}

	@Override
	public ReTrad getBy(Map<String, Object> paramMap) {
		return reTradDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return reTradDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return reTradDao.getSeqNextValue(seqName);
	}
}
