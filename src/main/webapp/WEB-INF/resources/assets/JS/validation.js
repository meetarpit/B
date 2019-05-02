/*Function For Register Validation*/
    function validateform(){  
    var name=document.registration.fname.value;  
    var lname=document.registration.lname.value; 
    var email=document.registration.name.value; 
    var pass=document.registration.password.value;
    var minNumberofChars = 6;
    var maxNumberofChars = 16;
    var min=10;
    var regularExpression  = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$/;
    var address=document.registration.address.value;  
    var phone=document.registration.phone.value;  
    var atposition=email.indexOf("@");  
    console.log("email");
  
 	 var dotposition=email.lastIndexOf("."); 
 	 
    if (name==null || name==""){  
     /*  alert("Name can't be blank"); */
      document.getElementById("nameloc").innerHTML=" Please enter first name";
      event.preventDefault();
      console.log(" for fname");
      return false;  
    }
    else if (lname==null || lname==""){  
    	document.getElementById("namel").innerHTML=" please enter last name";
    	event.preventDefault();
    	console.log(" for lname");
        return false;  
      }
    else if (atposition<1 || dotposition<atposition+2 || dotposition+2>=email.length){  
    	document.getElementById("nameemail").innerHTML=" Please Enter Email";
    	event.preventDefault();
    	console.log(" for email");
        return false;  
      }
    else if (pass==null || pass=="" || pass.length < minNumberofChars || pass.length > maxNumberofChars || !regularExpression.test(pass)){  
    	document.getElementById("namepassword").innerHTML="password should contain atleast one number and one special character";
    	event.preventDefault();
        return false;  
      }
   
    
    else if (phone==null || phone=="" || phone.length < min || phone.length > min){  
    	document.getElementById("namephone").innerHTML="mobile number should contain 10 digits";
    	event.preventDefault();
    	console.log(" for lname");
        return false;  
      }
    else if (address==null || address==""){  
    	document.getElementById("nameaddress").innerHTML=" Please Enter Adress";
    	event.preventDefault();
        return false;  
      }
    
    }  
    /*Function For Register Validation end*/
    
    /*Function For Login Validation*/
    
 function loginValidate(){
var email=document.loginform.name.value; 
var pass=document.loginform.password.value;
var minNumberofChars = 6;
var maxNumberofChars = 16;
var regularExpression  = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$/;
var atposition=email.indexOf("@");  
var dotposition=email.lastIndexOf(".");  
if (atposition<1 || dotposition<atposition+2 || dotposition+2>=email.length ){  
document.getElementById("nameemail").innerHTML=" Please Enter Valid Email";
event.preventDefault();
console.log(" for email");
return false;  
 }



else if (pass==null || pass=="" || pass.length < minNumberofChars || pass.length > maxNumberofChars || !regularExpression.test(pass)){  
	     document.getElementById("namepassword").innerHTML=" Please Enter Valid Password";
	  event.preventDefault();
   console.log(" for password");
   return false;  
	    } 


}      	    
       
    /*Function For Login Validation end*/
    
    /*Function For Admin Login Validation */
 
 function adminloginValidate(){
  	 var email=document.adminloginform.aname.value; 
  	 var pass=document.adminloginform.apassword.value;
  	 var atposition=email.indexOf("@");  
  	 var dotposition=email.lastIndexOf(".");  
  	  if (atposition<1 || dotposition<atposition+2 || dotposition+2>=email.length ){  
	        /*  alert("Name can't be blank"); */
	         document.getElementById("adminemail").innerHTML=" Please Enter Valid Email";
	         event.preventDefault();
	         console.log(" for email");
	         return false;  
	       }
	     else if (pass==null || pass==""){  
	     document.getElementById("adminpassword").innerHTML=" Please Enter Valid Password";
	  event.preventDefault();
     console.log(" for password");
     return false;  
	    } 
	
}
    /*Function For offers Date  Validation */
       function offer(){
    	var sdate=document.offerForm.startdate.value;
    	var enddate=document.offerForm.enddate.value;
    	
    	console.log("in offer");
    	if(sdate > enddate){
    		console.log("in condition");
    		alert("Start Date Can't be greater than expiry date");
    		event.preventDefault();
    		return false;
    	}
    	
    	  /*Function end For offers Date  Validation */
    }
       
//       function for delete confirm box
       function deleteConfirm(){
    	   var answer=confirm("Are you sure you want to delete this offer?");
    	   if(answer==false){
    		   event.preventDefault();
    	   } 
       }
           		   
    	   
    	 
       
    
    