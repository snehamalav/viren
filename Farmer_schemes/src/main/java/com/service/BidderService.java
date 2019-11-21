package com.service;

import java.util.List;

import com.model.Bidder;
import com.model.Farmer;

public interface BidderService {
	public boolean register(Bidder bidder);
	public boolean validateBidder(Bidder bidder);
	 /* public Farmer validateUser(Bidder bidder);
	  public List<Bidder> getUsers();
	  public boolean changepwd(String username,String opwd, String npwd);*/
	  //public QueryForm sendQuery(QueryForm queryForm);
}
