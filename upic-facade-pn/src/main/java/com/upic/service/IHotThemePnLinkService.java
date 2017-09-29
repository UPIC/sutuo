package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.HotThemePnLink;
import com.upic.po.SignPnLink;

public interface IHotThemePnLinkService extends BaseService<HotThemePnLink> {

	long insert(HotThemePnLink hotThemePnLink);

	long update(HotThemePnLink hotThemePnLink);

	long update(HotThemePnLink shtoThemePnL, String string);

}
