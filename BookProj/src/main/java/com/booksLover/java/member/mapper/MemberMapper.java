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
		//회원 마이페이지(단건조회)
		public MemberVO getMember(String memId);
		
		//회원목록 조회
		public List<MemberVO> getAllMemberList();
		
		/*
		 * 회원가입
		 */
		//회원가입
		public void signUp();
		
		//회원탈퇴
		public void withdrawal(String memId);
		
		//아이디 단건조회 -> 아이디 중복확인
		public MemberVO checkMemberId(String newMemId);
		
		//email 조회 -> 일치하는 이메일 있으면 이미 가입된 아이디 메세지 띄움
		public List<MemberVO> getAllEmail();
		
		
		
		/*
		 * 로그인
		 */
		//아이디 찾기
		public MemberVO findMemId(String name, String email);
		
		//비밀번호 찾기
		public MemberVO findMemPwd(String memId, String email);
		
		//임시 비밀번호 발급
		public MemberVO updateTemporaryPwd(MemberVO memVO);
		
		
		/*
		 * 회원 정보수정
		 */
		//정보수정(비밀번호, 별명, 전화번호, 이메일)
		public void editMemberInfo(MemberVO editedInfo);
		//회원 프로필수정
		public void editMemberProfileImg(MemberVO editProfileImg);
		
		//회원 등급수정
		public void updateGrade(MemberVO memberVO);
		
		
		
		
		
}

