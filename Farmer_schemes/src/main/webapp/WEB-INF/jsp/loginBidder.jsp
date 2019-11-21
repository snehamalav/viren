<!DOCTYPE HTML>
<head>
    <title>Web Page Having A Form</title>
    <link rel = "stylesheet" type="text/css" href="style.css">
<style>
       
h1
{
    color : #000000;
    text-align : center;
    font-family: "SIMPSON";
}
form
{
    align:"center";
}


.wrapper {
  display: flex;
  align-items: center;
  flex-direction: column; 
  justify-content: center;
  width: 100%;
  min-height: 100%;
  padding: 20px;
}

#formContent {
  -webkit-border-radius: 10px 10px 10px 10px;
  border-radius: 10px 10px 10px 10px;
  background: #fff;
  padding: 30px;
  width: 90%;
  max-width: 450px;
  position: relative;
  padding: 0px;
  text-align: center;
}

#formFooter {
  background-color: #f6f6f6;
  border-top: 1px solid #dce8f1;
  padding: 25px;
  text-align: center;
  -webkit-border-radius: 0 0 10px 10px;
  border-radius: 0 0 10px 10px;
}






/* FORM TYPOGRAPHY*/

input[type=button], input[type=submit], input[type=reset]  {
  background-color: #56baed;
  border: none;
  color: white;
  padding: 15px 80px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  text-transform: uppercase;
  font-size: 13px;
  -webkit-box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);
  box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);
  -webkit-border-radius: 5px 5px 5px 5px;
  border-radius: 5px 5px 5px 5px;
  margin: 5px 20px 40px 20px;
 
  transition: all 0.3s ease-in-out;
}



input[type=text] {
  background-color: #f6f6f6;
  border: none;
  color: #0d0d0d;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 5px;
  width: 85%;
  border: 2px solid #f6f6f6;
  
  transition: all 0.5s ease-in-out;
  -webkit-border-radius: 5px 5px 5px 5px;
  border-radius: 5px 5px 5px 5px;
}

    </style>

</head>
<body>
        <div class="topnav">
                <a href="Home1.html">Home</a>
                <!-- <a href="Farmerreg.html">Register</a> -->
                <div class="dropdown">
                        <button class="dropbtn">Register
                                 </button>
                        <div class="dropdown-content">
                          <a href="Farmerreg.do">Farmer</a>
                          <a href="Bidderreg.do">Bidder</a>
                        </div>
                    </div> 
                <a href="login.do">Login</a>
                <a href="About.html">About Us</a>
                <a href="Contact.html">Contact Us</a>
                <!-- <a href="#" style="float:right">Link</a> -->
              </div>
    <h1>Create a New Account</h1>
    <center>

      
            <div class="wrapper fadeInDown">
                   

  <div id="formContent">

    

    <!-- Login Form -->
    <form action="loginProcess1.do" method="post" modelAttribute="ibidder" >
      <input type="text" id="b_email"  name="b_email" placeholder="userid"/>
      <input type="password" id="password" name="password" placeholder="password"/>
     
        <input type="submit" value="submit"/>
  
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <a  href="#">Forgot Password?</a>
    </div>
  </div>
</div>

  </center>
</body>