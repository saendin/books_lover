package com.yedam.java;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.java.service.SaveService;
import com.yedam.java.service.SaveVO;


@SpringBootTest
class BookPrjApplicationTests {

	@Autowired
	SaveService service;

	
	@Test
	@Transactional
	@Rollback(false)
		void contextLoads() {
		System.out.println("test 성공");
		
		List<SaveVO> vo = new ArrayList<SaveVO>();
		vo = service.getSaveList();
		
		System.out.println(vo);
		
		
	}


}
