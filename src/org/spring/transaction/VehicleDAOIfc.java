package org.spring.transaction;

import org.springframework.jdbc.core.JdbcTemplate;

public interface VehicleDAOIfc {

	public void setJdbcTemplate(JdbcTemplate template);
	public Vehicle getVehicleDetails(int id);
	public void insertVehicleRecord(Vehicle vehicle);
}