package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IStandardDao;
import com.upic.po.Standard;
import com.upic.service.IStandardService;

@Service("standardService")
public class StandardService implements IStandardService {
	@Autowired
	private IStandardDao standardDao;

	@Override
	public Standard getById(long id) {
		return standardDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return standardDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return standardDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<Standard> listBy(Map<String, Object> paramMap) {
		return standardDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return standardDao.listBy(paramMap, sqlId);
	}

	@Override
	public Standard getBy(Map<String, Object> paramMap) {
		return standardDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return standardDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return standardDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(Standard standard) {
		return standardDao.insert(standard);
	}

	@Override
	public long update(Standard standard) {
		return standardDao.update(standard);
	}

}
