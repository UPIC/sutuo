package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IMeituPnDao;
import com.upic.po.MeituPn;
import com.upic.service.IMeituPnService;

@Service("meituPnService")
public class MeituPnService implements IMeituPnService {
	@Autowired
	private IMeituPnDao meituPnDao;

	@Override
	public MeituPn getById(long id) {
		return meituPnDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return meituPnDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return meituPnDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<MeituPn> listBy(Map<String, Object> paramMap) {
		return meituPnDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return meituPnDao.listBy(paramMap, sqlId);
	}

	@Override
	public MeituPn getBy(Map<String, Object> paramMap) {
		return meituPnDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return meituPnDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return meituPnDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(MeituPn meitutzFirst) {
		return meituPnDao.insert(meitutzFirst);
	}

	@Override
	public long update(MeituPn meitutzFirst) {
		return meituPnDao.update(meitutzFirst);
	}
}
