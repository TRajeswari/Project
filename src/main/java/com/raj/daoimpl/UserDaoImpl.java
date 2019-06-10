package com.raj.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raj.model.User;

@Component
public class UserDaoImpl 
{
	@Autowired
	SessionFactory factory;
	public void saveUser(User user)
	{
		Session session= factory.openSession();
		user.setRole("USER_NAME");
		user.setEnabled(true);
		session.save(user);
		Transaction transaction=session.beginTransaction();
		transaction.commit();	
	}
	
	
	

}
