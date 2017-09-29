package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.ThemePnB;

public interface IThemePnBService extends BaseService<ThemePnB> {

	long insert(ThemePnB themePnB);

	long update(ThemePnB themePnB);
}
