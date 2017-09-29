package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IShopTicketDao;
import com.upic.po.ShopTicket;
import com.upic.service.IShopTicketService;

@Service("shopTicketService")
public class ShopTicketService implements IShopTicketService {
	@Autowired
	private IShopTicketDao shopTicketDao;

	@Override
	public ShopTicket getById(long id) {
		return shopTicketDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return shopTicketDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return shopTicketDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<ShopTicket> listBy(Map<String, Object> paramMap) {
		return shopTicketDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return shopTicketDao.listBy(paramMap, sqlId);
	}

	@Override
	public ShopTicket getBy(Map<String, Object> paramMap) {
		return shopTicketDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return shopTicketDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return shopTicketDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(ShopTicket shopTicket) {
		return shopTicketDao.insert(shopTicket);
	}

	@Override
	public long update(ShopTicket shopTicket) {
		return shopTicketDao.update(shopTicket);
	}
}
