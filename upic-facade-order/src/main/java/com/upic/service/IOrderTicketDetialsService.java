package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.OrderTicketDetials;

public interface IOrderTicketDetialsService extends BaseService<OrderTicketDetials> {
	long update(OrderTicketDetials orderTicketDetials);
}
