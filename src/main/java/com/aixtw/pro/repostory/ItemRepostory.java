package com.aixtw.pro.repostory;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.aixtw.pro.entity.ItemEntity;

@Repository
public interface ItemRepostory<T> extends PagingAndSortingRepository<ItemEntity, String> {

	
	/**
	 * 
	 * @param memoRecordId (購買記錄編號) 
	 * @return
	 */
	Optional<T> findByMemoRecordId(String memoRecordId);

}
