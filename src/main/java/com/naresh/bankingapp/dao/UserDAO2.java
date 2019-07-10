package com.naresh.bankingapp.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naresh.bankingapp.model.User;

@Repository
public class UserDAO2 {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(User user) {

		System.out.println("UserDAO2->save" + user);
		Session session = null;
		try {
			System.out.println(sessionFactory);
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
