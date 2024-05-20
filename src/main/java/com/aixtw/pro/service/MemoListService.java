package com.aixtw.pro.service;

import com.aixtw.pro.entity.MemoListEntity;

public interface MemoListService {

	
	
	
	Iterable<MemoListEntity> findByMonthOrderByCreateDateAsc();
	
}
