package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IKeyWordKWDao;
import com.upic.po.KeyWordKW;
import com.upic.service.IKeyWordKWService;

@Service("keyWordKWService")
public class KeyWordKWService implements IKeyWordKWService {
	@Autowired
	private IKeyWordKWDao keyWordKWDao;

	@Override
	public KeyWordKW getById(long id) {
		return keyWordKWDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return keyWordKWDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return keyWordKWDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<KeyWordKW> listBy(Map<String, Object> paramMap) {
		return keyWordKWDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return keyWordKWDao.listBy(paramMap, sqlId);
	}

	@Override
	public KeyWordKW getBy(Map<String, Object> paramMap) {
		return keyWordKWDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return keyWordKWDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return keyWordKWDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(KeyWordKW KeyWordKW) {
		return keyWordKWDao.insert(KeyWordKW);
	}

	@Override
	public long update(KeyWordKW KeyWordKW) {
		return keyWordKWDao.update(KeyWordKW);
	}
}
