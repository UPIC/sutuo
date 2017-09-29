package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.StandardType;

public interface IStandardTypeService extends BaseService<StandardType> {

	long insert(StandardType standardType);

	long update(StandardType standardType);
}
