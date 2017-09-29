package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IPicLogDao;
import com.upic.po.PicLog;
import com.upic.service.IPicLogService;

@Service("picLogService")
public class PicLogService implements IPicLogService {
	@Autowired
	private IPicLogDao picLogDao;

	@Override
	public PicLog getById(long id) {
		return picLogDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return picLogDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return picLogDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<PicLog> listBy(Map<String, Object> paramMap) {
		return picLogDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return picLogDao.listBy(paramMap, sqlId);
	}

	@Override
	public PicLog getBy(Map<String, Object> paramMap) {
		return picLogDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return picLogDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return picLogDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(PicLog picLog) {
		return picLogDao.insert(picLog);
	}

	@Override
	public long update(PicLog picLog) {
		return picLogDao.update(picLog);
	}
}
