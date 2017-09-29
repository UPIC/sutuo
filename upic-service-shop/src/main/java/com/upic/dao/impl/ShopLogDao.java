package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IShopLogDao;
import com.upic.po.ShopLog;

@Repository("shopLogDao")
public class ShopLogDao extends BaseDaoImpl<ShopLog> implements IShopLogDao {

}
