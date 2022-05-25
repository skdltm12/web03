package com.shop.VOTest;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.shop.common.BoardVO;
import com.shop.common.MemberVO;
import com.shop.model.BoardDAO;
import com.shop.model.MemberDAO;

class DAOTest {
	private BoardDAO dao1;
	private MemberDAO dao2;
	private BoardVO vo1;
	private MemberVO vo2;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("인스턴스 시작");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {	
		System.out.println("인스턴스 종료");
	}

	@BeforeEach
	void setUp() throws Exception {
		vo1 = new BoardVO();
		dao1 = new BoardDAO();
		vo1.setTitle("유닛테스트 제목220");
		vo1.setContent("JUnit Test220입니다.");
		vo1.setNickname("admin");
		System.out.println("DAO테스트 시작");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("DAO테스트 종료");
	}

	@Test
	void DAOtest() {
		dao1.addBoard(vo1);
		fail("boardDAO테스트실패");
	}

	@Test
	void DAOtest2() {
		
		fail("MemberDAO 테스트실패");
	}
}
