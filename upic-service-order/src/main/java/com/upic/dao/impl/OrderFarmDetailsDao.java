package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IOrderFarmDetailsDao;
import com.upic.po.OrderFarmDetails;

@Repository("orderFarmDetailsDao")
public class OrderFarmDetailsDao extends BaseDaoImpl<OrderFarmDetails> implements IOrderFarmDetailsDao {

}
