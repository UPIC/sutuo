package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IStandardShopDao;
import com.upic.po.StandardShop;
import com.upic.service.IStandardShopService;

@Service("standardShopService")
public class StandardShopService implements IStandardShopService {
	@Autowired
	private IStandardShopDao standardShopDao;

	@Override
	public StandardShop getById(long id) {
		// TODO Auto-generated method stub
		return standardShopDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return standardShopDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		// TODO Auto-generated method stub
		return standardShopDao.listPage(pageParam, paramMap);
	}

	@Override
	public List<StandardShop> listBy(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return standardShopDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		// TODO Auto-generated method stub
		return standardShopDao.listBy(paramMap, sqlId);
	}

	@Override
	public StandardShop getBy(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return standardShopDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		// TODO Auto-generated method stub
		return standardShopDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		// TODO Auto-generated method stub
		return standardShopDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(StandardShop standardShop) {
		// TODO Auto-generated method stub
		return standardShopDao.insert(standardShop);
	}

	@Override
	public long update(StandardShop standardShop) {
		// TODO Auto-generated method stub
		return standardShopDao.update(standardShop);
	}

}
