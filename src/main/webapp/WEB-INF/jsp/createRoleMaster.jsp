<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
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
		          yearRange: "-0:+2",
		          minDate: 0
		          });
		    
		        $("#datepickertodt").datepicker({
		        	changeMonth: true,
		            changeYear: true,
		            dateFormat: "dd-mm-yy",
		            yearRange: "-0:+50",
		            minDate: 0
		            });
		        
		        $("#ceasedDate").datepicker({
		        	changeMonth: true,
		            changeYear: true,
		            dateFormat: "dd-mm-yy",
		            yearRange: "-50:+1",
		            maxDate: -0
		            });
		    
		  });
		  
		 
  
 
  </script>

  

    <title>Role Master</title> 
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

            <form method="post" action="saveRoleMaster" class="needs-validation card" novalidate id="registerUser">
             
                 <div class="card-header">
	                    Role Master
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
								    		
							       			<a href="rolesReport" class="btn btn-sm"><span><i class="fas fa-times"></i></span></a>

							       </c:if>	 
						
							      </div>
							      <div class="modal-body">
							         <p><span style="color:#2ECC71;">${successMessage}</span> <span style="color:#E74C3C;"> ${errorMessage}</span> </p>
							      </div>
							      <div class="modal-footer">
							      <c:if test = "${errorMessage!= null }">
							        	<button type="button" class="btn btn-sm" data-dismiss="modal" id="closeAlertModalbtn" >Close</button>
							        	
							       </c:if>	
							       
							       <c:if test = "${successMessage!= null }">
							       		<a href="rolesReport"  class="btn btn-sm" id="closeAlertModalbtn">Close</a>
							       				
							       		
							       </c:if>	  
							     </div>
							    </div>
							  </div>
							</div>
		
			
		
				 </c:if> 
		
                   
		
	                    <div class="form-row">
	                                           
	                       <div class="col-md-6 mb-3 input-field">
	                        <label for="validationCustom02">Role Name </label>
	                         	<input type="hidden" name="roleId" class="form-control" id="roleId"  value="${roleMaster.roleId}" >                       
	                       	  
	                       		<input type="text" name="roleName" class="form-control" id="roleName" minlength="1" maxlength="50" required value="${roleMaster.roleName}" >
	                        </div>
	                       <c:if test="${roleMaster.roleId!=null && roleMaster.roleId!=''}">
	                       
	                           <div class="col-md-6 mb-3 input-field form-check roleStatus">
	                                  <label class="form-check-label" for="roleStatus">
									     Status
									  </label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									  <input type="checkbox" class="form-check-input"  name="roleStatus" id="roleStatus" value=${roleMaster.roleStatus} checked  onClick="checkForVal(this)">
								</div>

	                        </c:if>
	                    </div>
                    
                     <div class="form-row">
                       <div class="submit-form mt-4">
                     	<button class="btn btn-sm" id="submitbtn" type="submit" onclick="enableField();">Submit</button> &nbsp; 
	                    <a href=rolesReport class="btn btn-sm">Back</a>
	                    </div>	                      
	                  </div>   
	            
  				<!-- ========Sub Role GRID START============== -->   
              	        
              		  
 				<fieldset class="scheduler-border addPostInner_table" id ="initialDisclosureGrid">
                      
                     <div class="inner_post_table card">
                        <div class="schedule_header">
                        	<div class="header_text header_text_plus">
                        		<h5>Access </h5>
                        		
                        	</div>  
                        </div>
                            
                 
                   <div class="inner_table_div">
                                    
                       <table class="table table-bordered table-sm table-striped table-hover activedatasorting"  id="attrTableSubRole">
                       
                        <thead class="thead">
                            
                            <tr>
                                <th scope="col" >Sub Role Name</th>
                                <th scope="col" >Activate</th>
                                                      
                            </tr>
                            <tr><td></td><td><input type='checkbox' id='selectAll'/><label class="ml-1" for="selectAll">Select All</label></td></tr>
                        </thead>
                       
                         <tbody>
            				<c:forEach items="${roleMaster.subRoleMaster}" var="showdata" varStatus="status">
                            <tr>
	                           
		                          	<input type='hidden' class='checkbox' name="SubRoleMaster[${status.index}].subRoleId" value="${showdata.subRoleId}" readonly/>
		                          	<input type='hidden' class="form-control" name="SubRoleMaster[${status.index}].subMenuAccessId" value="${showdata.subMenuAccessId}" readonly/>
		                          	<td>
		                          	  <input type='hidden' class='checkbox' name="SubRoleMaster[${status.index}].subRoleLabel" value="${showdata.subRoleLabel}" readonly/>
		                          	 ${showdata.subRoleLabel}
		                          	</td>
		                          	
		                          	  
	                          		
		                           <c:if test="${showdata.subRoleStatus == 'Y'}">
		                           
		                           		<td><input type='checkbox' class='checkbox' name="SubRoleMaster[${status.index}].subRoleStatus"  id="checkboxStatus${status.index}" checked value="${showdata.subRoleStatus}" onClick="checkForVal(this)"></td>
		                           </c:if>
		                           
		                           <c:if test="${showdata.subRoleStatus == 'N'}">
		                           
		                         		<td> <input type='checkbox' class='checkbox' name="SubRoleMaster[${status.index}].subRoleStatus" id="checkboxStatus${status.index}" value="${showdata.subRoleStatus}"  onClick="checkForVal(this)"></td>
		                           </c:if>
		                           
		                           <c:if test="${showdata.subRoleStatus == null}">
		                           
		                         		<td> <input type='checkbox' class='checkbox' name="SubRoleMaster[${status.index}].subRoleStatus"  id="checkboxStatus${status.index}" value="${showdata.subRoleStatus}"  onClick="checkForVal(this)"></td>
		                           </c:if>
                          </tr>
			              </c:forEach>
	                          	

                        </tbody>
                      
                    </table>
                   </div>
				</div>
  			</fieldset>
          
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
        	$('.roleMaster').addClass("activeLink");
        	$('.highlightBtn').focus();
        	
        	//=====sidemenu Opened======
    		//$("#check").prop("checked",true);
        	 
    	})
    </script>
    
    <script>

	/* $("#post_modal").on('shown.bs.modal', function() {
	        // not setting focus to submit button
	        alert("highlightBtn----<<<<<");
	        $("#highlightBtn").focus();
	  });*/
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
	
	$('#registerUser').validate({
	    rules: {
	    	remarks: {
	           maxlength: 1400
	        },
	        email: {
	        	minlength: 5,
	        	maxlength: 150,
	            required: true,
	            email: true
	        },
	        mobileNo: {
	            maxlength: 10,
	            minlength: 10,
	            digits: true,
	            required: true
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




 $(document).ready(function(){
	
			
	 $("#selectAll").click(function(){
		  var status=$('#roleStatus').val();
	        //$("input[type=checkbox]").prop('checked', $(this).prop('checked'));
	       	//$("input[type=checkbox]").prop('checked', $(this).prop('checked'));
	      
	       if ($(this).prop('checked')==true )
	    	{
	    	   var id=0;
	    	   
	    	   $('#attrTableSubRole tbody tr').each(function(index1){

			  		 $("#checkboxStatus"+id).prop("checked", true);
			  		 $('#checkboxStatus'+id).val("Y");
					  
					    id=id+1;
				})
				
				 $("#selectAll").prop("checked", true);
		  		 $('#selectAll').val("Y");
	    	   
	    	}
	       else
	        {

			   var id=0;
	    	   
	    	   $('#attrTableSubRole tbody tr').each(function(index1){

			  		 $("#checkboxStatus"+id).prop("checked", false);
			  		 $('#checkboxStatus'+id).val("N");
					  
					    id=id+1;
				})
				
				 $("#selectAll").prop("checked", false);
		  		 $('#selectAll').val("N");
	    	   
	        }
	      
	      
	      

	});

 });
 
 function checkForVal(data){
	 
	 if($(data).prop("checked") == true){
		// alert("Y");
		 $(data).val("Y");
		 }else{
			// alert("N"); 
			 $(data).val("N");
		 }
	 
 }
			  
</script>	

 <script>  
function PageLoad()
{

		
}

</script>

 
<script>


$(window).load(function() {
    $("#closeAlertModalbtn").focus();
});


function pasteFunction(data) {
return false;
}

function fieldNumberCheck(data,length) {

	//alert(data+" & "+event.charCode);
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

function pasteOnlyNumbers(event,length) {
		
	
	  if (event.type == "paste") {
		 
	    var clipboardData = event.clipboardData || window.clipboardData;
	    var pastedData = clipboardData.getData('Text');
	    //alert("pastedData="+pastedData);
	    if(pastedData.indexOf(".")>0)
	    {
	    	alert("Decimal value is not allowed."); 
	    	event.preventDefault();
		    	return
	    }
	    
	    if(pastedData.length>(length+1))
	    	{
	    	alert("Value should be less than or equal to "+length+1+" digit."); 
	    	  event.preventDefault();
	    	return
	    	}
	    if (isNaN(pastedData)) {
	      event.preventDefault();
	     alert("Please enter only number value");
	      return

	    } else {
	    	//alert("else");
	      return;
	    }
	  }
	 
	}
	
function pasteOnlyDecimal(event,length) {
	
	
	  if (event.type == "paste") {
		 
	    var clipboardData = event.clipboardData || window.clipboardData;
	    var pastedData = clipboardData.getData('Text');
	    //alert("pastedData="+pastedData);
	    var i=pastedData.indexOf(".");
	    if (i>0)
	    	{
	    		//alert("first ="+i);
	    		var j=pastedData.indexOf(".",i+1);
	    		if(j>0)
	    			{
	    			//alert("second ="+j);
	    			alert("Invalid Value"); 
	    	    	event.preventDefault();
	    		    	return
	    			}
	    	
	    	}
	    
	  
	    
	    if(pastedData.length>length)
	    	{
	    	alert("Value should be less than or equal to "+length+" digit."); 
	    	  event.preventDefault();
	    	return
	    	}
	    if (isNaN(pastedData)) {
	      event.preventDefault();
	     alert("Please enter only number value");
	      return

	    } else {
	    	//alert("else");
	    	
	      return;
	    }
	  }
	 
	}

</script>
  </body>
</html>