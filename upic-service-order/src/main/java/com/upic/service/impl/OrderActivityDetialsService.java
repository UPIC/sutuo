package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IOrderActivityDetialsDao;
import com.upic.po.OrderActivityDetials;
import com.upic.service.IOrderActivityDetialsService;

@Service("orderActivityService")
public class OrderActivityDetialsService implements IOrderActivityDetialsService {
	@Autowired
	private IOrderActivityDetialsDao orderActivityDetialsDao;

	@Override
	public OrderActivityDetials getById(long id) {
		return orderActivityDetialsDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return orderActivityDetialsDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return orderActivityDetialsDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<OrderActivityDetials> listBy(Map<String, Object> paramMap) {
		return orderActivityDetialsDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return orderActivityDetialsDao.listBy(paramMap, sqlId);
	}

	@Override
	public OrderActivityDetials getBy(Map<String, Object> paramMap) {
		return orderActivityDetialsDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return orderActivityDetialsDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return orderActivityDetialsDao.getSeqNextValue(seqName);
	}

	@Override
	public long update(OrderActivityDetials orderActivityDetials) {
		return orderActivityDetialsDao.update(orderActivityDetials);
	}
}
