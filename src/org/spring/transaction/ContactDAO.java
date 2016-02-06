package org.spring.transaction;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class ContactDAO implements ContactDAOIfc {

	private JdbcTemplate jdbcTemplate;
	private PlatformTransactionManager transactionManager;
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
	      this.transactionManager = transactionManager;
	   }
	
	public void setJdbcTemplate(JdbcTemplate template){
		this.jdbcTemplate=template;
	}
	
	public ContactDetails contactDetails(int id){
		String sql="Select * from Contact_details where mobile=?";
		ContactDetails contact=jdbcTemplate.queryForObject(sql, new Object[]{id}, new ContactMapper());
		return contact;
	}
	public void insertContactRecord(ContactDetails contact){
		TransactionDefinition def=new DefaultTransactionDefinition();
		TransactionStatus status=transactionManager.getTransaction(def);
		try{
			String sql="insert into contact_details values("+
						contact.getMobileNumber()+ ",'"+
						contact.getCity()+ "','"+
						contact.getHouse_street()+ "',"+
						contact.getPincode()+")";
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