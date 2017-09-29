package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.SignPn;

public interface ISignPnService extends BaseService<SignPn> {

	long insert(SignPn signPn);

	long update(SignPn signPn);
}
