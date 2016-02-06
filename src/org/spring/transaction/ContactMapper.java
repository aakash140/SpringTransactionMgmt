package org.spring.transaction;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ContactMapper implements RowMapper<ContactDetails> {

	public ContactDetails mapRow(ResultSet rs,int row) throws SQLException{
		ContactDetails contact=new ContactDetails();
		contact.setMobileNumber(rs.getInt("mobile"));
		contact.setCity(rs.getString("city"));
		contact.setHouse_street(rs.getString("house_street"));
		contact.setPincode(rs.getInt("pincode"));
		return contact;
	}
}