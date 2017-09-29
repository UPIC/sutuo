package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.ThemetzFirst;

public interface IThemetzFirstService extends BaseService<ThemetzFirst> {

	long insert(ThemetzFirst themetzFirst);

	long update(ThemetzFirst themetzFirst);
}
