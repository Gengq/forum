package com.forum.domain;

import java.util.Date;

public class Post {
	private int post_id;
	private int board_id;
	private int topic_id;
	private int user_id;
	private int post_type;
	private String post_title;
	private String post_text;
	private Date create_time;
	
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public int getTopic_id() {
		return topic_id;
	}
	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getPost_type() {
		return post_type;
	}
	public void setPost_type(int post_type) {
		this.post_type = post_type;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_text() {
		return post_text;
	}
	public void setPost_text(String post_text) {
		this.post_text = post_text;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "Post [board_id=" + board_id + ", topic_id=" + topic_id + ", user_id=" + user_id + ", post_title="
				+ post_title + ", post_text=" + post_text + "]";
	}
	
}
