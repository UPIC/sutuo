package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.ITypeShopFarmDao;
import com.upic.po.TypeShopFarm;
import com.upic.service.ITypeShopFarmService;

@Service("typeShopFarmService")
public class TypeShopFarmService implements ITypeShopFarmService {
	@Autowired
	private ITypeShopFarmDao typeShopFarmDao;

	@Override
	public TypeShopFarm getBy(Map<String, Object> arg0) {
		return typeShopFarmDao.getBy(arg0);
	}

	@Override
	public Object getBy(Map<String, Object> arg0, String arg1) {
		return typeShopFarmDao.getBy(arg0, arg1);
	}

	@Override
	public TypeShopFarm getById(long arg0) {
		return typeShopFarmDao.getById(arg0);
	}

	@Override
	public String getSeqNextValue(String arg0) {
		return typeShopFarmDao.getSeqNextValue(arg0);
	}

	@Override
	public List<TypeShopFarm> listBy(Map<String, Object> arg0) {
		return typeShopFarmDao.listBy(arg0);
	}

	@Override
	public List<Object> listBy(Map<String, Object> arg0, String arg1) {
		return typeShopFarmDao.listBy(arg0, arg1);
	}

	@Override
	public PageBean listPage(PageParam arg0, Map<String, Object> arg1) {
		return typeShopFarmDao.listPage(arg0, arg1);
	}

	@Override
	public PageBean listPage(PageParam arg0, Map<String, Object> arg1, String arg2) {
		return typeShopFarmDao.listPage(arg0, arg1, arg2);
	}

	@Override
	public long insert(TypeShopFarm arg0) {
		return typeShopFarmDao.insert(arg0);
	}

	@Override
	public long update(TypeShopFarm arg0) {
		return typeShopFarmDao.update(arg0);
	}
}
