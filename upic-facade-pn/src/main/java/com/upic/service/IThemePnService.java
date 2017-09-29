package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.ThemePn;

public interface IThemePnService extends BaseService<ThemePn> {

	long insert(ThemePn themePn);

	long update(ThemePn themePn);
}
