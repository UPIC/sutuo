package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.ILogFileDao;
import com.upic.po.LogFile;
import com.upic.service.ILogFileService;

@Service("logFileService")
public class LogFileService implements ILogFileService {
	@Autowired
	private ILogFileDao logFileDao;

	@Override
	public LogFile getById(long id) {
		return logFileDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return logFileDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return logFileDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<LogFile> listBy(Map<String, Object> paramMap) {
		return logFileDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return logFileDao.listBy(paramMap, sqlId);
	}

	@Override
	public LogFile getBy(Map<String, Object> paramMap) {
		return logFileDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return logFileDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return logFileDao.getSeqNextValue(seqName);
	}

	@Override
	public long update(LogFile logFile) {
		return logFileDao.update(logFile);
	}

	@Override
	public long insert(LogFile logFile) {
		return logFileDao.insert(logFile);
	}
}
