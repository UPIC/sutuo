package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.ShopPic;

public interface IShopPicService extends BaseService<ShopPic> {
	long insert(ShopPic shopPic);
	
	long update(ShopPic shopPic);
}
