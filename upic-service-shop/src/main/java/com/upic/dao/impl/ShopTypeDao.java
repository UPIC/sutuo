package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IShopTypeDao;
import com.upic.po.ShopType;

@Repository("shopTypeDao")
public class ShopTypeDao extends BaseDaoImpl<ShopType> implements IShopTypeDao {

}
