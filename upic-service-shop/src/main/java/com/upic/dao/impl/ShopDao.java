package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IShopDao;
import com.upic.po.Shop;

@Repository("shopDao")
public class ShopDao extends BaseDaoImpl<Shop> implements IShopDao {

}
