package org.spring.transaction;

import org.springframework.jdbc.core.JdbcTemplate;

public interface ContactDAOIfc {

	public void setJdbcTemplate(JdbcTemplate template);
	public ContactDetails contactDetails(int number);
	public void insertContactRecord(ContactDetails contact);
}