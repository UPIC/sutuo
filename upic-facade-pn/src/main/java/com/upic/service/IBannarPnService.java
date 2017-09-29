package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.BannarPn;

public interface IBannarPnService extends BaseService<BannarPn> {

	long insert(BannarPn bannarPn);

	long update(BannarPn bannarPn);
}
