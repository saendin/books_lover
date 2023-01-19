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
 * @title Member Mapper Interface
 */

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberMapper mapper;
	
	//멤버리스트
	@Override
	public List<MemberVO> getAllMemberList() {
		return mapper.getAllMemberList();
	}
}
