package com.booksLover.java.member.service;

import java.util.List;


/**
 * @create 01/18/23
 * @author sunjin
 * @title Member Mapper Interface
 */
//@Service
public interface MemberService {
	//회원가입
	public void join(MemberVO memberVO);
	
	//멤버리스트 조회
	public List<MemberVO> getAllMemberList();
	
	//멤버 단건조회
	public MemberVO getMember(String id);
	
	//아이디 찾기
	public MemberVO findId(String phone, String name);
	
	//비밀번호 찾기
	public MemberVO findPw(String id, String email);
}
