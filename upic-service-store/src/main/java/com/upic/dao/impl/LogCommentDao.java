package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.ILogCommentDao;
import com.upic.po.LogComment;

@Repository("logCommentPicDao")
public class LogCommentDao extends BaseDaoImpl<LogComment> implements ILogCommentDao {

}
