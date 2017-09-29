package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.HotThemePn;

public interface IHotThemePnService extends BaseService<HotThemePn> {

	long insert(HotThemePn hotThemePn);

	long update(HotThemePn hotThemePn);
}
