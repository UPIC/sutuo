package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.ISignPnDao;
import com.upic.po.SignPn;
import com.upic.service.ISignPnService;

@Service("signPnService")
public class SignPnService implements ISignPnService {
	@Autowired
	private ISignPnDao signPnDao;

	@Override
	public SignPn getById(long id) {
		return signPnDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return signPnDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return signPnDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<SignPn> listBy(Map<String, Object> paramMap) {
		return signPnDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return signPnDao.listBy(paramMap, sqlId);
	}

	@Override
	public SignPn getBy(Map<String, Object> paramMap) {
		return signPnDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return signPnDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return signPnDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(SignPn SignPn) {
		return signPnDao.insert(SignPn);
	}

	@Override
	public long update(SignPn SignPn) {
		return signPnDao.update(SignPn);
	}
}
