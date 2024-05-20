package com.aixtw.pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aixtw.pro.entity.PayTypeEntity;
import com.aixtw.pro.repostory.PayTypeRepostory;

@Service
public class PayTypeServiceImpl implements PayTypeService {

	@Autowired
	PayTypeRepostory<PayTypeEntity> payTypeRepostory;

	@Override
	public PayTypeEntity save(PayTypeEntity entity) {

		return payTypeRepostory.save(entity);
	}

	@Override
	public Iterable<PayTypeEntity> findAll() {
		// TODO Auto-generated method stub

		return payTypeRepostory.findAll();
	}

	@Override
	public boolean existsById(int id) {
		// TODO Auto-generated method stub
		return payTypeRepostory.existsById(id);
	}

	@Override
	public boolean delete(PayTypeEntity entity) {
		// TODO Auto-generated method stub
		int id = entity.getId();
		payTypeRepostory.delete(entity);
		
		return existsById(id);
	}

}
