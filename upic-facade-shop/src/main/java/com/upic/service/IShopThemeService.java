package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.ShopTheme;

public interface IShopThemeService extends BaseService<ShopTheme> {

	long insert(ShopTheme shopTheme);

	long update(ShopTheme shopTheme);
}
