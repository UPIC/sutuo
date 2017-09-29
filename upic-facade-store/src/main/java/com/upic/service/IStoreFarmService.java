package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.StoreFarm;

public interface IStoreFarmService extends BaseService<StoreFarm> {

	long update(StoreFarm storeFarm);

	long insert(StoreFarm storeFarm);
}
