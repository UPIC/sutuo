package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IBannarPnDao;
import com.upic.po.BannarPn;
import com.upic.service.IBannarPnService;

@Service("bannarPnService")
public class BannarPnService implements IBannarPnService {
	@Autowired
	private IBannarPnDao bannarPnDao;

	@Override
	public BannarPn getById(long id) {
		return bannarPnDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return bannarPnDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return bannarPnDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<BannarPn> listBy(Map<String, Object> paramMap) {
		return bannarPnDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return bannarPnDao.listBy(paramMap, sqlId);
	}

	@Override
	public BannarPn getBy(Map<String, Object> paramMap) {
		return bannarPnDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return bannarPnDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return bannarPnDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(BannarPn mainPic) {
		return bannarPnDao.insert(mainPic);
	}

	@Override
	public long update(BannarPn mainPic) {
		return bannarPnDao.update(mainPic);
	}
}
