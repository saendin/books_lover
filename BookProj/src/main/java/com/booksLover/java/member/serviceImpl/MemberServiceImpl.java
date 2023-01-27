package com.booksLover.java.member.serviceImpl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import com.booksLover.java.member.mapper.MemberMapper;
import com.booksLover.java.member.service.MemberService;
import com.booksLover.java.member.service.MemberVO;

/**
 * @create 01/18/23
 * @author sunjin
 * @title Member ServiceImpl Interface
 */

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberMapper memberMapper;
	
	//회원 마이페이지(단건조회)
	@Override
	public MemberVO getMember(String id) {
		return memberMapper.getMember(id);
	}
	
	//회원리스트 조회
	@Override
	public List<MemberVO> getAllMemberList() {
		return memberMapper.getAllMemberList();
	}
	
	/*
	 * 회원가입
	 */
	// Validator가 해당 클래스를 지원하는지 확인하는 메서드
	/*
	 * @Override public boolean supports(Class<?> clazz) { return
	 * MemberVO.class.isAssignableFrom(clazz); // }
	 */

	// 검증 대상 객체와 BindingResult 즉, 검증 로직을 수행하는 메서드
	/*
	 * @Override public void validate(Object target, Errors errors) { MemberVO
	 * memberVO = (MemberVO)target; BindingResult bindingResult = (BindingResult)
	 * errors; //1. 아이디를 입력하지 않았을 때 if (ObjectUtils.isEmpty(memberVO.getMemId())) {
	 * bindingResult.addError(new FieldError("memberVO", "id", "아이디를 입력해주세요!")); }
	 * 
	 * //2. 아이디 중복 체크 if (!ObjectUtils.isEmpty(memberVO.getMemId()) &&
	 * !ObjectUtils.isEmpty(memberMapper.getMemberId(memberVO.getMemId()))) {
	 * bindingResult.addError(new FieldError("memberVO", "id", "이미 존재하는 아이디입니다!"));
	 * }
	 * 
	 * String pattern = "(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}";
	 * 
	 * if (ObjectUtils.isEmpty(memberVO.getMemPw()) ||
	 * !(memberVO.getMemPw().matches(pattern))) { bindingResult.addError(new
	 * FieldError("memberVO", "password",
	 * "패스워드는 대문자, 소문자, 특수문자가 적어도 하나씩은 있어야 하며\n최소 8자리, 최대 20자리까지 가능합니다.")); }
	 * 
	 * //2. 아이디 중복 체크 if (!ObjectUtils.isEmpty(memberVO.getMemId()) &&
	 * !ObjectUtils.isEmpty(memberMapper.getMemberEmail(memberVO.getMemEmail()))) {
	 * bindingResult.addError(new FieldError("memberVO", "id", "이미 존재하는 아이디입니다!"));
	 * }
	 * 
	 * Calendar now = Calendar.getInstance(); int year = now.get(Calendar.YEAR);
	 * 
	 * if (ObjectUtils.isEmpty(memberVO.getMemBirth()) ||
	 * !(Integer.parseInt(memberVO.getMemBirthYear()) >= 1900 &&
	 * Integer.parseInt(memberVO.getMemBirthYear()) <= year)) {
	 * bindingResult.addError(new FieldError("memberVO", "year",
	 * "출생년도를 다시 확인해주세요!")); } }
	 */
	
	//회원가입 유효성검사
	@Override
	@Transactional
	public void join(MemberVO memberVO, BindingResult bindingResult) {
		
		//1. 아이디를 입력하지 않았을 때
		if (ObjectUtils.isEmpty(memberVO.getMemId())) {
			bindingResult.addError(new FieldError("memberVO", "memId", "아이디를 입력해주세요!"));
		}
		
		//2. 아이디 중복 체크
		if (!ObjectUtils.isEmpty(memberVO.getMemId()) 
				&& !ObjectUtils.isEmpty(memberMapper.getMemberId(memberVO.getMemId()))) {
			bindingResult.addError(new FieldError("memberVO", "memId", "이미 존재하는 아이디입니다!"));
		}
		
		//3. 이메일 중복 체크
		if (!ObjectUtils.isEmpty(memberVO.getMemEmail()) 
				&& !ObjectUtils.isEmpty(memberMapper.getMemberEmail(memberVO.getMemEmail()))) {
			bindingResult.addError(new FieldError("memberVO", "memEmail", "이미 존재하는 아이디입니다!"));
		}
		
		//4. 닉네임 중복 체크
		if (!ObjectUtils.isEmpty(memberVO.getMemId()) 
				&& !ObjectUtils.isEmpty(memberMapper.getMemberNickname(memberVO.getMemNickname()))) {
			bindingResult.addError(new FieldError("memberVO", "memNickname", "이미 존재하는 닉네임입니다!"));
		}
		
		//5. 비밀번호 유효성 검증
		String pattern = "(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}";
		
		if (ObjectUtils.isEmpty(memberVO.getMemPw())
				|| !(memberVO.getMemPw().matches(pattern))) {
			bindingResult.addError(new FieldError("memberVO", "memPw", "패스워드는 대문자, 소문자, 특수문자가 적어도 하나씩은 있어야 하며\n최소 8자리, 최대 20자리까지 가능합니다."));
		}
		
		
		//6. 출생년도 검증
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		
		if (ObjectUtils.isEmpty(memberVO.getMemBirth())
				|| !(Integer.parseInt(memberVO.getMemBirthYear()) >= 1900 && Integer.parseInt(memberVO.getMemBirthYear()) <= year)) {
			bindingResult.addError(new FieldError("memberVO", "memBirthday", "출생년도를 다시 확인해주세요!"));
		}
		
	    memberMapper.join(memberVO);
	}
	
	//아이디 중복검사
	@Override
	public MemberVO getMemberId(String id) {
		return memberMapper.getMemberId(id);
	}

	//이메일 중복검사 -> 일치하는 이메일 있으면 이미 가입된 아이디 메세지 띄움
	@Override
	public MemberVO getEmail(String email) {
		return memberMapper.getMemberEmail(email);
	}

	//별명 중복검사
	@Override
	public MemberVO getMemberNickname(String nickname) {
		return  memberMapper.getMemberNickname(nickname);
	}
	
	//아이디 찾기
	@Override
	public MemberVO findId(String phone, String name) {
		return memberMapper.findId(phone, name);
	}

	//비밀번호 찾기
	@Override
	public MemberVO findPw(String id, String email) {
		return memberMapper.findPw(id, email);
	}


	
}
