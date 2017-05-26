package com.github.nenomm.im.jdbc.simplejdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SomeDao {
	static Logger logger = LoggerFactory.getLogger(SomeDao.class);
	private JdbcTemplate jdbcTemplate;

	// this is supposed to be a best practice, although jdbcTemplate is threadsafe and can be shared between DAOs
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public String getUserName(long id) {
		return jdbcTemplate.queryForObject("select name from users where id = ?", new Object[] { id }, String.class);
	}

	public User findUser(long id) {
		logger.info("Fetching user for id={}", id);

		return jdbcTemplate.queryForObject(
				"select name from users where id = ?",
				new Object[] { id },
				new RowMapper<User>() {
					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
						User user = new User();
						user.setName(rs.getString("name"));
						return user;
					}
				});
	}

	public List<User> findUsers() {
		return jdbcTemplate.query(
				"select name from users",
				new RowMapper<User>() {
					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
						User user = new User();
						user.setName(rs.getString("name"));
						return user;
					}
				});
	}

}
