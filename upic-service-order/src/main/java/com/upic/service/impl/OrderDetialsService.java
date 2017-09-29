package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IOrderDetialsDao;
import com.upic.po.OrderDetials;
import com.upic.service.IOrderDetialsService;

@Service("orderDetialsService")
public class OrderDetialsService implements IOrderDetialsService {
	@Autowired
	private IOrderDetialsDao orderDetialsDao;

	@Override
	public OrderDetials getById(long id) {
		return orderDetialsDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return orderDetialsDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return orderDetialsDao.listPage(pageParam, paramMap);
	}

	@Override
	public List<OrderDetials> listBy(Map<String, Object> paramMap) {
		return orderDetialsDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return orderDetialsDao.listBy(paramMap, sqlId);
	}

	@Override
	public OrderDetials getBy(Map<String, Object> paramMap) {
		return orderDetialsDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return orderDetialsDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return orderDetialsDao.getSeqNextValue(seqName);
	}

	@Override
	public long update(OrderDetials orderDetials) {
		return orderDetialsDao.update(orderDetials);
	}
}
