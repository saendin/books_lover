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
	MemberMapper mapper;
	
	//회원 마이페이지(단건조회)
	@Override
	public MemberVO getMember(String memId) {
		return mapper.getMember(memId);
	}
	
	//회원리스트 조회
	@Override
	public List<MemberVO> getAllMemberList() {
		return mapper.getAllMemberList();
	}
	
	//아이디 찾기



	
}
