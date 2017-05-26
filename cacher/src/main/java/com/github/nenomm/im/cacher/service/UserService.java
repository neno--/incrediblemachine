package com.github.nenomm.im.cacher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.nenomm.im.jdbc.simplejdbc.SomeDao;
import com.github.nenomm.im.jdbc.simplejdbc.User;

@Service
public class UserService {
	@Autowired
	private SomeDao someDao;

	public User findUser(long id) {
		return someDao.findUser(id);
	}

	public User findCachedUser(long id) {
		return someDao.findUser(id);
	}
}
