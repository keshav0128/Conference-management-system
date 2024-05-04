package com.abhiyantrikitech.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abhiyantrikitech.model.LoginMaster;
import com.abhiyantrikitech.model.RoleMaster;
import com.abhiyantrikitech.model.SubRoleMaster;
import com.abhiyantrikitech.service.LoginService;
import com.abhiyantrikitech.service.RolesService;

@Controller
public class RolesController {
	@Autowired
	RolesService rolesService;
	
	@Autowired
	LoginService loginSertvice;
	
    @RequestMapping(value="/rolesReport", method=RequestMethod.GET)
	public String rolesReport(ModelMap model,HttpServletRequest request) {
	 System.out.println("RolesController : rolesReport");
	 LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
		
		if (loginMaster1==null)
		{
			model.put("errorMessage", "Session is expired,Please login again");
			 return "invalid-session";
		};
		
		// check role access from session start
		/*if (request.getSession().getAttribute("rolecreation")==null)
		{
			model.put("errorMessage", "you don't have access this functionality");
			 return "login";
		}*/
		// check role access end
	     
	 ArrayList arr=rolesService.getRoleData();
     model.put("data", arr);
     return "listRoleMaster";
   
  }





@RequestMapping(value="/createRoleMasterLink", method=RequestMethod.GET)
public String createRoleMasterLink(ModelMap model,HttpServletRequest request){
	
LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
	
	if (loginMaster1==null)
	{
		model.put("errorMessage", "Session is expired,Please login again");
		 return "invalid-session";
	}; 
	
	// check role access from session start
	/*if (request.getSession().getAttribute("rolecreation")==null)
	{
		model.put("errorMessage", "you don't have access this functionality");
		 return "login";
	}*/
	// check role access end
	
    ArrayList arr=rolesService.getSubRoleList();
    RoleMaster roleMaster=new RoleMaster();
    roleMaster.setRoleStatus("Y");
    roleMaster.setSubRoleMaster(arr);
    model.put("roleMaster", roleMaster);
    
	return "createRoleMaster";
}


//This is used To save data in Database
@RequestMapping(value="/saveRoleMaster", method=RequestMethod.POST)
public String saveRoleMaster(ModelMap model, @ModelAttribute("roleMaster") RoleMaster  roleMaster,HttpServletRequest request)throws SQLException, ClassNotFoundException
{  
	
	System.out.println("inside saveRoleMaster method");
	
		LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
		
		if (loginMaster1==null)
		{
			model.put("errorMessage", "Session is expired,Please login again");
			 return "invalid-session";
		};
		
		// check role access from session start
		/*if (request.getSession().getAttribute("rolecreation")==null)
		{
			model.put("errorMessage", "you don't have access this functionality");
			 return "login";
		}*/
		// check role access end
	    
		int subroleSelecte=0;
	    SubRoleMaster subRoleMaster=null;
	    for (int i=0;i<roleMaster.getSubRoleMaster().size();i++)
	    {
	    			   
			subRoleMaster=roleMaster.getSubRoleMaster().get(i);
			 if (subRoleMaster.getSubRoleStatus()!=null && subRoleMaster.getSubRoleStatus().equals("Y"))
			 {
				 subroleSelecte=1;
			 }
		 }
	    
	    if (subroleSelecte==0)
		{
			model.put("errorMessage", "Please select atleast one Sub Role");	
			model.put("roleMaster", roleMaster);
			return "createRoleMaster";
		}
		
		if (rolesService.checkDuplicateRole(roleMaster.getRoleName(),roleMaster.getRoleId()))
		{
			roleMaster.setCreateBy(loginMaster1.getLoginId());
			
			if (roleMaster.getRoleStatus()!=null)
			{
				roleMaster.setRoleStatus("Y");
			}
			else
			{
				roleMaster.setRoleStatus("N");
			}
			
			int cnt=0;
			
			if (roleMaster.getRoleId()==null||roleMaster.getRoleId().equals(""))
			{
				cnt=rolesService.createRole(roleMaster);
			}
			else
			{
				cnt=rolesService.updateRole(roleMaster);
			}
			
	
			if (cnt>0)
			{
				model.put("successMessage", "Role saved successfully");	
			    return "createRoleMaster";
				
			}
			else
			{
				model.put("errorMessage", "Role saving failed");	
				model.put("roleMaster", roleMaster);
				return "createRoleMaster";
			}
		}
		else
		{
			System.out.println("Duplicate");
			model.put("errorMessage", "Role is already exist");	
			model.put("roleMaster", roleMaster);
			

			return "createRoleMaster";
			
			
		
			
		}
	
}

@RequestMapping(value="/viewRole", method = RequestMethod.POST)
public String viewRole(ModelMap model,RoleMaster roleMaster,HttpServletRequest request){
	LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
	
	if (loginMaster1==null)
	{
		model.put("errorMessage", "Session is expired,Please login again");
		 return "invalid-session";
	}
	
	// check role access from session start
/*	if (request.getSession().getAttribute("rolecreation")==null)
	{
		model.put("errorMessage", "you don't have access this functionality");
		 return "login";
	}*/
	// check role access end
		
	RoleMaster roleMaster1= new RoleMaster();
		
		try {
			roleMaster1=rolesService.getRoleDataById(roleMaster.getRoleId());
			
		
		model.put("roleMaster", roleMaster1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return "createRoleMaster";
   }



}
