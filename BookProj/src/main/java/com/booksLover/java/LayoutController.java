package com.booksLover.java;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LayoutController {

	
	@GetMapping("")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("page/main");
		return modelAndView;
	}
	
	@GetMapping("bookReview")
	public ModelAndView bookReview() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("page/review/bookReview");
		return modelAndView;
	}
	
	
	@GetMapping("bookSearch")
	public ModelAndView booSearch() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("page/search/bookSearch");
		return modelAndView;
	}
	
//	@GetMapping("bookClub")
//	public ModelAndView bookClub() {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("page/club/bookClub");
//		return modelAndView;
//	}
	
	@GetMapping("myPage")
	public ModelAndView myPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("page/my/myPage");
		return modelAndView;
	}
	
	@GetMapping("login")
	public ModelAndView lgoin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("page/member/login");
		return modelAndView;
	}
	
}
