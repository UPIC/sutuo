package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IAddressDao;
import com.upic.po.Address;

@Repository("addressDao")
public class AddressDao extends BaseDaoImpl<Address> implements IAddressDao {

}
