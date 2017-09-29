package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.ThemeArea;

public interface IThemeAreaService extends BaseService<ThemeArea> {

	long insert(ThemeArea themeArea);

	long update(ThemeArea themeArea);
}
