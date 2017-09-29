package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IShopFarmDao;
import com.upic.po.ShopFarm;

@Repository("shopFarmDao")
public class ShopFarmDao extends BaseDaoImpl<ShopFarm> implements IShopFarmDao {

}
