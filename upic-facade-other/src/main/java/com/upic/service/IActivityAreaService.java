package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.ActivityArea;

public interface IActivityAreaService extends BaseService<ActivityArea> {

	long insert(ActivityArea activityArea);

	long update(ActivityArea activityArea);
}
