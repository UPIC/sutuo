package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.ICommentPicDao;
import com.upic.po.CommentPic;
import com.upic.service.ICommentPicService;

@Service("commentPicService")
public class CommentPicService implements ICommentPicService {
	@Autowired
	private ICommentPicDao commentPicDao;

	@Override
	public CommentPic getById(long id) {
		return commentPicDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return commentPicDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return commentPicDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<CommentPic> listBy(Map<String, Object> paramMap) {
		return commentPicDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return commentPicDao.listBy(paramMap, sqlId);
	}

	@Override
	public CommentPic getBy(Map<String, Object> paramMap) {
		return commentPicDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return commentPicDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return commentPicDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(CommentPic commentPic) {
		return commentPicDao.insert(commentPic);
	}

	@Override
	public long update(CommentPic commentPic) {
		return commentPicDao.update(commentPic);
	}
}
