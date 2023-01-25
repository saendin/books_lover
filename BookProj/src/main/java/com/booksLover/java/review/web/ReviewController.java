package com.booksLover.java.review.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.booksLover.java.review.service.ReviewService;

/**
 * @create 01/20/23
 * @author youree
 * @title Review controller
 */
@RestController
@RequestMapping("/")
public class ReviewController {

	@Autowired
	ReviewService service;

	@GetMapping("book-review")
	public ModelAndView bookReview() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("page/review/bookReview");
		mv.addObject("reviewList", service.getAllReview());
		return mv;
	}
	
	 @GetMapping("detail") 
	 public ModelAndView reviewDetail(int reviewId) {
		 //연결
		 ModelAndView mv = new ModelAndView();
		 mv.setViewName("page/review/bookReviewDetail");
		 mv.addObject("detail", service.getOneReview(reviewId)); 
		 return mv; 
	 }
	 
	 
}
