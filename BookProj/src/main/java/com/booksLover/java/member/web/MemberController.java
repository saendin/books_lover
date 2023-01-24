package com.booksLover.java.member.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.booksLover.java.member.service.MemberService;
import com.booksLover.java.member.service.MemberVO;



@RestController
@RequestMapping("/") //요청 URI 묶을 단위
public class MemberController {

	@Autowired
	MemberService memService;
	
//	@GetMapping
//	public ModelAndView main() {
//		//데이터와 뷰를 동시에 설정 가능
////		List<MemberVO> memberList = memService.getAllMemberList();
//		ModelAndView viewName = new ModelAndView();
//		viewName.setViewName("page/main"); //뷰의 이름
////		viewName.addObject("list", memberList);
//		
//		return viewName;
//	}

	
	//회원 리스트 반환
	@GetMapping("my-page")
	public ModelAndView getMemberList() throws Exception{
		List<MemberVO> memberList = memService.getAllMemberList();
		
		ModelAndView viewName = new ModelAndView();
		viewName.setViewName("page/my/myPage");
		viewName.addObject("list", memberList);
		
		return viewName;

	}
}
