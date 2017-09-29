package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IStandardDao;
import com.upic.po.Standard;

@Repository("standardDao")
public class StandardDao extends BaseDaoImpl<Standard> implements IStandardDao {

}
