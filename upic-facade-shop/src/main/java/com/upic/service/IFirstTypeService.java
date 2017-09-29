package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.FirstType;

public interface IFirstTypeService extends BaseService<FirstType> {

	long insert(FirstType firstType);

	long update(FirstType firstType);
}
