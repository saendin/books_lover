package com.booksLover.java.review.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.booksLover.java.review.service.ReviewVO;

/**
 * @create 01/20/23
 * @author youree
 * @title Review interface mapper
 */

@Mapper
public interface ReviewMapper {
	//전체조회
	public List<ReviewVO> getAllReview();
	//단건조회
	public ReviewVO getOneReview(int reviewId);
}
