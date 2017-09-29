package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.ThemetzShop;

public interface IThemetzShopService extends BaseService<ThemetzShop> {

	long insert(ThemetzShop themetzShop);

	long update(ThemetzShop themetzShop);
}
