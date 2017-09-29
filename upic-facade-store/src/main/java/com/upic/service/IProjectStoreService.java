package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.ProjectStore;

public interface IProjectStoreService extends BaseService<ProjectStore> {

	long insert(ProjectStore projectStore);

	long update(ProjectStore projectStore);
}
