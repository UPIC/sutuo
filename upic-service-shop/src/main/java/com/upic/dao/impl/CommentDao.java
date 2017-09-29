package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.ICommentDao;
import com.upic.po.Comment;

@Repository("commentDao")
public class CommentDao extends BaseDaoImpl<Comment> implements ICommentDao {

}
