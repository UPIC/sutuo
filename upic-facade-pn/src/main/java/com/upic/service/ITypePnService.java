package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.TypePn;

public interface ITypePnService extends BaseService<TypePn> {

	long insert(TypePn typePn);

	long update(TypePn typePn);
}
