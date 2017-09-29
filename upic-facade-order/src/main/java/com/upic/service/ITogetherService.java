package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.Together;

public interface ITogetherService extends BaseService<Together> {

	long update(Together together);
	
	long insert(Together together);
}
