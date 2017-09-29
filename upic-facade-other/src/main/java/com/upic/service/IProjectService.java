package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.Project;

public interface IProjectService extends BaseService<Project> {

	long insert(Project project);

	long update(Project project);
}
