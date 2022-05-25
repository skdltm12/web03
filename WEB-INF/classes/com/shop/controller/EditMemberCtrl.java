package com.shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.MemberVO;
import com.shop.model.MemberDAO;

@WebServlet("/EditMemberCtrl")
public class EditMemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditMemberCtrl() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("mid");
		String userpw = request.getParameter("mpw");
		String email = request.getParameter("memail");
		String tel = request.getParameter("mtel");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String postcode = request.getParameter("postcode");
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo.setMid(userid);
		vo.setMpw(userpw);
		vo.setMemail(email);
		vo.setMtel(tel);
		vo.setAddr1(addr1);
		vo.setAddr2(addr2);
		vo.setPostcode(postcode);
		int cnt = dao.editMember(vo);
		if(cnt>0) {  //회원정보수정 성공
			response.sendRedirect("index.jsp");
		} else {  //회원정보수정 실패
			response.sendRedirect("./member/myPage.jsp");
		}	
	}
}