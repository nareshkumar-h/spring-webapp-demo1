package com.naresh.bankingapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naresh.bankingapp.model.User;

@Repository
public class UserDAO3 {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(User user) {
		System.out.println("UserDAO3->save" + user);
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}
	
	public List<User> list(){
		Session session = sessionFactory.getCurrentSession();
		List<User> list = session.createQuery("from User",User.class).list();
		return list;
	}

}
