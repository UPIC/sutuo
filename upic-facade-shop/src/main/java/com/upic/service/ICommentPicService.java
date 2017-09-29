package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.CommentPic;

public interface ICommentPicService extends BaseService<CommentPic> {

	long insert(CommentPic c);

	long update(CommentPic commentPic);
}
