<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="fregstyle.css">
    <link rel="stylesheet" href="topnav.css">

<body>

    <div class="header">
        <h1>Farmers Portal</h1>
        <p>Scheme For Farmers</p>
      </div>
      
      <div class="topnav">
        <a href="#">Home</a>
        <a href="register.do">Register</a>
        <a href="#">Login</a>
        <a href="#">About Us</a>
        <a href="#">Contact Us</a>
        <!-- <a href="#" style="float:right">Link</a> -->
      </div>

<form id="regForm" action="Farmerregister.do" modelAttribute="farmer" method="post" enctype="multipart/form-data">
  <h1>Farmer Registration:</h1>
  <!-- One "tab" for each step in the form: -->
  <div class="tab">Personal Details
   
    <p><input type="text" name="full_name" placeholder="full name"></p>
    <p><input type="number" placeholder="Contact No"   name="contact_no" required/></p>
    <p><input type="email" placeholder="E-mail..."   name="f_email" required/></p>
  </div>

  <div class="tab">Address Details
    <p><input type="text" placeholder="Address line 1"   name="address"required/></p>
    <p><input type="text" placeholder="Address line 2"   name="address"required/></p>
    <p><input type="text" placeholder="City"   name="city" required/></p>
    <p><input type="text" placeholder="State"   name="state" required/></p>
    <p><input type="number" placeholder="Pin Code"   name="pincode" required/></p>
    LAND Details
    <p><input type="number" placeholder="Area"   name="land_area" required/></p>
    <p><input type="text" placeholder="Address"   name="land_address" required/></p>
    <p><input type="number" placeholder="Pin Code"   name="land_pincode" required/></p>
  </div>

  <div class="tab">Bank Details
    <p><input type="number" placeholder="AccountNo"   name="account_no"></p>
    <p><input type="number" placeholder="IFSC Code"   name="ifsc_code"></p>
  </div>

   <div class="tab">Document Upload
   <p> <input type="text" placeholder="Andhar no."  name="adhar_no"></p>
    <p><input type="file" placeholder="Aadhaar"  name="file"></p>
    <p><input type="file" placeholder="PAN" name="file"></p>
    <p><input type="file" placeholder="certificate"  name="file"></p>
  </div>

  <div class="tab">Set Password
    <p><input type="password" placeholder="Password"   name="password"></p>
    <!--  <p><input type="password" placeholder="Confirm Password"   name="password" type="confpass"></p>-->
  </div>
 <!--  <div style="overflow:auto;">
    <div style="float:right;">
      <button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
      <button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
    </div> -->
    <div class="tab">
    <p><input type="submit" value="submit"></p>
     </div>
  
  </div>
  <!-- Circles which indicates the steps of the form: -->
  <div style="text-align:center;margin-top:40px;">
    <span class="step"></span>
    <span class="step"></span>
    <span class="step"></span>
    <span class="step"></span>
    <span class="step"></span>
  </div>
  <div class="footer">
    <li><a target="_blank" href="https://india.gov.in/"><img alt="" src="https://enam.gov.in/web/assest/images/footer/img2.jpg"></a></li>
    <li><a target="_blank" href="https://digitizeindia.gov.in/"><img alt="" src="https://enam.gov.in/web/assest/images/footer/img3.jpg"></a></li>
    <li><a target="_blank" href="https://data.gov.in/"><img alt="" src="https://enam.gov.in/web/assest/images/footer/img4.jpg"></a></li>
    <li><a target="_blank" href="https://meity.gov.in/"><img alt="" src="https://enam.gov.in/web/assest/images/footer/img5.jpg"></a></li>
  </div>
</form>
<!-- <script>
var currentTab = 0; // Current tab is set to be the first tab (0)
showTab(currentTab); // Display the current tab

function showTab(n) {
  // This function will display the specified tab of the form...
  var x = document.getElementsByClassName("tab");
  x[n].style.display = "block";
  //... and fix the Previous/Next buttons:
  if (n == 0) {
    document.getElementById("prevBtn").style.display = "none";
  } else {
    document.getElementById("prevBtn").style.display = "inline";
  }
  if (n == (x.length - 1)) {
    document.getElementById("nextBtn").innerHTML = "Submit";
  } else {
    document.getElementById("nextBtn").innerHTML = "Next";
  }
  //... and run a function that will display the correct step indicator:
  fixStepIndicator(n)
}

function nextPrev(n) {
  // This function will figure out which tab to display
  var x = document.getElementsByClassName("tab");
  // Exit the function if any field in the current tab is invalid:
  if (n == 1 && !validateForm()) return false;
  // Hide the current tab:
  x[currentTab].style.display = "none";
  // Increase or decrease the current tab by 1:
  currentTab = currentTab + n;
  // if you have reached the end of the form...
  if (currentTab >= x.length) {
    // ... the form gets submitted:
    document.getElementById("regForm").submit();
    return false;
  }
  // Otherwise, display the correct tab:
  showTab(currentTab);
}

function validateForm() {
  // This function deals with validation of the form fields
  var x, y, i, valid = true;
  x = document.getElementsByClassName("tab");
  y = x[currentTab].getElementsByTagName("input");
  // A loop that checks every input field in the current tab:
  for (i = 0; i < y.length; i++) {
    // If a field is empty...
    if (y[i].value == "") {
      // add an "invalid" class to the field:
      y[i].className += " invalid";
      // and set the current valid status to false
      valid = false;
    }
  }
  // If the valid status is true, mark the step as finished and valid:
  if (valid) {
    document.getElementsByClassName("step")[currentTab].className += " finish";
  }
  return valid; // return the valid status
}

function fixStepIndicator(n) {
  // This function removes the "active" class of all steps...
  var i, x = document.getElementsByClassName("step");
  for (i = 0; i < x.length; i++) {
    x[i].className = x[i].className.replace(" active", "");
  }
  //... and adds the "active" class on the current step:
  x[n].className += " active";
}
</script> -->
</body>
</html>