package org.brief5.studentManagement;

public class student {

	protected int idStudent;
	protected String fName;
	protected String lName;
	protected String email;
	protected String adresse;
	protected String contact;
	
	public int getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	public String getFName() {
		return fName;
	}
	public void setFName(String fName) {
		this.fName = fName;
	}
	public String getLName() {
		return lName;
	}
	public void setLName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

	
	public student () {}
	public student (int idStudent) {
		this.idStudent=idStudent;
	}
	public student(String fName, String lName, String email, String adresse, String contact) {
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.adresse = adresse;
		this.contact = contact;
	}
	public student(int idStudent, String fName, String lName, String email, String adresse, String contact) {
	    this(fName,lName,email,adresse,contact);
		this.idStudent = idStudent;
	}
	
}
