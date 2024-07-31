package com.aixtw.pro.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aixtw.pro.entity.ItemKindEntity;

@Service
public interface ItemKindService {

	/**
	 * 1. 新建資料時, 自動判斷操作為新增 2.已有的資料, 自動判斷操作為更新
	 * 
	 * @param entity
	 * @return
	 */
	ItemKindEntity save(ItemKindEntity entity);

	/**
	 * 搜查全部資料
	 * 
	 * @return
	 */
	Iterable<ItemKindEntity> finall();

	/**
	 * 搜索此資料是否存在
	 * 
	 * @param id
	 * @return
	 */
	boolean existsById(int id);

	/**
	 * 
	 * @param entity
	 * @return
	 */
	boolean delete(ItemKindEntity entity);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Optional<ItemKindEntity> findById(int id);

}
