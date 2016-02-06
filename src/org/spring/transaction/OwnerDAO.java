package org.spring.transaction;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class OwnerDAO implements OwnerDAOIfc {
	private JdbcTemplate jdbcTemplate;
	private PlatformTransactionManager transactionManager;
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
	      this.transactionManager = transactionManager;
	   }
	
	
	public void setJdbcTemplate(JdbcTemplate template){
		this.jdbcTemplate=template;
	}
	
	public Owner ownerDetails(int id){
		String sql="Select * from Owner where voter_id=?";
		Owner owner=jdbcTemplate.queryForObject(sql, new Object[]{id}, new OwnerMapper());
		return owner;
	}
	
	public void insertOwnerRecord(Owner owner){
		TransactionDefinition def=new DefaultTransactionDefinition();
		TransactionStatus status=transactionManager.getTransaction(def);
		try{
			String sql="insert into owner values('"+
						owner.getVoterID()+ "','"+
						owner.getName()+"',"+
						owner.getContact().getMobileNumber()+")";
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