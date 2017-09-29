package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.ISignPnDao;
import com.upic.po.SignPn;

@Repository("signPnDao")
public class SignPnDao extends BaseDaoImpl<SignPn> implements ISignPnDao {

}
