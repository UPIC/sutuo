package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.City;

public interface ICityService extends BaseService<City>{

	long update(City o);

}
