<!DOCTYPE html>
<html lang="en">
<head>
   
    <title>About Us</title>
    
    <link rel = "stylesheet" type="text/css" href="style.css">
       </head>
    <style>
.btn {
  border: 2px solid black;
  background-color: white;
  color: black;
  padding: 14px 28px;
  font-size: 16px;
  cursor: pointer;
}
h1 {color:black; font-size:50px;font-weight:600;}
 
h3 {color:antiquewhite; font-size:28px;margin-bottom:24px;}


    </style>
    <body>  
           
            <div class="topnav">
                    <a href="Home1.html">Home</a>
                    <!-- <a href="Farmerreg.html">Register</a> -->
                    <div class="dropdown">
                            <button class="dropbtn">Register
                                     </button>
                            <div class="dropdown-content">
                              <a href="Farmerreg.html">Farmer</a>
                              <a href="Bidderreg.html">Bidder</a>
                            </div>
                        </div> 
                    <!-- <a href="logint.html">Login</a> -->
                    <div class="dropdown">
                        <button class="dropbtn">Login
                                 </button>
                        <div class="dropdown-content">
                          <a href="Admin.html">Admin</a>
                          <a href="Farmerhome.html">Farmer</a>
                          <a href="Bidderhome.html">Bidder</a>
                        </div>
                    </div> 
                    <a href="About.html">About Us</a>
                    <a href="Contact.html">Contact Us</a>
                    <!-- <a href="#" style="float:right">Link</a> -->
                  </div>   
                  <form action="viewfarmers.do" method="get">
                  <input type="submit" value="Add Farmer" ></form>
                  <form action="viewbidder.do" method="get">
                  <input type="submit" value="Add Bidder" ></form>
        </div>
        <div class="footer">
                <li><a target="_blank" href="https://india.gov.in/"><img alt="" src="https://enam.gov.in/web/assest/images/footer/img2.jpg"></a></li>
                <li><a target="_blank" href="https://digitizeindia.gov.in/"><img alt="" src="https://enam.gov.in/web/assest/images/footer/img3.jpg"></a></li>
                <li><a target="_blank" href="https://data.gov.in/"><img alt="" src="https://enam.gov.in/web/assest/images/footer/img4.jpg"></a></li>
                <li><a target="_blank" href="https://meity.gov.in/"><img alt="" src="https://enam.gov.in/web/assest/images/footer/img5.jpg"></a></li>
              </div>
    </body>
        
</html>