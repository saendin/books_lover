package com.booksLover.java.member.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	//회원가입
	@Override
	public void join(MemberVO memberVO) {
		memberMapper.join(memberVO);
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
