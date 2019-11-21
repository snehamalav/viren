package com.service;

import java.util.List;

import com.model.Farmer;

public interface FarmerService {
	public boolean register(Farmer farmer);
	public boolean validateFarmer(Farmer farmer);
	/*  public List<Farmer> getUsers();
	  public boolean changepwd(String username,String opwd, String npwd);*/
	  //public QueryForm sendQuery(QueryForm queryForm);
}
