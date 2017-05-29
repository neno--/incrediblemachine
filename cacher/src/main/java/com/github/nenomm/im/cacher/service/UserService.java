package com.github.nenomm.im.cacher.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.github.nenomm.im.jdbc.simplejdbc.SomeDao;
import com.github.nenomm.im.jdbc.simplejdbc.User;

@Service
public class UserService {
	static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private SomeDao someDao;

	public User findUser(long id) {
		return someDao.findUser(id);
	}

	@Cacheable("users")
	public User findCachedUser(long id) {
		logger.info("Invoking findCachedUser...");
		return someDao.findUser(id);
	}
}
