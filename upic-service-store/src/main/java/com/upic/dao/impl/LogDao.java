package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.ILogDao;
import com.upic.po.Log;

@Repository("logDao")
public class LogDao extends BaseDaoImpl<Log> implements ILogDao {

}
