package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IPicLogDao;
import com.upic.po.PicLog;

@Repository("picLogDao")
public class PicLogDao extends BaseDaoImpl<PicLog> implements IPicLogDao {

}
