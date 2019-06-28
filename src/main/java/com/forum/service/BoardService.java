package com.forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.dao.BoardDao;
import com.forum.domain.Board;

@Service
public class BoardService {
	@Autowired
	private BoardDao boardDao;

	public List<Board> getAllBoards(){
		return boardDao.getAllBoards();
	}
	public int addBoard(Board board) {
		return boardDao.addBoard(board);
	}
	public Board getBoardById(int boardId) {
		return boardDao.getBoardById(boardId);
	}
}
