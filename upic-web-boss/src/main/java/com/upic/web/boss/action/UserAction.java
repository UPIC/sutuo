package com.upic.web.boss.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.upic.po.User;
import com.upic.service.IUserService;

import wusc.edu.pay.web.boss.base.BossBaseAction;
import wusc.edu.pay.web.permission.entity.PmsOperator;
import wusc.edu.pay.web.permission.enums.OperatorTypeEnum;
import wusc.edu.pay.web.permission.enums.RoleTypeEnum;

public class UserAction extends BossBaseAction implements ModelDriven<User> {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(UserAction.class);
	private User user;
	@Autowired
	private IUserService userService;
	
	/**
	 * 查看所有商品
	 * 
	 * @return
	 */
	public String listUserList() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("openId", user.getOpenId()); //openID
			paramMap.put("sex", user.getSex()); //性别
			paramMap.put("orderDateBegin", user.getOrderDateBegin());//注册开始
			paramMap.put("orderDateEnd", user.getOrderDateEnd());//注册结束
			
			paramMap.put("userLoginDateBegin", user.getUserLoginDateBegin());
			paramMap.put("userLoginDateEnd", user.getUserLoginDateEnd());
			
			super.pageBean = userService.listPage(getPageParam(), paramMap);
			PmsOperator operator = this.getLoginedOperator();
			super.pushData(operator);
			super.pushData(pageBean);
			// 回显查询条件值
			super.pushData(paramMap);

			super.putData("RoleTypeEnumList", RoleTypeEnum.values());
			super.putData("user", user);
			super.putData("RoleTypeEnum", RoleTypeEnum.toMap());
			super.putData("OperatorTypeEnum", OperatorTypeEnum.toMap());
			return "userActionList";
		} catch (Exception e) {
			log.error("== listBrowseRecords exception:", e);
			return operateError("获取数据失败");
		}
	}
	@Override
	public User getModel() {
		if (user == null) {
			user = new User();
		}
		return user;
	}

}
