package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IShopActivityDao;
import com.upic.po.ShopActivity;

@Repository("shopActivityDao")
public class ShopActivityDao extends BaseDaoImpl<ShopActivity> implements IShopActivityDao {

}
