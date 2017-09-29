package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.Store;

public interface IStoreService extends BaseService<Store> {
	
	long insert(Store s);

	long update(Store s);
}
