package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.PicType;

public interface IPicTypeService extends BaseService<PicType> {

	long insert(PicType picType);

	long update(PicType picType);
}
