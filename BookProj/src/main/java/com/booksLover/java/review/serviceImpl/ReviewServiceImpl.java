package com.booksLover.java.review.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksLover.java.review.mapper.ReviewMapper;
import com.booksLover.java.review.service.ReviewService;
import com.booksLover.java.review.service.ReviewVO;

/**
 * @create 01/20/23
 * @author youree
 * @title Review service implement
 */

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewMapper mapper;
	
	//전체조회
	@Override	
	public List<ReviewVO> getAllReview() {
		List<ReviewVO> list = new ArrayList<ReviewVO>();
		list = mapper.getAllReview();
		return list;
	}

	//단건조회
	@Override	
	public ReviewVO getOneReview(int reviewId) {
		return mapper.getOneReview(reviewId);
	}
	
}
