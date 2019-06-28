package com.forum.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.forum.domain.User;
import com.forum.exception.UserExistException;
import com.forum.service.UserService;

@Controller
public class RegistController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/regist" ,method=RequestMethod.POST)
	public ModelAndView registUser(HttpServletRequest request, User user ) {
		Log log = LogFactory.getLog(this.getClass());
		log.info(user);
		ModelAndView mav = new ModelAndView();
		try {
			mav.setViewName("/success");
			userService.registUser(user);
		}catch(UserExistException e) {
			mav.addObject("error","用户名已存在");
			mav.setViewName("forward:/regist.jsp");
		}
		return mav;
	}
}
