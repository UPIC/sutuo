package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IStandardTypeDao;
import com.upic.po.StandardType;

@Repository("standardTypeDao")
public class StandardTypeDao extends BaseDaoImpl<StandardType> implements IStandardTypeDao {

}
