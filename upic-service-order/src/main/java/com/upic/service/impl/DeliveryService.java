package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IDeliveryDao;
import com.upic.po.Delivery;
import com.upic.service.IDeliveryService;


@Service("deliveryService")
public class DeliveryService implements IDeliveryService {
	@Autowired
	private IDeliveryDao deliveryDao;

	@Override
	public Delivery getById(long id) {
		return deliveryDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return deliveryDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return deliveryDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<Delivery> listBy(Map<String, Object> paramMap) {
		return deliveryDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return deliveryDao.listBy(paramMap, sqlId);
	}

	@Override
	public Delivery getBy(Map<String, Object> paramMap) {
		return deliveryDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return deliveryDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return deliveryDao.getSeqNextValue(seqName);
	}

	@Override
	public long update(Delivery delivery) {
		return deliveryDao.update(delivery);
	}
}
