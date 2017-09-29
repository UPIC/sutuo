package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IActivityAreaDao;
import com.upic.po.ActivityArea;
import com.upic.service.IActivityAreaService;

@Service("activityAreaService")
public class ActivityAreaService implements IActivityAreaService {
	@Autowired
	private IActivityAreaDao activityAreaDao;

	@Override
	public ActivityArea getById(long id) {
		return activityAreaDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return activityAreaDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return activityAreaDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<ActivityArea> listBy(Map<String, Object> paramMap) {
		return activityAreaDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return activityAreaDao.listBy(paramMap, sqlId);
	}

	@Override
	public ActivityArea getBy(Map<String, Object> paramMap) {
		return activityAreaDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return activityAreaDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return activityAreaDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(ActivityArea activityArea) {
		return activityAreaDao.insert(activityArea);
	}

	@Override
	public long update(ActivityArea activityArea) {
		return activityAreaDao.update(activityArea);
	}
}
