package org.spring.transaction;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class VehicleMapper implements RowMapper<Vehicle> {
	
	public Vehicle mapRow(ResultSet rs,int row) throws SQLException{
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleType(rs.getString("vehicle_type"));
		vehicle.setRegNumber(rs.getInt("reg_no"));
		return vehicle;		
	}
}