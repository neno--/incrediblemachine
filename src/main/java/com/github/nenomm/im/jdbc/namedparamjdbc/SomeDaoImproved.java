package com.github.nenomm.im.jdbc.namedparamjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.github.nenomm.im.jdbc.simplejdbc.User;

@Repository
public class SomeDaoImproved {
	private NamedParameterJdbcTemplate jdbcTemplate;

	// this is supposed to be a best practice, although jdbcTemplate is threadsafe and can be shared between DAOs
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public String getUserName(long id) {
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
		String sql = "select name from users where id = :id";

		return jdbcTemplate.queryForObject(sql, namedParameters, String.class);
	}
}
