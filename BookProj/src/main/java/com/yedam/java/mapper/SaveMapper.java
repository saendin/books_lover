package com.yedam.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.java.service.SaveVO;

@Mapper
public interface SaveMapper {

	public List<SaveVO> getSaveList();
}
