package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.ShopFarm;

public interface IShopFarmService extends BaseService<ShopFarm> {

	long insert(ShopFarm shopFarm);

	long update(ShopFarm ShopFarm);
}
