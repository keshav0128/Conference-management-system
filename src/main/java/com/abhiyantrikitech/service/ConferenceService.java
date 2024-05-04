package com.abhiyantrikitech.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.abhiyantrikitech.model.Conference;
import com.abhiyantrikitech.repository.ConferenceDao;



public class ConferenceService {
	@Autowired
	ConferenceDao cd;
	public Conference saveConference(Conference conf, String loggedInUser) throws Exception{
			return cd.saveConference(conf,loggedInUser);
		};
	public Conference getConferenceListById(String conferenceId ) throws Exception {
		return cd.getConferenceListById(conferenceId);
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList<Conference> getConferenceList() throws Exception {
		return cd.getConferenceList();
	}
	
	public Conference modifyConference(Conference conference, String logedInUser) throws Exception{
		return cd.modifyConference(conference,logedInUser);	
	};
}
