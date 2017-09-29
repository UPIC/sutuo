package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IProvinceDao;
import com.upic.po.Province;
import com.upic.service.IProvinceService;

@Service("provinceService")
public class ProvinceService implements IProvinceService {
	@Autowired
	private IProvinceDao provinceDao;

	@Override
	public Province getById(long id) {
		return provinceDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return provinceDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return provinceDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<Province> listBy(Map<String, Object> paramMap) {
		return provinceDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return provinceDao.listBy(paramMap, sqlId);
	}

	@Override
	public Province getBy(Map<String, Object> paramMap) {
		return provinceDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return provinceDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return provinceDao.getSeqNextValue(seqName);
	}

	@Override
	public long update(Province o) {
		return provinceDao.update(o);
	}
}
