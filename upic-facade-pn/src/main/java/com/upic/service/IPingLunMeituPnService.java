package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.PingLunMeituPn;

public interface IPingLunMeituPnService extends BaseService<PingLunMeituPn> {

	long insert(PingLunMeituPn pingLunMeituPn);

	long update(PingLunMeituPn pingLunMeituPn);
}
