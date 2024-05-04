package com.abhiyantrikitech.model;

public class QuizForm {

	private String programId;
	private String studentId;
	private String enrollmentId;
	private String studentName;
	private String studentEmail;
	private String programName;
	
	private String recordUpdate;
	
	public QuizForm(String enrollmentId, String programId,String studentId,
			String studentName, String studentEmail,String programName) {
		//super();

		this.enrollmentId = enrollmentId;
		this.programId = programId;
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.programName = programName;
	}
	public QuizForm() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getProgramId() {
		return programId;
	}
	public void setProgramId(String programId) {
		this.programId = programId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public String getRecordUpdate() {
		return recordUpdate;
	}
	public void setRecordUpdate(String recordUpdate) {
		this.recordUpdate = recordUpdate;
	}
	
}
