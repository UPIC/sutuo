package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.TypeShopFarm;

public interface ITypeShopFarmService extends BaseService<TypeShopFarm> {

	long update(TypeShopFarm typeShopFarm);

	long insert(TypeShopFarm typeShopFarm);
}
