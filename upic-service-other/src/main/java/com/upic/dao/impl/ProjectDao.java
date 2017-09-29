package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IProjectDao;
import com.upic.po.Project;

@Repository("projectDao")
public class ProjectDao extends BaseDaoImpl<Project> implements IProjectDao {

}
