package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IStoreSignDao;
import com.upic.po.StoreSign;
import com.upic.service.IStoreSignService;

@Service("storeSignService")
public class StoreSignService implements IStoreSignService {
	@Autowired
	private IStoreSignDao storeSignDao;

	@Override
	public StoreSign getById(long id) {
		return storeSignDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return storeSignDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return storeSignDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<StoreSign> listBy(Map<String, Object> paramMap) {
		return storeSignDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return storeSignDao.listBy(paramMap, sqlId);
	}

	@Override
	public StoreSign getBy(Map<String, Object> paramMap) {
		return storeSignDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return storeSignDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return storeSignDao.getSeqNextValue(seqName);
	}
	
}
