package com.upic.service;

import com.upic.common.core.service.BaseService;
import com.upic.po.LeaveMessage;

public interface ILeaveMessageService extends BaseService<LeaveMessage> {

	long insert(LeaveMessage leaveMessage);
}
