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
		private String memNickName;
		@DateTimeFormat(pattern = "yyyy-mm-dd")
		private int memBirthday;
		private int memSex;
		private int memPhone;
		private String memProfileImg;
		private int memGrade;
		private int memAdmin;
		private Date memLastLogin;
		private int memStatus;
}
