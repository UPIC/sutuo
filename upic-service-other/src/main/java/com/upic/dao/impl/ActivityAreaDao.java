package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IActivityAreaDao;
import com.upic.po.ActivityArea;

@Repository("activityAreaDao")
public class ActivityAreaDao extends BaseDaoImpl<ActivityArea> implements IActivityAreaDao {

}
