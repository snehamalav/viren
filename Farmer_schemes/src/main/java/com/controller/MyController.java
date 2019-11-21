package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.model.Farmer;
import com.service.FarmerService;

@Controller("myController1")

public class MyController {
	@Autowired
	//@Qualifier("farmerService")
	 public FarmerService farmerService;

	 @RequestMapping(value = "/Farmerregister", method = RequestMethod.GET)
	  public ModelAndView showRegister2(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("Farmerreg");
	    mav.addObject("farmer", new Farmer());
	    return mav;
	  }
	 
	 
	  @RequestMapping(value = "/Farmerregister", method = RequestMethod.POST)
	  public ModelAndView addfarmer2(HttpServletRequest request, HttpServletResponse response,  @ModelAttribute("farmer") Farmer farmer, @RequestParam("file") MultipartFile files[]) 
	  {
		  String full_name = farmer.getFull_name();
		  full_name = request.getParameter("full_name");
		  
		  System.out.println("fullname:"+full_name+"  Name:"+request.getParameter("full_name"));
		  System.out.println("contact:"+farmer.getContact_no()+"  "+request.getParameter("contact_no"));
			for (int i = 0; i < files.length; i++) {
				String filename="";
				if(i==0)
					filename=(full_name+i)+".jpg";//+".pdf";
					else if(i==1)
						filename=(full_name+i)+".jpg";//+".pdf";
					else if(i==2)
						filename=(full_name+i)+".jpg";
				MultipartFile file = files[i];
				try {
					byte[] bytes = file.getBytes();

					// Creating the directory to store file
					String rootPath = System.getProperty("catalina.home");
					File dir = new File(rootPath + File.separator + "tmpFiles");
					if (!dir.exists())
						dir.mkdirs();

					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath()+ File.separator + filename);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
					
					if(i==0)
                    farmer.setAdhar_fname(filename);
					else if(i==1)
						farmer.setPan_fname(filename);
					else if(i==2)
						farmer.setCertificate_fname(filename);
					farmer.setStatus("N");
					
					System.out.println("Server File Location="+ serverFile.getAbsolutePath());
					} catch (Exception e) {
					System.out.println( "You failed to upload " + (full_name+i) + " => " + e.getMessage());
				}
			}  
		  
		boolean flag=farmerService.register(farmer);
		System.out.println(flag+"8");
	    if(flag) {
	    ModelAndView mav = new ModelAndView("login");
	    mav.addObject("login", new Farmer());
	    return mav;
	    }
	    else {
	    	ModelAndView mav = new ModelAndView("Farmerreg");
	        mav.addObject("farmer", new Farmer());
	        mav.addObject("status","Sorry! Registration in incomplete");
	        return mav;	
	    }
	  }

	
	  @RequestMapping(value = "/login1", method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("login");
	    mav.addObject("farmer", new Farmer());
	    return mav;
	  }

	  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,   @ModelAttribute Farmer ifarmer) {
		  System.out.println("email"+ifarmer.getF_email());
		  System.out.println("name"+ifarmer.getFull_name());
		  System.out.println("hello");
	    ModelAndView mav = null;
	    boolean flag=farmerService.validateFarmer(ifarmer);
	    System.out.println(flag);
	    if (flag) {
	      mav = new ModelAndView("welcomeFarmer");
	      mav.addObject("email", ifarmer.getFull_name());
	      //session manage
	      
	      HttpSession session= request.getSession();
	      session.setAttribute("email", ifarmer.getFull_name());
	    } else {
	      mav = new ModelAndView("login");
	      mav.addObject("message", "farmeremail or Password is wrong!!");
	    }
	    return mav;
	  }

	/*	@RequestMapping(value = "/logout", method = RequestMethod.GET)
		public ModelAndView farmerlogout(HttpServletRequest request, HttpServletResponse response) {
			 HttpSession session =request.getSession(false);
			 session.invalidate();
			 ModelAndView mav = new ModelAndView("login");
			 mav.addObject("login", new Farmer());
			 return mav;
		 }

		@RequestMapping(value = "/viewfarmers", method = RequestMethod.GET)
		public ModelAndView viewflight(HttpServletRequest request, HttpServletResponse response) {
			List<Farmer>  farmerlist = farmerService();
			 ModelAndView mav = new ModelAndView("viewfarmers");
			 mav.addObject("farmerlist", farmerlist);
			 HttpSession session =request.getSession(false);
			 session.setAttribute("ulist", farmerlist);
			 return mav;
		 }
  
		@RequestMapping(value = "/changepwd", method = RequestMethod.GET)
		  public ModelAndView changepwd1(HttpServletRequest request, HttpServletResponse response) {
		    ModelAndView mav = new ModelAndView("changepwd");
		    return mav;
		  }
		@RequestMapping(value = "/changepwd", method = RequestMethod.POST)
		  public ModelAndView changepwd2(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
            String farmername=(String)session.getAttribute("farmername");
            String opwd= request.getParameter("opassword");
            String npwd= request.getParameter("npassword");
            System.out.println(farmername+"  "+opwd+"  "+npwd);
            boolean flag = farmerService.changepwd(farmername,opwd,npwd);
            if(flag) {
		       ModelAndView mav = new ModelAndView("changepwd");
		       mav.addObject("message", "Password is successfully updated");
		       return mav;
		  }
            else {
            	ModelAndView mav = new ModelAndView("changepwd");
 		       mav.addObject("message", "Password is not updated");
 		       return mav;
            }
		}
		
		@RequestMapping(value="/query", method=RequestMethod.GET)
	    public ModelAndView getQueryForm() {
			ModelAndView mav = new ModelAndView("query");
			mav.addObject("queryform",new QueryForm());
	    	return mav;
	    }
	    
	    @RequestMapping(value="/query", method=RequestMethod.POST)
	    public ModelAndView sendQueryForm(@ModelAttribute QueryForm queryForm) {
	    	System.out.println(queryForm.getName()+" "+queryForm.getInfo());
	    	queryForm = farmerService.sendQuery(queryForm);
	    	ModelAndView mav = new ModelAndView("query1");
	    	mav.addObject("obj",queryForm);
	    	return mav;
	    }
	  
	  @RequestMapping(value = "/register", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		//public ModelAndView showRegister() {
	    ModelAndView mav = new ModelAndView("register");
	    mav.addObject("farmer", new farmer());
	    return mav;
	  }

	  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	  public ModelAndView addfarmer(HttpServletRequest request, HttpServletResponse response,  @ModelAttribute("farmer") farmer farmer) {
	    boolean flag=farmerService.register(farmer);
	    if(flag) {
	    ModelAndView mav = new ModelAndView("login");
	    mav.addObject("login", new farmer());
	    return mav;
	    ModelAndView mav = new ModelAndView("fileregister");
		mav.addObject("farmerRegForm", new farmerRegForm());	
		mav.addObject("farmername",farmer.getfarmername());
	    return mav;
	    
	    }
	    else {
	    	ModelAndView mav = new ModelAndView("register");
	        mav.addObject("farmer", new farmer());
	        mav.addObject("status","Sorry! Registration in incomplete");
	        return mav;	
	    }
	  }
	  
	  @RequestMapping(value = "/uploadfiles", method = RequestMethod.POST)
		//public String save(	@ModelAttribute("farmerRegForm") farmerRegForm farmerRegForm,	BindingResult result) {
		  public String save (@RequestParam("farmername") String farmername,@RequestParam("file") MultipartFile files[]) {
		if (farmerRegForm != null) {
			
			List<String> uploadedFileNames = new ArrayList<String>();
			if (farmerRegForm.getFiles() != null) {
				for (MultipartFile file : farmerRegForm.getFiles()) {
					uploadedFileNames.add(file.getOriginalFilename());
				}
				//modelAndView.addObject("listUploadedFiles", uploadedFileNames);
			}
			System.out.println(uploadedFileNames);
	       
		} 
		  String message = "";
			for (int i = 0; i < files.length; i++) {
				MultipartFile file = files[i];
				//String name = names[i];
				try {
					byte[] bytes = file.getBytes();

					// Creating the directory to store file
					String rootPath = System.getProperty("catalina.home");
					File dir = new File(rootPath + File.separator + "tmpFiles");
					if (!dir.exists())
						dir.mkdirs();

					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath()+ File.separator + (farmername+i));
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();

					System.out.println("Server File Location="+ serverFile.getAbsolutePath());

					message = message + "You successfully uploaded file=" + (farmername+i)
							+ "<br />";
				} catch (Exception e) {
					System.out.println( "You failed to upload " + (farmername+i) + " => " + e.getMessage());
				}
			}
		return "welcome";
	      }
	  
	
	//Form handling with Model object
	@RequestMapping(value = "/contacts", method = RequestMethod.POST)
	public ModelAndView addContact(HttpServletRequest request, HttpServletResponse response) {
		 String name= request.getParameter("name");
		 String info = request.getParameter("info");
		 System.out.println(name+"  "+info);
		 // do some job using service layer
		 ModelAndView mav = new ModelAndView("viewcontact");
	     mav.addObject("name", name.toUpperCase());
	     mav.addObject("info", info.toLowerCase());
	     return mav;  
	     //return "viewcontact";
	 }




	}

	
	private int MAX_UPLOAD_SIZE = 5 * 1024 * 1024; 
	
	@Autowired
	 public farmerService farmerService;
	

	
	@RequestMapping(value = "/register", method = RequestMethod.GET )
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		//public ModelAndView showRegister() {
	    ModelAndView mav = new ModelAndView("register");
	    mav.addObject("farmer", new farmer());
	    return mav;
	  }

	  

	  //public ModelAndView addfarmer(HttpServletRequest request, HttpServletResponse response,  @ModelAttribute("farmer") farmer farmer , @RequestParam("file") MultipartFile[] files) {
	 // public ModelAndView addfarmer(@ModelAttribute("farmerRegForm") farmerRegForm farmerRegForm , BindingResult bindingResult ) {  
	  
	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addfarmer(HttpServletRequest request, HttpServletResponse response,  @ModelAttribute("farmer") farmer farmer) {
		  
		  try {
			Part part = request.getPart("file1");
			System.out.println(part);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  //System.out.println("obj:"+request.getParameter("address"));  
	  //System.out.println(("obj:"+farmerRegForm.getAddress()));
	   * 
		  
       boolean flag=farmerService.register(farmer);
	    if(flag) {
	    ModelAndView mav = new ModelAndView("login");
	    mav.addObject("login", new farmer());
	    	ModelAndView mav = new ModelAndView("fileregister");
		    mav.addObject("farmerRegForm", new farmerRegForm());	
		    mav.addObject("farmername",farmer.getfarmername());
	    return mav;
	    }
	    else {
	    	ModelAndView mav = new ModelAndView("register");
	        mav.addObject("farmer", new farmer());
	        mav.addObject("status","Sorry! Registration in incomplete");
	        return mav;	
	    }
	  }
	  
	
	 @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	  public ModelAndView addfarmer(HttpServletRequest request, HttpServletResponse response,  @ModelAttribute("farmer") farmer farmer) {
	    boolean flag=farmerService.register(farmer);
	    if(flag) {
	    ModelAndView mav = new ModelAndView("login");
	    mav.addObject("login", new Login());
	    return mav;
	    	ModelAndView mav = new ModelAndView("fileregister");
		    mav.addObject("farmerRegForm", new farmerRegForm());	
		    mav.addObject("farmername",farmer.getfarmername());
	    return mav;
	    }
	    else {
	    	ModelAndView mav = new ModelAndView("register");
	        mav.addObject("farmer", new farmer());
	        mav.addObject("status","Sorry! Registration in incomplete");
	        return mav;	
	    }
	  }
	  
	
	@RequestMapping(value = "/uploadfiles", method = RequestMethod.POST)
	public String save(	@ModelAttribute("farmerRegForm") farmerRegForm farmerRegForm,	BindingResult result) {
	if (farmerRegForm != null) {
		
		List<String> uploadedFileNames = new ArrayList<String>();
		if (farmerRegForm.getFiles() != null) {
			for (MultipartFile file : farmerRegForm.getFiles()) {
				uploadedFileNames.add(file.getOriginalFilename());
			}
			//modelAndView.addObject("listUploadedFiles", uploadedFileNames);
		}
		System.out.println(uploadedFileNames);
       
	} 
	return "welcome";
      }
 
    @RequestMapping(path="/hello1", method=RequestMethod.GET)
	public void show1() {
		System.out.println(" I am fine....");
	}
    
    @RequestMapping(value="/hello2", method=RequestMethod.GET)
    public String show2() {
    	System.out.println(" I am fine from show2....");
    	return "show2";
    }
    
    @RequestMapping(value="/hello3", method=RequestMethod.GET)
    public ModelAndView show3() {
    	ModelAndView mav  = new ModelAndView();
    	mav.setViewName("show3");
    	mav.addObject("var1","Dibakar Sanyal");
    	mav.addObject("address", "Kolkata,WB");
    	return mav;
    	
    }
    
    @RequestMapping(value="/query", method=RequestMethod.GET)
    public String getQueryForm() {
    	return "query";
    }
    
    @RequestMapping(value="/makequery", method=RequestMethod.POST)
    public ModelAndView sendQueryForm(@ModelAttribute MyQuery myQuery) {
    	System.out.println(myQuery.getName());
    	ModelAndView mav = new ModelAndView("query1");
    	mav.addObject("obj",myQuery);
    	return mav;
    }
    
    @RequestMapping(value = "/viewfarmers", method = RequestMethod.GET)
    public ModelAndView viewflight(HttpServletRequest request, HttpServletResponse response) {
    	List<farmer>  farmerlist = farmerService.getfarmers();
    	 ModelAndView mav = new ModelAndView("viewfarmers");
    	 mav.addObject("farmerlist", farmerlist);
    	// HttpSession session =request.getSession(false);
    	// session.setAttribute("ulist", farmerlist);
    	 return mav;
     }
    */
}


