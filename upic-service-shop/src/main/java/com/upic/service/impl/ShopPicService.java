package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IShopPicDao;
import com.upic.po.ShopPic;
import com.upic.service.IShopPicService;

@Service("shopPicService")
public class ShopPicService implements IShopPicService {
	@Autowired
	private IShopPicDao shopPicDao;

	@Override
	public ShopPic getById(long id) {
		return shopPicDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return shopPicDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return shopPicDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<ShopPic> listBy(Map<String, Object> paramMap) {
		return shopPicDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return shopPicDao.listBy(paramMap, sqlId);
	}

	@Override
	public ShopPic getBy(Map<String, Object> paramMap) {
		return shopPicDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return shopPicDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return shopPicDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(ShopPic shopPic) {
		return shopPicDao.insert(shopPic);
	}

	@Override
	public long update(ShopPic shopPic) {
		return shopPicDao.update(shopPic);
	}
}
