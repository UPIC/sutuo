package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IPicTypeDao;
import com.upic.po.PicType;

@Repository("picTypeDao")
public class PicTypeDao extends BaseDaoImpl<PicType> implements IPicTypeDao {

}
