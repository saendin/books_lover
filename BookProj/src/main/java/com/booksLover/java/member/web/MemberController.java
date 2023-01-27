package com.booksLover.java.member.web;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	MemberService memberService;
	
//	  @InitBinder
//	  public void init(WebDataBinder dataBinder) {
//	      dataBinder.addValidators(memberService.);
//	  }
	
	//아이디찾기폼
	@GetMapping("help/id")
	public ModelAndView findId() {
		return new ModelAndView("page/login/findIdForm");
	}
	
	//비밀번호찾기폼
	@GetMapping("help/pw")
	public ModelAndView findPw() {
		return new ModelAndView("page/login/findPwForm");
	}
	
	//회원가입 폼으로
	@GetMapping("join")
	public ModelAndView joinForm(Model model) throws Exception{
		model.addAttribute("memberVO",new MemberVO());
		return new ModelAndView("page/login/joinForm");
	}
	
	//회원가입
	@PostMapping("join")
	public ModelAndView join(@Valid MemberVO memberVO, BindingResult bindingResult) {
		System.out.println("memNickname=======>"+memberVO.getMemNickname());
		
		
		//출생 년/월/일은 합쳐서 memberBirth에 담기
		String birth = "";
		birth = memberVO.getMemBirthYear();
		System.out.println("birthYear=======>"+birth);
		
		if(memberVO.getMemBirthMonth().length()<2) {
			birth += 0;
			birth += memberVO.getMemBirthMonth();
		}else {
			birth += memberVO.getMemBirthMonth();
		}
		System.out.println("birthYearMonth=======>"+birth);
		
		if(memberVO.getMemBirthDay().length()<2) {
			birth += 0;
			birth += memberVO.getMemBirthDay();
		}else {
			birth += memberVO.getMemBirthDay();
		}
		System.out.println("birthday=======>"+birth);
		
		
		if(bindingResult.hasErrors()) {
			return new ModelAndView("page/login/joinForm");
		}
		//출생 년월일
		
		memberVO.setMemBirth(birth);
		memberService.join(memberVO, bindingResult);
		return new ModelAndView("page/main/main");//성공하면 main으로  
	}
	
	
	
	/*
	 * 먼저 form태그를 사용할 페이지에 비어있는 객체를 전달해야합니다 controller
	 */
	//@ModelAttribute("memberVO") MemberVO memberVO
//	@GetMapping("join/form")
//	public ModelAndView joinForm(Model model) throws Exception{
//		model.addAttribute("memberVO", new MemberVO());
//		return new ModelAndView("page/login/joinForm");
//	}
//	
//	@PostMapping("join")
//	public ModelAndView join(@ModelAttribute MemberVO memberVO, BindingResult bindingResult) {
//	    
//		((Validator) memberService).validate(memberVO, bindingResult);
//		
//		// 검증에 실패하면 다시 입력 폼으로
//	      if (bindingResult.hasErrors()) {
//	          return new ModelAndView("page/login/join");
//	      }
//	      
//	      memberService.join(memberVO);
//	    //성공하면 main으로  
//		return new ModelAndView("page/main/main");
//	}
	

	
	//정보수정
	@GetMapping("my-page/update")
	public ModelAndView getMemberProfile(Model model, String id) {
		id="user1";
		MemberVO memberInfo = memberService.getMember(id);
		
		ModelAndView viewName = new ModelAndView();
		viewName.setViewName("page/myPage/myPageEditForm");
		viewName.addObject("user", memberInfo);
		
		return viewName;
	}
	
	//비밀번호 체크
	@GetMapping("my-page/check-pw-form/{id}")
	public ModelAndView checkPw(Model model,@PathVariable String id) throws Exception{
		id="user1";
		MemberVO user = memberService.getMember(id);
		
		ModelAndView viewName = new ModelAndView();
		viewName.setViewName("page/myPage/checkPwForm");
		viewName.addObject("user", user);
//		user.setMemPw(memberVO.getMemPw());
//		List<MemberVO> memberList = memService.getAllMemberList();
//		System.out.println(test);
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
	
	
}
