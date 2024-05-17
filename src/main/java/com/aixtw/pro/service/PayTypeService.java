package com.aixtw.pro.service;

import com.aixtw.pro.entity.PayTypeEntity;

public interface PayTypeService {

	/**
	 * 1. 新建資料時, 自動判斷操作為新增 2.已有的資料, 自動判斷操作為更新
	 * 
	 * @return
	 */
	PayTypeEntity save();

	/**
	 * 搜查全部資料
	 * 
	 * @return
	 */
	Iterable<PayTypeEntity> findAll();

	/**
	 * 搜索此資料是否存在
	 * 
	 * @param id
	 * @return
	 */
	boolean existsById(String id);

	/**
	 * 刪除資料
	 * 
	 * @return
	 */
	boolean delete();

}
