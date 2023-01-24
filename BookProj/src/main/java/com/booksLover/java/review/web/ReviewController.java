package com.booksLover.java.review.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.booksLover.java.review.service.ReviewService;

/*
 * 
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
	 public String reviewDetail(Model model, int reviewId) {
	 model.addAttribute("detail", service.getOneReview(reviewId)); 
	 return "page/review/bookReviewDetail"; }
	 
}
