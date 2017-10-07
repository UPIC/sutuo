package com.upic.service;

import java.util.Map;

import com.upic.common.core.service.BaseService;
import com.upic.po.Order;

public interface IOrderService extends BaseService<Order> {

	long update(Order o);

	long insert(Order o);


}
