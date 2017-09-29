package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IShopSignDao;
import com.upic.po.ShopSign;

@Repository("shopSignDao")
public class ShopSignDao extends BaseDaoImpl<ShopSign> implements IShopSignDao {

}
