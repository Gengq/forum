package com.forum.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.forum.domain.Post;
import com.forum.domain.Topic;
import com.forum.domain.User;

@Repository
public class PostDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Post> getAllPosts(int topicId){
		String sql = "select * from t_post where topic_id=?";
		RowMapper<Post> rowMapper = new BeanPropertyRowMapper<Post>(Post.class);
		List<Post> posts = jdbcTemplate.query(sql,new Object[] {topicId},rowMapper);
		return posts;
	}
	public int addPost(Post post,Topic topic,User user, int post_type) {
		String sql = "insert t_post(board_id,topic_id,user_id,post_type,post_title,post_text,create_time) values(?,?,?,?,?,?,?)";
		Object[] o = {
			topic.getBoard_id(),
			topic.getTopic_id(),
			user.getUserId(),
			post_type,
			post.getPost_title(),
			post.getPost_text(),
			new Date()
		};
		int i = jdbcTemplate.update(sql,o);
		if(i > 0) {
			System.out.println("susses");
		}
		return i;
	}
}
