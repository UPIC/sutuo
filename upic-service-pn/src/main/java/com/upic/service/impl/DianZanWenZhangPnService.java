package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IDianZanWenZhangPnDao;
import com.upic.po.DianZanWenZhangPn;
import com.upic.service.IDianZanWenZhangPnService;

@Service("dianZanWenZhangPnService")
public class DianZanWenZhangPnService implements IDianZanWenZhangPnService {
	@Autowired
	private IDianZanWenZhangPnDao dianZanWenZhangPnDao;

	@Override
	public DianZanWenZhangPn getById(long id) {
		return dianZanWenZhangPnDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return dianZanWenZhangPnDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return dianZanWenZhangPnDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<DianZanWenZhangPn> listBy(Map<String, Object> paramMap) {
		return dianZanWenZhangPnDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return dianZanWenZhangPnDao.listBy(paramMap, sqlId);
	}

	@Override
	public DianZanWenZhangPn getBy(Map<String, Object> paramMap) {
		return dianZanWenZhangPnDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return dianZanWenZhangPnDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return dianZanWenZhangPnDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(DianZanWenZhangPn DianZanWenZhangtzFirst) {
		return dianZanWenZhangPnDao.insert(DianZanWenZhangtzFirst);
	}

	@Override
	public long update(DianZanWenZhangPn DianZanWenZhangtzFirst) {
		return dianZanWenZhangPnDao.update(DianZanWenZhangtzFirst);
	}
}
