package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.BrowseRecords;

public interface IBrowseRecordsService extends BaseService<BrowseRecords> {
	long insert(BrowseRecords address);
}
