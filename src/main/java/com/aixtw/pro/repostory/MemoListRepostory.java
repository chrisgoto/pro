package com.aixtw.pro.repostory;

import java.time.Instant;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.aixtw.pro.entity.MemoListEntity;

@Repository
public interface MemoListRepostory<T> extends PagingAndSortingRepository<MemoListEntity, String> {

	
	Optional<T> findByIsTodayTrue();
	
	Iterable<MemoListEntity> findByCreateDateOrderByCreateDateAsc(Instant createDate);
	
	@Modifying
	@Query("update memo_list set is_today = false where is_today = true")
	boolean updateIsTodayToFalse();
	
	@Query("select * from memo_list where to_char(create_date,'yyyy-mm-dd') = (select to_char(now(),'yyyy-mm-dd'))")
	Optional<T> findToDayRecord();
	
	
	
	
}
