package com.upic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.dao.IBrowseRecordsDao;
import com.upic.po.BrowseRecords;
import com.upic.service.IBrowseRecordsService;

@Service("browseRecordsService")
public class BrowseRecordsService implements IBrowseRecordsService {
	@Autowired
	private IBrowseRecordsDao browseRecordsDao;

	@Override
	public BrowseRecords getById(long id) {
		return browseRecordsDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return browseRecordsDao.listPage(pageParam, paramMap);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return browseRecordsDao.listPage(pageParam, paramMap, sqlId);
	}

	@Override
	public List<BrowseRecords> listBy(Map<String, Object> paramMap) {
		return browseRecordsDao.listBy(paramMap);
	}

	@Override
	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return browseRecordsDao.listBy(paramMap, sqlId);
	}

	@Override
	public BrowseRecords getBy(Map<String, Object> paramMap) {
		return browseRecordsDao.getBy(paramMap);
	}

	@Override
	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return browseRecordsDao.getBy(paramMap, sqlId);
	}

	@Override
	public String getSeqNextValue(String seqName) {
		return browseRecordsDao.getSeqNextValue(seqName);
	}

	@Override
	public long insert(BrowseRecords address) {
		return browseRecordsDao.insert(address);
	}
}
