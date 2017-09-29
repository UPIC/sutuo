package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IThemetzDao;
import com.upic.dao.IYouXuanDao;
import com.upic.po.Themetz;
import com.upic.po.YouXuan;
import com.upic.service.IThemetzService;
import com.upic.service.IYouXuanService;

@Service("youXuanService")
public class YouXuanService implements IYouXuanService {
	@Autowired
	private IYouXuanDao youXuanDao;

	@Override
	public YouXuan getById(long id) {
		return youXuanDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return youXuanDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return youXuanDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<YouXuan> listBy(Map<String, Object> paramMap) {
		return youXuanDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return youXuanDao.listBy(paramMap, sqlId);
	}

	@Override
	public YouXuan getBy(Map<String, Object> paramMap) {
		return youXuanDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return youXuanDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return youXuanDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(YouXuan youXuan) {
		return youXuanDao.insert(youXuan);
	}

	@Override
	public long update(YouXuan youXuan) {
		return youXuanDao.update(youXuan);
	}
}
