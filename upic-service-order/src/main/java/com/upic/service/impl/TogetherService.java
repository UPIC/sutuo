package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.ITogetherDao;
import com.upic.po.Together;
import com.upic.service.ITogetherService;

@Service("togetherService")
public class TogetherService implements ITogetherService {
	@Autowired
	private ITogetherDao togetherDao;

	@Override
	public Together getById(long id) {
		// TODO Auto-generated method stub
		return togetherDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return togetherDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		// TODO Auto-generated method stub
		return togetherDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<Together> listBy(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return togetherDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		// TODO Auto-generated method stub
		return togetherDao.listBy(paramMap, sqlId);
	}

	@Override
	public Together getBy(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return togetherDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		// TODO Auto-generated method stub
		return togetherDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		// TODO Auto-generated method stub
		return togetherDao.getSeqNextValue(seqName);
	}

	@Override
	public long update(Together together) {
		// TODO Auto-generated method stub
		return togetherDao.update(together);
	}

	@Override
	public long insert(Together together) {
		// TODO Auto-generated method stub
		return togetherDao.insert(together);
	}
}
