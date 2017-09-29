package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.ShopType;

public interface IShopTypeService extends BaseService<ShopType> {

	long insert(ShopType shopType);

	long update(ShopType shopType);
}
