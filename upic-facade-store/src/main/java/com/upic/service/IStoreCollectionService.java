package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.StoreCollection;

public interface IStoreCollectionService extends BaseService<StoreCollection> {

	long insert(StoreCollection storeCollection);

	long update(StoreCollection storeCollection);
}
