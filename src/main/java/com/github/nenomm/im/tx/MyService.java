package com.github.nenomm.im.tx;

public interface MyService {
	int getNumberOfUsers();

	void playAroundWithTx() throws MyServiceException;
}
