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

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import com.abhiyantrikitech.model.RefCodeMas;
import com.abhiyantrikitech.model.LoginMaster;
import com.abhiyantrikitech.service.RefCodeMasService;
import com.abhiyantrikitech.util.FileUpload;
import com.abhiyantrikitech.util.Util;
import com.abhiyantrikitech.util.Utility;

@Controller
public class RefCodeMasController {
@Autowired
RefCodeMasService sss;




@RequestMapping(value="/createRefCodeMas", method = RequestMethod.GET)
public String createRefCodeMas(ModelMap model,HttpServletRequest request){
	
	LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
	
	if (loginMaster1==null)
	{
		model.put("errorMessage", "Session is expired,Please login again");
		 return "invalid-session";
	};
	
	// check role access from session start
	if (request.getSession().getAttribute("refcodemaster")==null)
	{
		model.put("errorMessage", "you don't have access this functionality");
		 return "login";
	}
	// check role access end
		
	try {
		HashMap hm=sss.getAllType();
		model.put("typeList", hm);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
    return "AddRefCodeMas";
}



@RequestMapping(value="/saveRefCodeMas",method=RequestMethod.POST)
public String saveRefCodeMas(ModelMap model,@ModelAttribute("RefCodeMas") RefCodeMas dm,HttpServletRequest request) throws Exception {
	
		String errMsg="";
		System.out.println("inside controller's saveRefCodeMas method");
		LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
		
		if (loginMaster1==null)
		{
			model.put("errorMessage", "Session is expired,Please login again");
			 return "invalid-session";
		};
		
		// check role access from session start
		if (request.getSession().getAttribute("refcodemaster")==null)
		{
			model.put("errorMessage", "you don't have access this functionality");
			 return "login";
		}
		// check role access end
		
		try {
			
			try {
				HashMap hm=sss.getAllType();
				model.put("typeList", hm);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (sss.duplicateRefCode(dm.getRefId(), dm.getRefType().toUpperCase(), dm.getRefDesc().toUpperCase()))
			{
				model.put("errorMessage", "Ref Code Name should be unique.");
				model.put("refCodeMas", dm);
				
				return "AddRefCodeMas";
			}
			
			
			if(dm.getRefId()==null ||dm.getRefId().equals("")||
					dm.getRefId().equals("0"))
			{
				 
				dm.setRefCreatBy(loginMaster1.getLoginId());
				sss.saveRefCodeMas(dm, loginMaster1.getLoginId());
			}
			else
			{
				dm.setRefCreatBy(loginMaster1.getLoginId());
				sss.modifyRefCodeMas(dm, loginMaster1.getLoginId());
			}
			
			
			if (dm.getRecordUpdate().equals("true"))
			{
				 model.put("successMessage", "Ref Code save successfully");
				 model.put("refCodeMas", null); 		  
				 return "AddRefCodeMas";				
				
			}
			else
			{
				model.put("errorMessage", "Something went wrong, please try again.");
				model.put("refCodeMas", dm);
				
				return "AddRefCodeMas";
			}
		} catch(Exception e) {
			e.printStackTrace();
			
		}	
		 return "AddRefCodeMas";
			
	}




@RequestMapping(value="/viewRefCodeMas", method = RequestMethod.POST)
 public String viewRefCodeMas(ModelMap model,RefCodeMas dm,HttpServletRequest request){
	LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
		if (loginMaster1==null)
		{
		model.put("errorMessage", "Session is expired,Please login again");
		 return "invalid-session";
		}
		
		// check role access from session start
		if (request.getSession().getAttribute("refcodemaster")==null)
		{
			model.put("errorMessage", "you don't have access this functionality");
			 return "login";
		}
		// check role access end
		RefCodeMas newRefCodeMas= new RefCodeMas();
		
		try {
			newRefCodeMas=sss.getRefCodeMasListById(dm.getRefId());
		
					
			
		model.put("refCodeMas", newRefCodeMas);
		
		try {
			HashMap hm=sss.getAllType();
			model.put("typeList", hm);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "AddRefCodeMas";
    }

@RequestMapping(value="/getRefCodeMasList", method = RequestMethod.GET)
 public String getRefCodeMasList(ModelMap model,HttpServletRequest request){
		
		LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
		
		if (loginMaster1==null)
		{
			model.put("errorMessage", "Session is expired,Please login again");
			 return "invalid-session";
		}
		
		// check role access from session start
		if (request.getSession().getAttribute("refcodemaster")==null)
		{
			model.put("errorMessage", "you don't have access this functionality");
			 return "login";
		}
		// check role access end
		
		ArrayList ar=null;
		
		try {
			ar=sss.getRefCodeMasList();
		
		model.put("RefCodeMasList", ar);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "listRefCodeMas";
    }

//@GetMapping(value="/getRefCodeLov")
public @ResponseBody  HashMap<String,String> getRefCodeLov(@RequestParam("type") String type) throws Exception {
	boolean status=false;

	HashMap <String,String> hm= sss.getRefCodeLov(type);

	return hm;

}

}
