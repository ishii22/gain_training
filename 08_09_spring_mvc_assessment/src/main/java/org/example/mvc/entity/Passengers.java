package org.example.mvc.entity;

public class Passengers {
	private String passengerId;
	private String firstName;
	private String lastName;
	private long mobile;
	private String email;
	public Passengers() {}
	public Passengers(String passengerId,String firstName,String lastName,long mobile,String email) {
		this.passengerId=passengerId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.mobile=mobile;
		this.email=email;
	}
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
