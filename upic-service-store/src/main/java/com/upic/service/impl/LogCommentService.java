package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.ILogCommentDao;
import com.upic.po.LogComment;
import com.upic.service.ILogCommentService;

@Service("logCommentService")
public class LogCommentService implements ILogCommentService {
	@Autowired
	private ILogCommentDao logCommentDao;

	@Override
	public LogComment getById(long id) {
		return logCommentDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return logCommentDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return logCommentDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<LogComment> listBy(Map<String, Object> paramMap) {
		return logCommentDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return logCommentDao.listBy(paramMap, sqlId);
	}

	@Override
	public LogComment getBy(Map<String, Object> paramMap) {
		return logCommentDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return logCommentDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return logCommentDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(LogComment c) {
		return logCommentDao.insert(c);
	}
}
