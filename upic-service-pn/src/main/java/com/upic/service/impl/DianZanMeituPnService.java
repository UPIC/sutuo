package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IDianZanMeituPnDao;
import com.upic.po.DianZanMeituPn;
import com.upic.service.IDianZanMeituPnService;

@Service("dianZanMeituPnService")
public class DianZanMeituPnService implements IDianZanMeituPnService {
	@Autowired
	private IDianZanMeituPnDao dianZanMeituPnDao;

	@Override
	public DianZanMeituPn getById(long id) {
		return dianZanMeituPnDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return dianZanMeituPnDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return dianZanMeituPnDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<DianZanMeituPn> listBy(Map<String, Object> paramMap) {
		return dianZanMeituPnDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return dianZanMeituPnDao.listBy(paramMap, sqlId);
	}

	@Override
	public DianZanMeituPn getBy(Map<String, Object> paramMap) {
		return dianZanMeituPnDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return dianZanMeituPnDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return dianZanMeituPnDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(DianZanMeituPn DianZanMeitutzFirst) {
		return dianZanMeituPnDao.insert(DianZanMeitutzFirst);
	}

	@Override
	public long update(DianZanMeituPn DianZanMeitutzFirst) {
		return dianZanMeituPnDao.update(DianZanMeitutzFirst);
	}
}
