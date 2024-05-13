package com.aixtw.pro.repostory;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.aixtw.pro.entity.PayTypeEntity;

@Repository
public interface PayTypeRepostory<T> extends PagingAndSortingRepository<PayTypeEntity , Integer>{

	
	/**
	 * 
	 * @param name (付款名稱)
	 * @return
	 */
	Optional<T> findByTypeName(String name);
	
	
	
	
	
	
	
	
}
