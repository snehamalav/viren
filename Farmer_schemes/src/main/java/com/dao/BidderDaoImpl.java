package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.model.Bidder;
import com.model.Farmer;
@Repository("bidderDao")
public class BidderDaoImpl implements BidderDao {
	@PersistenceContext
	EntityManager em;
	public boolean register(Bidder bidder) {
		 
		    boolean flag=false;
		    try {
		    	em.persist(bidder);
		    	System.out.println("end");
		    	flag=true;
		    }
		    catch(Exception e) { 
		    	System.out.println("Error:"+e);  
		    	}
		    return flag;
	}

	public boolean validateBidder(Bidder bidder)
	{

		boolean result=false;
		try{
		
		//code for jpa
		
		Bidder u=em.find(Bidder.class,bidder.getB_email());
		System.out.println(result+"1");
	
		
		if(u!=null)
		{
			if(u.getPassword().equals(bidder.getPassword()))
				{
				result=true;
			    System.out.println(result+"2");
				}
		}
		System.out.println(result+"3");
		em.close();
	}
		catch(Exception e)
		{
			System.out.println("error:"+e);
		}
		System.out.println(result+"4");
		return result;
		
	}


	/*public Bidder validateUser(Bidder bidder) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Bidder> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean changepwd(String username, String opwd, String npwd) {
		// TODO Auto-generated method stub
		return false;
	}*/

}
