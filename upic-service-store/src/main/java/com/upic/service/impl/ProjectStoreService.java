package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IProjectStoreDao;
import com.upic.po.ProjectStore;
import com.upic.service.IProjectStoreService;

@Service("projectStoreService")
public class ProjectStoreService implements IProjectStoreService {
	@Autowired
	private IProjectStoreDao projectStoreDao;

	@Override
	public ProjectStore getById(long id) {
		return projectStoreDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return projectStoreDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return projectStoreDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<ProjectStore> listBy(Map<String, Object> paramMap) {
		return projectStoreDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return projectStoreDao.listBy(paramMap, sqlId);
	}

	@Override
	public ProjectStore getBy(Map<String, Object> paramMap) {
		return projectStoreDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return projectStoreDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return projectStoreDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(ProjectStore projectStore) {
		return projectStoreDao.insert(projectStore);
	}

	@Override
	public long update(ProjectStore projectStore) {
		return projectStoreDao.update(projectStore);
	}
}
