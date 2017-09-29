package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IAccessDao;
import com.upic.po.Access;

@Repository("accessDao")
public class AccessDao extends BaseDaoImpl<Access> implements IAccessDao {

}
