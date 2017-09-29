package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.ShopTicket;

public interface IShopTicketService extends BaseService<ShopTicket> {

	long insert(ShopTicket shopTicket);

	long update(ShopTicket shopTicket);
}
