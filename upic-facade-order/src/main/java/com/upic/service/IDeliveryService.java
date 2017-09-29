package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.Delivery;

public interface IDeliveryService extends BaseService<Delivery> {

	long update(Delivery delivery);
}
