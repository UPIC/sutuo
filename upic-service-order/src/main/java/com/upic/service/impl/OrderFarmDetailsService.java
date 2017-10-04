package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IOrderFarmDetailsDao;
import com.upic.po.OrderFarmDetails;
import com.upic.service.IOrderFarmDetailsService;

@Service("orderFarmDetailsService")
public class OrderFarmDetailsService implements IOrderFarmDetailsService {
	@Autowired
	private IOrderFarmDetailsDao orderFarmDetailsDao;
	
	@Override
	public OrderFarmDetails getBy(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		return orderFarmDetailsDao.getBy(arg0);
	}

	@Override
	public Object getBy(Map<String, Object> arg0, String arg1) {
		// TODO Auto-generated method stub
		return orderFarmDetailsDao.getBy(arg0, arg1);
	}

	@Override
	public OrderFarmDetails getById(long arg0) {
		// TODO Auto-generated method stub
		return orderFarmDetailsDao.getById(arg0);
	}

	@Override
	public String getSeqNextValue(String arg0) {
		// TODO Auto-generated method stub
		return orderFarmDetailsDao.getSeqNextValue(arg0);
	}

	@Override
	public List<OrderFarmDetails> listBy(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		return orderFarmDetailsDao.listBy(arg0);
	}

	@Override
	public List<Object> listBy(Map<String, Object> arg0, String arg1) {
		// TODO Auto-generated method stub
		return orderFarmDetailsDao.listBy(arg0, arg1);
	}

	@Override
	public PageBean listPage(PageParam arg0, Map<String, Object> arg1) {
		// TODO Auto-generated method stub
		return orderFarmDetailsDao.listPage(arg0, arg1);
	}

	@Override
	public PageBean listPage(PageParam arg0, Map<String, Object> arg1, String arg2) {
		// TODO Auto-generated method stub
		return orderFarmDetailsDao.listPage(arg0, arg1);
	}

}
