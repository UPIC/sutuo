package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.Access;

public interface IAccessService extends BaseService<Access> {

	long insert(Access a);
}
