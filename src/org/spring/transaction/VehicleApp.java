package org.spring.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VehicleApp {

	public static void main(String ...args){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		VehicleDAOIfc vehicleDao=(VehicleDAOIfc)context.getBean("vehicleDAO");
		OwnerDAOIfc ownerDao=(OwnerDAOIfc)context.getBean("ownerDAO");
		ContactDAOIfc contactDao=(ContactDAOIfc)context.getBean("contactDAO");
		
		ContactDetails contact=new ContactDetails();
		contact.setMobileNumber(9811569);
		contact.setCity("Delhi");
		contact.setHouse_street("58-A Preet Vihar");
		contact.setPincode(110051);
		
		Owner owner=new Owner();
		owner.setVoterID("NA1234");
		owner.setName("Aakash");
		owner.setContact(contact);
		
		Vehicle vehicle=new Vehicle();
		vehicle.setRegNumber(65478);
		vehicle.setVehicleType("2 wheeler");
		vehicle.setOwner(owner);
		
		contactDao.insertContactRecord(contact);
		ownerDao.insertOwnerRecord(owner);
		vehicleDao.insertVehicleRecord(vehicle);
	}
}