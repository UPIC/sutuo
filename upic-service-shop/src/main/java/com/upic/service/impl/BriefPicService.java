package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IBriefPicDao;
import com.upic.po.BriefPic;
import com.upic.service.IBriefPicService;

@Service("briefPicService")
public class BriefPicService implements IBriefPicService {
	@Autowired
	private IBriefPicDao briefPicDao;

	@Override
	public BriefPic getById(long id) {
		return briefPicDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return briefPicDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return briefPicDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<BriefPic> listBy(Map<String, Object> paramMap) {
		return briefPicDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return briefPicDao.listBy(paramMap, sqlId);
	}

	@Override
	public BriefPic getBy(Map<String, Object> paramMap) {
		return briefPicDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return briefPicDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return briefPicDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(BriefPic briefPic) {
		return briefPicDao.insert(briefPic);
	}

	@Override
	public long update(BriefPic briefPic) {
		return briefPicDao.update(briefPic);
	}
}
