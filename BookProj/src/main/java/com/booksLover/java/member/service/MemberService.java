package com.booksLover.java.member.service;

import java.util.List;

import org.springframework.validation.BindingResult;

/**
 * @create 01/18/23
 * @author sunjin
 * @title Member Mapper Interface
 */
//@Service
public interface MemberService {
	//회원가입
	public void join(MemberVO memberVO, BindingResult bindingResult);
	
	//아이디 중복검사
	public MemberVO getMemberId(String id);
	
	//이메일 중복검사(email) -> 일치하는 이메일 있으면 이미 가입된 아이디 메세지 띄움
	public MemberVO getEmail(String email);
	
	//닉네임 중복검사
	public MemberVO getMemberNickname(String nickname);
	
	//멤버리스트 조회
	public List<MemberVO> getAllMemberList();
	
	//멤버 단건조회
	public MemberVO getMember(String id);
	
	//아이디 찾기
	public MemberVO findId(String phone, String name);
	
	//비밀번호 찾기
	public MemberVO findPw(String id, String email);


}
