package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IPingLunMeituPnDao;
import com.upic.po.PingLunMeituPn;
import com.upic.service.IPingLunMeituPnService;

@Service("pingLunMeituPnService")
public class PingLunMeituPnService implements IPingLunMeituPnService {
	@Autowired
	private IPingLunMeituPnDao pingLunMeituPnDao;

	@Override
	public PingLunMeituPn getById(long id) {
		return pingLunMeituPnDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return pingLunMeituPnDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return pingLunMeituPnDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<PingLunMeituPn> listBy(Map<String, Object> paramMap) {
		return pingLunMeituPnDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return pingLunMeituPnDao.listBy(paramMap, sqlId);
	}

	@Override
	public PingLunMeituPn getBy(Map<String, Object> paramMap) {
		return pingLunMeituPnDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return pingLunMeituPnDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return pingLunMeituPnDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(PingLunMeituPn PingLunMeitutzFirst) {
		return pingLunMeituPnDao.insert(PingLunMeitutzFirst);
	}

	@Override
	public long update(PingLunMeituPn PingLunMeitutzFirst) {
		return pingLunMeituPnDao.update(PingLunMeitutzFirst);
	}
}
