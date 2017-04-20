package com.github.nenomm.im.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;

public class MyDaoImpl implements MyDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int numberOfUsers() {
		return jdbcTemplate.queryForObject("select count(*) from users;", new Object[] {}, Integer.class);
	}

	@Override
	public void removeFirst() {
		jdbcTemplate.execute("delete from users where id = 1;");
	}
}
