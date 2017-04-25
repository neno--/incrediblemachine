package com.github.nenomm.im.jdbc.sqlquery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import com.github.nenomm.im.jdbc.simplejdbc.User;

public class UserMappingQuery extends MappingSqlQuery<User> {
	public UserMappingQuery(DataSource ds) {
		super(ds, "select name from users where id = ?");
		super.declareParameter(new SqlParameter("id", Types.INTEGER));
		compile();
	}

	@Override
	protected User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setName(rs.getString("name"));
		return user;
	}
}
