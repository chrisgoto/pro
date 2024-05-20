package com.aixtw.pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aixtw.pro.entity.ItemKindEntity;
import com.aixtw.pro.repostory.ItemKindRepostory;

@Service
public class ItemKindServiceImpl implements ItemKindService {

	@Autowired
	ItemKindRepostory<ItemKindEntity> itemKindRepostory;
	
	
	@Override
	public ItemKindEntity save(ItemKindEntity entity) {
		// TODO Auto-generated method stub
		return itemKindRepostory.save(entity);
	}

	@Override
	public Iterable<ItemKindEntity> finall() {
		// TODO Auto-generated method stub
		return itemKindRepostory.findAll();
	}

	@Override
	public boolean existsById(int id) {
		// TODO Auto-generated method stub	
		return itemKindRepostory.existsById(id);
	}

	@Override
	public boolean delete(ItemKindEntity entity) {
		// TODO Auto-generated method stub
		
		int id = entity.getId();
		itemKindRepostory.delete(entity);
		
		return existsById(id);
	}

}
