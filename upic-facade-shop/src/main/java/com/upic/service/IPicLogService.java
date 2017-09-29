package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.PicLog;

public interface IPicLogService extends BaseService<PicLog> {

	long insert(PicLog picLog);

	long update(PicLog picLog);
}
