package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AdminDao;
import com.model.Bidder;
import com.model.Farmer;
@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
public AdminDao adminDao;
	@Transactional
	public List<Farmer> getFarmers()
	{
	    List<Farmer> list=adminDao.getFarmers();
		return list;
		
	}
	
	@Transactional
	public List<Bidder> getBidder()
	{
	    List<Bidder> alist=adminDao.getBidder();
		return alist;
		
	}

}
