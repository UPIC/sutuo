package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IThemePnDao;
import com.upic.po.ThemePn;

@Repository("themePnDao")
public class ThemePnDao extends BaseDaoImpl<ThemePn> implements IThemePnDao {

}
