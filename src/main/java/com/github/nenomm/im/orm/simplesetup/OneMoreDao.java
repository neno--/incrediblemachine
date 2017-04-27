package com.github.nenomm.im.orm.simplesetup;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OneMoreDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List findUsers() {
		return this.sessionFactory.getCurrentSession()
				.createQuery("from RealUser")
				.list();
	}
}
