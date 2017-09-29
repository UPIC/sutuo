package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IArticalPnDao;
import com.upic.po.ArticalPn;
import com.upic.service.IArticalPnService;

@Service("articalPnService")
public class ArticalPnService implements IArticalPnService {
	@Autowired
	private IArticalPnDao articalPnDao;

	@Override
	public ArticalPn getById(long id) {
		return articalPnDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return articalPnDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return articalPnDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<ArticalPn> listBy(Map<String, Object> paramMap) {
		return articalPnDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return articalPnDao.listBy(paramMap, sqlId);
	}

	@Override
	public ArticalPn getBy(Map<String, Object> paramMap) {
		return articalPnDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return articalPnDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return articalPnDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(ArticalPn articalPn) {
		return articalPnDao.insert(articalPn);
	}

	@Override
	public long update(ArticalPn articalPn) {
		return articalPnDao.update(articalPn);
	}
}
