package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IShopCrowdFundingDao;
import com.upic.po.ShopCrowdFunding;
import com.upic.service.IShopCrowdFundingService;

@Service("shopCrowdFundingService")
public class ShopCrowdFundingService implements IShopCrowdFundingService {
	@Autowired
	private IShopCrowdFundingDao shopCrowdFundingDao;
	
	@Override
	public ShopCrowdFunding getBy(Map<String, Object> arg0) {
		return shopCrowdFundingDao.getBy(arg0);
	}

	@Override
	public Object getBy(Map<String, Object> arg0, String arg1) {
		// TODO Auto-generated method stub
		return shopCrowdFundingDao.getBy(arg0, arg1);
	}

	@Override
	public ShopCrowdFunding getById(long arg0) {
		// TODO Auto-generated method stub
		return shopCrowdFundingDao.getById(arg0);
	}

	@Override
	public String getSeqNextValue(String arg0) {
		// TODO Auto-generated method stub
		return shopCrowdFundingDao.getSeqNextValue(arg0);
	}

	@Override
	public List<ShopCrowdFunding> listBy(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		return shopCrowdFundingDao.listBy(arg0);
	}

	@Override
	public List<Object> listBy(Map<String, Object> arg0, String arg1) {
		// TODO Auto-generated method stub
		return shopCrowdFundingDao.listBy(arg0, arg1);
	}

	@Override
	public PageBean listPage(PageParam arg0, Map<String, Object> arg1) {
		// TODO Auto-generated method stub
		return shopCrowdFundingDao.listPage(arg0, arg1);
	}

	@Override
	public PageBean listPage(PageParam arg0, Map<String, Object> arg1, String arg2) {
		// TODO Auto-generated method stub
		return shopCrowdFundingDao.listPage(arg0, arg1);
	}

}
