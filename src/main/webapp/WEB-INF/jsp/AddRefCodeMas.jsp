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
   	
   	<script>
		  $( function() {
		    
			  $("#datepickerfromdt").datepicker({
		      	changeMonth: true,
		          changeYear: true,
		          dateFormat: "dd-mm-yy",
		          yearRange: "-2:+2"
		          });
		    
		        $("#datepickertodt").datepicker({
		        	changeMonth: true,
		            changeYear: true,
		            dateFormat: "dd-mm-yy",
		            yearRange: "-2:+2"
		            });
		    
		  });
  
 
  </script>

    <title>Holiday Details</title> 
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

            <form method="post" action="saveRefCodeMas" class="needs-validation card" novalidate id="registerUser">
             
                 <div class="card-header">
	                    Reference Code Master
	             </div>
	               
	             <div class="card-body">
	                
                  <c:if test = "${successMessage != null || errorMessage!= null }">
		 	
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
							        	 <a href=getRefCodeMasList"  class="btn btn-sm"><span><i class="fas fa-times"></i></span></a>
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
							        	 <a href="getRefCodeMasList"  id="closeAlertModalbtn" class="btn btn-sm">Close</a>
							       </c:if>	       
							      </div>
							    </div>
							  </div>
							</div>
		
			
		
		</c:if> 
		
                   
		
                    <div class="form-row">
                   
                       <div class="col-md-6 mb-3 input-field">
                        <label for="validationCustom02">Type</label>
                         <input type="hidden" name="refId" class="form-control" id="refId" minlength="1" maxlength="200" value="${refCodeMas.refId}" >
                          <select  class="custom-select" name="refType" id="refType" value="${refCodeMas.refType}" >		                          		
                           <option value="">Choose ...</option>
	                   		<c:forEach items="${typeList}" var="packageVar"  > 
	                          	<c:if test="${packageVar.key==refCodeMas.refType}">
	                          		<option value="${packageVar.key}" selected>${packageVar.value}</option>
		                        </c:if>
		                       	<c:if test="${packageVar.key!=refCodeMas.refType}">
	                          		<option value="${packageVar.key}">${packageVar.value}</option>
	                        	</c:if>
	                          	
	                          
	                        </c:forEach>  
				         </select> 
                      </div>  
                       
                       <div class="col-md-6 mb-3 input-field">
	                       <c:if test="${refCodeMas.refId==null||refCodeMas.refId==''}">
	                       	 <label for="validationCustom02">Add New Type</label>
	                       </c:if>
	                       <c:if test="${refCodeMas.refId!=null && refCodeMas.refId!=''}">
	                         <label for="validationCustom02">Update Type</label>
	                       </c:if>
	                          <input type="text" name="newType" class="form-control" id="newType" minlength="1" maxlength="150" value="${refCodeMas.newType}"  >
	                      </div>               
                       
                    </div>
           <!-- /////////////////////////////////////////////////////////////////////////////////// -->         
                    <div class="form-row">
                   
	                   	 <div class="col-md-6 mb-3 input-field">
	                        <label for="validationCustom02">Value 1<span>*</span></label>
	                         <input type="text" name="refVal1" class="form-control" id="refVal1" minlength="1" maxlength="150" value="${refCodeMas.refVal1}" required >
	                      </div>  
	                      
	                       <div class="col-md-6 mb-3 input-field">
	                        <label for="validationCustom02">Value 2</label>
	                          <input type="text" name="refVal2" class="form-control" id="refVal2" minlength="1" maxlength="150" value="${refCodeMas.refVal2}"  >
	                      </div>    
                       
                    </div>
            <!-- /////////////////////////////////////////////////////////////////////////////////// -->          
                    <div class="form-row">
                   
                        <div class="col-md-6 mb-3 input-field">
                        <label for="validationCustom02">Description<span>*</span></label>
                         <input type="text" name="refDesc" class="form-control" id="refDesc" minlength="1" maxlength="150" value="${refCodeMas.refDesc}" required >
                      </div> 
                      
                      <c:if test="${refCodeMas.refId!=null&&refCodeMas.refId!=''}">
	                       <div class="col-md-6 mb-3 input-field">
	                        <label for="validationCustom02">Status<span>*</span></label>
	                          <select  class="custom-select" name="refStatus" id="refStatus" value="${refCodeMas.refStatus}" required>
	                         		<option value="Active" >Active</option>
	                         		<option value="Inactive">Inactive</option>
	                       	  </select>
	                      </div>  
                      </c:if>                    
                       
                    </div>
  
           <!-- /////////////////////////////////////////////////////////////////////////////////// -->  
            <c:if test="${refCodeMas.refId!=null&&refCodeMas.refId!=''}">
            		<div class="form-row">
                   
                        <div class="col-md-6 mb-3 input-field">
                        <label for="validationCustom02">Order<span>*</span></label>
                         <input type="text" name="refOrder" class="form-control" id="refOrder" minlength="1" maxlength="4" value="${refCodeMas.refOrder}" required onkeypress="return fieldNumberCheck(this,4)" onpaste="return pasteFunction(this)">
                      </div> 
             		</div>  
             </c:if>
            <!-- /////////////////////////////////////////////////////////////////////////////////// -->      
                    
                     <div class="form-row">  
	                    <div class="submit-form mt-4">
	                      <button class="btn btn-sm" id="submitbtn" type="submit">Submit</button> &nbsp;	                     
	                      <a href="getRefCodeMasList" class="btn btn-sm">Back</a>
	                    </div>
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
    		$('#flush-collapseOne').addClass("show");
        	$('.refCodeMaster').addClass("activeLink");
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
	
	$('#registerUser').validate({
	    rules: {
	    	refType: {

	            required: function ()
	            			{
				            	var newType=$("#newType").val();			
				            	if (newType==null||newTyp=="")
				            		{
				            			return true;
				            		}
	            			
	            				var refId="${refCodeMas.refId}";
	            				
	            				if (refId!=null && refId!="")
			            		{
			            			return true;
			            		}
	            				return false;
	            			}
	        },
	        
	        pin: {
	        	    maxlength: 6,
		            minlength: 6,
		            digits: true,
		            required: true
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
 $("#refStatus").val("${refCodeMas.refStatus}");
	
		
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