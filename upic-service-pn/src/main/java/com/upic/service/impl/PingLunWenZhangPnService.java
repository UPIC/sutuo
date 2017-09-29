package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IPingLunWenZhangPnDao;
import com.upic.po.PingLunWenZhangPn;
import com.upic.service.IPingLunWenZhangPnService;

@Service("pingLunWenZhangPnService")
public class PingLunWenZhangPnService implements IPingLunWenZhangPnService {
	@Autowired
	private IPingLunWenZhangPnDao pingLunWenZhangPnDao;

	@Override
	public PingLunWenZhangPn getById(long id) {
		return pingLunWenZhangPnDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return pingLunWenZhangPnDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return pingLunWenZhangPnDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<PingLunWenZhangPn> listBy(Map<String, Object> paramMap) {
		return pingLunWenZhangPnDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return pingLunWenZhangPnDao.listBy(paramMap, sqlId);
	}

	@Override
	public PingLunWenZhangPn getBy(Map<String, Object> paramMap) {
		return pingLunWenZhangPnDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return pingLunWenZhangPnDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return pingLunWenZhangPnDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(PingLunWenZhangPn PingLunWenZhangtzFirst) {
		return pingLunWenZhangPnDao.insert(PingLunWenZhangtzFirst);
	}

	@Override
	public long update(PingLunWenZhangPn PingLunWenZhangtzFirst) {
		return pingLunWenZhangPnDao.update(PingLunWenZhangtzFirst);
	}
}
