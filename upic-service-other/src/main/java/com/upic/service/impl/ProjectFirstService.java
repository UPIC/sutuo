package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IProjectFirstDao;
import com.upic.po.ProjectFirst;
import com.upic.service.IProjectFirstService;

@Service("projectFirstService")
public class ProjectFirstService implements IProjectFirstService {
	@Autowired
	private IProjectFirstDao projectFirstDao;

	@Override
	public ProjectFirst getById(long id) {
		return projectFirstDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return projectFirstDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return projectFirstDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<ProjectFirst> listBy(Map<String, Object> paramMap) {
		return projectFirstDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return projectFirstDao.listBy(paramMap, sqlId);
	}

	@Override
	public ProjectFirst getBy(Map<String, Object> paramMap) {
		return projectFirstDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return projectFirstDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return projectFirstDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(ProjectFirst projectFirst) {
		return projectFirstDao.insert(projectFirst);
	}

	@Override
	public long update(ProjectFirst projectFirst) {
		return projectFirstDao.update(projectFirst);
	}
}
