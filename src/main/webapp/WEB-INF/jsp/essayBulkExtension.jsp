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

    <title>Extension</title> 
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
  <body >
  
 <!-- =============menu============= -->  
 
  <%@ include file ="sideMenu.jsp" %>

<!-- =============================== -->  
  
  <div class="content" name="fr">
  
             
        <div class="content_container">


            <!-- action="uploadStudentMarks" -->
            <form method="post" action="essayBulkExtension"  class="needs-validation card" novalidate id="registerUser" enctype="multipart/form-data">
             
                 <div class="card-header">
	                    Essay Bulk Extension
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
							        	 <a href="home"  class="btn btn-sm"><span><i class="fas fa-times"></i></span></a>
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
							        	 <a href="home"  id="closeAlertModalbtn" class="btn btn-sm">Close</a>
							       </c:if>	       
							      </div>
							    </div>
							  </div>
							</div>
		
			
		
		</c:if> 
		
                   
		
                    <div class="form-row">
                   
                                           
                     
	                      
	                   <div class="col-md-6 mb-3 input-field">
	                      
	                         <label for="validationCustom02">File</label> <a href="downloadTemplateFile/userListForEssayExtensionUploadTemplate.xlsx">Template</a>                      
	                          <input type="file" name="dataFile" class="form-control" id="dataFile" minlength="1" maxlength="150" value="${dataFile}"  required>
	                   </div>               
                       
                    </div>
          
                     <div class="form-row">  
	                    <div class="submit-form mt-4">
	                      <button class="btn btn-sm" id="submitbtn" type="button" onclick="submitForm();">Submit</button> &nbsp;	                     
	                      <a href="home" class="btn btn-sm">Back</a>
	                    </div>
                    </div>
                    
                    <div class="form-row">
                    
	                   <div class="col-md-12 mb-3 input-field">
						    <label for="photofileName"><b>Log</b></b><span></span></label>	 						
							 <textarea  class="form-control" name="log"  id="log"  value="${message}" rows="4" cols="50" readonly >${message}</textarea> 
							 <div class="invalid-feedback">
	                          Please provide Log
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
   
   
   <script>
	// jquery for change the navigation background color when scroll 50px of the document/window
	    $(window).scroll(function(){
	       $('header').toggleClass('scrolled',$(this).scrollTop() > 60)
	    });

    </script>
    
    <!-- =====tooltip====== -->
    <script>
    	$(document).ready(function(){
    		$('#flush-collapseEvaluator').addClass("show");
        	$('.essayBulkExtension').addClass("activeLink");
        	$('.accordion-item-evaluator .accordion-button').addClass("active");
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
  	   
  	    $("#cancelbtn").click(function(){    		
    		
    		 $('#myModal1').modal('hide');
    		 $('#myModal2').modal('hide');
    	 })
    	 
    	  $("#cancelModel").click(function(){    		
    		
    		 $('#myModal1').modal('hide');
    		 $('#myModal2').modal('hide');
    	 })
  	   
     })
     
     $(window).load(function() {
    $("#closeAlertModalbtn").focus();
});
     
     function showDataExistBox ()
     {
    	
    	 $("#myModal2").modal({
    	       backdrop: 'static',
    	       keyboard: false,
    	       show: true
    	   });
    	 
    	 $('#myModa2').modal('show');
    	 
     }
     
     function showNoDataBox ()
     {
    	
    	 $("#myModal1").modal({
    	       backdrop: 'static',
    	       keyboard: false,
    	       show: true
    	   });
    	 
    	 $('#myModa1').modal('show');
    	 
     }
     
     
     
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
 	
		
}

function buttonStatus(data){
 	
	 var fired_button = $(data).val();
	 
	 if (fired_button=='Yes')
		 {
		 	$("#registerUser").submit();
		 }
	 
}

function submitForm(){
	
	
	dataFile=$('#dataFile').val();
	
	 if (dataFile==null||dataFile=='')
		{
			newAlert("Please select file for upload","");
			return false;
		}
	else
		{
		$("#registerUser").submit();
		$("#wait").css("display", "block");
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