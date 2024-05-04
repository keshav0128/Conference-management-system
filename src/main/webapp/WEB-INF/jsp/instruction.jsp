<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,java.io.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!doctype html>
<html lang="en">
  <head>
  
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <link rel="" href="css/bootstrap.css">
    
    <!-- Font Awesome CDN -->
    <!-- <script src="https://kit.fontawesome.com/23412c6a8d.js"></script> -->
    <script src="js/fontawesome.js"></script>

    <!-- css file cdn -->
    <link rel="stylesheet" href="css/loginAzadi.css">

    <!-- jquery cdn -->
   <!-- DataTables script -->

	<Script src="js/jquery-3.5.1.min.js"></Script>
    <Script src="js/jquery.validate.min.js"></Script>
    <Script src="js/bootstrap.min.js"></Script>
    <!-- js file link -->
    <script  type="text/javascript" src="js/style.js"></script>
    <script  src="js/bootstrap-password-toggler.min.js"></script>   
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <title>Azadi ka Amrit Mahotsav Program System</title>
    

    <style>
       .container-fluid{
          background-image: url(../images/Background_main.jpg);
       }
       .sub_btn_azadi .btn-blue{
			border-radius: 5px;
			/*background-color: #fff;
			z-index: 1;
			color: #fff;*/
			position: relative;
		}
		/*.sub_btn_azadi .btn-blue::before{
		   content: '';
		   position: absolute;
		   left: 0;
		   top: 0;
		   width:100%;
		   height: 100%;
		   border: 2px solid #1A237E;
		}
		.sub_btn_azadi .btn-blue::after{
		   content: '';
		   position: absolute;
		   top: 50%;
		   left: 50%;
		   transform: translate(-50%, -50%);
		   width: 95%;
		   height: 80%;
		   background-color: #1A237E;
		   border-radius: 5px;
		   z-index: -1;
		}*/
		
		
		.loginBy_col .card2{
		    width: 90%;
		}
		@media only screen and (max-width: 1024px){
		   
		}
    </style>
    
  </head>
  


<script language="javascript" type="text/javascript">

	
function forgetPassword()
{
	 
     var loginId =  document.getElementById("loginId").value;
     
     if (loginId =="") {
    	 //alert ("loginId is mandatory")
    	swal({
			  //title: "Good job!",
			  text: "Please fill Login Id and captcha to get password",
			  icon: "warning",
			  button: "Ok",
			  //dangerMode: true
			  closeOnClickOutside: false, // prevent close on click anywhere/outside
			  showConfirmButton: false,
			  allowOutsideClick: false,
			  allowEscapeKey: false
		 });
    	 
		
    	 return false;
    	}
     
     var captcha =  document.getElementById("captcha").value;
     if (captcha =="") {
    	 //alert ("captcha is mandatory")
    	 swal({
			  //title: "Good job!",
			  text: "Please fill captcha to get password",
			  icon: "warning",
			  button: "Ok",
			  //dangerMode: true
			  closeOnClickOutside: false, // prevent close on click anywhere/outside
			  showConfirmButton: false,
			  allowOutsideClick: false,
			  allowEscapeKey: false
		 });
    	 return false;
    	}
     
  var loginRole =  document.getElementById("loginRole").value;
     
     if (loginRole =="") {
    	 //alert ("loginId is mandatory")
    	swal({
			  //title: "Good job!",
			  text: "Please fill Login As to get password",
			  icon: "warning",
			  button: "Ok",
			  //dangerMode: true
			  closeOnClickOutside: false, // prevent close on click anywhere/outside
			  showConfirmButton: false,
			  allowOutsideClick: false,
			  allowEscapeKey: false
		 });
    	 
		
    	 return false;
    	}
     

      
     $('#loginId1').val(loginId);
     $('#captcha1').val(captcha);
     $('#loginRole').val(loginRole);
     $('#Forgotform').submit();
    	
}


function back_block() {
	
window.history.foward(-1)

}

Response.ExpiresAbsolute = new Date();//DateTime.Now;
Response.Expires = 0;
Response.CacheControl = "no-cache";
</script>
  <%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", -1); //prevent caching at the proxy server
%>

  <body  onload="loadaptcha();">
   

     
  <div class="container-fluid px-1 px-md-2 px-lg-1 px-xl-2 py-2 m-auto instruction_page">
    <div class="card card0 border-0">
        <div class="row d-flex">
            <div class="col-lg-6 col-md-12">
                <!-- <div class="card1 pb-5"> -->
                    <!-- <div class="row"> 
                       <img src="images/logo.png" class="logo"> 
                    </div> -->
                    <!-- <div class="row px-3 justify-content-center mt-4 mb-5 border-line"> 
                      <img src="images/azadi_mahotsav.png" class="image"> 
                    </div>-->
                    <!-- <div class="login_text">
                        <h3>Azadi Mahotsav</h3>
                        <p>We walked through fifty-two districts barefoot . We would tell the villagers about freedom</p>
                    </div> -->
               <!--  </div> -->
            </div>
            <div class="col-lg-6 col-md-12 loginBy_col">
               <p class="nseMsg">
			              Helpline is available from Monday to Friday 9:30 AM till 5:30 PM <i>(Helpdesk will remain closed on public holidays).</i> Help line number - 8095210200
			    </p>  
                <div class="card2 card border-0 px-2 py-3">
                    <!--<div class="row mb-4 px-2">-->
                        <!-- <h4 class="mb-0 mr-4 mt-2">Sign In</h4> -->
                        <!-- <h4 class="mb-0 mr-4 ">
                           <span>Azadi Ka Amrit Mahotsav</span>
                           <br>Program System
                        </h4> -->
                        <!-- <div class="comp_logo">
                           <img src="images/azadi_mahotsav.png" class="image">
                        </div> -->
                       
                   <!--  </div> -->
                   
                    
                    <div class="col-md-12 sub_btn sub_btn_azadi">
                        <a href="loginAzadiQuiz" class="card shadow">
			              <div class="card_icon">
			                <!-- <i class="fas fa-chalkboard-teacher"></i> -->
			                <img src="../images/quiz_icon.jpg">
			              </div> 
			              <div class="card-body"> 
			                Apply For Quiz
			              </div>  
			           </a> 
			          
			           <a href="loginAzadiEssay" class="card shadow">
			              <div class="card_icon">
			                <!-- <i class="fas fa-chalkboard-teacher"></i> -->
			                <img src="../images/essay_icons.jpg">
			              </div> 
			              <div class="card-body"> 
			                Apply For Essay
			              </div>  
			           </a> 
			           
			             
                       <!--  <a href="loginAzadiQuiz" class="btn btn-blue text-center">Apply For Quiz</a>
                        &nbsp;
                        <a href="loginAzadiEssay" class="btn btn-blue text-center">Apply For Essay</a> -->
                    </div> 
                    
                     
                    
                    
                 
                 <!-- ==========hidden input========== -->
                  <form action=forgetPassword method=POST id="Forgotform" name="Forgotform">
                     
                      <input type="hidden" name="loginId1" id="loginId1" class="form-input" required>
                      <input type="hidden" name="captcha1" id="captcha1" class="form-input" required>
                      <input type="hidden" name="loginFrom" id="loginFrom"  value="loginAzadi"> 
                      <input type="hidden" name="loginRole" id="loginRole" >       
                     
                  </form>
                    
                </div>
                
                
            </div>
        </div>
        <div class="bg-blue py-2">
            <div class="row px-3"> <small class="ml-4 ml-sm-5 mb-2">Copyright &copy; <script>document.write(new Date().getFullYear());</script>. All rights reserved by <a href="https://www.nism.ac.in/" target="_blank">National Institute Of Securities Markets</a></small>
              <!--    <div class="social-contact ml-4 ml-sm-auto"> <span class="fa fa-facebook mr-4 text-sm"></span> <span class="fa fa-google-plus mr-4 text-sm"></span> <span class="fa fa-linkedin mr-4 text-sm"></span> <span class="fa fa-twitter mr-4 mr-sm-5 text-sm"></span> </div>-->
            </div>
        </div>
    </div>
</div>

<script>
 
	function loadaptcha(){
		$.ajax({
            url: 'getAYTCaptcha',
            type: 'get',
            cache: false,
            //dataType: 'image/jpeg',
            //data: {action: 'process'},
            success: function(data){
        		document.getElementById('randomText').innerHTML = data;
    		}
        });
	}
	
	
    $(document).ready(function(){
        $("#reload").click(function(){
        	
        	$.ajax({
                url: 'getAYTCaptcha',
                type: 'get',
                cache: false,
                //dataType: 'image/jpeg',
                //data: {action: 'process'},
                success: function(data){
            		document.getElementById('randomText').innerHTML = data;
        		}
            });
        	
            //location.reload(true);
        });
    });
</script>



      
<script>
      // Example starter JavaScript for disabling form submissions if there are invalid fields
      (function() {
        'use strict';
        window.addEventListener('load', function() {
          // Fetch all the forms we want to apply custom Bootstrap validation styles to
          var forms = document.getElementsByClassName('needs-validation');
          // Loop over them and prevent submission
          var validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
              if (form.checkValidity() === false) {
                event.preventDefault();
                event.stopPropagation();
              }
              form.classList.add('was-validated');
            }, false);
          });
        }, false);
      })();
      </script>
     <script>
    
	$(document).ready(function () {
		
		$('#login').validate({
		    rules: {
		    	
		        email: {
		        	minlength: 5,
		        	maxlength: 200,
		            email: true
		        }
		        
		    },
		    errorElement: 'span',
	        highlight: function(element, errorClass, validClass) {
	            $(element).removeClass(validClass);
	            $("#togglePassword").hide();
	        },
	        unhighlight: function(element, errorClass, validClass) {
	            $(element).addClass(validClass);
	            $("#togglePassword").show();
	        },
		});
		});
	</script> 
	
	
	
  
      

<script>

function showPassword() {
	  var x = document.getElementById("Password");
	  if (x.type === "password") {
	    x.type = "text";
	  } else {
	    x.type = "password";
	  }
	}




</script>
  </body>
</html>