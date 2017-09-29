package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IStoreCollectionDao;
import com.upic.po.StoreCollection;
import com.upic.service.IStoreCollectionService;

@Service("storeCollectionService")
public class StoreCollectionService implements IStoreCollectionService {
	@Autowired
	private IStoreCollectionDao storeCollectionDao;

	@Override
	public StoreCollection getById(long id) {
		return storeCollectionDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return storeCollectionDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return storeCollectionDao.listPage(pageParam, paramMap);
	}

	@Override
	public List<StoreCollection> listBy(Map<String, Object> paramMap) {
		return storeCollectionDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return storeCollectionDao.listBy(paramMap, sqlId);
	}

	@Override
	public StoreCollection getBy(Map<String, Object> paramMap) {
		return storeCollectionDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return storeCollectionDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return storeCollectionDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(StoreCollection storeCollection) {
		return storeCollectionDao.insert(storeCollection);
	}

	@Override
	public long update(StoreCollection storeCollection) {
		return storeCollectionDao.update(storeCollection);
	}
}
