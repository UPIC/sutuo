package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IOrderDao;
import com.upic.po.Order;

@Repository("orderDao")
public class OrderDao extends BaseDaoImpl<Order> implements IOrderDao {

}
