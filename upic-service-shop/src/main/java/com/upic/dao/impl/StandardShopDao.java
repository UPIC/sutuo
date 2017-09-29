package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IStandardShopDao;
import com.upic.po.StandardShop;
@Repository("standardShopDao")
public class StandardShopDao extends BaseDaoImpl<StandardShop> implements IStandardShopDao {

}
