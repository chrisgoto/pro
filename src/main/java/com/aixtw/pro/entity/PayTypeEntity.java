package com.aixtw.pro.entity;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("pay_type")
public class PayTypeEntity implements Persistable<Integer> {

	@Id
	// @Setter(value = AccessLevel.NONE) 取消 Setter
	private int id;

	private String typeName;

	private String type;

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
		return this.id == 0;
	}

}
