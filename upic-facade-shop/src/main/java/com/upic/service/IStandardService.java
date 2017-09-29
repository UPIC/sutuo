package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.Standard;

public interface IStandardService extends BaseService<Standard> {

	long insert(Standard standard);

	long update(Standard standard);
}
