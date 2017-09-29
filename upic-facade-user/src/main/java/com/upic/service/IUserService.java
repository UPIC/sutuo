package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.User;

public interface IUserService extends BaseService<User> {

	long insert(User u);
}
