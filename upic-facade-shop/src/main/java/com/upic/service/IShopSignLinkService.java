package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.ShopSignLink;

public interface IShopSignLinkService extends BaseService<ShopSignLink> {

	long insert(ShopSignLink shopSignLink);

	long update(ShopSignLink shopSignLink);
}
