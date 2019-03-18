package com.thrillio.entities;

public class User {

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", fName=" + fName + ", lName=" + lName + ", password="
				+ password + ", gender=" + gender + ", userType=" + userType + "]";
		
	}

	private long id;
	private String email;
	private String fName;
	private String lName;
	private String password;
	private int gender;
	private String userType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
