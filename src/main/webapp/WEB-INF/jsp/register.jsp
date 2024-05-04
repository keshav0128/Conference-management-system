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
  </head>
    <%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", -1); //prevent caching at the proxy server
%>
  <body  onload="PageLoad();">
  
	
	
<!-- =============menu============= -->  
 
  <%@ include file ="sideMenu.jsp" %>

<!-- =============================== -->  
  
 <div class="content" name="fr">
  
   <div class="content_container">

           <form method="post" action="registerUser" class="needs-validation card" novalidate id="registerUser">
             

                <div class="card-header">
                    Register User
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
							        	 <a href="getUserList"  class="btn btn-sm"><span><i class="fas fa-times"></i></span></a>
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
							        	 <a href="getUserList"  id="closeAlertModalbtn" class="btn btn-sm">Close</a>
							       </c:if>	       
							      </div>
							    </div>
							  </div>
							</div>
		
			
		
				</c:if>
		
                  	<div class="form-row">
                   
	                       <div class="col-md-4 mb-2 input-field">
	                        <label for="validationCustom02">Full Name<span>*</span></label>
	                         <input type="hidden" name="userRequestId" class="form-control" id="userRequestId" minlength="1" maxlength="200" value="${loginMaster.userRequestId}" >
	                         <input type="hidden" name="userId" class="form-control" id="userId" minlength="1" maxlength="200" value="${loginMaster.userId}" >
	                         <input type="hidden" name="rpId" class="form-control" id="rpId" minlength="1" maxlength="200" value="${loginMaster.rpId}" >
	                        
	                         <input type="text" name="userName" class="form-control" id="userName" minlength="1" maxlength="150" value="${loginMaster.userName}" required>
		                       
	                       </div> 
                       
                       		<div class="col-md-4 mb-2 input-field">
		                        <label for="validationCustom01">Mobile Number<span>*</span><span class="user_hint"></span></label>
		                        <input type="text" name="mobileNo" id="mobileNo" class="form-control"  minlength="10" maxlength="10" value="${loginMaster.mobileNo}" required  onkeypress="return fieldNumberCheck(this,10)" onpaste="return pasteFunction(this)" >
		                        
	                       </div>
	                       
	                         <div class="col-md-4 mb-2 input-field">
		                        <label for="validationCustom01">Email</label>
		                        <input type="text" name="email" class="form-control" id="email" minlength="5" maxlength="200" required value="${loginMaster.email}"  >
		                                            
	                       </div>
	                      
                       
                    </div>
                    <!-- =============2nd row============= -->
                    
                    <div class="form-row">
                           
	                        <div class="col-md-4 mb-2 input-field">
	                        <label for="validationCustom02">Role<span>*</span></label>
	                        <select class="custom-select" name="roleId" id="roleId" value="${loginMaster.roleId}" required onchange="changeRole(this);">
	                          <option value="">Choose...</option>
									<c:forEach items="${roleName}" var="var1" varStatus="status"> 
									<c:if test="${var1.key==loginMaster.roleId}">
			                   		  <option value="${var1.key}" selected>${var1.value}</option>	
			                   		  </c:if>
			                   		  <c:if test="${var1.key!=loginMaster.roleId}">
			                   		  <option value="${var1.key}">${var1.value}</option>	
			                   		  </c:if>		                          
			                         </c:forEach> 
	                       	 </select>
	                       
                       </div>
	                       
	                      <div class="col-md-4 mb-2 input-field">
	                        <label for="validationCustom01">Login ID<span>*</span></label>
	                        <input type="text" name="loginId" class="form-control" id="loginId" minlength="1" maxlength="100" value="${loginMaster.loginId}"  required onchange="return duplicateLoginCheck(this.value);">
	                                            
	                     </div> 
	                     
	                     <c:if test="${loginMaster.userId!=null&&loginMaster.userId!=''}">
		                    <div class="col-md-4 mb-2 input-field">
		                        <label for="validationCustom01">Status<span>*</span></label>
		                        <select class="custom-select" name="status" id="status" value="${loginMaster.status}"  >
			                   		  <option value="Active" >Active</option>
			                   		  <option value="Inactive" >Inactive</option>	
	                       	 </select>
		                                            
		                   </div>
		                   </c:if>
                       
                    </div>
                   
               <!-- ==========================2nd row============= -->
                    
                      <div class="form-row">  
                      
	                     
	                   <c:if test="${loginMaster.userId!=null&&loginMaster.userId!=''}">
		                    
		                   <div class="col-md-4 mb-2 input-field">
		                        <label for="validationCustom01">Remarks</label>
		                        <input type="text" name="remarks" class="form-control" id="remarks" minlength="3" maxlength="100" value="${loginMaster.remarks}"  >
		                                            
		                   </div> 
	                   </c:if>
                     
                    </div>
                     

                <!-- ============================================= -->
                      <div class="submit-form mt-4">  	
                      		<button class="btn btn-sm" id="submitbtn" type="submit">Submit</button> &nbsp;
			        	 	<a href="getUserList"  class="btn btn-sm">Back</a>                    
			         </div>
                  
                  </div>
                     
              </form> 

           

  
   </div>
   
 </div>
  
   

<!-- =============footer========== -->
 <%@ include file ="footer.jsp" %> 
<!-- =============footer============= -->    

   
  

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
   
   
   <script>
	// jquery for change the navigation background color when scroll 50px of the document/window
	    $(window).scroll(function(){
	       $('header').toggleClass('scrolled',$(this).scrollTop() > 60)
	    });

    </script>
    
    <!-- =====tooltip====== -->
    <script>
    	$(document).ready(function(){
    		$('[data-toggle="tooltip"]').tooltip();
    		//alert("working...")
    		$('#flush-collapseOne').addClass("show");
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



   <script>
   
   function changeRole(data)
   {
	   
	   var role=$(data).val();
	  
	  
	   
   }
  
   
   
$(document).ready(function () {
	
	$('#registerUser').validate({
	    rules: {
	    	
	        email: {
	        	minlength: 5,
	        	maxlength: 200,
	            email: true
	        },
	        mobileNo: {
	            maxlength: 10,
	            minlength: 10,
	            digits: true,
	            required: true
	        }
	        
	      
	    },
	    errorElement: 'span',
        unhighlight: function(element, errorClass, validClass) {
            $(element).addClass(validClass);

        },
	});
	});
</script> 
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
     
         	 $(window).load(function() {
  	    $("#closeAlertModalbtn").focus();
  	});
   </script>  
<script>
$(document).ready(function () {

    $("#registerUser").submit(function (e) {

    	var myForm = $("#registerUser");
    	
    	//alert("myForm="+myForm.valid());
    	//Stop submitting form
    	if(myForm.valid())
    	{
        	//e.preventDefault();
        	$("#submitbtn").attr("disabled", true);
    	}
    	else
    	{
    		e.preventDefault();
        	$("#submitbtn").attr("disabled", false);
    	}
        return true;

    });
});


</script>

<script type="text/javascript">


function PageLoad()
{
	var login="${loginMaster.loginId}";	 
	if (login!=null&&login!='')
		{
			$("#loginId").prop( "disabled", true );
		}
		 
		 $("#status").val("${loginMaster.status}");
	
}

</script>

<script type="text/javascript">

 function duplicateLoginCheck(loginid){
	
	 $.ajax({url:"/duplicateLoginCheck", data : {"login" : login},success:function(result){
			if (!result)	
			{
				alert("Login ID is already exist");
				
				$("#loginId").val("");
				return false;
			}
			else
			{
				return true;
			}
			},
		error: function()
		{
			 
		}});
	}
 </script>
 
<script>

function pasteFunction(data) {
return false;
}

function fieldNumberCheck(data,length) {

	if(data.value.length>length)
	{
	return false;
	}
	
	if(event.charCode >= 48 && event.charCode <= 57)
	{
	return true;
	}
	return false;

}


function fieldMoneyCheck(data,length) {

	if(data.value.length>length)
	{
	return false;	
	}
	if((event.charCode >= 48 && event.charCode <= 57)||(event.charCode == 46 && data.value.split('.').length == 1))
	{
	return true;
	}
	return false;

}
</script>
  </body>
</html>