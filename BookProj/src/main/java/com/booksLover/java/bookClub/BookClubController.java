package com.booksLover.java.bookClub;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/book-club")
public class BookClubController {

	
	@GetMapping("")
	public ModelAndView bookClub() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("page/club/bookClub");
		return modelAndView;
	}

	
	@GetMapping("/detail")
	public ModelAndView detailList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("page/club/clubDetail");
		return modelAndView;
	}


}
