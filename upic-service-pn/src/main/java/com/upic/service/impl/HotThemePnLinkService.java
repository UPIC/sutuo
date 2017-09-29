package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IHotThemePnLinkDao;
import com.upic.po.HotThemePnLink;
import com.upic.po.SignPnLink;
import com.upic.service.IHotThemePnLinkService;

@Service("hotThemePnLinkService")
public class HotThemePnLinkService implements IHotThemePnLinkService {
	@Autowired
	private IHotThemePnLinkDao hotThemePnLinkDao;

	@Override
	public HotThemePnLink getById(long id) {
		return hotThemePnLinkDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return hotThemePnLinkDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return hotThemePnLinkDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<HotThemePnLink> listBy(Map<String, Object> paramMap) {
		return hotThemePnLinkDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return hotThemePnLinkDao.listBy(paramMap, sqlId);
	}

	@Override
	public HotThemePnLink getBy(Map<String, Object> paramMap) {
		return hotThemePnLinkDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return hotThemePnLinkDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return hotThemePnLinkDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(HotThemePnLink hotThemePnLink) {
		return hotThemePnLinkDao.insert(hotThemePnLink);
	}

	@Override
	public long update(HotThemePnLink hotThemePnLink) {
		return hotThemePnLinkDao.update(hotThemePnLink);
	}
	@Override
	public long update(HotThemePnLink hotThemePnLink,String method) {
		return hotThemePnLinkDao.update(hotThemePnLink,method);
	}

}
