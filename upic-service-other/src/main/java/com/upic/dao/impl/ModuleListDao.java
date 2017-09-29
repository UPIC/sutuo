package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IModuleListDao;
import com.upic.po.ModuleList;

@Repository("moduleListDao")
public class ModuleListDao extends BaseDaoImpl<ModuleList> implements IModuleListDao {

}
