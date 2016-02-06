package org.spring.transaction;

public class Owner {

	private String name;
	private String voterID;
	private ContactDetails contact;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVoterID() {
		return voterID;
	}
	public void setVoterID(String voterID) {
		this.voterID = voterID;
	}
	public ContactDetails getContact() {
		return contact;
	}
	public void setContact(ContactDetails contact) {
		this.contact = contact;
	}
}