package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.MemberVO;
import com.shop.model.MemberDAO;

@WebServlet("/addMemberCtrl")
public class addMemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addMemberCtrl() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mname = request.getParameter("mname");
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String memail = request.getParameter("memail");
		String mtel = request.getParameter("mtel");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String postcode = request.getParameter("postcode");
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo.setMname(mname);
		vo.setMid(mid);
		vo.setMpw(mpw);
		vo.setMemail(memail);
		vo.setMtel(mtel);
		vo.setAddr1(addr1);
		vo.setAddr2(addr2);
		vo.setPostcode(postcode);
		int cnt = dao.addMember(vo);
		if(cnt>0) {  //회원가입 성공
			response.sendRedirect("./member/login.jsp");
		} else {  //회원가입 실패
			response.sendRedirect("./member/join.jsp");
		}	
	}
}