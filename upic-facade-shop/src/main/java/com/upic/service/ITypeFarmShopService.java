package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.TypeFarmShop;

public interface ITypeFarmShopService extends BaseService<TypeFarmShop> {

	long update(TypeFarmShop typeFarmShop);

	long insert(TypeFarmShop typeFarmShop);
}
