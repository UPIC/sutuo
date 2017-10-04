package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IShopFarmTypeDao;
import com.upic.po.ShopFarmType;
import com.upic.service.IShopFarmTypeService;

@Service("shopFarmTypeService")
public class ShopFarmTypeService implements IShopFarmTypeService {
	@Autowired
	private IShopFarmTypeDao shopFarmTypeDao;

	@Override
	public ShopFarmType getBy(Map<String, Object> arg0) {
		return shopFarmTypeDao.getBy(arg0);
	}

	@Override
	public Object getBy(Map<String, Object> arg0, String arg1) {
		return shopFarmTypeDao.getBy(arg0, arg1);
	}

	@Override
	public ShopFarmType getById(long arg0) {
		return shopFarmTypeDao.getById(arg0);
	}

	@Override
	public String getSeqNextValue(String arg0) {
		return shopFarmTypeDao.getSeqNextValue(arg0);
	}

	@Override
	public List<ShopFarmType> listBy(Map<String, Object> arg0) {
		return shopFarmTypeDao.listBy(arg0);
	}

	@Override
	public List<Object> listBy(Map<String, Object> arg0, String arg1) {
		return shopFarmTypeDao.listBy(arg0, arg1);
	}

	@Override
	public PageBean listPage(PageParam arg0, Map<String, Object> arg1) {
		return shopFarmTypeDao.listPage(arg0, arg1);
	}

	@Override
	public PageBean listPage(PageParam arg0, Map<String, Object> arg1, String arg2) {
		return shopFarmTypeDao.listPage(arg0, arg1);
	}

}
