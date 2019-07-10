package com.naresh.bankingapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
	
	public User login(String email,String password) {
		User user = null;
		Session session = sessionFactory.getCurrentSession();
		Query<User> createQuery = session.createQuery("from User u where email = ?1 and password=?2", User.class);
		createQuery.setParameter(1, email);
		createQuery.setParameter(2, password);
		try {
			user = createQuery.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public List<User> list(){
		Session session = sessionFactory.getCurrentSession();
		List<User> list = session.createQuery("from User",User.class).list();
		return list;
	}

}
