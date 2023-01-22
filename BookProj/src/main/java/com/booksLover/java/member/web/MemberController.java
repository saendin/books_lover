package com.booksLover.java.member.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.booksLover.java.member.service.MemberService;
import com.booksLover.java.member.service.MemberVO;


@RestController
@RequestMapping("/my-page") //요청 URI 묶을 단위
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

	
	//마이페이지 (회원 리스트 반환(test))
	@GetMapping("")
	public ModelAndView getMemberList() throws Exception{
		List<MemberVO> memberList = memService.getAllMemberList();
		
		ModelAndView viewName = new ModelAndView();
		viewName.setViewName("page/member/myPage");
		viewName.addObject("list", memberList);
		
		return viewName;

	}
	
	//비밀번호 체크
	@GetMapping("/check-pw-form")
	public String doubleCheckPw(Model model, MemberVO memberVO) throws Exception{
		MemberVO user = new MemberVO();
		user.setMemId(memberVO.getMemId());
		user.setMemPw(memberVO.getMemPw());
//		String test = String.valueOf(memberList);
//		System.out.println(test);
		model.addAttribute("user", user);
		return "page/member/checkPwForm";

	}
}
