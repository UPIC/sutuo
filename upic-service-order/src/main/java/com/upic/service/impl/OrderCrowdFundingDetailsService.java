package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IOrderCrowdFundingDetailsDao;
import com.upic.po.OrderCrowdFundingDetails;
import com.upic.service.IOrderCrowdFundingDetailsService;

@Service("orderCrowdFundingDetailsService")
public class OrderCrowdFundingDetailsService implements IOrderCrowdFundingDetailsService {
	@Autowired
	private IOrderCrowdFundingDetailsDao orderCrowdFundingDetailsDao;

	@Override
	public OrderCrowdFundingDetails getBy(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		return orderCrowdFundingDetailsDao.getBy(arg0);
	}

	@Override
	public Object getBy(Map<String, Object> arg0, String arg1) {
		// TODO Auto-generated method stub
		return orderCrowdFundingDetailsDao.getBy(arg0, arg1);
	}

	@Override
	public OrderCrowdFundingDetails getById(long arg0) {
		// TODO Auto-generated method stub
		return orderCrowdFundingDetailsDao.getById(arg0);
	}

	@Override
	public String getSeqNextValue(String arg0) {
		// TODO Auto-generated method stub
		return orderCrowdFundingDetailsDao.getSeqNextValue(arg0);
	}

	@Override
	public List<OrderCrowdFundingDetails> listBy(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		return orderCrowdFundingDetailsDao.listBy(arg0);
	}

	@Override
	public List<Object> listBy(Map<String, Object> arg0, String arg1) {
		// TODO Auto-generated method stub
		return orderCrowdFundingDetailsDao.listBy(arg0, arg1);
	}

	@Override
	public PageBean listPage(PageParam arg0, Map<String, Object> arg1) {
		// TODO Auto-generated method stub
		return orderCrowdFundingDetailsDao.listPage(arg0, arg1);
	}

	@Override
	public PageBean listPage(PageParam arg0, Map<String, Object> arg1, String arg2) {
		// TODO Auto-generated method stub
		return orderCrowdFundingDetailsDao.listPage(arg0, arg1);
	}

}
