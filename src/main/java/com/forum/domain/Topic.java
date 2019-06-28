package com.forum.domain;

import java.util.Date;

public class Topic {
	private int topic_id;
	private int board_id;
	private String topic_title;
	private int user_id;
	private Date create_time;
	private Date last_post;
	private int topic_views;
	private int topic_replies;
	private int digest;
	public int getTopic_id() {
		return topic_id;
	}
	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getTopic_title() {
		return topic_title;
	}
	public void setTopic_title(String topic_title) {
		this.topic_title = topic_title;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getLast_post() {
		return last_post;
	}
	public void setLast_post(Date last_post) {
		this.last_post = last_post;
	}
	public int getTopic_views() {
		return topic_views;
	}
	public void setTopic_views(int topic_views) {
		this.topic_views = topic_views;
	}
	public int getTopic_replies() {
		return topic_replies;
	}
	public void setTopic_replies(int topic_replies) {
		this.topic_replies = topic_replies;
	}
	public int getDigest() {
		return digest;
	}
	public void setDigest(int digest) {
		this.digest = digest;
	}
	public String toString() {
		return "title:"+topic_title+",topic_id:"+topic_id;
	}
	
}
