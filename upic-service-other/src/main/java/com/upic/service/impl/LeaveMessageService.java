package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.ILeaveMessageDao;
import com.upic.po.Access;
import com.upic.po.LeaveMessage;
import com.upic.service.ILeaveMessageService;

@Service("leaveMessageService")
public class LeaveMessageService implements ILeaveMessageService {
	@Autowired
	private ILeaveMessageDao leaveMessageDao;

	@Override
	public LeaveMessage getById(long id) {
		return leaveMessageDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return leaveMessageDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return leaveMessageDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<LeaveMessage> listBy(Map<String, Object> paramMap) {
		return leaveMessageDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return leaveMessageDao.listBy(paramMap, sqlId);
	}

	@Override
	public LeaveMessage getBy(Map<String, Object> paramMap) {
		return leaveMessageDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return leaveMessageDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return leaveMessageDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(LeaveMessage leaveMessage) {
		return leaveMessageDao.insert(leaveMessage);
	}
}
