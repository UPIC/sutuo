package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.Themetz;

public interface IThemetzService extends BaseService<Themetz> {

	long insert(Themetz themetz);

	long update(Themetz themetz);
}
