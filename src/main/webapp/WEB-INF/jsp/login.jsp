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


    
    <link rel="" href="css/bootstrap4.min.css">
    
    <!-- Font Awesome CDN -->
    <!-- <script src="https://kit.fontawesome.com/23412c6a8d.js"></script> -->
    <script src="js/fontawesome.js"></script>

    <!-- css file cdn -->
    <link rel="stylesheet" href="css/login.css">

    <!-- jquery cdn -->
   <!-- DataTables script -->

	<Script src="js/jquery-3.5.1.min.js"></Script>
    <Script src="js/jquery.validate.min.js"></Script>
    <Script src="js/bootstrap.min.js"></Script>
    <!-- js file link -->
    <script  type="text/javascript" src="js/style.js"></script>
    <script  src="js/bootstrap-password-toggler.min.js"></script>   

    <title>Conference Management System</title>
    
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    
  </head>
  


<script language="javascript" type="text/javascript">

	
function forgetPassword(evt)
{
	 
     var loginId =  document.getElementById("loginId").value;
     if (loginId =="") {
    	 //alert ("loginId is mandatory")
    	swal({
			  //title: "Good job!",
			  text: "Please fill Login Id to get password",
			  icon: "warning",
			  button: "Ok",
			  //dangerMode: true
			  closeOnClickOutside: false, // prevent close on click anywhere/outside
			  showConfirmButton: false,
			  allowOutsideClick: false,
			  allowEscapeKey: false
		 });
    	 
    	evt.preventDefault();
    	 return false;
    	}
     
     /* var captcha =  document.getElementById("captcha").value;
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
    	 evt.preventDefault();
    	 return false;
    	}*/
     
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
    	 
    	evt.preventDefault();
    	 return false;
    	}
     
      
     $('#loginId1').val(loginId);
    // $('#captcha1').val(captcha);
     $('#loginRole1').val(loginRole);
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
   

     
  <div class="container-fluid px-1 px-md-2 px-lg-1 px-xl-2 py-2 m-auto">
    <div class="card card0 border-0">
        <div class="row d-flex">
            <div class="col-lg-6">
                <div class="card1 pb-5">
                    <div class="row"> <img src="images/logo.png" class="logo"> </div>
                    <div class="row px-3 justify-content-center mt-4 mb-5 border-line"> <img src="images/login_training_img.jpg" class="image"> </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="card2 card border-0 px-4 py-3">
                    <div class="row mb-4 px-3">
                        <!-- <h4 class="mb-0 mr-4 mt-2">Sign In</h4> -->
                        <h4 class="mb-0 mr-4 ">Conference Management System</h4>
                       
                    </div>
                   
                    
                    
                    <form  action=validLogin method=POST  id="login" name="login" class="needs-validation" novalidate>
							 
								<!-- ================================= -->
							<c:if test="${successMessage != null}">
								<div class="row">
									<div class="col-12">
										<div class="alert alert-success alert-dismissible fade show" role="alert">
											   ${successMessage}
											  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
											    <span aria-hidden="true">&times;</span>
											  </button>
										</div>
									 </div>
								 </div>
							 </c:if>
							  
							  <c:if test="${errorMessage != null}">
								 <div class="row">
									<div class="col-12">
										<div class="alert alert-danger alert-dismissible fade show" role="alert">
											  ${errorMessage}
											  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
										   	     <span aria-hidden="true">&times;</span>
											   </button>
										</div>
									 </div>
								  </div>
								</c:if> 
                    
                    
                    <input type="hidden" class="form-control form-control-sm" name="mac" id="mac" placeholder="mac" required>
                    
                    <div class="row px-3 mb-2"> <label class="mb-1">
                            <h6 class="mb-0 text-sm">Login ID</h6>
                            <input type="hidden" name="loginFrom" id="loginFrom"  value="login">
                            <input type="hidden" name="loginRole" id="loginRole" value="1" >
                        </label> <input class="form-control" type="text" name="loginId" id="loginId" placeholder="Enter Login Id"  value="${loginId}" required> </div>
                    <div class="row px-3 mb-2"> 
                        <label class="mb-1 col-12 pl-0">
                            <h6 class="mb-0 text-sm">Password</h6>
                        </label> 
                        <div class="password_field">
                           <input type="password" class="form-control" name="Password" id="Password" placeholder="Enter password" required>
                           <span><i class="far fa-eye" id="togglePassword" onclick="showPassword()"></i></span>
                        </div>
                    </div>
                    
                    
                    <div class="row px-3 mb-2">
	                    
	                    <!-- <div class="row px-3" id="captchaImg"> 
	                            <img src="${pageContext.request.contextPath }/getCaptcha">&nbsp;&nbsp;&nbsp;&nbsp;
	                    </div>
	                     <div class="row ml-1" id="randomText"></div>&nbsp;&nbsp;&nbsp;&nbsp;
	                     	                     	                     
	                     <button class="btn btn-sm" type="button" id="reload" name="reload"><i class="fas fa-sync"></i></button> 
	                     -->
	                </div>     
                    
                    <!-- 
                    <div class="row px-3 mb-4"> 
                       <label class="mb-1">
                        </label> <input  class="form-control" id="captcha" name="captcha" maxlength=10 placeholder="Captcha" required autocomplete="off"> 
                    </div>
                     -->
                   
                    
                    <div class="row mb-3 px-0"> 
                      <div class="col-md-4">
                        <button type="submit" class="btn btn-blue text-center sm:mx-auto">Login</button> 
                      </div> 
                      <div class="col-md-8">
                        <small class="font-weight-bold register_link mt-2"><a href="javascript:forgetPassword()" class="mb-0 text-sm text-success">
                          Forgot Password?
                        </a></small>
                      </div>  
                    </div>
                 </form>
                 
                 <!-- ==========hidden input========== -->
                  <form action=forgetPassword method=POST id="Forgotform" name="Forgotform">
                     
                      <input type="hidden" name="loginId1" id="loginId1" class="form-input" required>
                      <input type="hidden" name="captcha1" id="captcha1" class="form-input" required>
                      <input type="hidden" name="loginFrom" id="loginFrom"  value="login">  
                     <input type="hidden" name="loginRole1" id="loginRole1" value="1" >
                             
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
 /*
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
    });*/
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
	        },
	        unhighlight: function(element, errorClass, validClass) {
	            $(element).addClass(validClass);

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