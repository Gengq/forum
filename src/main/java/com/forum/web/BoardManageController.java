package com.forum.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.forum.domain.Board;
import com.forum.service.BoardService;

@Controller
public class BoardManageController {
	
	@Autowired
	private BoardService boardService;
	
	//列出所有版块信息
	@RequestMapping("/boardListAll")
	public ModelAndView listAllBoard() {
		List<Board> boards = boardService.getAllBoards();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("boardListAll");
		mav.addObject("boards", boards);
		return mav;
	}
	@RequestMapping("/newBoard")
	public String newBoard() {
		return "addBoard";
	}
	//添加版块
	@RequestMapping(value="/addBoard",method=RequestMethod.POST)
	public ModelAndView addBoard(HttpServletRequest request,Board board) {
		ModelAndView mav = new ModelAndView();
		if(boardService.addBoard(board)>0)
			mav.setViewName("success");
		else
			mav.setViewName("error");
		return mav;
	}

}
