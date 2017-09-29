package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IThemetzDao;
import com.upic.po.Themetz;

@Repository("themetzDao")
public class ThemetzDao extends BaseDaoImpl<Themetz> implements IThemetzDao {

}
