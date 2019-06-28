package com.forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.dao.TopicDao;
import com.forum.domain.Topic;
import com.forum.domain.User;

@Service
public class TopicService {
	@Autowired
	private TopicDao topicDao;
	
	public List<Topic> getAllTopic(int boardId){
		return topicDao.getAllTopics(boardId);
	}
	public int addTopic(Topic topic, User user) {
		return topicDao.addTopic(topic, user); 
	}
	public Topic getTopicById(int topicId) {
		return topicDao.getTopicById(topicId);
	}
}