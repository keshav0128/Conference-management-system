package com.abhiyantrikitech.model;

import java.util.ArrayList;



public class RoleMaster {
private String roleId;
private String roleName;
private String roleStatus;
private String createBy;
private String createDt;
private String lastUpdateBy;
private String lastUpdateDt;
private String selectAll;



public String getSelectAll() {
	return selectAll;
}
public void setSelectAll(String selectAll) {
	this.selectAll = selectAll;
}
private ArrayList<SubRoleMaster> subRoleMaster;


public String getLastUpdateBy() {
	return lastUpdateBy;
}
public void setLastUpdateBy(String lastUpdateBy) {
	this.lastUpdateBy = lastUpdateBy;
}
public String getLastUpdateDt() {
	return lastUpdateDt;
}
public void setLastUpdateDt(String lastUpdateDt) {
	this.lastUpdateDt = lastUpdateDt;
}
public String getRoleId() {
	return roleId;
}
public void setRoleId(String roleId) {
	this.roleId = roleId;
}
public String getRoleName() {
	return roleName;
}
public void setRoleName(String roleName) {
	this.roleName = roleName;
}
public String getRoleStatus() {
	return roleStatus;
}
public void setRoleStatus(String roleStatus) {
	this.roleStatus = roleStatus;
}
public String getCreateBy() {
	return createBy;
}
public void setCreateBy(String createBy) {
	this.createBy = createBy;
}
public String getCreateDt() {
	return createDt;
}
public void setCreateDt(String createDt) {
	this.createDt = createDt;
}

public ArrayList<SubRoleMaster> getSubRoleMaster() {
	return subRoleMaster;
}
public void setSubRoleMaster(ArrayList<SubRoleMaster> subRoleMaster) {
	this.subRoleMaster = subRoleMaster;
}
}
