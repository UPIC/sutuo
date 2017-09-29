package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.ISignPnLinkDao;
import com.upic.po.SignPnLink;
import com.upic.service.ISignPnLinkService;

@Service("signPnLinkService")
public class SignPnLinkService implements ISignPnLinkService {
	@Autowired
	private ISignPnLinkDao signPnLinkDao;

	@Override
	public SignPnLink getById(long id) {
		return signPnLinkDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return signPnLinkDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return signPnLinkDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<SignPnLink> listBy(Map<String, Object> paramMap) {
		return signPnLinkDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return signPnLinkDao.listBy(paramMap, sqlId);
	}

	@Override
	public SignPnLink getBy(Map<String, Object> paramMap) {
		return signPnLinkDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return signPnLinkDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return signPnLinkDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(SignPnLink SignPnLink) {
		return signPnLinkDao.insert(SignPnLink);
	}

	@Override
	public long update(SignPnLink SignPnLink) {
		return signPnLinkDao.update(SignPnLink);
	}
	@Override
	public long update(SignPnLink SignPnLink,String method) {
		return signPnLinkDao.update(SignPnLink,method);
	}
}
