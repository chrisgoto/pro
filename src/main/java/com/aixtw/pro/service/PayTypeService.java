package com.aixtw.pro.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aixtw.pro.entity.PayTypeEntity;

@Service
public interface PayTypeService {

	/**
	 * 1. 新建資料時, 自動判斷操作為新增 2.已有的資料, 自動判斷操作為更新
	 * 
	 * @param entity
	 * @return
	 */
	PayTypeEntity save(PayTypeEntity entity);

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
	boolean existsById(int id);

	/**
	 * 刪除資料
	 * 
	 * @param entity
	 * @return
	 */
	boolean delete(PayTypeEntity entity);

	/**
	 * 
	 * @param id
	 * @return
	 */
	Optional<PayTypeEntity> findOneById(int id);

}
