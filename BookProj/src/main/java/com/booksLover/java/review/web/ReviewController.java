package com.booksLover.java.review.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.booksLover.java.review.service.ReviewService;

/*
 * 
 */
@Controller
public class ReviewController {

	@Autowired
	ReviewService service;
	
	@GetMapping("/book-review")
	public ModelAndView bookReview() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("page/review/bookReview");
		mv.addObject("reviewList", service.getAllReview());
		return mv;
	}
	@GetMapping("/book-review/detail")
	public String reviewDetail(Model model, int reviewId) {
		model.addAttribute("detail", service.getOneReview(reviewId));
		return "page/review/bookReviewDetail";
	}
}
