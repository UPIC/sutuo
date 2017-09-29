package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IDeliveryDao;
import com.upic.po.Delivery;

@Repository("deliveryDao")
public class DeliveryDao extends BaseDaoImpl<Delivery> implements IDeliveryDao {

}
