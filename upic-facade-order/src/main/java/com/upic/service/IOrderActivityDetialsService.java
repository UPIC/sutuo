package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.OrderActivityDetials;

public interface IOrderActivityDetialsService extends BaseService<OrderActivityDetials> {
	long update(OrderActivityDetials orderActivityDetials);
}
