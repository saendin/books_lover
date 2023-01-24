package com.booksLover.java;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.booksLover.java.review.service.ReviewService;
import com.booksLover.java.review.service.ReviewVO;

@SpringBootTest
public class ReviewTest {

	@Autowired
	ReviewService service;
	
	@Test
	public void selectTest() {
		System.out.println("==SELECT TEST==");
		List<ReviewVO> list = service.getAllReview();
		for(ReviewVO vo : list) {
			System.out.println(vo.getReviewId()+". "+vo.getReviewTitle());
		}
		ReviewVO vo = service.getOneReview(1);
		System.out.println(vo.getReviewWriter());
	}
}
