package com.booksLover.java.review.serviceImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
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
	
	//도서조회
	@Override
	public List<ReviewVO> searchBook(String keyword, int display, int start) {
		String clientId = "hJaHmFOHQuaw1jycJTIU"; //애플리케이션 클라이언트 아이디
        String clientSecret = "jza5mK0qR0"; //애플리케이션 클라이언트 시크릿
        
        List<ReviewVO> bookList = null;
        String text = null;
		try {
	        text = URLEncoder.encode(keyword,"UTF-8");
	        URL url = new URL("https://openapi.naver.com/v1/search/book_adv.xml"
	        		+ "?d_isbn=" + text
	    			+ (display!=0 ? "&display="+display : "")
	    			+ (start !=0 ? "&satrt="+start : ""));
	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	        try {
	        	conn.setRequestProperty("X-Naver-Client-Id", clientId);
	        	conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	        	
	        	int responseCode = conn.getResponseCode();
	        	if(responseCode == HttpURLConnection.HTTP_OK) {	//정상호출
	        		InputStreamReader streamReader = new InputStreamReader(conn.getInputStream());
	        		BufferedReader lineReader = new BufferedReader(streamReader);
	        		StringBuilder responseBody = new StringBuilder();
	
	                String line;
	                while ((line = lineReader.readLine()) != null) {
	                    responseBody.append(line);
	                }
	                System.out.println(responseBody.toString());
        	}}catch(Exception e) {
        		e.printStackTrace();
        	}finally {
        		conn.disconnect();
        	}
        }catch(Exception e) {
        	e.printStackTrace();
        }
        return bookList;
	}
	
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
		ReviewVO book = mapper.getOneReview(reviewId);
		searchBook(book.getReviewBook(),0,0);
		return book;
	}

}
