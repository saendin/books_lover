package com.booksLover.java.member.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.booksLover.java.member.service.MemberService;
import com.booksLover.java.member.service.MemberVO;

/**
 * @create 01/18/23
 * @author sunjin
 * @title Member Controller
 */
@RestController
@RequestMapping("/")
public class MemberController {

	@Autowired
	MemberService memService;
	
	

	//마이페이지 (회원 리스트 반환(test))
	@GetMapping("my-page")
	public ModelAndView getMemberList() throws Exception{
		List<MemberVO> memberList = memService.getAllMemberList();
		
		ModelAndView viewName = new ModelAndView();
		viewName.setViewName("page/member/myPage");
		viewName.addObject("list", memberList);
		
		return viewName;

	}
	
	//정보수정
	@GetMapping("my-page/update")
	public ModelAndView getMemberProfile(Model model, String id) {
		id="user1";
		MemberVO user = memService.getMember(id);
		
		ModelAndView viewName = new ModelAndView();
		viewName.setViewName("page/member/myPageEditForm");
		viewName.addObject("user", user);
		
		return viewName;
	}
	
//	//비밀번호 체크
//	@GetMapping("/check-pw-form")
//	public String doubleCheckPw(Model model, String id) throws Exception{
//		id="user1";
//		MemberVO user = memService.getMember(id);
////		user.setMemPw(memberVO.getMemPw());
////		List<MemberVO> memberList = memService.getAllMemberList();
//		String test = String.valueOf(user);
////		System.out.println(test);
//		model.addAttribute("user", user);
//		return "page/member/checkPwForm";
//
//	}
	
	//비밀번호 체크
	@GetMapping("my-page/check-pw-form/{id}")
	public ModelAndView checkPw(Model model,@PathVariable String id) throws Exception{
		id="user1";
		MemberVO user = memService.getMember(id);
		
		ModelAndView viewName = new ModelAndView();
		viewName.setViewName("page/member/checkPwForm");
		viewName.addObject("user", user);
//		user.setMemPw(memberVO.getMemPw());
//		List<MemberVO> memberList = memService.getAllMemberList();
//		System.out.println(test);
		return viewName;

	}
}
