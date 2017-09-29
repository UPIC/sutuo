package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IDistrictDao;
import com.upic.po.District;
import com.upic.service.IDistrictService;

@Service("districtService")
public class DistrictService implements IDistrictService {
	@Autowired
	private IDistrictDao districtDao;

	@Override
	public District getById(long id) {
		return districtDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return districtDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return districtDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<District> listBy(Map<String, Object> paramMap) {
		return districtDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return districtDao.listBy(paramMap, sqlId);
	}

	@Override
	public District getBy(Map<String, Object> paramMap) {
		return districtDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return districtDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return districtDao.getSeqNextValue(seqName);
	}

	@Override
	public long update(District o) {
		return districtDao.update(o);
	}
}
