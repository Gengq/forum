package com.forum.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.forum.cons.CommonConstants;
import com.forum.domain.User;
import com.forum.exception.UserExistException;
import com.forum.service.UserService;

@Controller
public class LoginController{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:/boardListAll.html");
		return mav;
	}
	
	@RequestMapping("/loginCheck.html")
	public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand) {
		//通过用户名获取用户对象
		User user = userService.getUserByUserName(loginCommand.getUserName());
		if(user.getUserName() == null) {
			return new ModelAndView("forward:/login.jsp","error","用户名错误");
		}
		if(!user.getPassword().equals(loginCommand.getPassword())) {
			return new ModelAndView("forward:/login.jsp","error","密码错误");
		}
		else {
			//更新用户积分
			userService.updateUserCredit(user);
			//更新用户日志
			userService.updateUserLog(user, request.getRemoteAddr(), new Date());
			//设置session中user
			request.getSession().setAttribute(CommonConstants.USER_CONTEXT, user);
			return new ModelAndView("forward:/index.html");
		}
	}
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.removeAttribute(CommonConstants.USER_CONTEXT);
		return new ModelAndView("forward:/index.html");
	}

}