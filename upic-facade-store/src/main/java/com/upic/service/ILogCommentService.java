package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.LogComment;

public interface ILogCommentService extends BaseService<LogComment> {

	long insert(LogComment c);
}
