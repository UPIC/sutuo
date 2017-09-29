package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.MeituPn;

public interface IMeituPnService extends BaseService<MeituPn> {

	long insert(MeituPn meituPn);

	long update(MeituPn meituPn);
}
