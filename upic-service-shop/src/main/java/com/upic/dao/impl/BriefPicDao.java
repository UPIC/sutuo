package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IBriefPicDao;
import com.upic.po.BriefPic;

@Repository("briefPicDao")
public class BriefPicDao extends BaseDaoImpl<BriefPic> implements IBriefPicDao {

}
