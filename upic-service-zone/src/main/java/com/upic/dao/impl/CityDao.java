package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.ICityDao;
import com.upic.po.City;

@Repository("cityDao")
public class CityDao extends BaseDaoImpl<City> implements ICityDao {

}
