package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.ShopLog;

public interface IShopLogService extends BaseService<ShopLog> {

	long insert(ShopLog shopLog);

	long update(ShopLog shopLog);
}
