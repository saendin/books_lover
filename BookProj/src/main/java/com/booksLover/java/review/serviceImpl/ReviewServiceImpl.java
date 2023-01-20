package com.booksLover.java.review.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksLover.java.review.mapper.ReviewMapper;
import com.booksLover.java.review.service.ReviewService;
import com.booksLover.java.review.service.ReviewVO;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewMapper mapper;
	
	@Override
	public List<ReviewVO> getAllReview() {
		List<ReviewVO> list = new ArrayList<ReviewVO>();
		list = mapper.getAllReview();
		return list;
	}

}
