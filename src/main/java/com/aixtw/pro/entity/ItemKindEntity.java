package com.aixtw.pro.entity;

import java.time.Instant;

//import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

//import lombok.AccessLevel;
import lombok.Data;

@Data
@Table("item_kind")
public class ItemKindEntity implements Persistable<Integer> {

	@Id
	// @Setter(value = AccessLevel.NONE) 取消 Setter
	private int id;

	private String kindName;

	@CreatedDate
	private Instant createDate;
	// @CreatedBy
	private String createUser;
	@LastModifiedDate
	private Instant modifyDate;
	// @LastModifiedBy
	private String modifyUser;

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return id == 0;
	}

}
