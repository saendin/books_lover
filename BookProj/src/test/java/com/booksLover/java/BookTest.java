package com.booksLover.java;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.booksLover.java.book.service.BookService;

public class BookTest {
	
	@Autowired
	BookService bookService;
	
	//회원 리스트 조회 테스트
	@Test
	@Transactional
	public void bookSearchAPITest() {
		System.out.println("====test를 시작합니다.====");
		
		bookService.doSearch("아홉살인생");
	}
}
