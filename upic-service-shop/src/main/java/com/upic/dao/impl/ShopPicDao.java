package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IShopPicDao;
import com.upic.po.ShopPic;

@Repository("shopPicDao")
public class ShopPicDao extends BaseDaoImpl<ShopPic> implements IShopPicDao {

}
