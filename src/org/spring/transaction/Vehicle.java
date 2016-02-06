package org.spring.transaction;

public class Vehicle {

	private String vehicleType;
	private int regNumber;
	private Owner owner;
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public int getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(int regNumber) {
		this.regNumber = regNumber;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
}