package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.StandardShop;

public interface IStandardShopService extends BaseService<StandardShop>{

	
	long insert(StandardShop standardShop);

	long update(StandardShop standardShop);
}
