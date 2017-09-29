package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IStoreFarmDao;
import com.upic.po.StoreFarm;

@Repository("storeFarmDao")
public class StoreFarmDao extends BaseDaoImpl<StoreFarm> implements IStoreFarmDao {

}
