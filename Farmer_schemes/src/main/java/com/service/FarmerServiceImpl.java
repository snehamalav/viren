package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AdminDao;
import com.dao.FarmerDao;
import com.model.Farmer;

@Service("farmerService")
public class FarmerServiceImpl implements FarmerService {
	@Autowired
	//@Qualifier("farmerDao")
	public FarmerDao farmerDao;
	
	@Transactional
	public boolean register(Farmer farmer) {
			    return farmerDao.register(farmer);
	
	}
	@Transactional
	public boolean validateFarmer(Farmer farmer) {
		boolean flag=farmerDao.validateFarmer(farmer);
		return flag;
	}
}
	/*public List<Farmer> getUsers() {
		boolean flag=farmerDao.getUser(farmer);
		return flag;
	}*/

	/*public List<Farmer> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean changepwd(String username, String opwd, String npwd) {
		// TODO Auto-generated method stub
		return false;
	}
*/
