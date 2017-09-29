package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.DianZanMeituPn;

public interface IDianZanMeituPnService extends BaseService<DianZanMeituPn> {

	long insert(DianZanMeituPn dianZanMeituPn);

	long update(DianZanMeituPn dianZanMeituPn);
}
