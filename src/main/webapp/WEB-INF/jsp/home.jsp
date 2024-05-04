<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />

    <!-- =============header========== -->
		<%@ include file ="header.jsp" %>
	  <!-- =============menu============= --> 

    <title>${sessionScope.projectName} : Home</title>
  </head>
    <%
response.setHeader("Cache-Control","no-cache, no-store"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", -1); //prevent caching at the proxy server
if (session.getAttribute("loginMaster") == null) {
%>
	<c:redirect url="login" />
<%
	}
%>

  <body>
  
<!-- =============menu============= -->  
 
  <%@ include file ="sideMenu.jsp" %>

<!-- =============================== -->  
  
  <div class="content" name="fr">
  
     

      <div class="content_container">
        <div class="home_text">
          
           <div class="home_kotak">
                <h1>${sessionScope.projectName}</h1>
           </div>
           
         <!-- <div class="page_header">
             <h1>${sessionScope.projectName}</h1>
          </div> -->
          
        </div>  
      </div>
      
      
  </div>
  
    <c:if test = "${successMessage != null }">
		 	
			               <!-- Modal -->
							<div class="modal   alert_modal" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
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
							        	 <a href="logout"  class="btn btn-sm"><span><i class="fas fa-times"></i></span></a>
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
							        	 <a href="logout"  class="btn btn-sm">Close</a>
							       </c:if>	       
							      </div>
							    </div>
							  </div>
							</div>
		
			
		
		</c:if> 
		
 <c:if test = "${firstTimeLogin != null}">
		 			
            	
			               <!-- Modal -->
							<div class="modal   alert_modal1" id="staticBackdrop1" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
							  <div class="modal-dialog modal-dialog-centered">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h5 class="modal-title" id="staticBackdropLabel"><span style="color:#E74C3C;">${message}</span></h5>
							      </div>
									 <form method="post" action="resetPasswordHome" class="needs-validation" novalidate>     
									      <div class="modal-body">
									          <div class="form-row">
			                   
								                      <p><span style="color:#E74C3C;"> ${errorMessage}</span></p>
								                      
								                      <div class="col-md-6 mb-3 input-field">
								                        <label for="validationCustom01">New Password<span>*</span></label>
								                        <input type="password" name="Password" class="form-control" id="validationCustom04" minlength="6" maxlength="50"  required>
								                        <div class="invalid-feedback">
								                          Please provide a valid New Password.
								                        </div>
								                       </div>
								                       
								                       <div class="col-md-6 mb-3 input-field">
								                        <label for="validationCustom01">Confirm New Password<span>*</span></label>
								                        <input type="password" name="confirmPassword" class="form-control" id="validationCustom04" minlength="6" maxlength="50"  required>
								                        <div class="invalid-feedback">
								                          Please provide a valid Confirm Password.
								                        </div>
								                       </div>
							                   </div>
									      </div>
									      
									      
									      <ul class="note">
									      		<li><b>Password Policy :</b></li>
										        <li>only this special character is allowed @#$*!_-</li>
												<li>Should be minimum 8 digit.</li>
												<li>Should be contain special character.</li>
												<li>Should be alphanumeric. </li>
												<li>Should be 1 upper case letter.</li>
												<li>Should be 1 lower case letter.</li>
										  </ul>
										  
										  <div class="modal-footer">
									        	<button class="btn btn-sm submit_btn" id="submitbtn" type="submit" >Submit</button> &nbsp;	                     
									     </div> 
									     
									</form>	  

                                        
							        
							    </div>
							  </div>
							</div>
		
					
		
		</c:if> 
  

<!-- =============footer========== -->
 <%@ include file ="footer.jsp" %> 
<!-- =============footer============= -->  
   

   
   
<!--========================================-->   
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
  	   
  	   

    	 
    	  $("#staticBackdrop1").modal({
  	       backdrop: 'static',
  	       keyboard: false
  	   })
  	   
     })
     
     
     
   </script>    
  <script>
	// jquery for change the navigation background color when scroll 50px of the document/window
	    $(window).scroll(function(){
	       //$('header').toggleClass('scrolled',$(this).scrollTop() > 60)
	       $('.highlit_text').toggleClass('scrolled',$(this).scrollTop() > 60)
	        $('.search_icon').toggleClass('scrolled',$(this).scrollTop() > 60)
	       //$('.search_icon')
	    });

    </script>
    
    
    <!-- =====tooltip====== -->
    <script>
    	$(document).ready(function(){
    		$('[data-toggle="tooltip"]').tooltip();
    		$('.home').addClass("activeLink");
    	})
    </script>
  </body>
</html>