package com.forum.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.forum.domain.LoginLog;
import com.forum.domain.User;

@Repository
public class LoginLogDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int updateLoginLog(User user,String lastIp,Date lastDate) {
		String sqlQueryLog = "select * from t_login_log where user_id=?";
		try {
			RowMapper<LoginLog> rowMapper = new BeanPropertyRowMapper<LoginLog>(LoginLog.class);
			LoginLog loginLog = jdbcTemplate.queryForObject(sqlQueryLog, rowMapper,new Object[] {user.getUserId()});
		}
		catch(EmptyResultDataAccessException e) {
			String sql_Create_newlog = "insert into t_login_log(user_id,ip,login_datetime) value(?,?,?)";
			Object[] obj = {user.getUserId(),lastIp,lastDate};
			return jdbcTemplate.update(sql_Create_newlog,obj);
		}
		String sqlUpdateOldLog = "update t_login_log set ip=?,login_datetime=? where user_id=?";
		Object[] obj = {lastIp,lastDate,user.getUserId()};
		return jdbcTemplate.update(sqlUpdateOldLog,obj);
	}
}
