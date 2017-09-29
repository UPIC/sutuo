package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IOrderDetialsDao;
import com.upic.po.OrderDetials;

@Repository("orderDetialsDao")
public class OrderDetialsDao extends BaseDaoImpl<OrderDetials> implements IOrderDetialsDao {

}
