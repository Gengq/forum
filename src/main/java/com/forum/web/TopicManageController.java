package com.forum.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.forum.cons.CommonConstants;
import com.forum.domain.Board;
import com.forum.domain.Post;
import com.forum.domain.Topic;
import com.forum.domain.User;
import com.forum.service.BoardService;
import com.forum.service.PostService;
import com.forum.service.TopicService;

@Controller
public class TopicManageController {
	
	@Autowired
	private TopicService topicService;
	@Autowired
	private PostService postService;
	@Autowired
	private BoardService boardService;
	
	//列出某版块内的所有话题
	@RequestMapping("/topicListAll-{boardId}")
	public ModelAndView topicListAll(@PathVariable Integer boardId) {
		Log log = LogFactory.getLog(this.getClass());
		log.info(boardId);
		List<Topic> topics = topicService.getAllTopic(boardId);
		ModelAndView mav = new ModelAndView();
		mav.addObject("topics", topics);
		Board board = boardService.getBoardById(boardId);
		mav.addObject("board",board);
		mav.setViewName("topicListAll");
		return mav;
	}
	
	//
	@RequestMapping(value = "/addTopicPage-{boardId}", method = RequestMethod.GET)
	public ModelAndView addTopicPage(@PathVariable Integer boardId) {
		ModelAndView view =new ModelAndView();
		view.addObject("boardId", boardId);
		view.setViewName("/addTopic");
		return view;
	}
	
	//添加话题
	@RequestMapping(value = "/addTopic", method = RequestMethod.POST)
	public ModelAndView addTopic(HttpServletRequest request,Topic topic) {
		Log log = LogFactory.getLog(this.getClass());
		ModelAndView mav = new ModelAndView();
		topic.setBoard_id(Integer.parseInt(request.getParameter("boardId")));
		topic.setCreate_time(new Date());
		topic.setLast_post(new Date());
		topic.setDigest(0);
		User user = (User)request.getSession().getAttribute(CommonConstants.USER_CONTEXT);
		if(user == null) {
			mav.setViewName("error");
			return mav;
		}
		topicService.addTopic(topic, user );
		Post post = new Post();
		post.setTopic_id(topic.getTopic_id());
		post.setBoard_id(topic.getBoard_id());
		post.setCreate_time(new Date());
		post.setPost_title("主题贴");
		post.setPost_text(topic.getTopic_title());
		post.setTopic_id(topic.getTopic_id());
		post.setUser_id(user.getUserId());
		//在创建话题的同时创建主贴,设置其帖子类型为1，表示主贴
		postService.addPost(post, topic, user, 1);
		log.info(topic);
		mav.setViewName("forward:/postListAll-"+topic.getTopic_id()+".html");
		return mav;
	}
}
