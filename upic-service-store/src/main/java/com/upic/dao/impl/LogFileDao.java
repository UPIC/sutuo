package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.ILogFileDao;
import com.upic.po.LogFile;

@Repository("logFileDao")
public class LogFileDao extends BaseDaoImpl<LogFile> implements ILogFileDao {

}
