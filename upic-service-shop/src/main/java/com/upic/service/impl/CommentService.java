package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.ICommentDao;
import com.upic.po.Comment;
import com.upic.service.ICommentService;

@Service("commentService")
public class CommentService implements ICommentService {
	@Autowired
	private ICommentDao commentDao;

	@Override
	public Comment getById(long id) {
		return commentDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return commentDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return commentDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<Comment> listBy(Map<String, Object> paramMap) {
		return commentDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return commentDao.listBy(paramMap, sqlId);
	}

	@Override
	public Comment getBy(Map<String, Object> paramMap) {
		return commentDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return commentDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return commentDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(Comment c) {
		return commentDao.insert(c);
	}
}
