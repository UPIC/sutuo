package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.ShopCollection;

public interface IShopCollectionService extends BaseService<ShopCollection> {

	long insert(ShopCollection shopCollection);

	long update(ShopCollection shopCollection);
}
