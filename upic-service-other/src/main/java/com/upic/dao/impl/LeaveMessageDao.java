package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.ILeaveMessageDao;
import com.upic.po.LeaveMessage;

@Repository("leaveMessageDao")
public class LeaveMessageDao extends BaseDaoImpl<LeaveMessage> implements ILeaveMessageDao {

}
