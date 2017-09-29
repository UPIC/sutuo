package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.ICommentPicDao;
import com.upic.po.CommentPic;

@Repository("commentPicDao")
public class CommentPicDao extends BaseDaoImpl<CommentPic> implements ICommentPicDao {

}
