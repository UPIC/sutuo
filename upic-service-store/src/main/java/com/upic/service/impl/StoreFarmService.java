package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IStoreFarmDao;
import com.upic.po.StoreFarm;
import com.upic.service.IStoreFarmService;

@Service("storeFarmService")
public class StoreFarmService implements IStoreFarmService {
	@Autowired
	private IStoreFarmDao storeFarmDao;

	@Override
	public StoreFarm getBy(Map<String, Object> arg0) {
		return storeFarmDao.getBy(arg0);
	}

	@Override
	public Object getBy(Map<String, Object> arg0, String arg1) {
		return storeFarmDao.getBy(arg0, arg1);
	}

	@Override
	public StoreFarm getById(long arg0) {
		return storeFarmDao.getById(arg0);
	}

	@Override
	public String getSeqNextValue(String arg0) {
		return storeFarmDao.getSeqNextValue(arg0);
	}

	@Override
	public List<StoreFarm> listBy(Map<String, Object> arg0) {
		return storeFarmDao.listBy(arg0);
	}

	@Override
	public List<Object> listBy(Map<String, Object> arg0, String arg1) {
		return storeFarmDao.listBy(arg0, arg1);
	}

	@Override
	public PageBean listPage(PageParam arg0, Map<String, Object> arg1) {
		return storeFarmDao.listPage(arg0, arg1);
	}

	@Override
	public PageBean listPage(PageParam arg0, Map<String, Object> arg1, String arg2) {
		return storeFarmDao.listPage(arg0, arg1, arg2);
	}

	@Override
	public long insert(StoreFarm arg0) {
		return storeFarmDao.insert(arg0);
	}

	@Override
	public long update(StoreFarm arg0) {
		return storeFarmDao.update(arg0);
	}
}
