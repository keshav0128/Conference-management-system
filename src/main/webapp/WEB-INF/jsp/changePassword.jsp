<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    	<%@ include file ="header.jsp" %>
   

    <style type="text/css">
    .error{
    color:red;
    }
    </style>
    <title>Reset Password</title> 
  </head>
    <%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", -1); //prevent caching at the proxy server
%>
  <body>
  
	
<!-- =============menu============= -->  
 
  <%@ include file ="sideMenu.jsp" %>

<!-- =============================== -->  

  <div class="content" name="fr">	
  
        
        
         <div class="content_container">

              <form method="post" action="resetPassword" class="needs-validation card" novalidate>
                  
                    <div class="card-header">
	                     Reset Password
	                </div>
	               
	                <div class="card-body">
	                
                   <c:if test = "${successMessage != null || errorMessage!= null }">
		 	
			               <!-- Modal -->
							<div class="modal  alert_modal" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
							  <div class="modal-dialog modal-dialog-centered">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h5 class="modal-title" id="staticBackdropLabel">Message!</h5>
							        <c:if test = "${errorMessage!= null }">
								        <button type="button" class="close" data-dismiss="modal" aria-label="Close" id="closeAlertModal">
								          <span aria-hidden="true"><i class="fas fa-times"></i></span>
								        </button>
								    </c:if>   
								    <c:if test = "${successMessage!= null }">
							        	 <a href="pageAftAction"  class="btn btn-sm"><span><i class="fas fa-times"></i></span></a>
							       </c:if>	 
						
							      </div>
							      <div class="modal-body">
							         <p><span style="color:#2ECC71;">${successMessage}</span> <span style="color:#E74C3C;"> ${errorMessage}</span> </p>
							      </div>
							      <div class="modal-footer">
							      <c:if test = "${errorMessage!= null }">
							        	<button type="button" class="btn btn-sm" data-dismiss="modal" id="closeAlertModalbtn">Close</button>
							       </c:if>	
							       
							       <c:if test = "${successMessage!= null }">
							        	 <a href="pageAftAction"  class="btn btn-sm">Close</a>
							       </c:if>	       
							      </div>
							    </div>
							  </div>
							</div>
		
			
		
		</c:if>
                  
                  
                  
                    <div class="form-row">
                   
                       <input type="hidden" name="userId" value="${loginMaster.userId}" class="form-control form-control-sm" >
                     
                      
                      <div class="col-md-6 mb-3 input-field">
                        <label for="validationCustom01">New Password<span>*</span></label>
                        <input type="password" name="Password" class="form-control" id="Password" minlength="6" maxlength="50"  required>
                        <div class="invalid-feedback">
                          <!-- Please provide a valid New Password. -->
                          This field is required.
                        </div> 
                       </div>
                       
                       <div class="col-md-6 mb-3 input-field">
                        <label for="validationCustom01">confirm New Password<span>*</span></label>
                        <input type="password" name="confirmPassword" class="form-control" id="confirmPassword" minlength="6" maxlength="50"  required>
                        <div class="invalid-feedback">
                          <!-- Please provide a valid New Password. -->
                          This field is required.
                        </div>
                       </div>
                     
                  
                  
    
                    <!-- ================================= -->
                    <div class="submit-form mt-4">
                      <button class="btn" type="submit">Submit</button> &nbsp;
                      <a href="home" class="btn">Back</a>
                    </div>
                  </div>
                  
                </div>
                
                <ul class="note">
                  
                   <li>Should be minimum 6 digit.</li>
                  
                </ul>
  
            </form>
              
              						
     </div>

  </div>
   

<!-- =============footer========== -->
 <%@ include file ="footer.jsp" %> 
<!-- =============footer============= -->    

   
   
  



   <script>
     $(document).ready(function(){
    	 $("#closeAlertModal").click(function(){
    		
    		 $('.alert_modal').css('display','none');
    	 })
    	 
    	 
    	 
    	 $("#closeAlertModalbtn").click(function(){
    		
    		 $('.alert_modal').css('display','none');
    	 })
    	 
    	  $("#staticBackdrop").modal({
  	       backdrop: 'static',
  	       keyboard: false
  	   })
     })
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
      

  </body>
</html>