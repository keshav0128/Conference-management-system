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
   	
   	

    <title>Conference</title> 
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
     

              <form method="post" action="saveConference" class="needs-validation card" novalidate id="registerUser" enctype="multipart/form-data">
             
	                <div class="card-header">
	                    Conference Details
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
							        	 <a href="${pageName}"  class="btn btn-sm"><span><i class="fas fa-times"></i></span></a>
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
							        	 <a href="${pageName}"  class="btn btn-sm" id="closeAlertModalbtn">Close</a>
							       </c:if>	       
							      </div>
							    </div>
							  </div>
							</div>
		
			
		
		</c:if> 
		
                   
		
                    <div class="form-row">
                   
                      
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Type<span>*</span></label>
                             <input type="hidden" name="conferenceId" class="form-control form-control-sm" id="conferenceId" value="${Conference.conferenceId}" >
                        
                             <input type="text" name="type" class="form-control form-control-sm" id="type" minlength="1" maxlength="200" value="${Conference.type}" readonly>
                       </div>
                        
                                          
                       <div class="col-md-8 mb-4 input-field">
                        <label for="validationCustom02">Name of the Conference<span>*</span></label>
                             <input type="text" name="nameOfConference" class="form-control form-control-sm" id="nameOfConference" minlength="1" maxlength="200" value="${Conference.nameOfConference}" required>
                       </div>
                       
                    
                    </div>
  
                    <!-- ================================= -->
                    <div class="form-row">
                   
                                            
                       <div class="col-md-12 mb-6 input-field">
                        <label for="validationCustom02">Acronym<span>*</span></label>
                             <input type="text" name="acronym" class="form-control form-control-sm" id="acronym" minlength="1" maxlength="200" value="${Conference.acronym}" required>
                       </div>
                    
                    </div>
  
                    <!-- ================================= -->
                    <div class="form-row">
                   
                       <div class="col-md-12 mb-6 input-field">
                        <label for="validationCustom02">Web Page<span>*</span></label>
                         <input type="text" name="webPage" class="form-control form-control-sm" id="webPage" minlength="1" maxlength="200" required value="${Conference.webPage}"  >
                      </div> 
                      
                    </div>
  
                 <!-- ================================= -->
                    <div class="form-row">
                   
                     <div class="col-md-12 mb-6 input-field">
                        <label for="validationCustom02">Venue</label>
                         <input type="text" name="venue" class="form-control form-control-sm" id="venue" minlength="1" maxlength="200"  value="${Conference.venue}"  >
                      </div> 
                      
                    
                    </div>
                    
                     <!-- ================================= -->
                    <div class="form-row">
                   
                     <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">City<span>*</span></label>
                         <input type="text" name="city" class="form-control form-control-sm" id="city" minlength="1" maxlength="150" required value="${Conference.city}"  >
                      </div> 
                      
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Country/region<span>*</span></label>
                         <input type="text" name="country" class="form-control form-control-sm" id="country" minlength="1" maxlength="50" required value="${Conference.country}"  >
                      </div> 
                      
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Estimated number of Submission<span>*</span></label>
                         <input type="text" name="estimatedNoOfSubmission" class="form-control form-control-sm" id="estimatedNoOfSubmission" minlength="1" maxlength="10" required value="${Conference.estimatedNoOfSubmission}"  onkeypress="return fieldNumberCheck(this,10)" onpaste="return pasteFunction(this)">
                      </div> 
                      
                    
                    </div>
  					
  					 <!-- ================================= -->
                    <div class="form-row">
                   
                     <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Conference Start Date<span>*</span></label>
                         <input type="date" name="startDt" class="form-control form-control-sm" id="startDt" minlength="1" maxlength="50" required value="${Conference.startDt}"  >
                      </div> 
                      
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Conference End Date<span>*</span></label>
                         <input type="date" name="endDt" class="form-control form-control-sm" id="endDt" minlength="1" maxlength="50" required value="${Conference.endDt}"  >
                      </div> 
                      
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Deadline of Paper Submission<span>*</span></label>
                         <input type="date" name="paperSubmissionDeadline" class="form-control form-control-sm" id="paperSubmissionDeadline" minlength="1" maxlength="50" required value="${Conference.paperSubmissionDeadline}"  >
                      </div> 
                      
                    
                    </div>
                    
                       <!-- ================================= -->
					  
	                    <div class="form-row">
	                   
		                    <div class="col-md-12 mb-6 input-field">
	                        <label for="validationCustom02">Area Notes<span>*</span></label>
	                        	<textarea  class="form-control form-control-sm" name="areaNote"  id="areaNote" maxlength="4000" value="${Conference.areaNote}" rows="4" cols="100" required >${Conference.areaNote}</textarea>
	                        </div> 
	                      	
                      	 	
	                    </div>
	                    
                     <!-- ================================= -->
                    <div class="form-row">
                    
                    <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Organizer<span>*</span></label>
                         <input type="text" name="organizer" class="form-control form-control-sm" id="organizer" minlength="1" maxlength="100" required value="${Conference.organizer}"  >
                      </div> 
                   
                     <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Contact Phone Number<span>*</span></label>
                         <input type="text" name="contactNo" class="form-control form-control-sm" id="contactNo" minlength="1" maxlength="10" required value="${Conference.contactNo}" onkeypress="return fieldNumberCheck(this,10)" onpaste="return pasteFunction(this)" >
                      </div> 
                      
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Your Role<span>*</span></label>
                         <input type="text" name="yourRole" class="form-control form-control-sm" id="yourRole" minlength="1" maxlength="50"  value="${Conference.yourRole}" required >
                      </div> 
                      
                      
                      
                    
                    </div>
                   
                     <!-- ================================= -->
                     
                          
                    <div class="form-row">
                   
                         
                      <div class="col-md-12 mb-6 input-field">
                        <label for="validationCustom02">Organizer Web page<span>*</span></label>
                         <input type="text" name="organizerWebPage" class="form-control form-control-sm" id="organizerWebPage" minlength="1" maxlength="200" required value="${Conference.organizerWebPage}"  >
                      </div> 
                                            
                    
                    </div>
                    
                    <!-- ================================= -->
                     
                          
                    <div class="form-row">
                   
                     
                      
                      <div class="col-md-12 mb-6 input-field">
                        <label for="validationCustom02">Any Other Information</label>
                       		<textarea  class="form-control form-control-sm" name="anyOtherDetail"  id="anyOtherDetail" maxlength="4000" value="${Conference.anyOtherDetail}" rows="4" cols="100"  >${Conference.anyOtherDetail}</textarea>
	                    </div> 
                                         
                    </div>
                    
                      <!-- ================================= -->
                     
                          
                    <div class="form-row">
                   
                     
                      
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Evaluation Parameters created by Chair activated for Jury</label>
                         <input type="text" name="evaluationParameterMarksForJury" class="form-control form-control-sm" id="evaluationParameterMarksForJury" minlength="1" maxlength="3" required value="${Conference.evaluationParameterMarksForJury}" onkeypress="return fieldNumberCheck(this,3)" onpaste="return pasteFunction(this)" >
                      </div> 
                      
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Evaluation Parameters created by Chair activated for Chair</label>
                         <input type="text" name="evaluationParameterMarksForChair" class="form-control form-control-sm" id="evaluationParameterMarksForChair" minlength="1" maxlength="3" required value="${Conference.evaluationParameterMarksForChair}" onkeypress="return fieldNumberCheck(this,3)" onpaste="return pasteFunction(this)" >
                      </div> 
                      
                                         
                    </div>
                    <!-- ================================= -->
                     
                     <fieldset class="card sub_fielfset" id="studentFieldset">
					         <legend><h6> Theme <span>*</span></h6></legend>
					         
					         <div class="card table_card">
					               <div class="card-header">
						                 <h6>Theme</h6>
						                 
						                 <div>
						                 	<c:if test="${(Conference.status==null||Conference.status==''||Conference.status=='Drafted')}">
								                 <a class="add-row" title="Add New Participants" data-toggle="tooltip" >
								                   <i class="fas fa-plus-square"></i>Add Participant
								                 </a>
							                 </c:if>
							              </div>
						                 
						           </div>      
					                 <div class="card-body" id="studTable">
					                     <table class="table table-sm table-bordered table-striped" id="attrTableStudent">
					                         <thead>
					                            <tr>
					                               <th>Sr No<span>*</span></th>
					                               <th>Sub Theme<span>*</span></th>
					                               <th></th>
					                            <tr>
					                         </thead>
					                         
					                         <tbody>
					                         <c:forEach items="${Conference.subTheme}" var="showdata" varStatus="status">
					                            <tr>
					                               <td> ${status.index + 1}</td>
					                               <td><input type="text" class="form-control form-control-sm" name="subTheme[${status.index}].name" id="subTheme[${status.index}].name" required maxlength="150" value="${showdata.name}">
					                                <input type="hidden" class="form-control form-control-sm" name="subTheme[${status.index}].subthemeId" id="subTheme[${status.index}].subthemeId" maxlength="50" value="${showdata.subthemeId}"></td>
					                               <td class="last_td"><input type="radio" name="record" class="fas fa-times check-row"  id="delete-filter" onclick="showDeleteStudentBox(${showdata.studentId});"></td>
					                            </tr>
					                         </c:forEach>
					                         </tbody>
					                     </table>
					                 </div>
					             </div>
				
					    </fieldset>
					    
				
                     
                     
                     <!-- ==================================== -->     
                    <div class="form-row" id="configRight">                   
                     
                      
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Display Review Comment To Author</label>
                        	<select  class="form-control form-control-sm" name="displayReviewCommentToAuthor" id="displayReviewCommentToAuthor" maxlength="20" value="${extraActivity.displayReviewCommentToAuthor}"  >		                   		
		                   		<option value="" >Choose ..</option>
		                   		<option value="Yes" >Yes</option>
		                   		<option value="No">No</option>		                   	
		                   	</select>	                        
	                        
                      </div> 
                      
                      <div class="col-md-4 mb-2 input-field">
                        <label for="validationCustom02">Enable Email Notification To Author</label>
                     	<select  class="form-control form-control-sm" name="emailNotificationToAuthor" id="emailNotificationToAuthor" maxlength="20" value="${extraActivity.emailNotificationToAuthor}"  >		                   		
		                   		<option value="" >Choose ..</option>
		                   		<option value="Yes" >Yes</option>
		                   		<option value="No">No</option>		                   	
		                   	</select>	                        
	                     </div> 
                      
                                         
                    </div>
                  
                  
                     <!-- ================================= -->
                    
                     
                     <div class="form-row">  
	                    <div class="submit-form mt-4">
	                      <button class="btn btn-sm" id="submitbtnDraft" type="button" onclick="saveDraftFrom();">Save As Drafted</button> &nbsp;
	                      <button class="btn btn-sm" id="submitbtnSubmit" type="button" onclick="submitForm();">Submit</button> &nbsp;	                     
	                      <a href="home" class="btn btn-sm">Back</a>
	                    </div>
                    </div>
                
                  </div>
                  
                  
                   <div id="post_moda2">
							<div id="myModal2" class="modal fade">
								<div class="modal-dialog modal-confirm modal-dialog-centered">
									<div class="modal-content">
										<div class="modal-header">
														
											<h4 class="modal-title">Are you sure?</h4>	
							                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" id="cancelbtn2">
							                	<span aria-hidden="true">&times;</span>
							                </button>
										</div>
										<div class="modal-body">
											<p> Do you want to permanently delete student ?</p>
										</div>
										<div class="modal-footer justify-content-center infor_btn">
											<button type="button" class="btn btn-sm btn-warning" data-dismiss="modal" value="No" id="cancelModel2">No</button>
											
											<button type="button" class="btn btn-sm btn-success" name="delete" value="Yes"  onclick="deleteRowStudent()">Yes</button></li>
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

   <script>
   
   $(document).ready(function(){
       $(".add-row").click(function(){
       	
       	 var table = document.getElementById('attrTableStudent');
       		var rowLength = table.rows.length;
 // alert("rowLength=="+rowLength);
                   rowLength=rowLength-2;
           
            
            
           var markup =  
           "<tr>"+ 
           "<td>"+(rowLength+1)+"</td>"+
           "<td><input type='text' class='form-control form-control-sm' name='subTheme["+rowLength+"].name' id='subTheme["+rowLength+"].name' required maxlength='100'></td>"+
           "<td class='last_td'><input type='radio' name='record' class='fas fa-times check-row'  id='delete-filter' onclick='deleteRowStudent(0);'></td>"+     
            "</tr>";
           
           $("#attrTableStudent tbody").append(markup);
           

           
       });
});     

   
   
   function deleteRowStudent(){
		 

		 var id=$("#deleteId").val();
		 var programId="${Conference.conferenceId}";

		 var status='true';
		 if (id!=null &&id!='0'&&id!='')
			 {
			   $.ajax({type: 'GET', url:"/deleteStudent",data: {"conferenceId" : conferenceId,"subthemeId":id } ,success:function(result){
				   status=result;
			   
			   }});
			 }
		 $('#myModal2').modal('hide');
			if (status=='true')
			{
				 $("#attrTableStudent tbody").find('input[name="record"]').each(function(){
			    	 //alert("deleteRowEducation1111111")
			        if($(this).is(":checked")){
			        //	 alert("deleteRowEducation22222222")
			            $(this).parents("tr").remove();
			        }
			        $("#deleteId").val("");
			    });
			}
		   
		} 

   
   function showDeleteStudentBox (data)
   {
  	$('#deleteId').val(data);
  	 
		 $("#myModal2").modal({
  	       backdrop: 'static',
  	       keyboard: false,
  	       show: true
  	   });
	 
		$('#myModal2').modal('show');
    }
   
   function saveDraftFrom()
   {
	   if ($('#registerUser').valid())
	   {
	    $("#wait").css("display", "block");
	 	$('#requestStatus').val("Draft");	 	
	 	$('#submitbtnDraft').prop("disabled",true);
	 	$('#registerUser').submit();
	   }
   }
  
   function submitFrom()
   {
	   //var remarks=$('#verifyRemarks').val();
	   if ($('#registerUser').valid())
		   {
		    $("#wait").css("display", "block");
		 	$('#requestStatus').val("Submit");	 	
		 	$('#submitbtnSubmit').prop("disabled",true);
		 	$('#registerUser').submit();
		   }
	 	
   }
</script>


   
   </script>
  

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
    		$('#flush-collapseEvaluator').addClass("show");
        	$('.pendingEvaluatorList').addClass("activeLink");
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
  	   
     })
     
          $(window).load(function() {
    $("#closeAlertModalbtn").focus();
});
   </script>  

   <script>
   
 
   
$(document).ready(function () {
	
	$('#registerUser').validate({
	    rules: {
	    	areaNote: {
	            minlength: 1,
	            required: true,
	            maxlength: 3999
	        },
	        anyOtherDetail: {
	            minlength: 1,
	            required: false,
	            maxlength: 3999
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

<script type="text/javascript">

 
function PageLoad()
{
	
	
	
	
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