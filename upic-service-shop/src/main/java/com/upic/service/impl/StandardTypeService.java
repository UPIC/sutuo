package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IStandardTypeDao;
import com.upic.po.StandardType;
import com.upic.service.IStandardTypeService;

@Service("standardTypeService")
public class StandardTypeService implements IStandardTypeService {
	@Autowired
	private IStandardTypeDao standardTypeDao;

	@Override
	public StandardType getById(long id) {
		return standardTypeDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return standardTypeDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return standardTypeDao.listPage(pageParam, paramMap);
	}

	@Override
	public List<StandardType> listBy(Map<String, Object> paramMap) {
		return standardTypeDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return standardTypeDao.listBy(paramMap, sqlId);
	}

	@Override
	public StandardType getBy(Map<String, Object> paramMap) {
		return standardTypeDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return standardTypeDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return standardTypeDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(StandardType standardType) {
		return standardTypeDao.insert(standardType);
	}

	@Override
	public long update(StandardType standardType) {
		return standardTypeDao.update(standardType);
	}

}
