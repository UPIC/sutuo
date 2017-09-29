package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.ILogDao;
import com.upic.po.Log;
import com.upic.service.ILogService;

@Service("logService")
public class LogService implements ILogService {
	@Autowired
	private ILogDao logDao;

	@Override
	public Log getById(long id) {
		return logDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return logDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return logDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<Log> listBy(Map<String, Object> paramMap) {
		return logDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return logDao.listBy(paramMap, sqlId);
	}

	@Override
	public Log getBy(Map<String, Object> paramMap) {
		return logDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return logDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return logDao.getSeqNextValue(seqName);
	}

	@Override
	public long update(Log log) {
		return logDao.update(log);
	}

	@Override
	public long insert(Log log) {
		return logDao.insert(log);
	}
}
