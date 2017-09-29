package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.CityWithoutQu;

public interface ICityWithoutQuService extends BaseService<CityWithoutQu> {

	long insert(CityWithoutQu cityWithoutQu);

	long update(CityWithoutQu cityWithoutQu);
}
