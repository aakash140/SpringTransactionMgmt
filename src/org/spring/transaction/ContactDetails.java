package org.spring.transaction;

public class ContactDetails {

	private int mobileNumber;
	private String city;
	private String house_street;
	private int pincode;
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHouse_street() {
		return house_street;
	}
	public void setHouse_street(String house_street) {
		this.house_street = house_street;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
}