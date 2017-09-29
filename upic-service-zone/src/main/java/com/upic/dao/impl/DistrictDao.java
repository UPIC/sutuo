package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IDistrictDao;
import com.upic.po.District;

@Repository("district")
public class DistrictDao extends BaseDaoImpl<District> implements IDistrictDao {

}
