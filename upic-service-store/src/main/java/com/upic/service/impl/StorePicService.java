package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IStorePicDao;
import com.upic.po.StorePic;
import com.upic.service.IStorePicService;

@Service("storePicService")
public class StorePicService implements IStorePicService {
	@Autowired
	private IStorePicDao storePicDao;

	@Override
	public StorePic getById(long id) {
		return storePicDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return storePicDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return storePicDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<StorePic> listBy(Map<String, Object> paramMap) {
		return storePicDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return storePicDao.listBy(paramMap, sqlId);
	}

	@Override
	public StorePic getBy(Map<String, Object> paramMap) {
		return storePicDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return storePicDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return storePicDao.getSeqNextValue(seqName);
	}
}
