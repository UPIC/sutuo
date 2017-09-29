package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.BriefPic;

public interface IBriefPicService extends BaseService<BriefPic> {
	long insert(BriefPic briefPic);
	
	long update(BriefPic briefPic);
}
