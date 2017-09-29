package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IOrderTicketDetialsDao;
import com.upic.po.OrderTicketDetials;

@Repository("orderTicketDetialsDao")
public class OrderTicketDetialsDao extends BaseDaoImpl<OrderTicketDetials> implements IOrderTicketDetialsDao {

}
