package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IStoreOwnRecommendDao;
import com.upic.po.StoreOwnRecommend;
import com.upic.service.IStoreOwnRecommendService;

@Service("storeOwnRecommendService")
public class StoreOwnRecommendService implements IStoreOwnRecommendService {
	@Autowired
	private IStoreOwnRecommendDao storeOwnRecommendDao;

	@Override
	public StoreOwnRecommend getById(long id) {
		return storeOwnRecommendDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return storeOwnRecommendDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return storeOwnRecommendDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<StoreOwnRecommend> listBy(Map<String, Object> paramMap) {
		return storeOwnRecommendDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return storeOwnRecommendDao.listBy(paramMap, sqlId);
	}

	@Override
	public StoreOwnRecommend getBy(Map<String, Object> paramMap) {
		return storeOwnRecommendDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return storeOwnRecommendDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return storeOwnRecommendDao.getSeqNextValue(seqName);
	}
}
