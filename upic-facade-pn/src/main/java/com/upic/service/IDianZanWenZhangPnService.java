package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.DianZanWenZhangPn;

public interface IDianZanWenZhangPnService extends BaseService<DianZanWenZhangPn> {

	long insert(DianZanWenZhangPn dianZanWenZhangPn);

	long update(DianZanWenZhangPn dianZanWenZhangPn);
}
