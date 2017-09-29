package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IShopTicketDao;
import com.upic.po.ShopTicket;

@Repository("shopTicketDao")
public class ShopTicketDao extends BaseDaoImpl<ShopTicket> implements IShopTicketDao {

}
