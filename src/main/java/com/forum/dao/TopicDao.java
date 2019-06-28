package com.forum.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.forum.domain.Topic;
import com.forum.domain.User;

@Repository
public class TopicDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Topic> getAllTopics (int boardId){
		String sql = "select * from t_topic where board_id=?";
		RowMapper<Topic> rowMapper = new BeanPropertyRowMapper<Topic>(Topic.class);
		List<Topic> allTopics = jdbcTemplate.query(sql,new Object[]{boardId},rowMapper);
		return allTopics;
	}
	public int addTopic(Topic topic, User user) {
		String insertSql = "insert t_topic(topic_title,user_id,board_id,create_time,last_post,digest) values(?,?,?,?,?,?)";
		Object[] args = {topic.getTopic_title(),
									user.getUserId(),
									topic.getBoard_id(),
									topic.getCreate_time(),
									topic.getLast_post(),topic.getDigest()};
		return jdbcTemplate.update(insertSql,args);
	}
	public Topic getTopicById(int topicId) {
		String sql = "select * from t_topic where topic_id=?";
		RowMapper<Topic> rowMapper = new BeanPropertyRowMapper<Topic>(Topic.class);
		try {
			Topic topic = (Topic)jdbcTemplate.queryForObject(sql, rowMapper, topicId);
			return topic;
		}catch(EmptyResultDataAccessException e) {
			return new Topic();
		}
	}
}
