package org.spring.transaction;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class VehicleDAO implements VehicleDAOIfc {
	private JdbcTemplate jdbcTemplate;
	private PlatformTransactionManager transactionManager;
	
	public void setJdbcTemplate(JdbcTemplate template){
		this.jdbcTemplate=template;
	}
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		      this.transactionManager = transactionManager;
		   }
	
	public Vehicle getVehicleDetails(int id){
		String sql="Select * from Vehicle where reg_no=?";
		Vehicle vehicle=jdbcTemplate.queryForObject(sql, new Object[]{id}, new VehicleMapper());
		return vehicle;
	}
	
	public void insertVehicleRecord(Vehicle vehicle){
		TransactionDefinition def=new DefaultTransactionDefinition();
		TransactionStatus status=transactionManager.getTransaction(def);
		try{
			String sql="insert into vehicle values("+
						vehicle.getRegNumber() + ",'"+
						vehicle.getVehicleType() + "','"+
						vehicle.getOwner().getVoterID()+"')";
			jdbcTemplate.update(sql);
			transactionManager.commit(status);
			System.out.println(sql);
		}
		catch(DataAccessException de){
			de.printStackTrace();
			transactionManager.rollback(status);
		}
	}
}