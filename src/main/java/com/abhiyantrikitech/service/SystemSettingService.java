package com.abhiyantrikitech .service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhiyantrikitech.model.SystemSetting;

import com.abhiyantrikitech.repository.SystemSettingDao;

@Service
public class SystemSettingService {
	@Autowired
	SystemSettingDao ssd;
	
	public SystemSetting saveSystemSetting(SystemSetting SystemSetting, String loggedInUser) throws Exception{
		
		return ssd.saveSystemSetting(SystemSetting, loggedInUser);
		
	};
	
    public SystemSetting modifySystemSetting(SystemSetting SystemSetting, String loggedInUser) throws Exception{
		
		return ssd.modifySystemSetting(SystemSetting, loggedInUser);
		
	};
	
	public SystemSetting getSystemSettingListById(String id ) throws Exception {
		return ssd.getSystemSettingListById(id);
	}
	
	public SystemSetting getSystemSettingListBySubjectId(String id ) throws Exception {
		return ssd.getSystemSettingListBySubjectId(id);
	}
	
	public ArrayList getSystemSettingList() throws Exception {
		return ssd.getSystemSettingList();
	}
	
	public boolean checkDuplicateSystemConfiguration(String id,String subjectId ) throws Exception {
		return ssd.checkDuplicateSystemConfiguration(id,subjectId);
	}
	

}
