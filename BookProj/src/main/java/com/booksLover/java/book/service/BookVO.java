package com.booksLover.java.book.service;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) //선언되지 않은 데이터가 들어오면 무시
public class BookVO {
    private String title; 		// 제목
    private String isbn;		// isbn
    private String link; 		// 쇼핑링크
    private String image; 		// 책 표지
    private String author;		// 저자
    private String price;		// 가격
    private String discount;	// 할인가
    private String publisher;	// 출판사
    private String pubdate;	 	// 출판일
    private String description;	// 설명
    private int total;
    
}
