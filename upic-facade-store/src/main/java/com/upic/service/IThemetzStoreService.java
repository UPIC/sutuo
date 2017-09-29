package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.ThemetzStore;

public interface IThemetzStoreService extends BaseService<ThemetzStore> {

	long insert(ThemetzStore themetzStore);

	long update(ThemetzStore themetzStore);
}
