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

    <title>System Setting</title> 
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
     

              <form method="post" action="saveSystemSetting" class="needs-validation card" novalidate id="registerUser" enctype="multipart/form-data">
             
	                <div class="card-header">
	                    System Setting
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
							        	 <a href="getSystemSettingList"  class="btn btn-sm"><span><i class="fas fa-times"></i></span></a>
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
							        	 <a href="getSystemSettingList"  class="btn btn-sm" id="closeAlertModalbtn">Close</a>
							       </c:if>	       
							      </div>
							    </div>
							  </div>
							</div>
		
			
		
		</c:if> 
		
                   
		
                    <div class="form-row">
                   
                       <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Company Name<span>*</span></label>
                         <input type="hidden" name="id" class="form-control" id="holidayId" minlength="1" maxlength="200" value="${systemSetting.id}" >
                         <input type="text" name="companyName" class="form-control" id="companyName" minlength="1" maxlength="150" value="${systemSetting.companyName}" required >
                      </div>  
                                          
                       <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">SMTP Host<span>*</span></label>
                             <input type="text" name="smtpHost"   class="form-control form-control-sm" id="smtpHost" minlength="1" maxlength="50" value="${systemSetting.smtpHost}">
                       </div>
                       
                       <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">SMTP Port<span>*</span></label>
                         <input type="text" name="smtpPort" class="form-control" id="smtpPort" minlength="1" maxlength="10" value="${systemSetting.smtpPort}" onkeypress="return fieldNumberCheck(this,10)" onpaste="return pasteFunction(this)" >
                      </div>
                    
                    </div>
  
                    <!-- ================================= -->
                    <div class="form-row">
                   
                                            
                       <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">SMTP User Name<span>*</span></label>
                             <input type="text" name="smtpUserName"   class="form-control form-control-sm" id="smtpUserName" minlength="1" maxlength="100" value="${systemSetting.smtpUserName}">
                       </div>
                       
                       <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">SMTP Password<span>*</span></label>
                         <input type="text" name="smtpPassword" class="form-control" id="smtpPassword" minlength="1" maxlength="50" value="${systemSetting.smtpPassword}"  >
                      </div>  
                    
                     <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Email From<span>*</span></label>
                         <input type="text" name="emailFrom" class="form-control" id="emailFrom" minlength="1" maxlength="150" required value="${systemSetting.emailFrom}"  >
                      </div>  
                    
                    </div>
  
                    <!-- ================================= -->
                    <div class="form-row">
                   
                       <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">SMS Sender<span>*</span></label>
                         <input type="text" name="smsSender" class="form-control" id="smsSender" minlength="1" maxlength="50" required value="${systemSetting.smsSender}"  >
                      </div> 
                      
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Program Name<span>*</span></label>
                         <input type="text" name="programName" class="form-control" id="programName" minlength="1" maxlength="150" required value="${systemSetting.programName}"  >
                      </div> 
                      
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Quiz Marks Limit<span>*</span></label>
                         <input type="text" name="quizMarksLimit" class="form-control" id="quizMarksLimit" minlength="1" maxlength="3" required value="${systemSetting.quizMarksLimit}" onkeypress="return fieldNumberCheck(this,3)" onpaste="return pasteFunction(this)" >
                      </div> 
                    
                    </div>
  
                 <!-- ================================= -->
                    <div class="form-row">
                   
                     <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Issuing Authority 1 Name</label>
                         <input type="text" name="issueAuthName1" class="form-control" id="issueAuthName1" minlength="1" maxlength="150"  value="${systemSetting.issueAuthName1}"  >
                      </div> 
                      
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Issuing Authority 1 Sign</label><a href="downloadTemplateFile/${systemSetting.issueAuthNameSign1}">${systemSetting.issueAuthNameSign1}</a>
                         <input type="file" name="issueAuthNameSign1Multipart" class="form-control" id="issueAuthNameSign1Multipart" minlength="1" maxlength="150"  value="${systemSetting.issueAuthNameSign1Multipart}"  >
                      </div> 
                      
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Issuing Authority 1 Designation</label>
                         <input type="text" name="issueAuthDesignation1" class="form-control" id="issueAuthDesignation1" minlength="1" maxlength="150"  value="${systemSetting.issueAuthDesignation1}"  >
                      </div> 
                      
                    
                    </div>
                    
                     <!-- ================================= -->
                    <div class="form-row">
                   
                     <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Issuing Department Name<span>*</span></label>
                         <input type="text" name="departmentName" class="form-control" id="departmentName" minlength="1" maxlength="150" required value="${systemSetting.departmentName}"  >
                      </div> 
                      
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Issuing Department Phone<span>*</span></label>
                         <input type="text" name="departmentPhone" class="form-control" id="departmentPhone" minlength="1" maxlength="50" required value="${systemSetting.departmentPhone}"  >
                      </div> 
                      
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Issuing Department Email<span>*</span></label>
                         <input type="text" name="departmentEmail" class="form-control" id="departmentEmail" minlength="1" maxlength="150" required value="${systemSetting.departmentEmail}"  >
                      </div> 
                      
                    
                    </div>
  					
  					 <!-- ================================= -->
                    <div class="form-row">
                   
                     <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Contact Person Name<span>*</span></label>
                         <input type="text" name="contactName" class="form-control" id="contactName" minlength="1" maxlength="150" required value="${systemSetting.contactName}"  >
                      </div> 
                      
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Contact Person Department Phone<span>*</span></label>
                         <input type="text" name="contactPhone" class="form-control" id="contactPhone" minlength="1" maxlength="50" required value="${systemSetting.contactPhone}"  >
                      </div> 
                      
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Contact Person Department Email<span>*</span></label>
                         <input type="text" name="contactEmail" class="form-control" id="contactEmail" minlength="1" maxlength="150" required value="${systemSetting.contactEmail}"  >
                      </div> 
                      
                    
                    </div>
                    
                     <!-- ================================= -->
                    <div class="form-row">
                    
                    <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Contact Person Designation<span>*</span></label>
                         <input type="text" name="contactDesignation" class="form-control" id="contactDesignation" minlength="1" maxlength="150" required value="${systemSetting.contactDesignation}"  >
                      </div> 
                   
                     <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Issuing Authority 2 Name<span>*</span></label>
                         <input type="text" name="issueAuthName2" class="form-control" id="issueAuthName2" minlength="1" maxlength="150" required value="${systemSetting.issueAuthName2}"  >
                      </div> 
                      
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Issuing Authority 2 Sign<span>*</span></label><a href="downloadTemplateFile/${systemSetting.issueAuthNameSign2}">${systemSetting.issueAuthNameSign2}</a>
                         <input type="file" name="issueAuthNameSign2Multipart" class="form-control" id="issueAuthNameSign2Multipart" minlength="1" maxlength="150"  value="${systemSetting.issueAuthNameSign2Multipart}"  >
                      </div> 
                      
                      
                      
                    
                    </div>
                      <!-- ================================= -->
					  
	                    <div class="form-row">
	                   
	                    <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Issuing Authority 2 Designation<span>*</span></label>
                         <input type="text" name="issueAuthDesignation2" class="form-control" id="issueAuthDesignation2" minlength="1" maxlength="150" required value="${systemSetting.issueAuthDesignation2}"  >
                      	</div> 
                      	
                      	  <div class="col-md-4 mb-2 input-field">
	                        <label for="validationCustom02">Dean Name<span>*</span></label>
	                         <input type="text" name="deanName" class="form-control" id="deanName" minlength="1" maxlength="150" required value="${systemSetting.deanName}"  >
	                      </div> 
                      
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Dean Designation<span>*</span></label>
                         <input type="text" name="deanDesignation" class="form-control" id="deanDesignation" minlength="1" maxlength="150" required value="${systemSetting.deanDesignation}"  >
                      </div> 
                      	
                      	
	                    </div>
                    
                     <!-- ================================= -->
                     
                          
                    <div class="form-row">
                   
                         
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Dean Phone<span>*</span></label>
                         <input type="text" name="deanPhone" class="form-control" id="deanPhone" minlength="1" maxlength="50" required value="${systemSetting.deanPhone}"  >
                      </div> 
                      
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Dean Email<span>*</span></label>
                         <input type="text" name="deanEmail" class="form-control" id="deanEmail" minlength="1" maxlength="150" required value="${systemSetting.deanEmail}"  >
                      </div> 
                      
                       <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Dean Sign<span>*</span></label><a href="downloadTemplateFile/${systemSetting.deanSign}">${systemSetting.deanSign}</a>
                         <input type="file" name="deanSignMultipart" class="form-control" id="deanSignMultipart" minlength="1" maxlength="150"  value="${systemSetting.deanSignMultipart}"  >
                      </div> 
                      
                    
                    </div>
                    
                    <!-- ================================= -->
                     
                          
                    <div class="form-row">
                   
                     
                      
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Submission Email</label>
                         <input type="text" name="submissionEmailId" class="form-control" id="submissionEmailId" minlength="1" maxlength="150" value="${systemSetting.submissionEmailId}"  >
                      </div> 
                      
                      <div class="col-md-4 mb-2 input-field">
	                          <label for="">Subject name<span>*</span></label>
	                                	<select class="form-select" name="subjectId" id="subjectId"  required value="${systemSetting.subjectId}" >
				                        	<option value="">Choose...</option>
											<c:forEach items="${subjectList}" var="var1" varStatus="status"> 
											<c:if test="${var1.key==systemSetting.subjectId}">
					                   		  <option value="${var1.key}" selected>${var1.value}</option>	
					                   		  </c:if>
					                   		  <c:if test="${var1.key!=systemSetting.subjectId}">
					                   		  <option value="${var1.key}">${var1.value}</option>	
					                   		  </c:if>		                          
					                         </c:forEach>
				                    </select>             
		                   
		                   
		                   
		                   </div>
                      
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Essay Submission Due In Hrs<span>*</span></label>
                         <input type="text" name="essaySubmitDueDateInHrs" class="form-control" id="essaySubmitDueDateInHrs" minlength="1" maxlength="4" required value="${systemSetting.essaySubmitDueDateInHrs}" onkeypress="return fieldNumberCheck(this,4)" onpaste="return pasteFunction(this)" >
                      </div> 
                      
                    
                    </div>
                     <!-- ================================= -->
                    
                     
                     <div class="form-row">  
	                    <div class="submit-form mt-4">
	                      <button class="btn btn-sm" id="submitbtn" type="submit">Submit</button> &nbsp;	                     
	                      <a href="getSystemSettingList" class="btn btn-sm">Back</a>
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
        	$('.systemConfiguration').addClass("activeLink");
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
	    	postprice: {
	            minlength: 1,
	            required: true,
	            money: true,
                maxlength: 10
	        },
	        email: {
	        	minlength: 5,
	        	maxlength: 200,
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
	 $('#issueAuthNameSign1Multipart').on('change', function() { 
  	  
		 var fileInput = 
		        document.getElementById('issueAuthNameSign1Multipart');      
		    var filePath = fileInput.value;  
		    // Allowing file type
		    var allowedExtensions = 
            /(\.jpg|\.jpeg|\.png|\.gif)$/i;
		      
		    if (!allowedExtensions.exec(filePath)) {
		        newAlert('Invalid Issuing Authority Sign 1 file type. File should be in jpg/jpeg/png/gif format.',"");
		        $('#issueAuthNameSign1Multipart').val("");
		        return false;
		    } 
		    
		    var specialChars = "#%&?";
           if (checkSpecialCharacter(filePath,specialChars)) {
           	newAlert("Issuing Authority Sign 1 file should not contain special characters ie #%&?","");
               $('#issueAuthNameSign1Multipart').val("");
           } 
		 
		 var file_length= document.getElementById("issueAuthNameSign1Multipart").value.length ;
    	
    	if (file_length>150)
    		{
    		 newAlert("Issuing Authority Sign 1 File Name should be less than 150 character.",""); 
       		 $('#issueAuthNameSign1Multipart').val("");
    		}
    	
    	const size =  
           (this.files[0].size / 1024 / 1024).toFixed(2); 

        if (size == 0 ) { 
        	newAlert("Issuing Authority Sign 1 File can not empty",""); 
        	$('#issueAuthNameSign1Multipart').val("");
        }
        
        if (size > 10 ) { 
            newAlert("Issuing Authority Sign 1 File must be less than 10 MB",""); 
            $('#issueAuthNameSign1Multipart').val("");
        }
        
    }); 
	});	



$(document).ready(function(){
	 $('#issueAuthNameSign2Multipart').on('change', function() { 
  	  
		 var fileInput = 
		        document.getElementById('issueAuthNameSign2Multipart');      
		    var filePath = fileInput.value;  
		    // Allowing file type
		    var allowedExtensions = 
            /(\.jpg|\.jpeg|\.png|\.gif)$/i;
		      
		    if (!allowedExtensions.exec(filePath)) {
		        newAlert('Invalid Issuing Authority Sign 2 file type. File should be in jpg/jpeg/png/gif format.',"");
		        $('#issueAuthNameSign2Multipart').val("");
		        return false;
		    } 
		    
		    var specialChars = "#%&?";
           if (checkSpecialCharacter(filePath,specialChars)) {
           	newAlert("Issuing Authority Sign 2 file should not contain special characters ie #%&?","");
               $('#issueAuthNameSign2Multipart').val("");
           } 
		 
		 var file_length= document.getElementById("issueAuthNameSign1Multipart").value.length ;
    	
    	if (file_length>150)
    		{
    		 newAlert("Issuing Authority Sign 2 File Name should be less than 150 character.",""); 
       		 $('#issueAuthNameSign2Multipart').val("");
    		}
    	
    	const size =  
           (this.files[0].size / 1024 / 1024).toFixed(2); 

        if (size == 0 ) { 
        	newAlert("Issuing Authority Sign 2 File can not empty",""); 
        	$('#issueAuthNameSign2Multipart').val("");
        }
        
        if (size > 10 ) { 
            newAlert("Issuing Authority Sign 2 File must be less than 10 MB",""); 
            $('#issueAuthNameSign2Multipart').val("");
        }
        
    }); 
	});
	
	

$(document).ready(function(){
	 $('#deanSignMultipart').on('change', function() { 
  	  
		 var fileInput = 
		        document.getElementById('deanSignMultipart');      
		    var filePath = fileInput.value;  
		    // Allowing file type
		    var allowedExtensions = 
            /(\.jpg|\.jpeg|\.png|\.gif)$/i;
		      
		    if (!allowedExtensions.exec(filePath)) {
		        newAlert('Invalid Dean Sign file type. File should be in jpg/jpeg/png/gif format.',"");
		        $('#deanSignMultipart').val("");
		        return false;
		    } 
		    
		    var specialChars = "#%&?";
           if (checkSpecialCharacter(filePath,specialChars)) {
           	newAlert("Dean Sign file should not contain special characters ie #%&?","");
               $('#deanSignMultipart').val("");
           } 
		 
		 var file_length= document.getElementById("deanSignMultipart").value.length ;
    	
    	if (file_length>150)
    		{
    		 newAlert("Dean Sign File Name should be less than 150 character.",""); 
       		 $('#deanSignMultipart').val("");
    		}
    	
    	const size =  
           (this.files[0].size / 1024 / 1024).toFixed(2); 

        if (size == 0 ) { 
        	newAlert("Dean Sign File can not empty",""); 
        	$('#deanSignMultipart').val("");
        }
        
        if (size > 10 ) { 
            newAlert("Dean Sign File must be less than 10 MB",""); 
            $('#deanSignMultipart').val("");
        }
        
    }); 
	});

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
	
	if ("${systemSetting.issueAuthNameSign1}"==null||"${systemSetting.issueAuthNameSign1}"=='')
		{		
		//$("#issueAuthNameSign1Multipart").attr("required", true);
		}
	
	if ("${systemSetting.issueAuthNameSign2}"==null||"${systemSetting.issueAuthNameSign2}"=='')
	{		
		$("#issueAuthNameSign2Multipart").attr("required", true);
	}
	
	if ("${systemSetting.deanSign}"==null||"${systemSetting.deanSign}"=='')
	{		
		$("#deanSignMultipart").attr("required", true);
	}
	
	
	
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

function preventfieldNumber(data) {
	
 	if(event.charCode >= 48 && event.charCode <= 57)
 	{
 	return false;
 	}
 	return true;

 }
 
function checkSpecialCharacter(fileName,specialChars)
{
// var specialChars = "#%&*:<>?/{|}";

    for (j = 0; j < specialChars.length; j++) {
        if (fileName.indexOf(specialChars[j]) > -1) {
            return true;
        }

    }
    return false;
}
 
function newAlert(textMessage,icon)
{
	var icon1="";
	if (icon=="success")
		{
			icon1="success";
		}
	else
		{
			icon1="warning";
		}

	swal({
		  //title: "Good job!",
		  text: textMessage,
		  icon: icon1,
		  button: "Ok",
		  //dangerMode: true
		  closeOnClickOutside: false, // prevent close on click anywhere/outside
		  showConfirmButton: false,
		  allowOutsideClick: false,
		  allowEscapeKey: false
	 });
}

</script>
  </body>
</html>