package com.abhiyantrikitech.model;

public class SubRoleMaster {

private String subRoleId;
private String subMenuAccessId;
private String roleId;
private String subRoleStatus;
private String createBy;
private String createDt;
private String subRoleLabel;


public String getSubRoleLabel() {
	return subRoleLabel;
}
public void setSubRoleLabel(String subRoleLabel) {
	this.subRoleLabel = subRoleLabel;
}
public String getSubRoleId() {
	return subRoleId;
}
public void setSubRoleId(String subRoleId) {
	this.subRoleId = subRoleId;
}



public String getSubMenuAccessId() {
	return subMenuAccessId;
}
public void setSubMenuAccessId(String subMenuAccessId) {
	this.subMenuAccessId = subMenuAccessId;
}
public String getRoleId() {
	return roleId;
}
public void setRoleId(String roleId) {
	this.roleId = roleId;
}
public String getSubRoleStatus() {
	return subRoleStatus;
}
public void setSubRoleStatus(String subRoleStatus) {
	this.subRoleStatus = subRoleStatus;
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

}
