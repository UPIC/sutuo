package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.Shop;

public interface IShopService extends BaseService<Shop> {

	long insert(Shop shop);

	long update(Shop shop);
}
