package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IAccessDao;
import com.upic.po.Access;
import com.upic.service.IAccessService;

@Service("accessService")
public class AccessService implements IAccessService {
	@Autowired
	private IAccessDao accessDao;

	@Override
	public Access getById(long id) {
		return accessDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return accessDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return accessDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<Access> listBy(Map<String, Object> paramMap) {
		return accessDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return accessDao.listBy(paramMap, sqlId);
	}

	@Override
	public Access getBy(Map<String, Object> paramMap) {
		return accessDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return accessDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return accessDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(Access a) {
		return accessDao.insert(a);
	}
}
