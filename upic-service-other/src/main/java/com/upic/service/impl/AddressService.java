package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IAddressDao;
import com.upic.po.Address;
import com.upic.service.IAddressService;

@Service("addressService")
public class AddressService implements IAddressService {
	@Autowired
	private IAddressDao addressDao;

	@Override
	public Address getById(long id) {
		return addressDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return addressDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return addressDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<Address> listBy(Map<String, Object> paramMap) {
		return addressDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return addressDao.listBy(paramMap, sqlId);
	}

	@Override
	public Address getBy(Map<String, Object> paramMap) {
		return addressDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return addressDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return addressDao.getSeqNextValue(seqName);
	}

	@Override
	public long update(Address address) {
		return addressDao.update(address);
	}

	@Override
	public long insert(Address address) {
		return addressDao.insert(address);
	}
}
