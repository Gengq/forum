package com.forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.dao.PostDao;
import com.forum.domain.Post;
import com.forum.domain.Topic;
import com.forum.domain.User;

@Service
public class PostService {

	@Autowired
	private PostDao postDao;
	
	public List<Post> getAllPosts(int topicId){
		return postDao.getAllPosts(topicId);
	}
	public int addPost(Post post,Topic topic,User user, int post_type) {
		return postDao.addPost(post, topic, user, post_type);
	}
}
