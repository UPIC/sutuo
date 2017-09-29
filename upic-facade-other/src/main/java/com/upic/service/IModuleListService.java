package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.ModuleList;

public interface IModuleListService extends BaseService<ModuleList> {

	long insert(ModuleList moduleList);

	long update(ModuleList moduleList);
}
