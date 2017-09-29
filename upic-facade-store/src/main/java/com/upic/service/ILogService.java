package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.Log;

public interface ILogService extends BaseService<Log> {
	long insert(Log log);

	long update(Log log);
}
