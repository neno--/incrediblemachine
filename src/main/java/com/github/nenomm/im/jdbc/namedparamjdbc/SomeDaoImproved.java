package com.github.nenomm.im.jdbc.namedparamjdbc;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.github.nenomm.im.jdbc.simplejdbc.User;

@Repository
public class SomeDaoImproved {
	private NamedParameterJdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert simpleInsert;

	// this is supposed to be a best practice, although jdbcTemplate is threadsafe and can be shared between DAOs
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.simpleInsert = new SimpleJdbcInsert(dataSource).usingColumns("users");
	}

	public String getUserName(long id) {
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
		String sql = "select name from users where id = :id";

		return jdbcTemplate.queryForObject(sql, namedParameters, String.class);
	}

	public void insertUser(User user) {
		Map<String, Object> parameters = new HashMap<String, Object>(3);

		parameters.put("id", 100);
		parameters.put("name", user.getName());
		parameters.put("email", "test@example.com");

		simpleInsert.execute(parameters);
	}
}
