package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IAnnouncementDao;
import com.upic.po.Announcement;
import com.upic.service.IAnnouncementService;

@Service("announcementService")
public class AnnouncementService implements IAnnouncementService {
	@Autowired
	private IAnnouncementDao announcementDao;

	@Override
	public Announcement getById(long id) {
		return announcementDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return announcementDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return announcementDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<Announcement> listBy(Map<String, Object> paramMap) {
		return announcementDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return announcementDao.listBy(paramMap, sqlId);
	}

	@Override
	public Announcement getBy(Map<String, Object> paramMap) {
		return announcementDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return announcementDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return announcementDao.getSeqNextValue(seqName);
	}
}
