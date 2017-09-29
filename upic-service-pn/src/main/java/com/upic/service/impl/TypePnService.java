package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.ITypePnDao;
import com.upic.po.TypePn;
import com.upic.service.ITypePnService;

@Service("typePnService")
public class TypePnService implements ITypePnService {
	@Autowired
	private ITypePnDao typePnDao;

	@Override
	public TypePn getById(long id) {
		return typePnDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return typePnDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return typePnDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<TypePn> listBy(Map<String, Object> paramMap) {
		return typePnDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return typePnDao.listBy(paramMap, sqlId);
	}

	@Override
	public TypePn getBy(Map<String, Object> paramMap) {
		return typePnDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return typePnDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return typePnDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(TypePn picType) {
		return typePnDao.insert(picType);
	}

	@Override
	public long update(TypePn picType) {
		return typePnDao.update(picType);
	}
}
