package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IProjectShopDao;
import com.upic.po.ProjectShop;
import com.upic.service.IProjectShopService;

@Service("projectShopService")
public class ProjectShopService implements IProjectShopService {
	@Autowired
	private IProjectShopDao projectShopDao;

	@Override
	public ProjectShop getById(long id) {
		return projectShopDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return projectShopDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return projectShopDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<ProjectShop> listBy(Map<String, Object> paramMap) {
		return projectShopDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return projectShopDao.listBy(paramMap, sqlId);
	}

	@Override
	public ProjectShop getBy(Map<String, Object> paramMap) {
		return projectShopDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return projectShopDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return projectShopDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(ProjectShop projectShop) {
		return projectShopDao.insert(projectShop);
	}

	@Override
	public long update(ProjectShop projectShop) {
		return projectShopDao.update(projectShop);
	}
}
