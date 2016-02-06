package org.spring.transaction;

import org.springframework.jdbc.core.JdbcTemplate;

public interface OwnerDAOIfc {

	public void setJdbcTemplate(JdbcTemplate template);
	public Owner ownerDetails(int id);
	public void insertOwnerRecord(Owner owner);
}