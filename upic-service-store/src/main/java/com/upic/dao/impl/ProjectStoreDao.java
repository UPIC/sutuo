package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IProjectStoreDao;
import com.upic.po.ProjectStore;

@Repository("projectStoreDao")
public class ProjectStoreDao extends BaseDaoImpl<ProjectStore> implements IProjectStoreDao {

}
