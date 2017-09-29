package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IStoreSignDao;
import com.upic.po.StoreSign;

@Repository("storeSignDao")
public class StoreSignDao extends BaseDaoImpl<StoreSign> implements IStoreSignDao {

}
