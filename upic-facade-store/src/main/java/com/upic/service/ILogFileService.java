package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.LogFile;

public interface ILogFileService extends BaseService<LogFile> {
	
	long insert(LogFile logFile);

	long update(LogFile logFile);
}
