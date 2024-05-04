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

  <body onLoad="popNotification()">

<!-- =============menu============= -->  
 
   <c:if test = "${sessionScope.loginMaster.roleName=='Admin' }"> 
  <%@ include file ="sideMenu.jsp" %>
</c:if>

<!-- =============================== -->  
  
<c:if test = "${sessionScope.loginMaster.roleName=='Admin' }"> 
 <div class="content" name="fr">
</c:if>

<c:if test = "${sessionScope.loginMaster.roleName!='Admin' }"> 
 <div class="content noAdmin" name="fr">
</c:if>

  
     

      <div class="content_container">
         <div class="home_text">
          
          <div class="page_header">
             <h1>${sessionScope.projectName}</h1>
          </div>   
          
          <div class="home_content">
          
	          <div class="row">
	             <div class="col-lg-8 col-md-8 col-sm-12">
	              
	               <div class="nav_card">
	              
	                  <div class="row">
	                   <c:if test = "${sessionScope.studentregister!=null}"> 
	                    <div class="col-lg-4 col-md-6 col-sm-12 cols">
			                  <a href="registerStudentDetail" class="card shadow">
			                      <div class="card_icon">
			                          <i class="fas fa-user-plus"></i>
			                          <!-- <img src="images/home/registration_form.jpg"> -->
			                      </div>
			                      <div class="card-body">
			                        Student Register
			                      </div>
			                  </a>
			              </div>
			              </c:if>
			              <c:if test = "${sessionScope.bulkstudentregister!=null }">  
			              <div class="col-lg-4 col-md-6 col-sm-12 cols">
			                  <a href="registerBulkStudentDetail" class="card shadow">
			                      <div class="card_icon">
			                           <!-- <i class="fa fa-upload" aria-hidden="true"></i> -->
			                           <i class="fas fa-upload"></i>
			                          <!-- <img src="images/home/students.jpg">  -->
			                      </div>
			                      <div class="card-body">
			                         Bulk Student Upload
			                      </div>
			                  </a>
			              </div>
			              </c:if>
			               <c:if test = "${sessionScope.loginMaster.roleId=='5' }"> 
			            
			              <div class="col-lg-4 col-md-6 col-sm-12 cols">
			                  <a href="getCollegeWiseStudentListReport" class="card shadow">
			                      <div class="card_icon">
			                           <i class="fas fa-clipboard-list"></i>			                          
			                      </div>
			                      <div class="card-body">
			                         Registered Student List
			                      </div>
			                  </a>
			              </div>
			            </c:if>
			              
			               <c:if test = "${sessionScope.rpclameamtapproval!=null}"> 
				              <div class="col-lg-4 col-md-6 col-sm-12 cols">
				                  <a href="getPendingRpClameAmtByCollegeList" class="card shadow">
				                      <div class="card_icon">
				                           <i class="fas fa-clipboard-list"></i>
				                         
				                      </div>
				                      <div class="card-body">
				                         Pending RP's request for approval
				                      </div>
				                  </a>
				              </div>
			              </c:if>
			              
			              <c:if test = "${sessionScope.rpclameamtapproval!=null}"> 
				              <div class="col-lg-4 col-md-6 col-sm-12 cols">
				                  <a href="getAllRpClameAmtByCollegeList" class="card shadow">
				                      <div class="card_icon">
				                           <i class="fas fa-clipboard-list"></i>
				                         
				                      </div>
				                      <div class="card-body">
				                         All RP Request List
				                      </div>
				                  </a>
				              </div>
			              </c:if>
			              
			              
			              
			               <c:if test = "${sessionScope.addcollegebankdetail!=null}"> 
				              <div class="col-lg-4 col-md-6 col-sm-12 cols">
				                  <a href="addCollegeBankDetail" class="card shadow">
				                      <div class="card_icon">
				                           <i class="fas fa-clipboard-list"></i>
				                         
				                      </div>
				                      <div class="card-body">
				                         Add Bank Detail
				                      </div>
				                  </a>
				              </div>
			              </c:if>
			              
			              
			              
			              <c:if test = "${sessionScope.verifyparticipantdetail!=null }">  
			               <div class="col-lg-4 col-md-6 col-sm-12 cols">
			                  <a href="VerifyParticipantDataPage" class="card shadow">
			                      <div class="card_icon">
			                          <i class="fas fa-user-check"></i>
			                          <!-- <img src="images/azadi_mahotsav.png"> -->
			                      </div>
			                      <div class="card-body">
			                        Verify Participant Detail
			                      </div>
			                  </a>
			              </div>
			              </c:if>
			              <c:if test = "${sessionScope.displayactivestudymaterial!=null }">  
			              <div class="col-lg-4 col-md-6 col-sm-12 cols">
			                  <a href="getActiveStudyMaterialMasList" class="card shadow">
			                      <div class="card_icon">
			                          <i class="fas fa-file-download"></i>
			                          <!--<img src="images/azadi_mahotsav.png">-->
			                      </div>
			                      <div class="card-body">
			                         Download Study Material
			                      </div>
			                  </a>
			              </div>
			              </c:if>
			              <c:if test = "${sessionScope.startquizazadi!=null }">  
			               <div class="col-lg-4 col-md-6 col-sm-12 cols">
			                  <a href="startStudentQuizByLogin" class="card shadow startQuizByLoginClass">
			                      <div class="card_icon">
			                          <i class="fas fa-chalkboard-teacher"></i>
			                          <!--<img src="images/azadi_mahotsav.png">-->
			                      </div>
			                      <div class="card-body">
			                         Start Quiz
			                      </div>
			                  </a>
			              </div>
			              </c:if>
			              <c:if test = "${sessionScope.downloadcertificateazadi!=null }">  
			               <div class="col-lg-4 col-md-6 col-sm-12 cols">
			                  <a href="downloadQuizCertificate" class="card shadow">
			                      <div class="card_icon">
			                          <i class="fas fa-award"></i>
			                          <!-- <img src="images/azadi_mahotsav.png"> -->
			                      </div>
			                      <div class="card-body">
			                         Download Certificate
			                      </div>
			                  </a>
			              </div>
			              </c:if>
			              
			              <c:if test = "${sessionScope.addessay!=null }"> 
			                <div class="col-lg-4 col-md-6 col-sm-12 cols">
			                  <a href="createEssayMas" class="card shadow">
			                      <div class="card_icon">
			                          <i class="fas fa-edit"></i>
			                          <!--<img src="images/azadi_mahotsav.png">-->
			                      </div>
			                      <div class="card-body">
			                       Add Essay
			                      </div>
			                  </a>
			              </div>
			              </c:if>
			              
			               <c:if test = "${sessionScope.evaluationessay!=null }"> 
			               <div class="col-lg-4 col-md-6 col-sm-12 cols">
			                  <a href="getPendingEssayMasList" class="card shadow">
			                      <div class="card_icon">
			                         <span>${evaluatorPendingCnt}</span>
			                      </div>
			                      <div class="card-body">
			                       Pending Essay For Evaluation
			                      </div>
			                  </a>
			              </div>
			              </c:if>
			              
			             <c:if test = "${sessionScope.evaluationessay!=null }"> 
			               <div class="col-lg-4 col-md-6 col-sm-12 cols">
			                  <a href="getCompletedEssayMasList" class="card shadow">
			                      <div class="card_icon">
			                         <span>${evaluatorCompletedCnt}</span>
			                      </div>
			                      <div class="card-body">
			                       Completed Essay For Evaluation
			                      </div>
			                  </a>
			              </div>
			              </c:if>
			              
			               <c:if test = "${sessionScope.rpclameamt!=null }"> 
			               <div class="col-lg-4 col-md-6 col-sm-12 cols">
			                  <a href="getRpClameAmtListByRP" class="card shadow">
			                      <div class="card_icon">
			                          <i class="fas fa-edit"></i>
			                          <!--<img src="images/azadi_mahotsav.png">-->
			                      </div>
			                      <div class="card-body">
			                       Request college for approval
			                      </div>
			                  </a>
			                  
			              </div>
			              </c:if>
			              
			              
			              
	                 
                   </div>
                   
	          </div>
	          
	           
	      </div>
	      
	       <c:if test="${sessionScope.guidlinedisplay!=null }">
	      			<div class="col-lg-4 col-md-4 col-sm-12">
		                  <div class="notification_board card">
		                      <div class="card-header">
		                          notification board
		                      </div>
		                      <div class="card-body">
		                        <!-- <div class="marquee_content"> -->
		                        <marquee scrollamount="30" scrolldelay="800" direction= "up" onmouseover="this.stop();" onmouseout="this.start();">
		                           <!--<c:forEach items="${GuidelineMasList}" var="GuidelineMas" varStatus="status">
				                    
							            <div class="alert alert-danger" role="alert">
											  ${GuidelineMas.createDate}&nbsp;${GuidelineMas.guideline} 
										 </div>	    
								    	           
			                       </c:forEach>-->
			                       <div id="not"></div>
			                    </marquee>	
									
								<!--  </div> -->	  				  
		                      </div>
		                  </div>
		              </div>
	            </c:if>
	          
        </div>
        
        
      
       
       
  <!-- ///////////////////////////////////////////////////////////////////////// -->
       
      
      
      </div>
      
      
  </div>
  
    <c:if test = "${successMessage != null ||errorMessage != null || message !=null }">
		 	
			               <!-- Modal -->
							<div class="modal   alert_modal" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
							  <div class="modal-dialog modal-dialog-centered">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h5 class="modal-title" id="staticBackdropLabel">Message!</h5>
							        <c:if test = "${errorMessage!= null || message !=null }">
								        <button type="button" class="close" data-dismiss="modal" aria-label="Close" id="closeAlertModal">
								          <span aria-hidden="true"><i class="fas fa-times"></i></span>
								        </button>
								    </c:if>   
								    <c:if test = "${successMessage!= null }">
							        	 <a href="pageAftAction"  class="btn btn-sm"><span><i class="fas fa-times"></i></span></a>
							       </c:if>	 
						
							      </div>
							      <div class="modal-body">
							         <p><span style="color:#2ECC71;">${successMessage}</span> <span style="color:#E74C3C;"> ${errorMessage}${message} </span> </p>
							      </div>
							      <div class="modal-footer">
							      <c:if test = "${errorMessage!= null || message !=null }">
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
										        
												<li>Should be minimum 6 digit.</li>
												
												
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

<script type="text/javascript">
        var isOpera = !!window.opera || navigator.userAgent.indexOf(' OPR/') >= 0;
        // Opera 8.0+ (UA detection to detect Blink/v8-powered Opera)
        var isFirefox = typeof InstallTrigger !== 'undefined';   // Firefox 1.0+
        var isSafari = Object.prototype.toString.call(window.HTMLElement).indexOf('Constructor') > 0;
        // At least Safari 3+: "[object HTMLElementConstructor]"
        var isChrome = !!window.chrome && !isOpera;   // Chrome 1+
        var isIE = /*@cc_on!@*/false || !!document.documentMode;   // At least IE6
        function MarqueStart() {

            if (isChrome) {
                mrq.start();

            }
            else {
                mrq.setAttribute('scrollamount', 0, 0);

            }
        }
        function MarqueStop() {
            if (isChrome) {
                mrq.stop();
            }
            else {
                mrq.setAttribute('scrollamount', 2, 0);
            }
        }


    </script>
     
 <script>
     $(document).ready(function(){
    	 
    	 
    	 
    	 $(".startQuizByLoginClass").click(function(){
     		
    		 $('#wait').css('display','block');
    		
    		 
    	 })
    	 
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
    
    <script type="text/javascript">
    
    
    function popNotification(){
    	//alert('Display Column')
    	var colDtls ={};
    	var colLabelDtls ={};
    	var colLovType ={};
    	
    	 var subjectId="${sessionScope.loginMaster.subjectId}";
    	 
    	$.ajax({url:"/getActiveGuidelineMasListAjax",data: {"subjectId" :subjectId },success:function(result){	
    			var option="";
    		console.log(result.length);
    		
    		for(var guidelineMas of result){
    			console.log(guidelineMas.guideline);
    				
			 
    			option = option + "<div class='alert alert-danger' role='alert'>"+guidelineMas.guideline+"</div>";
    		};
    			
    		  $('#not').html(option);
    		},
    	error: function()
    	{
    		 
    	}});
    	
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