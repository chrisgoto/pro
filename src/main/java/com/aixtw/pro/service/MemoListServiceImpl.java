package com.aixtw.pro.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.aixtw.pro.entity.MemoListEntity;
import com.aixtw.pro.repostory.MemoListRepostory;

public class MemoListServiceImpl implements MemoListService {

	@Autowired
	MemoListRepostory<MemoListEntity> memoListRepostory;

	@Override
	public Iterable<MemoListEntity> findByMonthRecordOrderByCreateDateAsc(String month) {
		// TODO Auto-generated method stub
		return memoListRepostory.findByMonthRecordOrderByCreateDateAsc(month);
	}

	@Override
	public Iterable<MemoListEntity> findAll() {
		// TODO Auto-generated method stub
		return memoListRepostory.findAll();
	}



}
