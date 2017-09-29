package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IFirstTypeDao;
import com.upic.po.FirstType;
import com.upic.service.IFirstTypeService;

@Service("firstTypeService")
public class FirstTypeService implements IFirstTypeService {
	@Autowired
	private IFirstTypeDao firstTypeDao;

	@Override
	public FirstType getById(long id) {
		return firstTypeDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return firstTypeDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return firstTypeDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<FirstType> listBy(Map<String, Object> paramMap) {
		return firstTypeDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return firstTypeDao.listBy(paramMap, sqlId);
	}

	@Override
	public FirstType getBy(Map<String, Object> paramMap) {
		return firstTypeDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return firstTypeDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return firstTypeDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(FirstType firstType) {
		return firstTypeDao.insert(firstType);
	}

	@Override
	public long update(FirstType firstType) {
		return firstTypeDao.update(firstType);
	}
}
