package com.abhiyantrikitech.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import com.abhiyantrikitech.model.SystemSetting;
import com.abhiyantrikitech.model.LoginMaster;
import com.abhiyantrikitech.service.SystemSettingService;
import com.abhiyantrikitech.util.FileUpload;


@Controller
public class SystemSettingController {
@Autowired
SystemSettingService sss;


@Value("${serverfilepathtemplate}")
String filePath;


@RequestMapping(value="/createSystemSetting", method = RequestMethod.GET)
public String createSystemSetting(ModelMap model,HttpServletRequest request){
	
	LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
	
	if (loginMaster1==null)
	{
		model.put("errorMessage", "Session is expired,Please login again");
		 return "invalid-session";
	};
	// check role access from session start
	if (request.getSession().getAttribute("systemconfiguration")==null)
	{
		model.put("errorMessage", "you don't have access this functionality");
		 return "login";
	}
	// check role access end	
	
	HashMap hm;
	try {
	//	hm = subjectMasService.getSubjectList("Active");
		// model.put("subjectList", hm); 
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	

    return "AddSystemSetting";
}



@RequestMapping(value="/saveSystemSetting",method=RequestMethod.POST)
public String saveSystemSetting(ModelMap model,@ModelAttribute("systemSetting") SystemSetting systemSetting,HttpServletRequest request) throws Exception {
	
		String errMsg="";
		System.out.println("inside controller's saveSystemSetting method");
		LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
		
		if (loginMaster1==null)
		{
			model.put("errorMessage", "Session is expired,Please login again");
			 return "invalid-session";
		};
		
		// check role access from session start
		if (request.getSession().getAttribute("systemconfiguration")==null)
		{
			model.put("errorMessage", "you don't have access this functionality");
			 return "login";
		}
		// check role access end
		
		try {
			///HashMap hm = subjectMasService.getSubjectList("Active");
		//	 model.put("subjectList", hm); 
			 
			 if (sss.checkDuplicateSystemConfiguration(systemSetting.getId(),systemSetting.getSubjectId()))
			 {
				 	model.put("errorMessage", "Configuration is already exist for this subject ");
					model.put("systemSetting", systemSetting);
					
					return "AddSystemSetting";
			 }
			 
			 
			if (systemSetting.getIssueAuthNameSign1Multipart()!=null &&!systemSetting.getIssueAuthNameSign1Multipart().isEmpty()) {

				FileUpload fu=new FileUpload();				
				String newFileName="sign1_"+fu.dateApendFileName(systemSetting.getIssueAuthNameSign1Multipart().getOriginalFilename());
				String status=fu.fileUpload(systemSetting.getIssueAuthNameSign1Multipart(),filePath,newFileName);
				if (!status.equals(""))
				{
					errMsg=status;
					
				}
				else
				{
					systemSetting.setIssueAuthNameSign1(newFileName);
				}
			}	
			
			if (systemSetting.getIssueAuthNameSign2Multipart()!=null &&!systemSetting.getIssueAuthNameSign2Multipart().isEmpty()) {

				FileUpload fu=new FileUpload();				
				String newFileName="sign2_"+fu.dateApendFileName(systemSetting.getIssueAuthNameSign2Multipart().getOriginalFilename());
				String status=fu.fileUpload(systemSetting.getIssueAuthNameSign2Multipart(),filePath,newFileName);
				System.out.println("status="+status);
				if (!status.equals(""))
				{
					errMsg=status;
					
				}
				else
				{
					systemSetting.setIssueAuthNameSign2(newFileName);
				}
			}	
			
			if (systemSetting.getDeanSignMultipart()!=null &&!systemSetting.getDeanSignMultipart().isEmpty()) {

				FileUpload fu=new FileUpload();				
				String newFileName="dean_"+fu.dateApendFileName(systemSetting.getDeanSignMultipart().getOriginalFilename());
				String status=fu.fileUpload(systemSetting.getDeanSignMultipart(),filePath,newFileName);
				if (!status.equals(""))
				{
					errMsg=status;
					
				}
				else
				{
					systemSetting.setDeanSign(newFileName);
				}
			}	
			
			if (errMsg!=null &&!errMsg.equals(""))
			{
				model.put("errorMessage", errMsg);
				model.put("systemSetting", systemSetting);
				
				return "AddSystemSetting";
			}
			
			if(systemSetting.getId()==null ||systemSetting.getId().equals("")||
					systemSetting.getId().equals("0"))
			{
				 
				systemSetting.setCreateBy(loginMaster1.getLoginId());
				sss.saveSystemSetting(systemSetting, loginMaster1.getLoginId());
			}
			else
			{
				systemSetting.setCreateBy(loginMaster1.getLoginId());
				sss.modifySystemSetting(systemSetting, loginMaster1.getLoginId());
			}

			if (systemSetting.getRecordUpdate().equals("true"))
			{
				 model.put("successMessage", "System Setting save successfully");
				 model.put("systemSetting", null); 		  
				 return "AddSystemSetting";				
				
			}
			else
			{
				model.put("errorMessage", "Something went wrong, please try again.");
				model.put("systemSetting", systemSetting);
				
				return "AddSystemSetting";
			}
		} catch(Exception e) {
			e.printStackTrace();
			
		}	
		 return "AddSystemSetting";
			
	}




@RequestMapping(value="/viewSystemSetting", method = RequestMethod.POST)
 public String viewSystemSetting(ModelMap model,SystemSetting SystemSetting,HttpServletRequest request){
	LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
		if (loginMaster1==null)
		{
		 model.put("errorMessage", "Session is expired,Please login again");
		 return "invalid-session";
		}
		// check role access from session start
		if (request.getSession().getAttribute("systemconfiguration")==null)
		{
			model.put("errorMessage", "you don't have access this functionality");
			 return "login";
		}
		// check role access end
		
		SystemSetting newSystemSetting= new SystemSetting();
		
		try {
			newSystemSetting=sss.getSystemSettingListById(SystemSetting.getId());
		
					
			
		model.put("systemSetting", newSystemSetting);
		
		//HashMap hm = subjectMasService.getSubjectList("Active");
		// model.put("subjectList", hm); 
		
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "AddSystemSetting";
    }

@RequestMapping(value="/getSystemSettingList", method = RequestMethod.GET)
 public String getSystemSettingList(ModelMap model,HttpServletRequest request){
		
		LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
		
		if (loginMaster1==null)
		{
			model.put("errorMessage", "Session is expired,Please login again");
			 return "invalid-session";
		}
		// check role access from session start
		if (request.getSession().getAttribute("systemconfiguration")==null)
		{
			model.put("errorMessage", "you don't have access this functionality");
			 return "login";
		}
		// check role access end
		
		ArrayList ar=null;
		
		try {
			ar=sss.getSystemSettingList();
		
		model.put("SystemSettingList", ar);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "listSystemSetting";
    }



}
