package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.OrderDetials;

public interface IOrderDetialsService extends BaseService<OrderDetials> {
	long update(OrderDetials orderDetials);
}
