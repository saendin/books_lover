package com.booksLover.java;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LayoutController {

	
	@GetMapping("")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("page/main/main");
		return modelAndView;
	}
	
//	@GetMapping("book-review")
//	public ModelAndView bookReview() {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("page/review/bookReview");
//		return modelAndView;
//	}
//	
	
//	@GetMapping("book/search-detail")
//	public ModelAndView bookSearch() {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("page/search/bookSearchDetail");
//		return modelAndView;
//	}
	
//	@GetMapping("bookClub")
//	public ModelAndView bookClub() {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("page/club/bookClub");
//		return modelAndView;
//	}

	//로그인
	@GetMapping("login")
	public String login(Model model) {
		model.addAttribute("signInURL", "join"); //회원가입 URL
		return "page/login/loginForm";
	}
	
	//회원가입
	@GetMapping("join")
	public ModelAndView signIn(){
		ModelAndView signInForm = new ModelAndView("page/login/joinForm");
		signInForm.addObject("mainURL", ""); //메인 URL
		return signInForm;
	}
	
	//아이디찾기폼
	@GetMapping("help/id")
	public String findId() {
		return "page/login/findIdForm";
	}
	
	//비밀번호찾기폼
	@GetMapping("help/pw")
	public String findPw() {

		return "page/login/ForgetPwForm";
	}
	
	

	
}
