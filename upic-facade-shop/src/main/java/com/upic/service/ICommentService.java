package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.Comment;

public interface ICommentService extends BaseService<Comment> {

	long insert(Comment c);
}
