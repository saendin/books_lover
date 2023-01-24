package com.booksLover.java.review.service;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @create 01/20/23
 * @author youree
 * @title Review interface service
 */

@Service
public interface ReviewService {
	public List<ReviewVO> getAllReview();
	public ReviewVO getOneReview(int reviewId);
}
