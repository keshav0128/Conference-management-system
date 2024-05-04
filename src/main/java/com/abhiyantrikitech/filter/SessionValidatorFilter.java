package com.abhiyantrikitech.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.abhiyantrikitech.model.LoginMaster;;

@Component


public class SessionValidatorFilter implements Filter  {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
  
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        
        HttpSession session=req.getSession(false); 

        //System.out.println(".............SessionValidatorFilter.............");
        //!req.getRequestURI().equals("/login")
        if(!req.getRequestURI().equals("/instruction") &&!req.getRequestURI().equals("/") && !req.getRequestURI().equals("/backOffice") &&
        		!req.getRequestURI().equals("/loginAzadi") && !req.getRequestURI().equals("homeAzadi") && 
        		!req.getRequestURI().equals("/home") && !req.getRequestURI().equals("/getCaptcha") && !req.getRequestURI().equals("/getAYTCaptcha") &&
        		!req.getRequestURI().equals("/validLogin") &&!req.getRequestURI().equals("/createConference") &&
        		!req.getRequestURI().equals("/downloadFile/") && !req.getRequestURI().equals("/saveResourcePersonMaster") &&
        		!req.getRequestURI().equals("/editResourcePersonMasterOnRework") && !req.getRequestURI().equals("/quiz-landing") &&
        		!req.getRequestURI().equals("/student-feedback-link") && !req.getRequestURI().equals("/feedback-save") &&
        		!req.getRequestURI().equals("/registerApplicantDetail") && !req.getRequestURI().equals("/saveApplicantDetail") &&
        		!req.getRequestURI().equals("/registerEvaluatorDetail") && !req.getRequestURI().equals("/saveEvaluatorDetail") &&
        		!req.getRequestURI().equals("/registerRPAzadiDetail") && !req.getRequestURI().equals("/saveRPDetailAjadi") &&
				!req.getRequestURI().equals("/registerCollegeDetail") && !req.getRequestURI().equals("/saveCollegeDetail") &&
        		!req.getRequestURI().equals("/registerProfessionalDetail") && !req.getRequestURI().equals("/saveProfessionalDetail") &&
				!req.getRequestURI().equals("/editEvaluatorMasterOnRework") && !req.getRequestURI().equals("/editRPAjadiOnRework") &&
        		!req.getRequestURI().equals("/student-quiz-link") && !req.getRequestURI().equals("/quiz-save") && 
        		!req.getRequestURI().equals("/getQuestions") && !req.getRequestURI().equals("/downloadRPFile") &&
        		!req.getRequestURI().equals("/forgetPassword") && !req.getRequestURI().equals("/generateOtp") && 
        		!req.getRequestURI().equals("/validateOtp") && !req.getRequestURI().equals("/lms/updatePayment") &&
        		!req.getRequestURI().equals("/generateOtp1") && !req.getRequestURI().equals("/validateOtp1") &&
        		!req.getRequestURI().equals("/generateOtpRP") && !req.getRequestURI().equals("/generateOtpMobileWithoutCheck") && 
        		!req.getRequestURI().equals("/generateOtpMobile") && !req.getRequestURI().equals("/validateOtpMobile") &&
        		(!req.getRequestURI().toLowerCase().contains(".css")) && (!req.getRequestURI().toLowerCase().contains(".jpg")) &&
        		(!req.getRequestURI().toLowerCase().contains(".png")) &&(!req.getRequestURI().toLowerCase().contains(".gif")) &&
        		(!req.getRequestURI().toLowerCase().contains(".js")) && (!req.getRequestURI().toLowerCase().contains(".")) && 
        		!req.getRequestURI().equals("/RegisterForQuiz") && !req.getRequestURI().equals("/RegisterForEssay") && !req.getRequestURI().equals("/CommonRegister")&& 
        		!req.getRequestURI().equals("/loginAzadiQuiz") && !req.getRequestURI().equals("/getActiveStudyMaterialMasListWithoutLogin") 
        		&& !req.getRequestURI().equals("/quizInstruction") && !req.getRequestURI().equals("/essayInstruction") && 
        		!req.getRequestURI().equals("/loginAzadiEssay") && !req.getRequestURI().equals("/quickregister")
        		&& !req.getRequestURI().equals("/saveFestStudentDetail") && !req.getRequestURI().equals("/generateOtpMobileWithoutCheckFest")
        		){
        	
        	/*if(req.getRequestURI().matches(".*[css|jpg|png|gif|js].*")){
        	    chain.doFilter(request, response);
        	    //return;
        	}*/
        	
        	try{
		        if(session!=null && session.getAttribute("loginMaster") !=null){
		        	chain.doFilter(request, response);
		        }else{
		        	System.out.println("<<<<<<<<<<<Invalid>>>>>>>><><>"+req.getRequestURI());
		        	res.sendError(401, "Unauthorized access");  
		        	return;		        	
		        }
        	}catch(Exception e){
        		throw e;
        	}
        
        }else{
        	chain.doFilter(request, response);
        }
        
       
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
