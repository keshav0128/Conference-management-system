package com.abhiyantrikitech.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhiyantrikitech.model.LoginTrack;
import com.abhiyantrikitech.model.LoginMaster;
import com.abhiyantrikitech.model.LoginMasterDTO;
import com.abhiyantrikitech.repository.LoginDao;
import com.abhiyantrikitech.util.Utility;

@Service
public class LoginService {
	@Autowired
	LoginDao loginDao;
	Connection conn=null;
	public LoginMaster registerUser(LoginMaster loginMaster) throws Exception{
	
		return loginDao.registerUser(loginMaster,conn);
	}
	
	public LoginMaster updateProfile(LoginMaster loginMaster) throws Exception{
		
		return loginDao.updateProfile(loginMaster);
	}
	
	public LoginMaster updateUser(LoginMaster loginMaster) throws Exception{
		return loginDao.updateUser(loginMaster,conn);
	}
	
	public LoginMaster resetPassword(LoginMaster loginMaster) throws Exception{	
		return loginDao.resetPassword(loginMaster);
	}
	
	
	public LoginMaster validateLogin(String loginId,String Password,String subjectId,String loginRole) throws Exception{
		
		return loginDao.validateLogin(loginId,Password,subjectId,loginRole); 
	} 
	
	public LoginMaster getLoginById(String loginId,String roleId) throws Exception{
		return loginDao.getLoginById(loginId,roleId);
	} 
	
	public LoginMaster getLoginByRPId(String rpId) throws Exception{	
		return loginDao.getLoginByRPId(rpId);
	} 
	
	public HashMap getRoleName() throws Exception{	
		return loginDao.getRoleName();
	}
	
		
	public LoginMaster getPassword(String login,String roleId) throws Exception{	
		return loginDao.getPassword(login,roleId);
	}

	
	public boolean duplicateLoginCheck(String login)  throws Exception{
		
		return loginDao.duplicateLoginCheck(login);
	 
	}
	
	public boolean duplicateEmailCheck(String email,String userId) throws Exception{
		return loginDao.duplicateEmailCheck(email,userId);
	}
	
	public boolean duplicateMobileCheck(String mobile,String userId) throws Exception{
		return loginDao.duplicateMobileCheck(mobile,userId);
	}
	
	public ArrayList getUserList() throws Exception{
		return loginDao.getUserList();
	}
	
	public String insertLoginTrack(LoginTrack loginTrack) throws Exception {
		return loginDao.insertLoginTrack(loginTrack);
	}
	
	public String updateLoginTrack(String id,String loginId) throws Exception {
		return loginDao.updateLoginTrack(id,loginId);
	}
	
	
	
	
	public LoginMaster getLoginByUserId(String userId) throws Exception{
		return loginDao.getLoginByUserId(userId);
	}
	
	public LoginMasterDTO getUserListServerSidePagination(int start, int length, String filter,int sortColIndex,String order) throws Exception{
		return loginDao.getUserListServerSidePagination(start,length,filter,sortColIndex,order);
	}
	
	
	
}
