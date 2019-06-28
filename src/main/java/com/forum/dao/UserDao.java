package com.forum.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.forum.domain.User;

@Repository
public class UserDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public User getUserByUserName(String userName) {
		String sqlStr = "SELECT * FROM t_user"
								+" WHERE user_name=?";
		Log log = LogFactory.getLog(this.getClass());
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		try {
			User user = jdbcTemplate.queryForObject(sqlStr, rowMapper,userName);
			log.info("user:"+user.toString());
			return user;
		}
		catch(EmptyResultDataAccessException e) {
			return new User();
		}
	}
	
	public int updateCredit(User user) {
		String sqlStr = "update t_user set credit=? where user_name=?";
		Object[] params = new Object[]{
			user.getCredit()+5,
			user.getUserName()
		};
		int num = this.jdbcTemplate.update(sqlStr, params);
		return num;
	}
	
	public int registUser(User user) {
		String sqlRegist = "insert into t_user(user_name,password,user_type,credit) value(?,?,?,?)";
		Object[] params = new Object[] {
				user.getUserName(),
				user.getPassword(),
				user.getUserType(),
				user.getCredit()
		};
		int num = jdbcTemplate.update(sqlRegist,params);
		return num;
	}
	
	public User findUserByUserName(final String userName) {
		String sqlStr = "SELECT user_id,user_name,credits"
								+" FROM t_user WHERE user_name=?";
		final User user = new User();
		jdbcTemplate.query(sqlStr, new Object[] {userName},
					new RowCallbackHandler() {
						public void processRow(ResultSet rs)throws SQLException{
							user.setUserId(rs.getInt("user_id"));
							user.setUserName(userName);
							user.setCredit(rs.getInt("credit"));
						}
					}
				);
		return user;
	}
}