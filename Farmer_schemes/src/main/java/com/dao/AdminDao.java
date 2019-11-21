package com.dao;

import java.util.List;

import com.model.Bidder;
import com.model.Farmer;

public interface AdminDao {
	
	public List<Farmer> getFarmers();
	public List<Bidder> getBidder();

}
