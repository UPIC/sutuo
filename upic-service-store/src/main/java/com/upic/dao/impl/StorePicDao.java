package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IStorePicDao;
import com.upic.po.StorePic;

@Repository("storePicDao")
public class StorePicDao extends BaseDaoImpl<StorePic> implements IStorePicDao {

}
