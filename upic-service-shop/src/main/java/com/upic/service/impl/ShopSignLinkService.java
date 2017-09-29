package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IShopSignLinkDao;
import com.upic.po.ShopSignLink;
import com.upic.service.IShopSignLinkService;

@Service("shopSignLinkService")
public class ShopSignLinkService implements IShopSignLinkService {
	@Autowired
	private IShopSignLinkDao shopSignLinkDao;

	@Override
	public ShopSignLink getById(long id) {
		return shopSignLinkDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return shopSignLinkDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return shopSignLinkDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<ShopSignLink> listBy(Map<String, Object> paramMap) {
		return shopSignLinkDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return shopSignLinkDao.listBy(paramMap, sqlId);
	}

	@Override
	public ShopSignLink getBy(Map<String, Object> paramMap) {
		return shopSignLinkDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return shopSignLinkDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return shopSignLinkDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(ShopSignLink shopSignLink) {
		return shopSignLinkDao.insert(shopSignLink);
	}

	@Override
	public long update(ShopSignLink shopSignLink) {
		return shopSignLinkDao.update(shopSignLink);
	}
}
