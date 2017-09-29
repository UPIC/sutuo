package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.KeyWordKW;

public interface IKeyWordKWService extends BaseService<KeyWordKW> {

	long insert(KeyWordKW keyWordKW);

	long update(KeyWordKW keyWordKW);
}
