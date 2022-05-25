package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.BoardVO;
import com.shop.model.BoardDAO;


@WebServlet("/addBoardCtrl")
public class addBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public addBoardCtrl() {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String nickname = request.getParameter("nickname");
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setNickname(nickname);
		
		BoardDAO board = new BoardDAO();
		int cnt = board.addBoard(vo);
		if(cnt>0) {	//등록성공
			response.sendRedirect("GetBoardListCtrl");
		} else {	//등록실패
			response.sendRedirect("./board/addBoardForm.jsp");
		}
	}

}
