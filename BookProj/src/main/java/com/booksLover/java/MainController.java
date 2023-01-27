package com.booksLover.java;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.booksLover.java.member.service.MemberService;
import com.booksLover.java.member.service.MemberVO;

@RestController
@RequestMapping("/")
public class MainController {

	@Autowired
	MemberService memberService;
	
	@GetMapping("")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("page/main/main");
		return modelAndView;
	}
	
	/*
	 * 로그인
	 */
	//로그인
	@GetMapping("login")
	public ModelAndView login() {
		ModelAndView viewName = new ModelAndView();
		viewName.setViewName("page/login/loginForm");
		return viewName;
	} 
	
	
	//마이페이지 (회원 리스트 반환(test))
	@GetMapping("my-page")
	public ModelAndView getMemberList() throws Exception{
		List<MemberVO> memberList = memberService.getAllMemberList();
		
		ModelAndView viewName = new ModelAndView();
		viewName.setViewName("page/myPage/myPage");
		viewName.addObject("list", memberList);
		
		return viewName;

	}


	
	

	
}
