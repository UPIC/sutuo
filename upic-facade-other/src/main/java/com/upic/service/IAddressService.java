package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.Address;

public interface IAddressService extends BaseService<Address> {

	long update(Address address);

	long insert(Address address);
}
