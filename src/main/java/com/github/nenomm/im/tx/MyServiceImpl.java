package com.github.nenomm.im.tx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class MyServiceImpl implements MyService {
	static Logger logger = LoggerFactory.getLogger(MyServiceImpl.class);

	@Autowired
	private MyDao myDao;

	@Override
	public int getNumberOfUsers() {
		logger.info("getting number of users");
		return myDao.numberOfUsers();
	}

	@Override
	@Transactional(rollbackFor = MyServiceException.class, propagation = Propagation.MANDATORY)
	public void playAroundWithTx() throws MyServiceException {
		logger.info("First count: {}", myDao.numberOfUsers());

		myDao.removeFirst();

		logger.info("Second count: {}", myDao.numberOfUsers());

		throw new MyServiceException();
	}
}
