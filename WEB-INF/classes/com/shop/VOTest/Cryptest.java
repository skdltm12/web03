package com.shop.VOTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Base64;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Cryptest {

	private String data = "1234";
	private String encoding;
	private String indata = "VmtaYVUxTnRWbkpPVlZaWFZrVnJPUT09";							 
	private byte[] decoding;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void Cryptest1() {
		encoding = Base64.getEncoder().encodeToString(data.getBytes());
		System.out.println("암호화된 데이터 : "+encoding);
		fail("암호화 테스트 실패");
	}
	
	@Test
	void Cryptest2() {
		decoding = Base64.getDecoder().decode(indata);
		String StrDecode = new String(decoding);
		System.out.println("복호화된 데이터 : "+StrDecode);
		fail("복호화 테스트 실패");
	}

}
