package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IPicTypeDao;
import com.upic.po.PicType;
import com.upic.service.IPicTypeService;

@Service("picTypeService")
public class PicTypeService implements IPicTypeService {
	@Autowired
	private IPicTypeDao picTypeDao;

	@Override
	public PicType getById(long id) {
		return picTypeDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return picTypeDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return picTypeDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<PicType> listBy(Map<String, Object> paramMap) {
		return picTypeDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return picTypeDao.listBy(paramMap, sqlId);
	}

	@Override
	public PicType getBy(Map<String, Object> paramMap) {
		return picTypeDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return picTypeDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return picTypeDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(PicType picType) {
		return picTypeDao.insert(picType);
	}

	@Override
	public long update(PicType picType) {
		return picTypeDao.update(picType);
	}
}
