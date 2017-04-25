package com.github.nenomm.im.jdbc.sqlquery;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdvancedDao {
	private UserMappingQuery userMappingQuery;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		userMappingQuery = new UserMappingQuery(dataSource);
	}

	public String getUserName(long id) {
		return userMappingQuery.execute(id).get(0).getName();
	}
}
