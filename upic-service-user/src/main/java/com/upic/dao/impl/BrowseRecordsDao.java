package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IBrowseRecordsDao;
import com.upic.po.BrowseRecords;

@Repository("browseRecordsDao")
public class BrowseRecordsDao extends BaseDaoImpl<BrowseRecords> implements IBrowseRecordsDao {

}
