package com.booksLover.java.review.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * @create 01/20/23
 * @author youree
 * @title Review VO
 */

@Data
public class ReviewVO {
	//리뷰 게시글 정보
	private int reviewId;	//게시글 ID
	private String reviewWriter;	//작성자 ID
	private String reviewTitle;		//게시글 제목
	private int reviewTheme;	//0일반후기 1독서기행후기
	private int reviewStar;		//평점(0~10)
	private String reviewContent;	//후기 내용
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date reviewDate;	//작성일
	private int reviewView;		//조회수
	private int reviewSecret;	//비밀글여부(0공개 1비공개)
	private int reviewStatus;	//상태(0일반 1삭제 9접근제한)
	
	//리뷰한 도서 정보
	private String reviewBook;		//ISBN
	private String reviewBookTitle;	//제목
	private String reviewBookAuthor;//저자
	private String reviewBookPublisher;	//출판사
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date reviewBookPubdate;	//출간일
	private String reviewBookImage;	//썸네일 이미지 URL
}
