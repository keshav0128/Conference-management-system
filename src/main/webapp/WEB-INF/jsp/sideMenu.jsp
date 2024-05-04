 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
 <div class="side_menu">
  
     
     <!-- <label for="check" class="hide_menu">
          <i class="fas fa-chevron-left collapse_Icon"></i>
     </label> -->
     <h2 class="logo">${sessionScope.projectName}</h2>
      
      

      
      <div class="navigation_link">
      
        <a href="${sessionScope.loginMaster.homePage}" class="home"  id="navLinks" >
            <i class="fas fa-home" title="Home" data-toggle="tooltip"></i><span>Home</span>
         </a>
         
         <!-- ======================================================================== -->
      
       
         
       
         <!-- ============================================================================= -->
		
	<div class="accordion accordion-flush" id="accordionFlushExample">
	
		  <!-- ============================================================================= -->
		  
	<c:if test = "${sessionScope.createuser!=null|| sessionScope.systemconfiguration!=null||
		sessionScope.rolecreation!=null||sessionScope.alluserlist!=null||sessionScope.refcodemaster!=null ||sessionScope.subjectmaster!=null
		||sessionScope.guidlinemaster!=null||sessionScope.studymaterialmaster!=null||sessionScope.quizconfiguration!=null||sessionScope.quizquestionmaster!=null
		||sessionScope.studentregisterquizadmin!=null||sessionScope.activeuserforinactive!=null||sessionScope.inactiveuserforactive!=null }"> 
		    
		    <div class="accordion-item accordion-item-masters" id="drpDwn">
			    <h2 class="accordion-header" id="flush-headingOne">
			      	  
			      	  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
			            	 <i class="fas fa-warehouse" title="Master" data-toggle="tooltip"></i><span>Masters</span>
				      </button>
			    </h2>
			    <div id="flush-collapseOne" class="accordion-collapse collapse " aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
			      <div class="accordion-body">
			      	
		         		
		         		<c:if test = "${ sessionScope.alluserlist!=null || sessionScope.createuser!=null  }">
					        <a href="getUserList" class="navLink userManagement" >
			           			 <i class="fas fa-long-arrow-alt-right" title="All User" data-toggle="tooltip" ></i><span>All Users List</span>
			         		</a>
		         		</c:if>
		         		
		         		
		         		
		         		<c:if test = "${ sessionScope.systemconfiguration!=null  }">
					        <a href="getSystemSettingList" class="navLink systemConfiguration" >
			           			 <i class="fas fa-long-arrow-alt-right" title="System Setting" data-toggle="tooltip" ></i><span>System Configuration</span>
			         		</a>
		         		</c:if>
		         		
		         		<c:if test = "${ sessionScope.rolecreation!=null  }">
					        <a href="rolesReport" class="navLink roleMaster" >
			           			 <i class="fas fa-long-arrow-alt-right" title="Role Creation" data-toggle="tooltip" ></i><span>Role Master</span>
			         		</a>
		         		</c:if>
		         		
		         		<c:if test = "${ sessionScope.refcodemaster!=null  }">
					        <a href="getRefCodeMasList" class="navLink refCodeMaster" >
			           			 <i class="fas fa-long-arrow-alt-right" title="Ref Code" data-toggle="tooltip" ></i><span>Ref Code Master</span>
			         		</a>
		         		</c:if>
		         		
		         	<!--	<c:if test = "${ sessionScope.subjectmaster!=null  }">
					        <a href="getSubjectMasList" class="navLink subjectMaster" >
			           			 <i class="fas fa-long-arrow-alt-right" title="Subject Master" data-toggle="tooltip" ></i><span>Subject Master</span>
			         		</a>
		         		</c:if>
		         		
		         		
		         		
		         		<c:if test = "${ sessionScope.guidlinemaster!=null  }">
					        <a href="getGuidelineMasList" class="navLink guidLineMaster" >
			           			 <i class="fas fa-long-arrow-alt-right" title="Guideline Master" data-toggle="tooltip" ></i><span>Guideline Master</span>
			         		</a>
		         		</c:if>
		         		
		         		<c:if test = "${ sessionScope.studymaterialmaster!=null  }">
					        <a href="getStudyMaterialMasList" class="navLink studyMaterialMaster" >
			           			 <i class="fas fa-long-arrow-alt-right" title="Study Material Master" data-toggle="tooltip" ></i><span>Study Material Master</span>
			         		</a>
		         		</c:if>
		         		
		         		<c:if test = "${ sessionScope.quizconfiguration!=null  }">
					        <a href="getQuizConfigurationMasterList" class="navLink quizConfigMaster" >
			           			 <i class="fas fa-long-arrow-alt-right" title="Quiz Configuration Master" data-toggle="tooltip" ></i><span>Quiz Configuration Master</span>
			         		</a>
		         		</c:if>
		         		
		         		<c:if test = "${ sessionScope.quizquestionmaster!=null  }">
					        <a href="getQuestionMasterList" class="navLink quesMaster" >
			           			 <i class="fas fa-long-arrow-alt-right" title="Quiz Question List" data-toggle="tooltip" ></i><span>Quiz Question List</span>
			         		</a>
		         		</c:if>
		         		
		         		<c:if test = "${ sessionScope.quizquestionmaster!=null  }">
					        <a href="uploadQuestion" class="navLink uploadQues" >
			           			 <i class="fas fa-long-arrow-alt-right" title="Upload Quiz Question" data-toggle="tooltip" ></i><span>Upload Quiz Question</span>
			         		</a>
		         		</c:if>
		         		
		         		<c:if test = "${ sessionScope.generatequestionpaperforsubject!=null  }">
					        <a href="generateQuizSubjectWisePage" class="navLink uploadQues" >
			           			 <i class="fas fa-long-arrow-alt-right" title="Generate Question Paper" data-toggle="tooltip" ></i><span>Generate Question Paper</span>
			         		</a>
		         		</c:if>
		         		
		         		
		         		
		         		<c:if test = "${ sessionScope.studentregisterquizadmin!=null  }">
					        <a href="registerBulkStudentDetailByAdmin" class="navLink registerBulkStudent" >
			           			 <i class="fas fa-long-arrow-alt-right" title="Add Bulk Student Register By Admin" data-toggle="tooltip" ></i><span>Student Register By Admin</span>
			         		</a>
		         		</c:if> 
		         		
		         		<c:if test = "${ sessionScope.activeuserforinactive!=null  }">
					        <a href="getActiveUserList" class="navLink activeUserList" >
			           			 <i class="fas fa-long-arrow-alt-right" title="Active User List" data-toggle="tooltip" ></i><span>Active User List</span>
			         		</a>
		         		</c:if>
		         		
		         		<c:if test = "${ sessionScope.inactiveuserforactive!=null  }">
					        <a href="getInactiveUserList" class="navLink inActiveUserList" >
			           			 <i class="fas fa-long-arrow-alt-right" title="Inactive User List" data-toggle="tooltip" ></i><span>Inactive User List</span>
			         		</a>
		         		</c:if>
		         		
		         		<c:if test = "${ sessionScope.emaillogreport!=null  }">
					        <a href="getEmailLogReport" class="navLink emaillog" >
			           			 <i class="fas fa-long-arrow-alt-right" title="Email Report" data-toggle="tooltip" ></i><span>Email Report</span>
			         		</a>
		         		</c:if> -->
		         	
			      </div>
			    </div>
			  </div>
		</c:if>
		
		<!-- =================================================================== -->
		
			<div class="accordion-item accordion-item-evaluator" id="drpDwn">
			    <h2 class="accordion-header" id="flush-headingRp">
			      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseEvaluator" aria-expanded="false" aria-controls="flush-collapseEvaluator">
			          <i class="far fa-calendar-alt" title="DP Master" data-toggle="tooltip"></i><span>Conference</span>
			      </button>
			    </h2>
			    <div id="flush-collapseEvaluator" class="accordion-collapse collapse" aria-labelledby="flush-headingRp" data-bs-parent="#accordionFlushExample">
			      <div class="accordion-body"> 
			      
		            
		            
						  <a href="createConference" class="navLink pendingEvaluatorList" >
				        	 <i class="fas fa-long-arrow-alt-right" title="Create Conference" data-toggle="tooltip" ></i><span>Create Conference</span>
				          </a>
			          
			          
						  <a href="getPendingRPAzadiDetailList" class="navLink pendingRPAzadiList" >
				        	 <i class="fas fa-long-arrow-alt-right" title="Pending Resource Person" data-toggle="tooltip" ></i><span>All Conferences</span>
				          </a>
			        
			          
			          <!--<c:if test = "${ sessionScope.languagewiseassignedlist!=null  }">
						        <a href="getLanguageWiseAssignCntList" class="navLink languagewiseessayassignlist" >
				           			 <i class="fas fa-long-arrow-alt-right" title="Language Wise Essay Count for Assignment" data-toggle="tooltip" ></i><span>Language Wise Essay Count for Assignment</span>
				         		</a>
			         </c:if>
		         		
		         		<c:if test = "${ sessionScope.essaydetaillist!=null  }">
					        <a href="getEssayMasList" class="navLink essayMaster" >
			           			 <i class="fas fa-long-arrow-alt-right" title="Essay Master" data-toggle="tooltip" ></i><span>Essay Detail List for reassign</span>
			         		</a>
		         		</c:if>
		         		
		         		<c:if test = "${ sessionScope.calculatecollegerank!=null  }">
					        <a href="calculateCollegeRankPage" class="navLink calculateCollegeRank" >
			           			 <i class="fas fa-long-arrow-alt-right" title="Calculate College Score" data-toggle="tooltip" ></i><span>Calculate College Score</span>
			         		</a>
		         		</c:if>
		         		
		         		 <c:if test = "${ sessionScope.editcollegedetail!=null  }">
					        <a href="getCollegeDetailListEdit" class="navLink collegeListEdit" >
			           			 <i class="fas fa-long-arrow-alt-right" title="College List" data-toggle="tooltip" ></i><span>College List For Modification</span>
			         		</a>
		         		</c:if>
		         		
		         		 <c:if test = "${ sessionScope.examextension!=null  }">
					        <a href="getExtensionRequireList" class="navLink examExtension" >
			           			 <i class="fas fa-long-arrow-alt-right" title="Student List" data-toggle="tooltip" ></i><span>Student List For Extension</span>
			         		</a>
		         		</c:if>
		         		
		         		 <c:if test = "${ sessionScope.studentdetaileditazadi!=null  }">
					        <a href="getStudentListEdit" class="navLink studentListEdit" >
			           			 <i class="fas fa-long-arrow-alt-right" title="Student List" data-toggle="tooltip" ></i><span>Student List For Modification</span>
			         		</a>
		         		</c:if>
		         		
		         		<c:if test = "${ sessionScope.sendregisterbulkemail!=null  }">
					        <a href="sendBulkRegisterEmailPage" class="navLink SendRegisterBulkEmailList" >
			           			 <i class="fas fa-long-arrow-alt-right" title="User List" data-toggle="tooltip" ></i><span>Send Bulk Register Email</span>
			         		</a>
		         		</c:if> 
		         		
		         		
		         		
		         		<c:if test = "${ sessionScope.quizbulkextension!=null  }">
					        <a href="quizBulkExtensionPage" class="navLink quizBulkExtension" >
			           			 <i class="fas fa-long-arrow-alt-right" title="User List" data-toggle="tooltip" ></i><span>Quiz Bulk Extension</span>
			         		</a>
		         		</c:if>
		         		
		         			<c:if test = "${ sessionScope.essaybulkextension!=null  }">
					        <a href="essayBulkExtensionPage" class="navLink essayBulkExtension" >
			           			 <i class="fas fa-long-arrow-alt-right" title="User List" data-toggle="tooltip" ></i><span>Essay Bulk Extension</span>
			         		</a>
		         		</c:if>
		         		
		         		
			         	-->
			         		
			         		
		             
			      </div>
			    </div>
			 </div>      
		
		 <!-- =================================================================== -->

			<div class="accordion-item accordion-item-rp" id="drpDwn">
			    <h2 class="accordion-header" id="flush-headingRp">
			      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseRp" aria-expanded="false" aria-controls="flush-collapseDp">
			          <i class="far fa-calendar-alt" title="DP Master" data-toggle="tooltip"></i><span>Papers</span>
			      </button>
			    </h2>
			    <div id="flush-collapseRp" class="accordion-collapse collapse" aria-labelledby="flush-headingRp" data-bs-parent="#accordionFlushExample">
			      <div class="accordion-body"> 
			      
			        
		             
			        
						  <a href="getPendingResourcePersonMasterList" class="navLink pendingResourceList" >
				        	 <i class="fas fa-long-arrow-alt-right" title="Pending Resource Person" data-toggle="tooltip" ></i><span>Submit Papers</span>
				          </a>
			       
						<a href="getResourcePersonMasterList" class="navLink allReasonPerson" >
				        	 <i class="fas fa-long-arrow-alt-right" title="All Resource Person" data-toggle="tooltip" ></i><span>All Papers</span>
				        </a>
			        
			             <a href="generateImpanelmentLetterPage" class="navLink generateImpanelment" >
			                 <i class="fas fa-long-arrow-alt-right" title="Download RP Empanelment" data-toggle="tooltip" ></i><span>All Active Papers</span>
			             </a>
		            
		             
		             
		             
			      </div>
			    </div>
			 </div> 
		    
		   <!-- ============================================================================= -->

		  <div class="accordion-item accordion-item-program" id="drpDwn">
		    <h2 class="accordion-header" id="flush-headingDp">
		      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseDp" aria-expanded="false" aria-controls="flush-collapseDp">
		          <i class="far fa-calendar-alt" title="DP Master" data-toggle="tooltip"></i><span>Announcements</span>
		      </button>
		    </h2>
		    <div id="flush-collapseDp" class="accordion-collapse collapse" aria-labelledby="flush-headingDp" data-bs-parent="#accordionFlushExample">
		      <div class="accordion-body"> 
		     
		         <a href="createProgram" class="navLink programRegistration" >
	                 <i class="fas fa-long-arrow-alt-right" title="Program Registration" data-toggle="tooltip" ></i><span>Create Email Template </span>
	             </a>
	         
		             <a href="getPendingForApprovalProgramList" class="navLink approvalPending" >
		                 <i class="fas fa-long-arrow-alt-right" title="List of Programs For Verification Pending" data-toggle="tooltip" ></i><span>All Email Template</span>
		             </a> 
	             
		             <a href="getPendingProgramList" class="navLink verificationPending" >
		                 <i class="fas fa-long-arrow-alt-right" title="List of Programs For Verification Pending" data-toggle="tooltip" ></i><span>Create Announcement</span>
		             </a> 
	            
		             <a href="getProgramListForPayment" class="navLink paymentpending" >
		                 <i class="fas fa-long-arrow-alt-right" title="Initiate Payment" data-toggle="tooltip" ></i><span>All Announcement</span>
		             </a>
	             
	             
	            <!--    <c:if test = "${ sessionScope.paymentdetails!=null  }">
		             <a href="getPendingForPaymentCompleteProgramList" class="navLink paymentDetailPending" >
		                 <i class="fas fa-long-arrow-alt-right" title="Payment Details" data-toggle="tooltip" ></i><span>Payment Details</span>
		             </a>
	             </c:if>
	          
	           <c:if test = "${ sessionScope.allprogram!=null  }">
		         <a href="getProgramList" class="navLink allProgramList" >
	                 <i class="fas fa-long-arrow-alt-right" title="All Programs" data-toggle="tooltip" ></i><span>Program List </span>
	             </a>
	          </c:if> 
	          
	           <c:if test = "${sessionScope.loginMaster.rpId!=null&&sessionScope.loginMaster.rpId!=''&&sessionScope.loginMaster.rpId!='0'}">
		         <a href="getProgramListRP" class="navLink programListRP" >
	                 <i class="fas fa-long-arrow-alt-right" title="All RP Programs" data-toggle="tooltip" ></i><span>All Program List </span>
	             </a>
	          </c:if> 
	          
	        
	            <c:if test = "${ sessionScope.uploadresults!=null  }">  
	              <a href="uploadMarksScreen" class="navLink uploadResult" >
	                 <i class="fas fa-long-arrow-alt-right" title="Upload Student Results" data-toggle="tooltip" ></i><span>Upload Quiz Result</span>
	             </a> 
	            </c:if>
	            
	           <c:if test = "${ sessionScope.feedbackgenerate!=null  }">
		             <a href="sendFeedbackPage" class="navLink generatefeedback" >
		                 <i class="fas fa-long-arrow-alt-right" title="Generate feedback" data-toggle="tooltip" ></i><span>Generate feedback</span>
		             </a>
	             </c:if>
	             
	              <c:if test = "${ sessionScope.generatecertificate!=null  }">
		             <a href="generateCertificate" class="navLink generateCertificate" >
		                 <i class="fas fa-long-arrow-alt-right" title="Generate Certificate" data-toggle="tooltip" ></i><span>Generate Certificate</span>
		             </a>
	             </c:if>	             
	             -->
		      </div>
		    </div>
		  </div>
		  
		
		   <!-- ============================================================================= -->
		
		  <div class="accordion-item accordion-item-report" id="drpDwn">
		    <h2 class="accordion-header" id="flush-headingDp">
		      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseReport" aria-expanded="false" aria-controls="
		      flush-collapseReport">
		          <i class="fas fa-download" title="DP Master" data-toggle="tooltip"></i><span>Reports</span>
		      </button>
		    </h2>
		    <div id="flush-collapseReport" class="accordion-collapse collapse" aria-labelledby="flush-headingDp" data-bs-parent="#accordionFlushExample">
		      <div class="accordion-body">
		      <!--  
		          <c:if test = "${ sessionScope.resourcepersonreport!=null  }">
			         <a href="getResourcePersonMasterListReport" class="navLink resourcePersonReport" >
		                 <i class="fas fa-long-arrow-alt-right" title="RP Report" data-toggle="tooltip" ></i><span>List of Resource Person </span>
		             </a>
	             </c:if>
	             
	             
	              <c:if test = "${ sessionScope.registeredcollegesreport!=null  }">
			         <a href="getCollegeList" class="navLink registeredCollegeReport" >
		                 <i class="fas fa-long-arrow-alt-right" title="List of Registered Colleges" data-toggle="tooltip" ></i><span>List of Registered Colleges </span>
		             </a> 
	             </c:if>
	             
	              <c:if test = "${ sessionScope.programreport!=null  }">
		              <a href="getProgramListSubjectWisePage" class="navLink programReport" >
		                 <i class="fas fa-long-arrow-alt-right" title=" All Program Subject Wise" data-toggle="tooltip" ></i><span>List of All Program Subject Wise</span>
		             </a>
	             </c:if> 
	             
	           <c:if test = "${ sessionScope.rpwiseprogramreport!=null  }">
		         <a href="getProgramListRPWisePage" class="navLink programRPReport" >
	                 <i class="fas fa-long-arrow-alt-right" title="All Programs RP Wise" data-toggle="tooltip" ></i><span>List of Programs RP Wise </span>
	             </a>
	          </c:if> 
	             
	              <c:if test = "${ sessionScope.feedbackreport!=null  }">
		             <a href="getFeedbackListPage" class="navLink feedbackReport" >
		                 <i class="fas fa-long-arrow-alt-right" title="Feedback Report" data-toggle="tooltip" ></i><span>All Feedback List Program Wise</span>
		             </a>
	             </c:if>
	             
	             <c:if test = "${ sessionScope.feedbackresponsereport!=null  }">
		             <a href="getFeedbackResponseListPage" class="navLink feedbackResponseReport" >
		                 <i class="fas fa-long-arrow-alt-right" title="Feedback Response Report" data-toggle="tooltip" ></i><span>Feedback Response Report</span>
		             </a>
	             </c:if>
	             
	             <c:if test = "${ sessionScope.participantsreport!=null  }">
		             <a href="getAllStudentList" class="navLink participantsReport" >
		                 <i class="fas fa-long-arrow-alt-right" title="List of Participants" data-toggle="tooltip" ></i><span>List of Participants</span>
		             </a>
	             </c:if>
	             
	             <c:if test = "${ sessionScope.quizresultreport!=null  }">
		             <a href="getQuizReportPage" class="navLink quizResultReport" >
		                 <i class="fas fa-long-arrow-alt-right" title="List of Participants" data-toggle="tooltip" ></i><span>All Quiz Result Program Wise</span>
		             </a>
	             </c:if>
	           --> 
	             
	             
	              
	             
		      </div>
		    </div>
		  </div>
	
	
			
			  
		</div>

		
         
         
          <!-- ============================================================================ -->
    
         
         


         


      </div>   
  </div>
  
  <!-- <script>
     $('#check').click(function(){
    	  $('.accordion-item h2').css('margin-left','220px');
    	  $('.accordion-item h2 button span').css('display','none');
     })
  </script>-->
  
 <!--  <script>
     const collapse = document.querySelector(".collapseBtn")
     
      $('#check').click(function(){
    	  collapse.classList.add("active");
      });
  </script>-->
  
  
  <!-- <script>
      const activeLink = document.querySelector(".navLink")
      
      $('#navLinks').click(function(){
    	  alert("welcome rajni...")
    	  activeLink.classList.add("activeLink");
      });
  </script>-->
  
 <!--  <script>
      $('.hide_menu').click(function(){
    	  alert("working properly...")
    	  $('.collapse_Icon').css('transform','rotate(180deg)')
      })
  </script> -->