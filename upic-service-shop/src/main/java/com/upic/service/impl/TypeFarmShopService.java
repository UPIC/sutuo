package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.ITypeFarmShopDao;
import com.upic.po.TypeFarmShop;
import com.upic.service.ITypeFarmShopService;

@Service("typeFarmShopService")
public class TypeFarmShopService implements ITypeFarmShopService {
	@Autowired
	private ITypeFarmShopDao typeFarmShopDao;

	@Override
	public TypeFarmShop getBy(Map<String, Object> arg0) {
		return typeFarmShopDao.getBy(arg0);
	}

	@Override
	public Object getBy(Map<String, Object> arg0, String arg1) {
		return typeFarmShopDao.getBy(arg0, arg1);
	}

	@Override
	public TypeFarmShop getById(long arg0) {
		return typeFarmShopDao.getById(arg0);
	}

	@Override
	public String getSeqNextValue(String arg0) {
		return typeFarmShopDao.getSeqNextValue(arg0);
	}

	@Override
	public List<TypeFarmShop> listBy(Map<String, Object> arg0) {
		return typeFarmShopDao.listBy(arg0);
	}

	@Override
	public List<Object> listBy(Map<String, Object> arg0, String arg1) {
		return typeFarmShopDao.listBy(arg0, arg1);
	}

	@Override
	public PageBean listPage(PageParam arg0, Map<String, Object> arg1) {
		return typeFarmShopDao.listPage(arg0, arg1);
	}

	@Override
	public PageBean listPage(PageParam arg0, Map<String, Object> arg1, String arg2) {
		return typeFarmShopDao.listPage(arg0, arg1, arg2);
	}

	@Override
	public long insert(TypeFarmShop arg0) {
		return typeFarmShopDao.insert(arg0);
	}

	@Override
	public long update(TypeFarmShop arg0) {
		return typeFarmShopDao.update(arg0);
	}
}
