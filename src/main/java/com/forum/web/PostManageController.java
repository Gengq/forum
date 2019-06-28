package com.forum.web;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.forum.cons.CommonConstants;
import com.forum.domain.Post;
import com.forum.domain.Topic;
import com.forum.domain.User;
import com.forum.service.PostService;
import com.forum.service.TopicService;
import com.forum.service.UserService;

@Controller
public class PostManageController {

	@Autowired
	private PostService postService;
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/postListAll-{topicId}")
	public ModelAndView postListAll(@PathVariable Integer topicId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("posts", postService.getAllPosts(topicId));
		mav.addObject("topicId",topicId);
		mav.addObject("topic",topicService.getTopicById(topicId));
		mav.setViewName("postListAll");
		return mav;
	}
	@RequestMapping("/addPostPage-{topicId}")
	public ModelAndView addPostPage(@PathVariable Integer topicId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("topicId", topicId);
		mav.addObject("topic",topicService.getTopicById(topicId));
		mav.setViewName("/addPost");
		return mav;
	}
	@RequestMapping("/addPost")
	public ModelAndView addPost(HttpServletRequest request, Post post) {
		System.out.println("*****"+post.toString());
		ModelAndView mav = new ModelAndView();
		Topic topic = topicService.getTopicById(Integer.parseInt(request.getParameter("topicId")));
		User user = (User)request.getSession().getAttribute(CommonConstants.USER_CONTEXT);
		if(user == null) {
			mav.setViewName("error");
			return mav;
		}
		post.setBoard_id(topic.getBoard_id());
		post.setCreate_time(new Date());
		postService.addPost(post, topic, user, 2);
		mav.setViewName("forward:/postListAll-"+topic.getTopic_id()+".html");
		return mav;
	}
}
