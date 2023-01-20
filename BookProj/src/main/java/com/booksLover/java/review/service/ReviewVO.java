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
	private int reviewId;
	private String reviewWriter;
	private String reviewBook;
	private String reviewTitle;
	private int reviewTheme;
	private int reviewStar;
	private String reviewContent;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date reviewDate;
	private int reviewView;
	private int reviewSecret;
	private int reviewStatus;
}
