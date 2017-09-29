package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IStoreDao;
import com.upic.po.Store;
import com.upic.service.IStoreService;

@Service("storeService")
public class StoreService implements IStoreService {
	@Autowired
	private IStoreDao storeDao;

	@Override
	public Store getById(long id) {
		return storeDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return storeDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return storeDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<Store> listBy(Map<String, Object> paramMap) {
		return storeDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return storeDao.listBy(paramMap, sqlId);
	}

	@Override
	public Store getBy(Map<String, Object> paramMap) {
		return storeDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return storeDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return storeDao.getSeqNextValue(seqName);
	}

	@Override
	public long update(Store s) {
		return storeDao.update(s);
	}

	@Override
	public long insert(Store s) {
		return storeDao.insert(s);
	}
}
