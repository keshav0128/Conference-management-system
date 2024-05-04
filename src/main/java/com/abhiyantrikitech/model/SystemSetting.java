package com.abhiyantrikitech.model;

import org.springframework.web.multipart.MultipartFile;

public class SystemSetting {

	private String id;
	private String companyName;
	private String smtpHost;
	private String smtpPort;
	private String smtpUserName;
	private String smtpPassword;
	private String emailFrom;
	private String recordUpdate="false";
	private String createBy;
	private String createDate;
	
	private String smsSender;

	private String programName;	
	private String issueAuthName1;
	private String issueAuthNameSign1;
	private MultipartFile issueAuthNameSign1Multipart;
	private String issueAuthDesignation1;
	private String departmentName;
	private String departmentPhone;
	private String departmentEmail;	
	private String contactName;
	private String contactPhone;
	private String contactEmail;
	private String contactDesignation;
	private String issueAuthName2;
	private String issueAuthNameSign2;
	private MultipartFile issueAuthNameSign2Multipart;
	private String issueAuthDesignation2;
	private String quizMarksLimit="60";
	private String projectName;
	
	private String deanName;
	private String deanPhone;
	private String deanEmail;
	private String deanDesignation;
	private String deanSign;
	private MultipartFile deanSignMultipart;
	private String submissionEmailId;
	private String subjectId;
	private String subjectName;
	private String essaySubmitDueDateInHrs;
	
	
	
	
	
	public String getEssaySubmitDueDateInHrs() {
		return essaySubmitDueDateInHrs;
	}
	public void setEssaySubmitDueDateInHrs(String essaySubmitDueDateInHrs) {
		this.essaySubmitDueDateInHrs = essaySubmitDueDateInHrs;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubmissionEmailId() {
		return submissionEmailId;
	}
	public void setSubmissionEmailId(String submissionEmailId) {
		this.submissionEmailId = submissionEmailId;
	}
	public String getDeanName() {
		return deanName;
	}
	public void setDeanName(String deanName) {
		this.deanName = deanName;
	}
	public String getDeanPhone() {
		return deanPhone;
	}
	public void setDeanPhone(String deanPhone) {
		this.deanPhone = deanPhone;
	}
	public String getDeanEmail() {
		return deanEmail;
	}
	public void setDeanEmail(String deanEmail) {
		this.deanEmail = deanEmail;
	}
	public String getDeanDesignation() {
		return deanDesignation;
	}
	public void setDeanDesignation(String deanDesignation) {
		this.deanDesignation = deanDesignation;
	}
	public String getDeanSign() {
		return deanSign;
	}
	public void setDeanSign(String deanSign) {
		this.deanSign = deanSign;
	}
	public MultipartFile getDeanSignMultipart() {
		return deanSignMultipart;
	}
	public void setDeanSignMultipart(MultipartFile deanSignMultipart) {
		this.deanSignMultipart = deanSignMultipart;
	}
	public String getContactDesignation() {
		return contactDesignation;
	}
	public void setContactDesignation(String contactDesignation) {
		this.contactDesignation = contactDesignation;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getQuizMarksLimit() {
		return quizMarksLimit;
	}
	public void setQuizMarksLimit(String quizMarksLimit) {
		this.quizMarksLimit = quizMarksLimit;
	}
	public String getIssueAuthName1() {
		return issueAuthName1;
	}
	public void setIssueAuthName1(String issueAuthName1) {
		this.issueAuthName1 = issueAuthName1;
	}
	public String getIssueAuthNameSign1() {
		return issueAuthNameSign1;
	}
	public void setIssueAuthNameSign1(String issueAuthNameSign1) {
		this.issueAuthNameSign1 = issueAuthNameSign1;
	}
	public MultipartFile getIssueAuthNameSign1Multipart() {
		return issueAuthNameSign1Multipart;
	}
	public void setIssueAuthNameSign1Multipart(MultipartFile issueAuthNameSign1Multipart) {
		this.issueAuthNameSign1Multipart = issueAuthNameSign1Multipart;
	}
	public String getIssueAuthDesignation1() {
		return issueAuthDesignation1;
	}
	public void setIssueAuthDesignation1(String issueAuthDesignation1) {
		this.issueAuthDesignation1 = issueAuthDesignation1;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentPhone() {
		return departmentPhone;
	}
	public void setDepartmentPhone(String departmentPhone) {
		this.departmentPhone = departmentPhone;
	}
	public String getDepartmentEmail() {
		return departmentEmail;
	}
	public void setDepartmentEmail(String departmentEmail) {
		this.departmentEmail = departmentEmail;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getIssueAuthName2() {
		return issueAuthName2;
	}
	public void setIssueAuthName2(String issueAuthName2) {
		this.issueAuthName2 = issueAuthName2;
	}
	public String getIssueAuthNameSign2() {
		return issueAuthNameSign2;
	}
	public void setIssueAuthNameSign2(String issueAuthNameSign2) {
		this.issueAuthNameSign2 = issueAuthNameSign2;
	}
	public MultipartFile getIssueAuthNameSign2Multipart() {
		return issueAuthNameSign2Multipart;
	}
	public void setIssueAuthNameSign2Multipart(MultipartFile issueAuthNameSign2Multipart) {
		this.issueAuthNameSign2Multipart = issueAuthNameSign2Multipart;
	}
	public String getIssueAuthDesignation2() {
		return issueAuthDesignation2;
	}
	public void setIssueAuthDesignation2(String issueAuthDesignation2) {
		this.issueAuthDesignation2 = issueAuthDesignation2;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSmtpHost() {
		return smtpHost;
	}
	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}
	public String getSmtpPort() {
		return smtpPort;
	}
	public void setSmtpPort(String smtpPort) {
		this.smtpPort = smtpPort;
	}
	public String getSmtpUserName() {
		return smtpUserName;
	}
	public void setSmtpUserName(String smtpUserName) {
		this.smtpUserName = smtpUserName;
	}
	public String getSmtpPassword() {
		return smtpPassword;
	}
	public void setSmtpPassword(String smtpPassword) {
		this.smtpPassword = smtpPassword;
	}
	public String getEmailFrom() {
		return emailFrom;
	}
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	public String getRecordUpdate() {
		return recordUpdate;
	}
	public void setRecordUpdate(String recordUpdate) {
		this.recordUpdate = recordUpdate;
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
	public String getSmsSender() {
		return smsSender;
	}
	public void setSmsSender(String smsSender) {
		this.smsSender = smsSender;
	}

	

}
