package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.ProjectFirst;

public interface IProjectFirstService extends BaseService<ProjectFirst> {

	long insert(ProjectFirst projectFirst);

	long update(ProjectFirst projectFirst);
}
