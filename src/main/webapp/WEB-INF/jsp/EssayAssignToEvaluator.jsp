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

    <title>Essay Assignment</title> 
    <style type="text/css">
    .error{
    color:red;
    }
    
    .disabledbutton {
    pointer-events: none;
    opacity: 0.4;
}
    </style>
    
<link href="css/editor.css" type="text/css" rel="stylesheet"/>
<script src="js/editor.js"></script>
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
     

              <form method="post" action="updateAssignment" class="needs-validation card" novalidate id="essayWriting" enctype="multipart/form-data">
             
	                <div class="card-header">
	                    Essay Assignment
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
							        	  <c:if test="${EssayMas.reqFrom!=null && EssayMas.reqFrom!=''}">									    	
									    	<a href="${EssayMas.reqFrom}"  class="btn btn-sm"><span><i class="fas fa-times"></i></span></a>
									    </c:if>
									    
									    <c:if test="${EssayMas.reqFrom==null || EssayMas.reqFrom==''}">
									    	<a href="homeAzadi"  class="btn btn-sm"><span><i class="fas fa-times"></i></span></a>
									    </c:if>
								    	 	
							        	
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
							        	 <c:if test="${EssayMas.reqFrom!=null && EssayMas.reqFrom!=''}">									    	
									    	<a href="${EssayMas.reqFrom}"  id="closeAlertModalbtn" class="btn btn-sm">Close</a>
									    </c:if>
									    
									    <c:if test="${EssayMas.reqFrom==null || EssayMas.reqFrom==''}">
									        <a href="homeAzadi"  id="closeAlertModalbtn" class="btn btn-sm">Close</a>									    	
									    </c:if>
							       </c:if>	       
							      </div>
							    </div>
							  </div>
							</div>
		
			
		
		</c:if> 
					
					   
					   
						   <div class="form-row">
	                   
		                       <div class="col-md-4 mb-2 input-field">
		                         <label for="validationCustom02">Language</label>
		                           <input type="hidden" name="reqFrom" class="form-control" id="reqFrom" minlength="1" maxlength="100"  value="${EssayMas.reqFrom}"  >
		                         <input type="text" name="language" class="form-control fieldForDisable" id="language" minlength="1" maxlength="50"  value="${EssayMas.language}" readonly >
		                      </div> 
		                      
		                       <div class="col-md-4 mb-2 input-field">
				                        <label for="validationCustom01">Pending Essay Count<span>*</span></label>
				                        <input type="text" name="pendingForAssignCnt" class="form-control fieldForDisable" id="pendingForAssignCnt" minlength="1" maxlength="6"  value="${EssayMas.pendingForAssignCnt}" readonly>
                  
			                   </div>
			                   
			                  </div>
			                  
			                  <div class="form-row">
			                   
			                    <div class="col-md-4 mb-2 input-field">
				                        <label for="validationCustom01">No Of Essay Assign<span>*</span></label>
				                        <input type="text" name="noOfEssay" class="form-control fieldForDisable" id="noOfEssay" minlength="1" maxlength="6"  value="${EssayMas.noOfEssay}" required onkeypress="return fieldMoneyCheck(this,6)" onpaste="return pasteFunction(this)" >
                  
			                   </div>
			                   
			                  
			                   
			                    <div class="col-md-4 mb-2 input-field">
				                        <label for="validationCustom01">Assign For Evaluation<span>*</span></label>
				                        <select class="form-select" name="essayAssignTo" id="essayAssignTo"  value="${EssayMas.essayAssignTo}" >
				                        	<option value="">Choose...</option>
					                        <c:forEach items="${rpList}" var="var1" varStatus="status"> 
												<c:if test="${var1.key==EssayMas.essayAssignTo}">
						                   		  <option value="${var1.key}" selected>${var1.value}</option>	
						                   		  </c:if>
						                   		  <c:if test="${var1.key!=EssayMas.essayAssignTo}">
						                   		  <option value="${var1.key}">${var1.value}</option>	
						                   		  </c:if>
						                    </c:forEach>
					                    </select>		                                
			                   </div>
			                       
		                    </div> 
					
					
					
                    
                     <div class="form-row">  
	                    <div class="submit-form mt-4">
	                    	<button class="btn btn-sm" id="submitbtn" type="button" onClick="saveEssay();">Assign</button> &nbsp;	 
						
                    </div>
                
                  </div>
                  
                  <div id="post_moda2">
							<div id="myModal4" class="modal fade">
								<div class="modal-dialog modal-confirm modal-dialog-centered">
									<div class="modal-content">
										<div class="modal-header">
														
											<h4 class="modal-title">Are you sure?</h4>	
							                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" id="cancelbtn4">
							                	<span aria-hidden="true">&times;</span>
							                </button>
										</div>
										<div class="modal-body">
											<p> Do you want to finally submit the essay. Once submitted essay can not be edited. <br>
											    Do you want to continue ?</p>
										</div>
										<div class="modal-footer justify-content-center infor_btn">
											<button type="button" class="btn btn-sm btn-warning" data-dismiss="modal" value="No" id="cancelModel4">No</button>
											
											<button type="button" class="btn btn-sm btn-success" name="delete" value="Yes"  onclick="submitEssayForm();">Yes</button></li>
										</div>
									</div>
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
    
<script type="text/javascript">

	
function saveEssay(){


	
	if ($('#noOfEssay').val()==null||$('#noOfEssay').val()=='')
		{
			newAlert("Please add no of essay for assign","");
			return false;
		}
	
	if ($('#noOfEssay').val()>$('#pendingForAssignCnt').val())
		{
			newAlert("No of essay for assign can not greater than pending count.","");
			return false;
		}
	

	 if ($("#essayAssignTo").val()==null || $("#essayAssignTo").val()=='')
		{
		 	newAlert("Please select Evaluator.","");
			return false;
		
		}
	 
	
	$('#essayWriting').submit();
	$("#wait").css("display", "block");
}
</script>
   
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
    		
    		$('#flush-collapseEvaluator').addClass("show");
        	$('.languagewiseessayassignlist').addClass("activeLink");
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
  	   
  	    $("#cancelbtn2").click(function(){  
    		 $('#myModal2').modal('hide');
    	 })
    	 
    	  $("#cancelModel2").click(function(){    		
    		 $('#myModal2').modal('hide');
    	 })
    	 
    	   $("#cancelbtn4").click(function(){  
    		 $('#myModal4').modal('hide');
    	 })
    	 
    	  $("#cancelModel4").click(function(){    		
    		 $('#myModal4').modal('hide');
    	 })
  	   
  	   
     })
     
      function showSubmitBox ()
     {
    	
		 $("#myModal4").modal({
    	       backdrop: 'static',
    	       keyboard: false,
    	       show: true
    	   });
  	 
		$('#myModal4').modal('show');
      }
     
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
	        essayComment: {
	        	maxlength: 500
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


$(document).ready(function(){
	 $('#essayMultipartFileName').on('change', function() { 
   	  
		 var fileInput = 
		        document.getElementById('essayMultipartFileName');      
		    var filePath = fileInput.value;  
		    // Allowing file type
		    var allowedExtensions = 
		    	 /(\.jpg|\.jpeg|\.png|\.gif|\.pdf|\.doc|\.docx)$/i;
		      
		    if (!allowedExtensions.exec(filePath)) {
		        newAlert('Invalid file type. File should be in pdf format.',"");
		        $('#essayMultipartFileName').val("");
		        return false;
		    } 
		    
		    var specialChars = "#%&?";
            if (checkSpecialCharacter(filePath,specialChars)) {
            	newAlert("File should not contain special characters ie #%&?","");
                $('#essayMultipartFileName').val("");
            } 
		 
		 var file_length= document.getElementById("essayMultipartFileName").value.length ;
     	
     	if (file_length>150)
     		{
     		 newAlert("File Name should be less than 150 character.",""); 
        		 $('#essayMultipartFileName').val("");
     		}
     	
     	const size =  
            (this.files[0].size / 1024 / 1024).toFixed(2); 

         if (size == 0 ) { 
         	newAlert("File can not empty",""); 
         	$('#essayMultipartFileName').val("");
         }
         
         if (size > 20 ) { 
             newAlert("File must be less than 20 MB",""); 
             $('#essayMultipartFileName').val("");
         }
         
     }); 
	});


 
function PageLoad()
{
}
</script>

 
<script>


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
   
 <div id="wait" style="display:none;width:100%;height:100%;position:fixed;top:0%;left:0%;justify-content:center;align-items:center;background-color:rgba(0,0,0,.3);"><div style="position:absolute; left:50% ; top:50%; transform:translate(-50% , -50%); width:100px;" />
 <img src='images/loading4.gif' width="100%" height="100%"><h3 style="margin-top:.5rem; margin-left:1rem;">Processing..</h3>
 </div>
 
 <script>
$(document).ready(function(){
  $(document).ajaxStart(function(){
    $("#wait").css("display", "block");
  });
  $(document).ajaxComplete(function(){
    $("#wait").css("display", "none");
  });
});



  </script>
  </body>
</html>