package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.ICityDao;
import com.upic.po.City;
import com.upic.service.ICityService;

@Service("cityService")
public class CityService implements ICityService {
	@Autowired
	private ICityDao cityDao;

	@Override
	public City getById(long id) {
		return cityDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return cityDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return cityDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<City> listBy(Map<String, Object> paramMap) {
		return cityDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return cityDao.listBy(paramMap, sqlId);
	}

	@Override
	public City getBy(Map<String, Object> paramMap) {
		return cityDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return cityDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return cityDao.getSeqNextValue(seqName);
	}

	@Override
	public long update(City o) {
		return cityDao.update(o);
	}
}
