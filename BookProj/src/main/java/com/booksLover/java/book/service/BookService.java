package com.booksLover.java.book.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @create 01/25/23
 * @author sunjin
 * @title Naver Book Search Service Interface
 */
@Service
public interface BookService {
	
	@Transactional(readOnly = true)
	public Object doSearch(String keyword);

}
