package com.forum.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.forum.domain.Board;

@Repository
public class BoardDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int addBoard(Board board) {
		String insertSql = "insert t_board(board_name,board_desc) values(?,?)";
		Object[] args = {board.getBoard_name(),board.getBoard_desc()};
		return jdbcTemplate.update(insertSql,args);
	}
	public List<Board> getAllBoards() {
		RowMapper<Board> rowmapper = new BeanPropertyRowMapper<Board>(Board.class);
		String sql = "select * from t_board";
		List<Board> list = jdbcTemplate.query(sql,rowmapper);
		Log log = LogFactory.getLog(this.getClass());
		for(Board a :list) {
			log.info(a.toString());
		}
		return list;
	}
	public Board getBoardById(int boardId) {
		String sql = "select * from t_board where board_id=?";
		RowMapper<Board> rowMapper = new BeanPropertyRowMapper<Board>(Board.class);
		try {
			if(boardId > 0) {
				Board board = jdbcTemplate.queryForObject(sql,rowMapper, boardId);
				return board; 
			}else {
				return new Board();
			}
		}catch(EmptyResultDataAccessException e) {
			return new Board();
		}
	}
}
