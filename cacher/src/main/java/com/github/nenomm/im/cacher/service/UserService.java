package com.github.nenomm.im.cacher.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.nenomm.im.jdbc.simplejdbc.SomeDao;
import com.github.nenomm.im.jdbc.simplejdbc.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private SomeDao someDao;

	public User findUser(long id) {
		return someDao.findUser(id);
	}
}
