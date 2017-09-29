package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IShopCollectionDao;
import com.upic.po.ShopCollection;

@Repository("shopCollectionDao")
public class ShopCollectionDao extends BaseDaoImpl<ShopCollection> implements IShopCollectionDao {

}
