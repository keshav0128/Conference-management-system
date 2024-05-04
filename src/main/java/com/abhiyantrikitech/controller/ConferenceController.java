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



import com.abhiyantrikitech.model.Conference;
import com.abhiyantrikitech.model.LoginMaster;
import com.abhiyantrikitech.service.ConferenceService;
import com.abhiyantrikitech.util.FileUpload;
import com.abhiyantrikitech.util.Util;
import com.abhiyantrikitech.util.Utility;

@Controller
public class ConferenceController {
@Autowired
ConferenceService confServ;




@RequestMapping(value="/createConference", method = RequestMethod.GET)
public String createConference(ModelMap model,HttpServletRequest request){
	
	LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
	
	if (loginMaster1==null)
	{
		model.put("errorMessage", "Session is expired,Please login again");
		return "login";
	};
	
	// check role access from session start
	/*if (request.getSession().getAttribute("Conferenceter")==null)
	{
		model.put("errorMessage", "you don't have access this functionality");
		 return "login";
	}*/
	// check role access end
		
	System.out.println("create conference");
	Conference cnf=new Conference();
	cnf.setEvaluationParameterMarksForJury("No");
	cnf.setEvaluationParameterMarksForChair("No");
	model.put("Conference", cnf);
    return "AddConference";
}

@RequestMapping(value = "/saveConference", method = RequestMethod.POST)
public String saveConference(ModelMap model, @ModelAttribute("Conference") Conference Conference,
		HttpServletRequest request) throws Exception {

	String errMsg = "";
	System.out.println("inside controller's saveConference method");
	LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");

	if (loginMaster1 == null) {
		model.put("errorMessage", "Session is expired,Please login again");
		return "login";
	}
	;

	// check role access from session start
	if (request.getSession().getAttribute("Conferencemaster") == null) {
		model.put("errorMessage", "you don't have access this functionality");
		return "login";
	}
	// check role access end

	try {

		/*
		 * if (confServ.duplicateConfere(Conference.getConferenceId(),
		 * Conference.getNameOfConference())) { model.put("errorMessage",
		 * "Conference Name is already exist."); model.put("Conference", Conference);
		 * 
		 * return "AddConference"; }
		 * 
		 * if (confServ.checkActiveCount(Conference.getId()) &&
		 * Conference.getStatus().equals("Active")) { model.put("errorMessage",
		 * "One Active Conference is already present."); model.put("Conference",
		 * Conference);
		 * 
		 * return "AddConference"; }
		 */

		if (Conference.getConferenceId() == null || Conference.getConferenceId().equals("") || Conference.getConferenceId().equals("0")) {

			Conference.setCreatBy(loginMaster1.getLoginId());
			confServ.saveConference(Conference, loginMaster1.getLoginId());
		} else {
			Conference.setCreatBy(loginMaster1.getLoginId());
			confServ.modifyConference(Conference, loginMaster1.getLoginId());
		}

		if (Conference.getRecordUpdate().equals("true")) {
			model.put("successMessage", "Conference save successfully");
			model.put("Conference", null);
			return "AddConference";

		} else {
			model.put("errorMessage", "Something went wrong, please try again.");
			model.put("Conference", Conference);

			return "AddConference";
		}
	} catch (Exception e) {
		e.printStackTrace();

	}
	return "AddConference";

}

@RequestMapping(value="/viewConference", method = RequestMethod.POST)
 public String viewConference(ModelMap model,Conference Conference,HttpServletRequest request){
	LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
		if (loginMaster1==null)
		{
		 model.put("errorMessage", "Session is expired,Please login again");
		 return "login";
		}
		// check role access from session start
		if (request.getSession().getAttribute("Conferencemaster")==null)
		{
			model.put("errorMessage", "you don't have access this functionality");
			 return "login";
		}
		// check role access end
		
		Conference newConference= new Conference();
		
		try {
			newConference=confServ.getConferenceListById(Conference.getConferenceId());
		
					
			
		model.put("Conference", newConference);
		
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "AddConference";
    }

@RequestMapping(value="/getConferenceList", method = RequestMethod.GET)
 public String getConferenceList(ModelMap model,HttpServletRequest request){
		
		LoginMaster loginMaster1 = (LoginMaster) request.getSession().getAttribute("loginMaster");
		
		if (loginMaster1==null)
		{
			model.put("errorMessage", "Session is expired,Please login again");
			 return "login";
		}
		// check role access from session start
		if (request.getSession().getAttribute("Conferencemaster")==null)
		{
			model.put("errorMessage", "you don't have access this functionality");
			 return "login";
		}
		// check role access end
		
		ArrayList<Conference> ar=null;
		
		try {
			ar=confServ.getConferenceList();
		
		model.put("ConferenceList", ar);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "listConference";
    }

}
