 package com.abhiyantrikitech.model;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

public class CoAuthorDetails {
private String authorid;
private String name;
private String designation;
private String organization;
private String mobile;
private String email;
private String country;
private String affiliation;
private String webpage;
private String correspondingAuthor;
public String getAuthorid() {
	return authorid;
}
public void setAuthorid(String authorid) {
	this.authorid = authorid;
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

}
