package com.abhiyantrikitech.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhiyantrikitech.model.RoleMaster;

import com.abhiyantrikitech.repository.RolesDao;

@Service
public class RolesService {

	@Autowired
	RolesDao rolesDao;
	
	public int createRole(RoleMaster roleMaster) {
		return rolesDao.createRole(roleMaster);
	}
	
	public int updateRole(RoleMaster roleMaster) {
		return rolesDao.updateRole(roleMaster);
	}
	
		
	public ArrayList getSubRoleList()
	{
		return rolesDao.getSubRoleList();
	}
	
	public ArrayList<RoleMaster> getRoleData() {	
		return rolesDao.getRoleData();
	}
	
	public RoleMaster getRoleDataById(String roleId){
		return rolesDao.getRoleDataById(roleId);
	}
	
	public boolean checkDuplicateRole (String roleName,String roleId)
	{
		return rolesDao.checkDuplicateRole(roleName, roleId);
	}
	
	public LinkedHashMap getRoleAccessByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return rolesDao.getRoleAccessByRoleId(roleId);
	}

	public boolean checkMenuAccess(String roleId,String menuCode) {
		return rolesDao.checkMenuAccess(roleId,menuCode);
	}
	
	

}
