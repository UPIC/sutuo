package com.upic.dao.impl;

import org.springframework.stereotype.Repository;

import com.upic.base.BaseDaoImpl;
import com.upic.dao.IAnnouncementDao;
import com.upic.po.Announcement;

@Repository("announcementDao")
public class AnnouncementDao extends BaseDaoImpl<Announcement> implements IAnnouncementDao {

}
