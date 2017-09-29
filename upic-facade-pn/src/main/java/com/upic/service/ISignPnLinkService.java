package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.SignPnLink;

public interface ISignPnLinkService extends BaseService<SignPnLink>{

	
	long insert(SignPnLink signPnLink);

	long update(SignPnLink signPnLink);


	long update(SignPnLink SignPnLink, String method);
}
