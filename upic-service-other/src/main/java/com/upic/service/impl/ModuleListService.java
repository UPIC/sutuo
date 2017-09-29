package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IModuleListDao;
import com.upic.po.ModuleList;
import com.upic.service.IModuleListService;

@Service("moduleListService")
public class ModuleListService implements IModuleListService {
	@Autowired
	private IModuleListDao moduleListDao;

	@Override
	public ModuleList getById(long id) {
		return moduleListDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return moduleListDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return moduleListDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<ModuleList> listBy(Map<String, Object> paramMap) {
		return moduleListDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return moduleListDao.listBy(paramMap, sqlId);
	}

	@Override
	public ModuleList getBy(Map<String, Object> paramMap) {
		return moduleListDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return moduleListDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return moduleListDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(ModuleList moduleList) {
		return moduleListDao.insert(moduleList);
	}

	@Override
	public long update(ModuleList moduleList) {
		return moduleListDao.update(moduleList);
	}
}
