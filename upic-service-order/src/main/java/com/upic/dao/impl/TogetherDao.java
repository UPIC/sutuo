package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.ITogetherDao;
import com.upic.po.Together;

@Repository("togetherDao")
public class TogetherDao extends BaseDaoImpl<Together> implements ITogetherDao {

}
