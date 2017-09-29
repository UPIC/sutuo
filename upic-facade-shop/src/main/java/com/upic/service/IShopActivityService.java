package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.ShopActivity;

public interface IShopActivityService extends BaseService<ShopActivity> {

	long insert(ShopActivity shopActivity);

	long update(ShopActivity shopActivity);
}
