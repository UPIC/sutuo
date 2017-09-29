package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.ProjectShop;

public interface IProjectShopService extends BaseService<ProjectShop> {

	long insert(ProjectShop projectShop);

	long update(ProjectShop projectShop);
}
