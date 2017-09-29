package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IOrderDao;
import com.upic.po.Order;
import com.upic.service.IOrderService;

@Service("orderService")
public class OrderService implements IOrderService {
	@Autowired
	private IOrderDao orderDao;

	@Override
	public Order getById(long id) {
		return orderDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return orderDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return orderDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<Order> listBy(Map<String, Object> paramMap) {
		return orderDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return orderDao.listBy(paramMap, sqlId);
	}

	@Override
	public Order getBy(Map<String, Object> paramMap) {
		return orderDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return orderDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return orderDao.getSeqNextValue(seqName);
	}

	@Override
	public long update(Order o) {
		return orderDao.update(o);
	}

	@Override
	public long insert(Order o) {
		return orderDao.insert(o);
	}
}
