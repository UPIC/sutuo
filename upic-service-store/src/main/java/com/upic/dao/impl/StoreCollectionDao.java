package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IStoreCollectionDao;
import com.upic.po.StoreCollection;

@Repository("storeCollectionDao")
public class StoreCollectionDao extends BaseDaoImpl<StoreCollection> implements IStoreCollectionDao {

}
