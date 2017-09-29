package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IUserDao;
import com.upic.po.User;
import com.upic.service.IUserService;

@Service("userService")
public class UserService implements IUserService {
	@Autowired
	private IUserDao userDao;

	@Override
	public User getById(long id) {
		return userDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return userDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return userDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<User> listBy(Map<String, Object> paramMap) {
		return userDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return userDao.listBy(paramMap, sqlId);
	}

	@Override
	public User getBy(Map<String, Object> paramMap) {
		return userDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return userDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return userDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(User u) {
		return userDao.insert(u);
	}
}
