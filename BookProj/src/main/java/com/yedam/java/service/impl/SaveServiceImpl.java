package com.yedam.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.mapper.SaveMapper;
import com.yedam.java.service.SaveService;
import com.yedam.java.service.SaveVO;

@Service
public class SaveServiceImpl implements SaveService {

	@Autowired
	SaveMapper mapper;

	@Override
	public List<SaveVO> getSaveList() {
		return mapper.getSaveList();
	}
}
