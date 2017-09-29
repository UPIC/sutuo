package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IOrderTicketDetialsDao;
import com.upic.po.OrderTicketDetials;
import com.upic.service.IOrderTicketDetialsService;

@Service("orderTicketService")
public class OrderTicketDetialsService implements IOrderTicketDetialsService {
	@Autowired
	private IOrderTicketDetialsDao orderTicketDetialsDao;

	@Override
	public OrderTicketDetials getById(long id) {
		return orderTicketDetialsDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return orderTicketDetialsDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return orderTicketDetialsDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<OrderTicketDetials> listBy(Map<String, Object> paramMap) {
		return orderTicketDetialsDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return orderTicketDetialsDao.listBy(paramMap, sqlId);
	}

	@Override
	public OrderTicketDetials getBy(Map<String, Object> paramMap) {
		return orderTicketDetialsDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return orderTicketDetialsDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return orderTicketDetialsDao.getSeqNextValue(seqName);
	}

	@Override
	public long update(OrderTicketDetials orderTicketDetials) {
		return orderTicketDetialsDao.update(orderTicketDetials);
	}
}
