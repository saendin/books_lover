package com.booksLover.java.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @create 01/18/23
 * @author sunjin
 * @title Member Mapper Interface
 */
//@Service
public interface MemberService {
	public List<MemberVO> getAllMemberList();
	public MemberVO getMember(String memId);
}
