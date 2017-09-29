package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IProvinceDao;
import com.upic.po.Province;

@Repository("provinceDao")
public class ProvinceDao extends BaseDaoImpl<Province> implements IProvinceDao {

}
