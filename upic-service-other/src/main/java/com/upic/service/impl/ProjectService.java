package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IProjectDao;
import com.upic.po.Project;
import com.upic.service.IProjectService;

@Service("projectService")
public class ProjectService implements IProjectService {
	@Autowired
	private IProjectDao projectDao;

	@Override
	public Project getById(long id) {
		return projectDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return projectDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return projectDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<Project> listBy(Map<String, Object> paramMap) {
		return projectDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return projectDao.listBy(paramMap, sqlId);
	}

	@Override
	public Project getBy(Map<String, Object> paramMap) {
		return projectDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return projectDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return projectDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(Project project) {
		return projectDao.insert(project);
	}

	@Override
	public long update(Project project) {
		return projectDao.insert(project);
	}
}
