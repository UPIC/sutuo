package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IUserDao;
import com.upic.po.User;

@Repository("userDao")
public class UserDao extends BaseDaoImpl<User> implements IUserDao {

}
