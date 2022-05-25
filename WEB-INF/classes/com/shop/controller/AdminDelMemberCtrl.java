package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.model.MemberDAO;

@WebServlet("/AdminDelMemberCtrl")
public class AdminDelMemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AdminDelMemberCtrl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		MemberDAO dao = new MemberDAO();
		int cnt = dao.delMember(mid);
		if(cnt>0) {  //회원탈퇴 성공
			response.sendRedirect("/GetMemberListCtrl");
		} else {  //회원탈퇴 실패
			response.sendRedirect("./index.jsp");
		}	
	}
}