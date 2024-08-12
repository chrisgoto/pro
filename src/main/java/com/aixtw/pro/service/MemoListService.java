package com.aixtw.pro.service;

import com.aixtw.pro.entity.MemoListEntity;

public interface MemoListService {

	
	
	/**
	 * 依月份查找
	 * @param month
	 * @return
	 */
	Iterable<MemoListEntity> findByMonthRecordOrderByCreateDateAsc(String month);
	
	
	Iterable<MemoListEntity> findAll();
	
}
