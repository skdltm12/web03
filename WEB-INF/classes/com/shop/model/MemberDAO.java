package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;

import com.shop.common.JDBCConnection;
import com.shop.common.MemberVO;

public class MemberDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	int cnt = 0;
	public int addMember(MemberVO vo) { //회원가입
		String pw = Base64.getEncoder().encodeToString(vo.getMpw().getBytes());
		try {
			conn = JDBCConnection.getConnection();
			sql = "insert into member values(?, ?, ?, ?, ?, ?, ?, ?, sysdate, '9')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, pw);
			pstmt.setString(3, vo.getMname());
			pstmt.setString(4, vo.getMemail());
			pstmt.setString(5, vo.getMtel());
			pstmt.setString(6, vo.getAddr1());
			pstmt.setString(7, vo.getAddr2());
			pstmt.setString(8, vo.getPostcode());
			
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(pstmt, conn);
		}
		return cnt;
	}
	
	public int editMember(MemberVO vo) {  //회원정보수정
		String pw = Base64.getEncoder().encodeToString(vo.getMpw().getBytes());
		try {
			conn = JDBCConnection.getConnection();
			sql = "update member set mpw=?, memail=?, mtel=?, addr1=?, addr2=?, postcode=? where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, vo.getMemail());
			pstmt.setString(3, vo.getMtel());
			pstmt.setString(4, vo.getAddr1());
			pstmt.setString(5, vo.getAddr2());
			pstmt.setString(6, vo.getPostcode());
			pstmt.setString(7, vo.getMid());
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(pstmt, conn);
		}
		return cnt;
	}
	
	public int delMember(String uid) { //회원탈퇴
		try {
			conn = JDBCConnection.getConnection();
			sql = "delete from member where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(pstmt, conn);
		}
		return cnt;
	}
	
	public int login(MemberVO vo) {  //로그인
		byte[] pwc; 
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from member where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pwc = Base64.getDecoder().decode(rs.getString("mpw"));
				String pw = new String(pwc);
				if(vo.getMpw().equals(pw)) { //복호화하여 비교
					cnt = 1;
				} else {
					cnt = 0;
				}
			} else {
				cnt = 0;
			}
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		return cnt;
	}
	
	public int idCheck(String uid) { //아이디 중복체크
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from member where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = 1;
			} else {
				cnt = 0;
			}
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		return cnt;
	}
	
	public ArrayList<MemberVO> getMemberList() {  //관리자 회원목록 보기
		ArrayList<MemberVO> list = null;
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<MemberVO>();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setMname(rs.getString("mname"));
				vo.setMid(rs.getString("mid"));
				vo.setMpw(rs.getString("mpw"));
				vo.setMemail(rs.getString("memail"));
				vo.setMtel(rs.getString("mtel"));
				vo.setAddr1(rs.getString("addr1"));
				vo.setAddr1(rs.getString("addr2"));
				vo.setPostcode(rs.getString("postcode"));
				vo.setMjoindate(rs.getDate("mjoindate"));
				list.add(vo);
			}
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		return list;
	}
	
	public MemberVO getMember(String uid) { //관리자 회원정보 상세보기
		byte[] pwc;
		MemberVO member = new MemberVO();
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from member where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setMid(rs.getString("mid"));
				pwc = Base64.getDecoder().decode(rs.getString("mpw"));
				String pw = new String(pwc);
				member.setMid(rs.getString("mid"));
				member.setMpw(rs.getString("mpw"));
				member.setMemail(rs.getString("memail"));
				member.setMtel(rs.getString("mtel"));
				member.setAddr1(rs.getString("addr1"));
				member.setAddr2(rs.getString("addr2"));
				member.setPostcode(rs.getString("postcode"));
				member.setMjoindate(rs.getDate("mjoindate"));
			}
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		return member;
	}
}
