package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IShopThemeDao;
import com.upic.po.ShopTheme;

@Repository("shopThemeDao")
public class ShopThemeDao extends BaseDaoImpl<ShopTheme> implements IShopThemeDao {

}
