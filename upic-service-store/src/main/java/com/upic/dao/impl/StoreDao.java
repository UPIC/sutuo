package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IStoreDao;
import com.upic.po.Store;

@Repository("storeDao")
public class StoreDao extends BaseDaoImpl<Store> implements IStoreDao {

}
