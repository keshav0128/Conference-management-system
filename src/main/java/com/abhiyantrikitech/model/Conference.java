 package com.abhiyantrikitech.model;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

public class Conference {
private String conferenceId;
private String type="Conference";
private String nameOfConference;
private String acronym;
private String webPage;
private String venue;
private String city;
private String country;
private String estimatedNoOfSubmission;
private String startDt;
private String endDt;
private String paperSubmissionDeadline;
private String areaNote;
private String organizer;
private String organizerWebPage;
private String contactNo;
private String yourRole;
private String anyOtherDetail;
private ArrayList<SubThemeDetails> subTheme;
private String evaluationParameterMarksForJury;
private String evaluationParameterMarksForChair;
private String creatBy;
private String creatDt;
private String recordUpdate;
private String displayReviewCommentTOAuthor;
private String emailNotificationToAuthor;
private String pageName;
private String status;
private String requestStatus;





public String getRequestStatus() {
	return requestStatus;
}
public void setRequestStatus(String requestStatus) {
	this.requestStatus = requestStatus;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getPageName() {
	return pageName;
}
public void setPageName(String pageName) {
	this.pageName = pageName;
}
public String getDisplayReviewCommentTOAuthor() {
	return displayReviewCommentTOAuthor;
}
public void setDisplayReviewCommentTOAuthor(String displayReviewCommentTOAuthor) {
	this.displayReviewCommentTOAuthor = displayReviewCommentTOAuthor;
}
public String getEmailNotificationToAuthor() {
	return emailNotificationToAuthor;
}
public void setEmailNotificationToAuthor(String emailNotificationToAuthor) {
	this.emailNotificationToAuthor = emailNotificationToAuthor;
}
public String getCreatBy() {
	return creatBy;
}
public void setCreatBy(String creatBy) {
	this.creatBy = creatBy;
}
public String getCreatDt() {
	return creatDt;
}
public void setCreatDt(String creatDt) {
	this.creatDt = creatDt;
}
public String getRecordUpdate() {
	return recordUpdate;
}
public void setRecordUpdate(String recordUpdate) {
	this.recordUpdate = recordUpdate;
}
public ArrayList<SubThemeDetails> getSubTheme() {
	return subTheme;
}
public void setSubTheme(ArrayList<SubThemeDetails> subTheme) {
	this.subTheme = subTheme;
}
public String getConferenceId() {
	return conferenceId;
}
public void setConferenceId(String conferenceId) {
	this.conferenceId = conferenceId;
}
public String getNameOfConference() {
	return nameOfConference;
}
public void setNameOfConference(String nameOfConference) {
	this.nameOfConference = nameOfConference;
}
public String getAcronym() {
	return acronym;
}
public void setAcronym(String acronym) {
	this.acronym = acronym;
}
public String getWebPage() {
	return webPage;
}
public void setWebPage(String webPage) {
	this.webPage = webPage;
}
public String getVenue() {
	return venue;
}
public void setVenue(String venue) {
	this.venue = venue;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getEstimatedNoOfSubmission() {
	return estimatedNoOfSubmission;
}
public void setEstimatedNoOfSubmission(String estimatedNoOfSubmission) {
	this.estimatedNoOfSubmission = estimatedNoOfSubmission;
}
public String getStartDt() {
	return startDt;
}
public void setStartDt(String startDt) {
	this.startDt = startDt;
}
public String getEndDt() {
	return endDt;
}
public void setEndDt(String endDt) {
	this.endDt = endDt;
}
public String getPaperSubmissionDeadline() {
	return paperSubmissionDeadline;
}
public void setPaperSubmissionDeadline(String paperSubmissionDeadline) {
	this.paperSubmissionDeadline = paperSubmissionDeadline;
}
public String getAreaNote() {
	return areaNote;
}
public void setAreaNote(String areaNote) {
	this.areaNote = areaNote;
}
public String getOrganizer() {
	return organizer;
}
public void setOrganizer(String organizer) {
	this.organizer = organizer;
}
public String getOrganizerWebPage() {
	return organizerWebPage;
}
public void setOrganizerWebPage(String organizerWebPage) {
	this.organizerWebPage = organizerWebPage;
}
public String getContactNo() {
	return contactNo;
}
public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}
public String getYourRole() {
	return yourRole;
}
public void setYourRole(String yourRole) {
	this.yourRole = yourRole;
}
public String getAnyOtherDetail() {
	return anyOtherDetail;
}
public void setAnyOtherDetail(String anyOtherDetail) {
	this.anyOtherDetail = anyOtherDetail;
}

public String getEvaluationParameterMarksForJury() {
	return evaluationParameterMarksForJury;
}
public void setEvaluationParameterMarksForJury(String evaluationParameterMarksForJury) {
	this.evaluationParameterMarksForJury = evaluationParameterMarksForJury;
}
public String getEvaluationParameterMarksForChair() {
	return evaluationParameterMarksForChair;
}
public void setEvaluationParameterMarksForChair(String evaluationParameterMarksForChair) {
	this.evaluationParameterMarksForChair = evaluationParameterMarksForChair;
}

}
