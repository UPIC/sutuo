package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.MainPic;

public interface IMainPicService extends BaseService<MainPic> {

	long insert(MainPic mainPic);

	long update(MainPic mainPic);
}
