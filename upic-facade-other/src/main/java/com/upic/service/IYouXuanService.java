package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.YouXuan;

public interface IYouXuanService extends BaseService<YouXuan> {

	long insert(YouXuan youXuan);

	long update(YouXuan youXuan);
}
