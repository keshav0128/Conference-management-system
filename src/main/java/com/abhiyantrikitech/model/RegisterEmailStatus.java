package com.abhiyantrikitech.model;

public class RegisterEmailStatus {

	private String loginId;
	private String subjectId;
	private String roleId;
	private String roleName;
	private String status;
	private String description;
	private String createBy;
	private String createDate;
	private String emailSentDate;
	private String recordUpdate="false";
	
	
	
	public String getEmailSentDate() {
		return emailSentDate;
	}
	public void setEmailSentDate(String emailSentDate) {
		this.emailSentDate = emailSentDate;
	}
	public String getRecordUpdate() {
		return recordUpdate;
	}
	public void setRecordUpdate(String recordUpdate) {
		this.recordUpdate = recordUpdate;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	
	
	
	
}
