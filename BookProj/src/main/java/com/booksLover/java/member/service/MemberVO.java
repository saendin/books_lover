package com.booksLover.java.member.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * @create 01/18/23
 * @author sunjin
 * @title Member VO
 */
@Data
public class MemberVO {
	
		private String memId;
		private String memPw;
		private String memName;
		private String memNickname;
		@DateTimeFormat(pattern = "yyyy-mm-dd")
		private int memSex;
		private String memPhone;
		private String memEmail;
		private String memBirth;
		
		private String memBirthYear;
		private String memBirthMonth;
		private String memBirthDay;
		
		private String memProfileImg;
		private int memGrade;
		private int memAdmin;
		private Date memLastLogin;
		private int memStatus;
}
