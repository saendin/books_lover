package com.yedam.java.service;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public interface SaveService {
	
	//SAVE 리스트 조회
	public List<SaveVO> getSaveList();
}
