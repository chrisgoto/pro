package com.aixtw.pro.repostory;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.aixtw.pro.entity.ItemKindEntity;

@Repository
public interface ItemKindRepostory<T> extends PagingAndSortingRepository<ItemKindEntity, Integer> {

	/**
	 * 
	 * @param name
	 * @return
	 */
	Optional<T> findByKindName(String name);
}
