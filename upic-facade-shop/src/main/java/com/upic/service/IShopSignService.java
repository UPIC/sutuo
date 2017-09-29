package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.ShopSign;

public interface IShopSignService extends BaseService<ShopSign> {

	long insert(ShopSign shopSign);

	long update(ShopSign shopSign);
}
