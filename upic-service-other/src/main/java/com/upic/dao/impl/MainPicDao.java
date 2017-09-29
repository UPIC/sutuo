package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IMainPicDao;
import com.upic.po.MainPic;

@Repository("mainPicDao")
public class MainPicDao extends BaseDaoImpl<MainPic> implements IMainPicDao {

}
