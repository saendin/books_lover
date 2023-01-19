package com.booksLover.java.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.booksLover.java.member.service.MemberVO;

/**
 * @create 01/18/23
 * @author sunjin
 * @title Member Mapper Interface
 */
@Mapper
public interface MemberMapper {
		public List<MemberVO> getAllMemberList();
}

