package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IMainPicDao;
import com.upic.po.MainPic;
import com.upic.service.IMainPicService;

@Service("mainPicService")
public class MainPicService implements IMainPicService {
	@Autowired
	private IMainPicDao mainPicDao;

	@Override
	public MainPic getById(long id) {
		return mainPicDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return mainPicDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return mainPicDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<MainPic> listBy(Map<String, Object> paramMap) {
		return mainPicDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return mainPicDao.listBy(paramMap, sqlId);
	}

	@Override
	public MainPic getBy(Map<String, Object> paramMap) {
		return mainPicDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return mainPicDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return mainPicDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(MainPic mainPic) {
		return mainPicDao.insert(mainPic);
	}

	@Override
	public long update(MainPic mainPic) {
		return mainPicDao.update(mainPic);
	}
}
