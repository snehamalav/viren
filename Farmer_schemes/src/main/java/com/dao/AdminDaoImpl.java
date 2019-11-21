package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.model.Bidder;
import com.model.Farmer;
@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {
	@PersistenceContext
	EntityManager em;
	public List<Farmer> getFarmers(){
	
		@SuppressWarnings("unchecked")
		List<Farmer> list=em.createQuery("Select f from Farmer f").getResultList();
		return list;
		
	}
	
	public List<Bidder> getBidder(){
		
		@SuppressWarnings("unchecked")
		List<Bidder> alist=em.createQuery("Select b from Bidder b").getResultList();
		return alist;
		
	}
	
	
	
}

