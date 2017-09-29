package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.PingLunWenZhangPn;

public interface IPingLunWenZhangPnService extends BaseService<PingLunWenZhangPn> {

	long insert(PingLunWenZhangPn pingLunWenZhangPn);

	long update(PingLunWenZhangPn pingLunWenZhangPn);
}
