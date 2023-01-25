package com.booksLover.java.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.booksLover.java.book.service.BookService;
import com.booksLover.java.book.service.BookVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//
/**
 * @create 01/25/23
 * @author sunjin
 * @title Naver Book Search
 */
@RestController
@RequestMapping("/")
public class BookController {

	@Autowired
	BookService bookService;
	
//	// 책 검색 요청 함수
//	@GetMapping("book/search")
//	public String searchBook(@RequestParam(value = "keyword", defaultValue = "아홉살인생") String keyword, Model model) {
////		BookVO bookVO = new BookVO();
////		bookVO.setTitle(keyword);
//		
//		model.addAttribute("bookInfo", bookService.search(keyword));
//
//		return bookService.search(keyword);
//	}
	
	// 책 검색 요청 함수
	@GetMapping("book/search-detail")
	public ModelAndView searchBook(@RequestParam(value = "keyword", required = false) String keyword) throws JsonMappingException, JsonProcessingException {
		ModelAndView viewName = new ModelAndView();
		if(keyword == "") {
			System.out.println("검색 결과가 없습니다 페이지 리턴");
			viewName.setViewName("page/search/noResult");
			return viewName;
		} else {
			Object bookResultArray = bookService.doSearch(keyword);
			System.out.println(bookResultArray);
			
			viewName.setViewName("page/search/bookSearchDetail");
			viewName.addObject("keyword", keyword);
			viewName.addObject("bookInfo", bookResultArray);
			
			return viewName;
		}
		
	}

}
