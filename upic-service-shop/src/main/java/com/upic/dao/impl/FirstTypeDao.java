package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IFirstTypeDao;
import com.upic.po.FirstType;

@Repository("firstTypeDao")
public class FirstTypeDao extends BaseDaoImpl<FirstType> implements IFirstTypeDao {

}
