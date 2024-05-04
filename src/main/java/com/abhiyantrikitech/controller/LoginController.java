package com.abhiyantrikitech.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.abhiyantrikitech.util.EmailUtil;
import com.abhiyantrikitech.util.Utility;
import com.abhiyantrikitech.service.RefCodeMasService;
import com.abhiyantrikitech.service.RolesService;

import com.abhiyantrikitech.model.LoginTrack;
import com.abhiyantrikitech.model.LoginMaster;
import com.abhiyantrikitech.model.LoginMasterDTO;
import com.abhiyantrikitech.model.Logininfo;
import com.abhiyantrikitech.model.RegisterEmailStatus;
import com.abhiyantrikitech.model.SystemSetting;
import com.abhiyantrikitech.service.LoginService;
import com.abhiyantrikitech.service.LogininfoProperties;
import com.abhiyantrikitech.service.SystemSettingService;



@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	@Autowired
	SystemSettingService systemSettingService;
	@Autowired
	RefCodeMasService rf;
	@Autowired
	RolesService rolesService;
	Logininfo logininfo;
	@Value("${projectName}")	
	private String projectName;
	@Value("${serverbaseurl}")
	String serverbaseurl;
	
	
	
	@RequestMapping(value={"/",""}, method = RequestMethod.GET)
    public String showLoginPage1(ModelMap model){
		
		
		return "login";
    }
	
	@RequestMapping(value=" r", method = RequestMethod.GET)
    public String showLoginPage3(ModelMap model){
		
		return "login";
    }
	
	@RequestMapping(value="/backOffice", method = RequestMethod.GET)
    public String showLoginPage2(ModelMap model){
		
		
		return "login";
    }
	
	@RequestMapping(value="/instruction", method = RequestMethod.GET)
    public String showInstruction(ModelMap model){
	
	
		return "instruction";
    }
	
	@RequestMapping(value="/quizInstruction", method = RequestMethod.GET)
    public String quizInstruction(ModelMap model){
	
	
		return "QuizInstruction";
    }
	
	
	@RequestMapping(value="/essayInstruction", method = RequestMethod.GET)
    public String essayInstruction(ModelMap model){
	
	
		return "EssayInstruction";
    }
	/*@RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(ModelMap model){
	
	
		return "login";
    }*/
	

	@RequestMapping(value="/loginQuiz", method = RequestMethod.GET)
    public String loginQuiz(ModelMap model){
	
	
		return "loginQuiz";
    }
	
	@RequestMapping(value="/loginEssay", method = RequestMethod.GET)
    public String loginEssay(ModelMap model){
	
	
		return "loginEssay";
    }
	
	
	
	
	

	
	@RequestMapping(value="/support", method = RequestMethod.GET)
    public String supportPage(ModelMap model,HttpServletRequest request){
		
		LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
		if (loginMaster1==null)
		{
			model.put("errorMessage", "Session is expired,Please login again");
			 return "invalid-session";
		}
		
		
		return "support";
    }
	
	
				
			
				
				@RequestMapping(value="/home", method = RequestMethod.GET)
			    public String showHomePage(ModelMap model,HttpServletRequest request){
					System.out.println("----showHomePage-----");
					LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
					if (loginMaster1==null)
					{
						model.put("errorMessage", "Session is expired,Please login again");
						 return "invalid-session";
					}
					

			        return "home";
			    }
				
	
	@RequestMapping(value="/validLogin", method = RequestMethod.POST)
    public String validateLogin(@RequestParam("loginId") String loginId,@RequestParam("Password") String Password,
    		//@RequestParam("captcha") String captcha,
    		@RequestParam("mac") String mac,
    		@RequestParam("loginFrom") String loginFrom,
    		@RequestParam("loginRole") String loginRole,ModelMap model,HttpServletRequest request){
		
		System.out.println("inside LoginController.validateLogin method"+loginId +" & LoginFrom="+loginFrom+" & loginRole="+loginRole);
	
		String returnPage="backOffice";
		String homePage="home";
		
		if (loginFrom!=null)
		{
			returnPage=loginFrom;
		}
		
		LoginMaster lm;
		try {
			 if (loginId==null||loginId=="")
			 {
				 model.put("errorMessage", "Please enter login ID.");				
				 return returnPage; 
			 }
			 
			 if (Password==null||Password=="")
			 {
				 model.put("errorMessage", "Please enter Password.");
				 model.put("loginId", loginId);
				 return returnPage; 
			 }
			 
			/* if (captcha==null||captcha=="")
			 {
				 model.put("errorMessage", "Please enter Captcha.");
				 model.put("loginId", loginId);
				 return returnPage; 
			 }*/
			 
			 if (loginRole==null||loginRole==""||loginRole.equals(""))
			 {
				 model.put("errorMessage", "Please enter Login As");
				 model.put("loginId", loginId);
				 return returnPage; 
			 }
			 
			 
			 /*
			 
			 String captchaInMemory="";
			 try
			 {
			 HttpSession session=request.getSession();
			 captchaInMemory = session.getAttribute(session+"captcha_security").toString();
			 }catch(Exception e)
			 {
				 System.out.println("Geeting captcha from session="+e.getMessage());
			 }
			 
			 if (captchaInMemory.equals(""))
			 {
				 model.put("errorMessage", "Captcha Expired, Please try again.");
				 return returnPage;  
			 }
				
			 if(!captchaInMemory.equals(captcha))
			 {
				 model.put("errorMessage", "Invalid Captcha, Please try again.");
				 return returnPage; 
			 }
			 
			 */
			//////////////////////////////////////////////
						 
			String macaddr="";
			if(mac!=null&&!mac.equals(""))
			{
			macaddr=mac.replace("Physical Address. . . . . . . . . : ", ",").trim().replaceAll("\\s{1,}", "").substring(1);
			}
			
			String ip = request.getRemoteAddr();
			
			if (ip.equals("0:0:0:0:0:0:0:1"))
			{
			logininfo=LogininfoProperties.getLogininfo(loginId);
			}
			else
			{
			logininfo=LogininfoProperties.getRemoteMachineinfo(loginId,request);
			}
			
			LoginTrack loginTrack= new LoginTrack();
			
			loginTrack.setPortalName("WEB");
			loginTrack.setLoginId(loginId);
			loginTrack.setLoginMachineType("DESKTOP");
			loginTrack.setIpAddress(logininfo.getLdIp());
			loginTrack.setMacId(logininfo.getLdMacId());
			loginTrack.setMachineName(logininfo.getLdHostName());
			
			String trackId=loginService.insertLoginTrack(loginTrack);
			
			
			
			//////////////////////////////////////////////
			 
			if (returnPage.equals("login"))
			{
				lm = loginService.validateLogin(loginId,Password,"2",loginRole);
			}
			else
			{
				lm = loginService.validateLogin(loginId,Password,"3",loginRole);
			}
			
			
			/*lm = new LoginMaster();
			lm.setLoginId("deepak1");
			lm.setRoleId("1");
			lm.setRecordUpdate("true");
			*/
			
			
			
			if (lm==null)
			{
				model.put("errorMessage", "Either Login Id or password is incorrect. Please try again");
				System.out.println("Either Login Id or password is incorrect. Please try again (lm is null)==="+loginId);
				return returnPage;
			}
			
			//System.out.println("lm.getSubjectName()==="+lm.getSubjectName());
			if (lm.getRecordUpdate()=="true")
			{				
				
				System.out.println("successfully login==="+loginId+ " & roleId="+lm.getRoleId());
				
				/*if (lm.getFirstTimeLogin().equalsIgnoreCase("Yes"))
				{
					
					model.put("firstTimeLogin","Yes");
					model.put("message","Please change your password");
					//return "home";
				}*/
				
				if (lm.getNextTimePasswordChangeDate()!=null )
				{
					Date nextDate =Utility.convertDateFormatInDate(lm.getNextTimePasswordChangeDate(), "yyyy-MM-dd", "yyyy/MM/dd");
					Date todayDt=Utility.todayDate("yyyy/MM/dd");
					
					if (todayDt.compareTo(todayDt)>0)
					{					
						System.out.println("Password Expired on="+nextDate);
						model.put("firstTimeLogin","Yes");
						model.put("message","Your password has been expired, Please set new password.");
					}
					//return "home";
				}
				
				//System.out.println("======== before projectName==="+projectName);
				
				//System.out.println("lm.getSubjectId()==="+lm.getSubjectId());
				
				//if (lm.getSubjectId()==null||lm.getSubjectId().equals("")||lm.getSubjectId().equals("0"))
				//{
					lm.setLoginPage("login");
					lm.setLogoutPage("login");
					lm.setHomePage("home");
					homePage="home";
					
				/*}else if (lm.getSubjectId().equals("2")||lm.getSubjectId().equals("1")) // FLIPS
				{
					lm.setLoginPage("login");
					lm.setLogoutPage("login");
					lm.setHomePage("home");
					homePage="home";
					
					
				}
				else  // AZADI
				{
					//System.out.println(" azadi subject page");
					if (loginRole.equals("5")||loginRole.equals("7")||loginRole.equals("10"))
					{
						lm.setLoginPage("loginQuiz");
						lm.setLogoutPage("instruction");
					}
					else if (loginRole.equals("8")||loginRole.equals("9"))
					{
						lm.setLoginPage("loginEssay");
						lm.setLogoutPage("instruction");
					}
					else
					{
						lm.setLoginPage("loginQuiz");
						lm.setLogoutPage("instruction");
					}
					
					lm.setHomePage("homeAzadi");
					homePage="homeAzadi";
					
				}
				*/
				/*if (lm.getSubjectName()==null||lm.getSubjectName().equals(""))
				{
				 projectName=subjectMasService.getSubjectMasListById(lm.getSubjectId()).getSubjectName();
				}
				else
				{
					projectName=lm.getSubjectName();
				}*/
				
				System.out.println("======== after projectName==="+projectName+" & login id="+loginId);
				
				lm.setTrackId(trackId);
				
				request.getSession().setAttribute("loginMaster", lm);
				
				HashMap hm=rolesService.getRoleAccessByRoleId(lm.getRoleId());
				
				request.getSession().setAttribute("projectName", projectName);
				
				request.getSession().setAttribute("roleAccess", hm);
				
				if (hm != null)
				{
					Set keys = hm.keySet();
					Iterator i = keys.iterator();
					while (i.hasNext()) {					   
					   String keyName=(String) i.next();
					   
					   request.getSession().setAttribute(keyName, "yes");
					   
					} 
				}
				
				
			
				
				//if (request.getSession().getAttribute("evaluationessay")!=null)
				//{
				//	model.put("evaluatorPendingCnt", essayMasService.getAssignCountEssayMasList(lm.getRpId(), "Pending"));
				//	model.put("evaluatorCompletedCnt", essayMasService.getAssignCountEssayMasList(lm.getRpId(), "Completed"));
				//}
				
								
				return homePage;
			}
			else
			{
				model.put("errorMessage", "Either Login or password is wrong. Please try again");
				return returnPage;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnPage;
					
    }
	
	@RequestMapping(value="/forgetPassword", method = RequestMethod.POST)
    public String forgetPassword(ModelMap model,@RequestParam("loginId1") String loginId,
    		//@RequestParam("captcha1") String captcha,
    		@RequestParam("loginFrom") String loginFrom,@RequestParam("loginRole1") String loginRole,HttpServletRequest request){
		System.out.println("inside LoginController.forgetPassword method-"+loginId+" & loginRole-"+loginRole);
		
		LoginMaster loginMaster;
		String loginPage="login";
		try {
			
			if (loginFrom!=null && !loginFrom.equals(""))
			{
				loginPage=loginFrom;
			}
			
			if (loginId==null||loginId=="")
			 {
				 model.put("errorMessage", "Please enter Login ID.");
				 return loginPage; 
			 }
			
			if (loginRole==null||loginRole=="")
			 {
				 model.put("errorMessage", "Please enter Login As.");
				 return loginPage; 
			 }
			
			 /*if (captcha==null||captcha=="")
			 {
				 model.put("errorMessage", "Please enter Captcha.");
				 model.put("loginId", loginId);
				 return loginPage; 
			 }
			 
			 String captchaInMemory="";
			 try
			 {
			 HttpSession session=request.getSession();
			 captchaInMemory = session.getAttribute(session+"captcha_security").toString();
			 }catch(Exception e)
			 {
				 System.out.println("Geeting captcha from session="+e.getMessage());
			 }
			 
			 if (captchaInMemory.equals(""))
			 {
				 model.put("errorMessage", "Captcha Expired, Please try again.");
				 return loginPage;  
			 }
				
			 if(!captchaInMemory.equals(captcha))
			 {
				 model.put("errorMessage", "Invalid Captcha, Please try again.");
				 return loginPage; 
			 }
			 
			*/
			 if (loginPage.equals("login")||loginPage.equals("backOffice"))
			 {
				 loginMaster = loginService.getPassword(loginId,loginRole);
			 }
			 else
			 {
				 loginMaster = loginService.getPassword(loginId,loginRole);
			 }
			
			
					
			String SMSBody;
			String SMSSender;
			if (loginMaster.getRecordUpdate()=="true")
			{
				///////////////////////////////////////////////////
				SystemSetting ss=systemSettingService.getSystemSettingListById("1");
				
				/*SMSBody="Dear "+loginMaster.getUserName() +", Your password is "+loginMaster.getPassword()+" to login "+ss.getProgramName()+" Program Application. ";
				
				SMSSender=ss.getSmsSender();
				
				boolean response=Utility.sendSms(loginMaster.getMobileNo(),SMSBody,SMSSender);
				if (response)
				{
					model.put("successMessage", "Your password has been sent on your registered Email.");
					
				}
				else
				{
					model.put("errorMessage", "Something is wrong. Please try again.");
					
				}*/
				
				
				EmailUtil eu =new EmailUtil();
				eu.setMailfrom(ss.getEmailFrom());
				eu.setHost(ss.getSmtpHost());
				eu.setPassword(ss.getSmtpPassword());
				eu.setUsername(ss.getSmtpUserName());
				eu.setPort(ss.getSmtpPort());
				eu.setMailto(loginMaster.getEmail());
				
				
					
				String mailSubject="Forget Password for "+ss.getProgramName()+" Program";

				String mailBody="Dear "+loginMaster.getUserName() +",<br/> Your password is "+loginMaster.getPassword()+" to login "+ss.getProgramName()+" Program. "+
														
						"<br/>"+
						"<br/>Regards"+
						"<br/>NISM"+
						"<br/><br/>Note: This is an auto generated email. Please do not respond. ";
				
				eu.setContent(mailBody);			
				eu.setMailsubject(mailSubject);
				System.out.println(mailBody);
				String emailResponse=eu.sendMail();
				
				if (emailResponse==null||!emailResponse.equals("true"))
				{
					System.out.println("Email failed for "+loginMaster.getEmail());
					model.put("errorMessage", "Something is wrong. Please try again.");
				}
				else
				{
					model.put("successMessage", "Your password has been sent on your registered Email.");
				}
				
		
		
				//////////////////////////////////////////////////
			
				return loginPage;
			}
			else if (loginMaster.getRecordUpdate()=="notregister")
			{
				model.put("errorMessage", "This login is not active in our system. Please register");
				return loginPage;
			}
			else 
			{
				model.put("errorMessage", "Somethingh is wrong. Please try again");
				return loginPage;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginPage;
					
    }
	
	
	
	@RequestMapping(value="/changePassword", method = RequestMethod.GET)
    public String showResetPasswordPage(ModelMap model,HttpServletRequest request){
		System.out.println("----showResetPasswordPage-----");
		LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
		if (loginMaster1==null)
		{
			model.put("errorMessage", "Session is expired,Please login again");
			 return "invalid-session";
		}
        
		return "changePassword";
    }
	
	
	
	@RequestMapping(value="/resetPassword", method = RequestMethod.POST)
    public String resetPassword(ModelMap model, LoginMaster  loginMaster,HttpServletRequest request){
		//only this spacial character is allowed @#$*!_-
		//o	Should be minimum 8 digit.
		//o	Should be contain special character.
		//o	Should be alphanumeric.
		//o	Should be 1 upper case letter.
		//o	Should be 1 lower case letter.
		System.out.println("inside LoginController.resetPassword method-");
		String msg="";
		String homePage="home";
		try {
				LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
				
					if (loginMaster1==null)
					{
						model.put("errorMessage", "Session is expired,Please login again");
						 return "invalid-session";
					}
					
					homePage=loginMaster1.getHomePage();
					
					
					if (loginMaster.getPassword()==null||loginMaster.getPassword().equals(""))					
					{
						msg= "Please enter New Password.<br/>\n";
						
					}
					
					if (loginMaster.getConfirmPassword()==null||loginMaster.getConfirmPassword().equals(""))					
					{
						msg= msg+"Please enter Confirm New Password.<br/>\n";
						
					}
					
					if (msg.equals(""))
						
						{
						String password=loginService.getPassword(loginMaster1.getLoginId(),loginMaster1.getRoleId()).getPassword();
						
						if (loginMaster.getPassword().equals(password))					
						{
							msg= msg+"New Password should be different from current password.<br/>\n";
							
						}
						
											
						if (loginMaster.getPassword().trim().length()<6)					
						{
							msg= msg+"New Password should be minimum 6 character.<br/>\n";
							
						}
					
					 	//String regex = "[0-9]+"; 
						/*String regex="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#!@$*]).{8,}$";
				        
				        Pattern p = Pattern.compile(regex); 
				        Matcher m = p.matcher(loginMaster.getPassword()); 
				        
				        if(!m.matches())
				        {
				        	msg= msg+"New Password should be combination of number and character. Check Password policy.<br/>\n";
				        }*/
				        
				        if (!loginMaster.getPassword().equals(loginMaster.getConfirmPassword()))
				        {
				        	
				        	msg= msg+"New Password and Confirm New Password should be same.<br/>\n";
				        }
					}
			        
			        
			        if (!msg.equals(""))
			        {
			        	model.put("errorMessage", msg);
						loginMaster.setPassword("");
						loginMaster.setConfirmPassword("");
						
						model.put("loginMaster", loginMaster);
						return "changePassword";
			        }
				
					loginMaster.setCreatBy(loginMaster1.getLoginId());
					loginMaster.setUserId(loginMaster1.getUserId());
					
					loginMaster=loginService.resetPassword(loginMaster);
			
					if (loginMaster.getRecordUpdate()=="true")
					{
						model.put("successMessage", "Password has been updated successfully ");
						
						return "changePassword";
					}
					
					else 
					{
						model.put("errorMessage", "Error in Password updation ");
						model.put("loginMaster", loginMaster);
						return "changePassword";
					}
				
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return homePage;
    }
	

	
	
	

	@RequestMapping(value="/resetPasswordHome", method = RequestMethod.POST)
    public String resetPasswordHome(ModelMap model, LoginMaster  loginMaster,HttpServletRequest request){
		//only this spacial character is allowed @#$*!_-
		//o	Should be minimum 8 digit.
		//o	Should be contain special character.
		//o	Should be alphanumeric.
		//o	Should be 1 upper case letter.
		//o	Should be 1 lower case letter.
		System.out.println("inside LoginController.resetPasswordHome method-");
		String msg="";
		String homePage="home";
		try {
				LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
				
					if (loginMaster1==null)
					{
						model.put("errorMessage", "Session is expired,Please login again");
						 return "invalid-session";
					}
					
					homePage=loginMaster1.getHomePage();
					
					
					if (loginMaster.getPassword()==null||loginMaster.getPassword().equals(""))					
					{
						msg= "Please enter New Password.<br/>\n";
						
					}
					
					if (loginMaster.getConfirmPassword()==null||loginMaster.getConfirmPassword().equals(""))					
					{
						msg= msg+"Please enter Confirm New Password.<br/>\n";
						
					}
					
					if (msg.equals(""))
						
						{
						String password=loginService.getPassword(loginMaster1.getLoginId(),loginMaster1.getRoleId()).getPassword();
						
						if (loginMaster.getPassword().equals(password))					
						{
							msg= msg+"New Password should be different from current password.<br/>\n";
							
						}
						
											
						if (loginMaster.getPassword().trim().length()<6)					
						{
							msg= msg+"New Password should be minimum 6 character.<br/>\n";
							
						}
					
					 	//String regex = "[0-9]+"; 	
						/*String regex="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#!@$*]).{8,}$";
				        
				        Pattern p = Pattern.compile(regex); 
				        Matcher m = p.matcher(loginMaster.getPassword()); 
				        
				        if(!m.matches())
				        {
				        	msg= msg+"New Password should be combination of number and character .<br/>\n";
				        }*/
				        
				        if (!loginMaster.getPassword().equals(loginMaster.getConfirmPassword()))
				        {
				        	
				        	msg= msg+"New Password and Confirm New Password should be same.<br/>\n";
				        }
					}
			        
			        System.out.println("msg==="+msg);
			        
			        if (!msg.equals(""))
			        {
			        	model.put("errorMessage", msg);
						loginMaster.setPassword("");
						loginMaster.setConfirmPassword("");
						
						model.put("loginMaster", loginMaster);
						model.put("firstTimeLogin", "Yes");
						return homePage;
			        }
			        
				
					loginMaster.setCreatBy(loginMaster1.getLoginId());
					loginMaster.setUserId(loginMaster1.getUserId());
					
					loginMaster=loginService.resetPassword(loginMaster);
			
					if (loginMaster.getRecordUpdate()=="true")
					{
						model.put("successMessage", "Password has been updated successfully ");
						
						return homePage;
					}
					
					else 
					{
						model.put("errorMessage", "Error in Password updation ");
						model.put("loginMaster", loginMaster);
						model.put("firstTimeLogin", "Yes");
						return homePage;
					}
				
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return homePage;
    }
	
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
    public String showRegisterPage(ModelMap model,HttpServletRequest request){
		System.out.println("register");
		LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
		
		if (loginMaster1==null)
		{
			model.put("errorMessage", "Session is expired,Please login again");
			 return "invalid-session";
		};
		
		if (request.getSession().getAttribute("createuser")==null)
		{
			model.put("errorMessage", "you don't have access this functionality");
			 return loginMaster1.getLoginPage();
		}
		
		
		
		LoginMaster loginMaster= new LoginMaster();
		
		loginMaster.setStatus("Active");
		
		model.put("loginMaster", loginMaster);
		try {
			model.put("roleName", loginService.getRoleName());
			//model.put("deptName", rf.getRefCodeLov("Departments"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return "register";
    }
	
	

	
	@RequestMapping(value="/viewRegister", method = RequestMethod.POST)
	 public String viewRegister(ModelMap model,LoginMaster login,HttpServletRequest request){
		LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
		
		if (loginMaster1==null)
		{
			model.put("errorMessage", "Session is expired,Please login again");
			 return "invalid-session";
		}
			LoginMaster loginMaster= new LoginMaster();
			
			try {
				loginMaster=loginService.getLoginById(login.getLoginId(),login.getRoleId());
				
			
			model.put("loginMaster", loginMaster);
			
			model.put("roleName", loginService.getRoleName());
			//model.put("deptName", rf.getRefCodeLov("Departments"));
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return "register";
	    }
	
	@RequestMapping(value="/getUserList", method = RequestMethod.GET)
	 public String getUserList(ModelMap model,HttpServletRequest request){
			
			LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
			
			if (loginMaster1==null)
			{
				model.put("errorMessage", "Session is expired,Please login again");
				 return "invalid-session";
			}
			
			// check role access from session start
			if (request.getSession().getAttribute("alluserlist")==null)
			{
				model.put("errorMessage", "you don't have access this module");
				 return loginMaster1.getLoginPage();
			}
			// check role access end
			
			
			ArrayList ar=null;
			
			/*try {
				ar=loginService.getUserList();
			
			model.put("userList", ar);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	        return "listUser";
	    }
	
	@RequestMapping(value="/profile", method = RequestMethod.GET)
    public String showProfilePage(ModelMap model,HttpServletRequest request){
		System.out.println("----showProfilePage-----");
		
			
		try {
			LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
			
			if (loginMaster1==null)
			{
				model.put("errorMessage", "Session is expired,Please login again");
				 return "invalid-session";
			}
		   
		   else
		   {
				   model.put("loginMaster", loginMaster1);
				return "myProfile";
		   }
		
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return "myProfile";
    }
	

	
	
	
	@RequestMapping(value="/registerUser", method = RequestMethod.POST)
    public String registerUser(ModelMap model, LoginMaster  loginMaster,HttpServletRequest request){
		
		System.out.println("inside LoginController.registerUser method-"+loginMaster.getLoginId());
		LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
		if (loginMaster1==null)
		{
			model.put("errorMessage", "Session is expired,Please login again");
			 return "invalid-session";
		}
		
		if (request.getSession().getAttribute("createuser")==null)
		{
			model.put("errorMessage", "you don't have access this functionality");
			 return loginMaster1.getLoginPage();
		}
		
		
		String msg="";
		String userType="New";
		try {
			
			model.put("roleName", loginService.getRoleName());
			//model.put("deptName", rf.getRefCodeLov("Departments")); 
			
			if ((loginMaster.getUserId()==null||loginMaster.getUserId().equals(""))&& loginService.duplicateLoginCheck(loginMaster.getLoginId()))
			{
				msg="Login Id is already exist. "+"<br/>";
			}
			
			if (loginService.duplicateMobileCheck(loginMaster.getMobileNo(), loginMaster.getUserId()))
			{
				msg=msg+"Mobile No is already exist. "+"<br/>";
			}
			
			if (loginService.duplicateEmailCheck(loginMaster.getEmail(), loginMaster.getUserId()))
			{
				msg=msg+"Email is already exist. "+"<br/>";
			}
			
			System.out.println("msg=="+msg);
			
			if (msg.equals(""))
			{
				loginMaster.setCreatBy(loginMaster1.getLoginId());
				
				if(loginMaster.getUserId()==null||loginMaster.getUserId().equals(""))	
				{
					userType="New";
					loginMaster=loginService.registerUser(loginMaster);
				}
				else
				{
					userType="Existing";
					loginMaster=loginService.updateUser(loginMaster);
				}
				
				System.out.println("loginMaster.getRecordUpdate()=="+loginMaster.getRecordUpdate());
		
				if (loginMaster.getRecordUpdate().equals("true"))
				{
					
					
					//////////////////////////////////////
					if(userType.equals("New"))
					{
						try
						{
							SystemSetting ss=systemSettingService.getSystemSettingListById("1");
							
							String SMSBody;
							String SMSSender;
							String mailBody = null;
							String mailSubject=null;
									
							LoginMaster lm=loginService.getPassword(loginMaster.getLoginId(),loginMaster.getRoleId());
							
							String password=lm.getPassword();
							

							SMSBody="Dear "+lm.getUserName()+", Your login ID is "+loginMaster.getLoginId()+" and password is "+password+" to login "+ss.getProgramName()+" Program application. ";
							
							SMSSender=ss.getSmsSender();

							boolean response=Utility.sendSms(lm.getMobileNo(),SMSBody,SMSSender);
							if (response)
							{
								System.out.println("Password SMS sent successfully for-"+loginMaster.getMobileNo());
								
							}
							else
							{
								System.out.println("Password SMS sent failed for -"+loginMaster.getMobileNo());
								
							}
							System.out.println("SMS PROCESS END=="+response);
							
						    ////////////////////////////////////////////
							
							EmailUtil eu =new EmailUtil();
							eu.setMailfrom(ss.getEmailFrom());
							eu.setHost(ss.getSmtpHost());
							eu.setPassword(ss.getSmtpPassword());
							eu.setUsername(ss.getSmtpUserName());
							eu.setPort(ss.getSmtpPort());
							eu.setMailto(loginMaster.getEmail());
							
							mailSubject="Account Details for "+ss.getProgramName()+" Program.";

							mailBody="Dear "+loginMaster.getUserName() +"<br/>, Your account has been created in "+ss.getProgramName()+" Program application. Below is your login crendentials."+
									"<br/> Login ID -"+loginMaster.getLoginId()+
									"<br/> Password -"+password+
									"<br/><br/>"+
									"Regards"+
									"<br/>NISM"+
									"<br/><br/>Note: This is an auto generated email. Please do not respond. ";
							
							eu.setContent(mailBody);			
							eu.setMailsubject(mailSubject);
							
							String emailResponse=eu.sendMail();
							
							if (emailResponse==null||!emailResponse.equals("true"))
							{
								System.out.println("Email sent failed for -"+loginMaster.getEmail());
							}
							
						
						}catch (Exception e)
						{
							System.out.println("Exception in send email & sms - "+e);
						}
					
					}
					
					///////////////////////////////////////
					
					
					
					model.put("successMessage", "User Save successfully ");
					model.put("loginMaster", null);
					return "register";
				}
				
				else 
				{
					model.put("errorMessage", "Error in register ,Please contact to administrator ");
					model.put("loginMaster", loginMaster);
					
					return "register";
				}
			}
			else
			{
				model.put("errorMessage", msg);
				model.put("loginMaster", loginMaster);
				return "register";
				
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "register";
    }
	

	@RequestMapping(value="/updateProfile", method = RequestMethod.POST)
    public String myProfile(ModelMap model, LoginMaster  loginMaster,HttpServletRequest request){
		
		System.out.println("inside LoginController.myProfile method-"+loginMaster);
		String msg="";
		
		
		try {
			LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
			
			if (loginMaster1==null)
			{
				model.put("errorMessage", "Session is expired,Please login again");
				 return "invalid-session";
			}
			
			if (loginService.duplicateMobileCheck(loginMaster.getMobileNo(), loginMaster.getUserId()))
			{
				model.put("errorMessage", "Mobile No is already exists. ");
				model.put("loginMaster", loginMaster);
				return "myProfile";
			}
			
			loginMaster.setCreatBy(loginMaster1.getLoginId());
					
				loginMaster=loginService.updateProfile(loginMaster);
		
				if (loginMaster.getRecordUpdate()=="true")
				{
					model.put("successMessage", "Profile has been updated successfully ");
					
					
					loginMaster = loginService.getLoginById(loginMaster1.getLoginId(),loginMaster1.getRoleId());
					
						
						if (loginMaster.getRoleId().equals("5")||loginMaster.getRoleId().equals("7")||loginMaster.getRoleId().equals("10"))
						{
							loginMaster.setLoginPage("loginQuiz");
							loginMaster.setLogoutPage("instruction");
							loginMaster.setHomePage("homeAzadi");
						}
						else if (loginMaster.getRoleId().equals("8")||loginMaster.getRoleId().equals("9"))
						{
							loginMaster.setLoginPage("loginEssay");
							loginMaster.setLogoutPage("instruction");
							loginMaster.setHomePage("homeAzadi");
						}
						else
						{
							loginMaster.setLoginPage("login");
							loginMaster.setLogoutPage("login");
							loginMaster.setHomePage("home");
						}
						
						
						
						
						
					
					request.getSession().setAttribute("loginMaster", loginMaster);
					model.put("loginMaster", loginMaster);
					return "myProfile";
				}
				
				else 
				{
					model.put("errorMessage", "Error in profile updation ");
					model.put("loginMaster", loginMaster);
					return "myProfile";
				}
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "myProfile";
    }
	

	@RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model,HttpServletRequest request){
		
		System.out.println("inside LoginController.logout method-");
		String loginPage="invalid-session";
		try {
				LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
				
				if (loginMaster1==null)
				{
					model.put("errorMessage", "You are successfully logout,Please login again");
				
					   request.getSession().setAttribute("roleAccess", null);
					   request.getSession().setAttribute("projectName", null);
					
					return "invalid-session";
				}
			   
			   else
			   {
				   loginPage=loginMaster1.getLogoutPage();
				   
				   loginService.updateLoginTrack(loginMaster1.getTrackId(),loginMaster1.getLoginId());
					
				   request.getSession().setAttribute("loginMaster", null);
				   request.getSession().setAttribute("roleAccess", null);
				   request.getSession().setAttribute("projectName", null);
				   request.getSession().invalidate();
				   
					
				   
				   
				   model.put("sucessMessage", "You are successfully logout,Please login again");
				 			   
				   System.out.println("loginPage="+loginPage);
				   return loginPage;
			   }
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return loginPage;
    }
	
	@RequestMapping(value="/pageAftAction", method = RequestMethod.GET)
    public String pageAftAction(ModelMap model,HttpServletRequest request){
		
		System.out.println("inside LoginController.pageAftAction method-");
		String loginPage="invalid-session";
		try {
				LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
				
				if (loginMaster1==null)
				{
					model.put("errorMessage", "You are successfully logout,Please login again");
				
					   request.getSession().setAttribute("roleAccess", null);
					   request.getSession().setAttribute("projectName", null);
					
					return "invalid-session";
				}
			   
			   else
			   {
				   loginPage=loginMaster1.getLoginPage();
				   
				   loginService.updateLoginTrack(loginMaster1.getTrackId(),loginMaster1.getLoginId());
					
				   request.getSession().setAttribute("loginMaster", null);
				   request.getSession().setAttribute("roleAccess", null);
				   request.getSession().setAttribute("projectName", null);
				   request.getSession().invalidate();
				   
					
				   
				   
				   model.put("sucessMessage", "You are successfully logout,Please login again");
				 			   
				   System.out.println("loginPage="+loginPage);
				   return loginPage;
			   }
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return loginPage;
    }
	
	
	
	@RequestMapping(value="/logoutAzadi", method = RequestMethod.GET)
    public String logoutAzadi(ModelMap model,HttpServletRequest request){
		
		System.out.println("inside LoginController.logoutAzadi method-");
		String loginPage="invalid-session";
		try {
				LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
				
				if (loginMaster1==null)
				{
					model.put("errorMessage", "Session is expired,Please login again");
					 request.getSession().setAttribute("roleAccess", null);
					   request.getSession().setAttribute("projectName", null);
					return "invalid-session";
				}
			   
			   else
			   {
				   loginPage=loginMaster1.getLogoutPage();
				   loginService.updateLoginTrack(loginMaster1.getTrackId(),loginMaster1.getLoginId());
					  
				   
				   request.getSession().setAttribute("loginMaster", null);
				   request.getSession().setAttribute("roleAccess", null);
				   request.getSession().setAttribute("projectName", null);
				   request.getSession().invalidate();
				   
				   
				   model.put("sucessMessage", "You are successfully logout,Please login again");
				 			   
				   
				   return loginPage;
			   }
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "login";
    }
	
	@RequestMapping(value="/logoutAzadiEssay", method = RequestMethod.GET)
    public String logoutAzadiEssay(ModelMap model,HttpServletRequest request){
		
		System.out.println("inside LoginController.logoutAzadiEssay method-");
		try {
				LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
				
				if (loginMaster1==null)
				{
					model.put("errorMessage", "Session is expired,Please login again");
					 request.getSession().setAttribute("roleAccess", null);
					   request.getSession().setAttribute("projectName", null);
					return "invalid-session";
				}
			   
			   else
			   {
				   loginService.updateLoginTrack(loginMaster1.getTrackId(),loginMaster1.getLoginId());
					  
				   
				   request.getSession().setAttribute("loginMaster", null);
				   request.getSession().setAttribute("roleAccess", null);
				   request.getSession().setAttribute("projectName", null);
				   request.getSession().invalidate();
				   
				   
				   model.put("sucessMessage", "You are successfully logout,Please login again");
				 			   
				   
				   return "loginEssay";
			   }
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "loginEssay";
    }
	
	@RequestMapping(value="/getCaptcha", method = RequestMethod.GET)
	public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpg");
		int iTotalChars = 6;
		int iHeight = 40;
		int iWidth = 150;
		Font fntStyle1 = new Font("Arial", Font.BOLD, 30);
		Random randChars = new Random();
		String sImageCode = (Long.toString(Math.abs(randChars.nextLong()), 36)).substring(0, iTotalChars);
		BufferedImage biImage = new BufferedImage(iWidth, iHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2dImage = (Graphics2D) biImage.getGraphics();
		int iCircle = 15;
		for (int i = 0; i < iCircle; i++) {
			g2dImage.setColor(new Color(randChars.nextInt(255), randChars.nextInt(255), randChars.nextInt(255)));
		}
		g2dImage.setFont(fntStyle1);
		for (int i = 0; i < iTotalChars; i++) {
			g2dImage.setColor(new Color(randChars.nextInt(255), randChars.nextInt(255), randChars.nextInt(255)));
			if (i % 2 == 0) {
				g2dImage.drawString(sImageCode.substring(i, i + 1), 25 * i, 24);
			} else {
				g2dImage.drawString(sImageCode.substring(i, i + 1), 25 * i, 35);
			}
		}
		OutputStream osImage = response.getOutputStream();
		ImageIO.write(biImage, "jpeg", osImage);
		g2dImage.dispose();
		HttpSession session = request.getSession();
		
		session.setAttribute(session+"captcha_security", sImageCode);
	}
	
	@RequestMapping(value="/getAYTCaptcha", method = RequestMethod.GET)
	public @ResponseBody String getAYTCaptcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("image/jpg");
		System.out.println("getAYTCaptcha");
		int iTotalChars = 6;
		Random randChars = new Random();
		String sImageCode = (Long.toString(Math.abs(randChars.nextLong()), 36)).substring(0, iTotalChars);
		HttpSession session = request.getSession();
		session.setAttribute(session+"captcha_security", sImageCode);
		return sImageCode;
	}
	

@RequestMapping(value="/SendRegisterEmail", method = RequestMethod.GET)
public String SendRegisterEmail(LoginMaster login,ModelMap model,HttpServletRequest request){
	
	System.out.println("inside SendRegisterEmail method-"+login.getLoginId());
	
	LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
	
	if (loginMaster1==null)
	{
		model.put("errorMessage", "Session is expired,Please login again");
		 return "invalid-session";
	}
	
	// check role access from session start
	if (request.getSession().getAttribute("alluserlist")==null)
	{
		model.put("errorMessage", "you don't have access this module");
		 return loginMaster1.getLoginPage();
	}
	String msg="";
	String userType="New";
	String SMSBody="";
	String SMSSender="";
	boolean response=false;
	try {
		ArrayList ar=null;
		
		
		//	ar=loginService.getUserList();
		
		//model.put("userList", ar);
		
		LoginMaster loginMaster = loginService.getLoginById(login.getLoginId(),login.getRoleId());
			
				///////////////////////////////////////
				
				
		if (loginMaster.getLoginId()!=null && !loginMaster.getLoginId().equals("") )
		{
			
			
			/////////////////////SMS//////////
			SystemSetting ss=systemSettingService.getSystemSettingListBySubjectId("3");
			//////////////////////EMAIL////////
			try
			{
			EmailUtil eu =new EmailUtil();
			eu.setMailfrom(ss.getEmailFrom());
			eu.setHost(ss.getSmtpHost());
			eu.setPassword(ss.getSmtpPassword());
			eu.setUsername(ss.getSmtpUserName());
			eu.setPort(ss.getSmtpPort());
			eu.setMailto(loginMaster.getEmail());
			
			String mailSubject="Registration Information for "+ss.getProgramName()+" Program";

			String mailBody="Dear "+loginMaster.getUserName() +" ,<br/><br/> Your registration for "+ss.getProgramName()+" Program has been done. Kindly login and proceed."+
					"Here are your login credentials:"+
					"<br/><br/> Email: -"+loginMaster.getLoginId()+
					"<br/> Password -"+loginMaster.getPassword()+
					"<br/><br/> Click Here to login - "+serverbaseurl+
					"<br/><br/>"+
					"Regards"+
					"<br/>NISM"+
					"<br/><br/>Note: This is an auto generated email. Please do not respond. ";
			
			eu.setContent(mailBody);			
			eu.setMailsubject(mailSubject);
			
			String emailResponse=eu.sendMail();
			
			if (emailResponse!=null&&emailResponse.equals("true"))
			{
				model.put("successMessage", "Register Email has been Sent");
				
				RegisterEmailStatus res=new RegisterEmailStatus();
				res.setLoginId(loginMaster.getLoginId());
				res.setRoleId(loginMaster.getRoleId());
				res.setSubjectId("3");
				res.setDescription("");
				res.setStatus("SUCCESS");
				
				
				//quizRegisterService.saveRegisterEmailStatus(res,loginMaster1.getLoginId());
			
				
			}
			else
			{
				model.put("successMessage", "Register Email Sending Failed");
				
				RegisterEmailStatus res=new RegisterEmailStatus();
				
				res.setLoginId(loginMaster.getLoginId());
				res.setRoleId(loginMaster.getRoleId());
				res.setSubjectId("3");
				res.setDescription("Email sent failed.");
				res.setStatus("FAILED");
				
				
				//quizRegisterService.saveRegisterEmailStatus(res,loginMaster1.getLoginId());
				
			}
			}catch (Exception e)
			{
				e.printStackTrace();
			}
						
			/////////////////////////////////////SMS///////////////////////////////////////////////
						
			try
			{
				SMSBody="Dear "+loginMaster.getUserName().trim()+" ,\n\n"+
						"Your registration for Azadi Ka Amrit Mahotsav Program has been done. Kindly login and proceed. Here are your login credentials.\n\n"+
										"Email: - "+loginMaster.getLoginId()+"\n"+
										"Password - "+loginMaster.getPassword()+"\n\n"+
										"Click Here to login - https://quiz.nism.ac.in/loginQuiz\n\n"+
										"In case of  any difficulty feel free to contact on 8095210200 or write back on Sebiquiz@nism.ac.in .\n\n"+
										"Regards,\n"+
										"NISM";
				
				SMSSender=ss.getSmsSender();
				
				response=Utility.sendSms(loginMaster.getMobileNo(),SMSBody,SMSSender);
				if (response)
				{
					System.out.println( "SMS sent successfully on your registered Mobile No.");
					
				}
				else
				{
					System.out.println( "SMS Sent failed for "+loginMaster.getMobileNo());
					
				}
			
			
			}catch (Exception e)
			{
				e.printStackTrace();
			}
			
			////////////////////////////////////WHATSUP///////////////////////////////////////////
			try
			{
				SMSBody="Dear  "+loginMaster.getUserName().trim()+"\n\n"+
						"Your registration for Azadi Ka Amrit Mahotsav Program has been done. Kindly login and proceed. Here are your login credentials.\n\n"+
										"Email: - "+loginMaster.getLoginId().trim()+"\n"+
										"Password - "+loginMaster.getPassword()+"\n\n"+
										"Click Here to login - https://quiz.nism.ac.in/loginQuiz  \n\n"+
										"In case of  any difficulty feel free to contact on 8095210200 or write back on Sebiquiz@nism.ac.in \n\n"+
										"Regards,\n"+
										"NISM\n\n"+
										"Note: This is an auto generated message. Please do not respond.";
				
				response=Utility.sendWhatsupMessage(loginMaster.getMobileNo(),SMSBody);
				if (response)
				{
					System.out.println( "Whatsup sent successfully on your registered Mobile No.");
					
				}
				else
				{
					System.out.println( "Whatsup Sent failed for "+loginMaster.getMobileNo());
					
				}
			
			
			}catch (Exception e)
			{
				e.printStackTrace();
			}
			
			//////////////////////////////////////////////////////////////////////////////////////



			
		}
		else
		{
			model.put("successMessage", "Login details does not exist");
		}
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return "listUser";
    
}


/*Pagination*/
@GetMapping("/getUserListServerSidePagination")
public @ResponseBody LoginMasterDTO getUserListServerSidePagination(@RequestParam("start") int start,
		@RequestParam("length") int length,
		@RequestParam("draw") int draw,
		@RequestParam("order[0][column]") int sortColIndex,
		@RequestParam("order[0][dir]") String order,
		@RequestParam("columns[0][data]") String col0DataAttrName,
		@RequestParam("search[value]") String search) throws Exception {
	
	// To handle Sorting
	// sortColIndex => which column index is being sorted
	// order => asc or desc
	// col0DataAttrName => can be used to pass column name dymanically in DB Query

	System.out.println("search>>>>>>>"+search);
	System.out.println("order>>>>>>>"+order);
	System.out.println("sortColIndex>>>>>>>"+sortColIndex);
	System.out.println("length>>>>>>>"+length);
	System.out.println("start>>>>>>>"+start);
	
	
	LoginMasterDTO usersDto = loginService.getUserListServerSidePagination(start, length,search,sortColIndex,order);
	usersDto.setDraw(draw);
	
	return usersDto;
}
/**/

@RequestMapping(value="/viewRegisterGet", method = RequestMethod.GET)
public String viewRegisterGet(ModelMap model,LoginMaster login,@RequestParam("loginId") String loginId,
		@RequestParam("roleId") String roleId,HttpServletRequest request){
	LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
	
	if (loginMaster1==null)
	{
		model.put("errorMessage", "Session is expired,Please login again");
		 return "invalid-session";
	}
		LoginMaster loginMaster= new LoginMaster();
		
		
		try {
			loginMaster=loginService.getLoginById(loginId,roleId);
			
		
		model.put("loginMaster", loginMaster);
		
		model.put("roleName", loginService.getRoleName());
		
		
	
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return "register";
   }


}
