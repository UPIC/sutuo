package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.ICityWithoutQuDao;
import com.upic.po.CityWithoutQu;
import com.upic.service.ICityWithoutQuService;

@Service("cityWithoutQuService")
public class CityWithoutQuService implements ICityWithoutQuService {
	@Autowired
	private ICityWithoutQuDao cityWithoutQuDao;

	@Override
	public CityWithoutQu getById(long id) {
		return cityWithoutQuDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return cityWithoutQuDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return cityWithoutQuDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<CityWithoutQu> listBy(Map<String, Object> paramMap) {
		return cityWithoutQuDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return cityWithoutQuDao.listBy(paramMap, sqlId);
	}

	@Override
	public CityWithoutQu getBy(Map<String, Object> paramMap) {
		return cityWithoutQuDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return cityWithoutQuDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return cityWithoutQuDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(CityWithoutQu cityWithoutQu) {
		return cityWithoutQuDao.insert(cityWithoutQu);
	}

	@Override
	public long update(CityWithoutQu cityWithoutQu) {
		return cityWithoutQuDao.update(cityWithoutQu);
	}
}
