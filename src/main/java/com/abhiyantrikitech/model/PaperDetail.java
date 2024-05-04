 package com.abhiyantrikitech.model;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

public class PaperDetail {
private String paperid;
private String name;
private String designation;
private String organization;
private String mobile;
private String email;
private String country;
private String affiliation;
private String webpage;
private String correspondingAuthor;
private ArrayList<CoAuthorDetails> coAuthor;
private String title;
private String abstracts;
private String jelCode;
private String theme;
private String keywords;
private MultipartFile paperAttachment;
private String paperFileName;
private String evaluationParameterMarksForJury;
private String evaluationParameterMarksForChair;
private String creatBy;
private String creatDt;
private String recordUpdate;
public String getPaperid() {
	return paperid;
}
public void setPaperid(String paperid) {
	this.paperid = paperid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getOrganization() {
	return organization;
}
public void setOrganization(String organization) {
	this.organization = organization;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getAffiliation() {
	return affiliation;
}
public void setAffiliation(String affiliation) {
	this.affiliation = affiliation;
}
public String getWebpage() {
	return webpage;
}
public void setWebpage(String webpage) {
	this.webpage = webpage;
}
public String getCorrespondingAuthor() {
	return correspondingAuthor;
}
public void setCorrespondingAuthor(String correspondingAuthor) {
	this.correspondingAuthor = correspondingAuthor;
}
public ArrayList<CoAuthorDetails> getCoAuthor() {
	return coAuthor;
}
public void setCoAuthor(ArrayList<CoAuthorDetails> coAuthor) {
	this.coAuthor = coAuthor;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAbstracts() {
	return abstracts;
}
public void setAbstracts(String abstracts) {
	this.abstracts = abstracts;
}
public String getJelCode() {
	return jelCode;
}
public void setJelCode(String jelCode) {
	this.jelCode = jelCode;
}
public String getTheme() {
	return theme;
}
public void setTheme(String theme) {
	this.theme = theme;
}
public String getKeywords() {
	return keywords;
}
public void setKeywords(String keywords) {
	this.keywords = keywords;
}
public MultipartFile getPaperAttachment() {
	return paperAttachment;
}
public void setPaperAttachment(MultipartFile paperAttachment) {
	this.paperAttachment = paperAttachment;
}
public String getPaperFileName() {
	return paperFileName;
}
public void setPaperFileName(String paperFileName) {
	this.paperFileName = paperFileName;
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



}
