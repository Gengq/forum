package com.forum.service;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.dao.LoginLogDao;
import com.forum.dao.UserDao;
import com.forum.domain.User;
import com.forum.exception.UserExistException;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private LoginLogDao loginLogDao;
	
	public User getUserByUserName(String userName) {
		User user = userDao.getUserByUserName(userName);
		return user;
	}
	
	public int updateUserCredit(User user) {
		return userDao.updateCredit(user);
	}
	public int updateUserLog(User user,String lastIp,Date lastDate) {
		return loginLogDao.updateLoginLog(user,lastIp,lastDate);
	}
	public void registUser(User user) throws UserExistException{
		User theUser = userDao.getUserByUserName(user.getUserName());
		if(theUser.getUserName()!= null) {
				throw new UserExistException("用户名已存在");
		}else {
			user.setCredit(0);
			user.setLocked(0);
			user.setUserType(0);
			userDao.registUser(user);
		}
	}
}
