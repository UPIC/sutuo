package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IStoreSignLinkDao;
import com.upic.po.StoreSignLink;
import com.upic.service.IStoreSignLinkService;

@Service("storeSignLinkService")
public class StoreSignLinkService implements IStoreSignLinkService {
	@Autowired
	private IStoreSignLinkDao storeSignLinkDao;

	@Override
	public StoreSignLink getById(long id) {
		return storeSignLinkDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return storeSignLinkDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return storeSignLinkDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<StoreSignLink> listBy(Map<String, Object> paramMap) {
		return storeSignLinkDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return storeSignLinkDao.listBy(paramMap, sqlId);
	}

	@Override
	public StoreSignLink getBy(Map<String, Object> paramMap) {
		return storeSignLinkDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return storeSignLinkDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return storeSignLinkDao.getSeqNextValue(seqName);
	}
}
