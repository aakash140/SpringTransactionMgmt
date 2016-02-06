package org.spring.transaction;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OwnerMapper implements RowMapper<Owner> {

	public Owner mapRow(ResultSet rs,int row) throws SQLException{
		Owner owner=new Owner();
		owner.setVoterID(rs.getString("voter_id"));
		owner.setName(rs.getString("name"));
		return owner;
	}
}