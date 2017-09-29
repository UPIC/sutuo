package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.ArticalPn;

public interface IArticalPnService extends BaseService<ArticalPn> {

	long insert(ArticalPn articalPn);

	long update(ArticalPn articalPn);
}
