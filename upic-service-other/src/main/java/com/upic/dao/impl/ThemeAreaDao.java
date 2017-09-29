package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IThemeAreaDao;
import com.upic.po.ThemeArea;

@Repository("themeAreaDao")
public class ThemeAreaDao extends BaseDaoImpl<ThemeArea> implements IThemeAreaDao {

}
