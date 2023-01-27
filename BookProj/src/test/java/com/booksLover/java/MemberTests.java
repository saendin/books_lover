package com.booksLover.java;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.booksLover.java.book.service.BookService;
import com.booksLover.java.book.service.BookVO;
import com.booksLover.java.member.mapper.MemberMapper;
import com.booksLover.java.member.service.MemberService;
import com.booksLover.java.member.service.MemberVO;

@SpringBootTest
class MemberTests {

	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	MemberService memberService;
	
	//회원 리스트 조회 테스트
	@Test
	@Transactional
	@Rollback(false)
	public void getAllMemberTest() {
		System.out.println("test를 시작합니다.");
		
		List<MemberVO> memberList = new ArrayList<>();
		
		for(int i=0; i<memberList.size(); i++) {
			System.out.println(memberList);
		}
		
		memberService.getAllMemberList();
	}


}
