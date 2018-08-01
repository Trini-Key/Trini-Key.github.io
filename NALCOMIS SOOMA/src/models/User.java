package models;

public class User {
	
	String fName, lName, pWord, workCenter, job;
	int userType;
	
	public User() {
		fName = "John";
		lName = "Doe";
		pWord = "password";
		workCenter = "Maintenance-Admin";
		job = "Data-Specialist";
		userType = 1;
		
	}
	
	public User(String fName, String lName, String pWord, String workCenter, String job) {
		this.fName = fName ;
		this.lName = lName;
		this.pWord = pWord;
		this.workCenter = workCenter;
		this.job = job;
		userType = 0;
	}
	
	public User(String fName, String lName, String pWord, String workCenter, String job, int type) {
		this.fName = fName ;
		this.lName = lName;
		this.pWord = pWord;
		this.workCenter = workCenter;
		this.job = job;
		userType = type;
	}
	
	public void setFn(String fN) {
		fName = fN;
	}
	
	public void setLn(String lN) {
		lName = lN;
	}
	
	public void setPw(String pW) {
		pWord = pW;
	}
	
	public void setWc(String wC) {
		workCenter = wC;
	}
	
	public void setJb(String jB) {
		job = jB;
	}
	
	public void setType(int type) {
		userType = type;
	}
	
	public String getWc() {
		return workCenter;
	}
	
	public String getJb() {
		return job;
	}
	
	public String getFn() {
		return fName;
	}
	
	public String getLn() {
		return lName;
	}
	
	public String getPw() {
		return pWord;
	}
	
	public int getType() {
		return userType;
	}
	
}
