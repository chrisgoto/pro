package com.aixtw.pro.entity;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("item")
public class ItemEntity implements Persistable<String> {

	@Id
	private String id;
	private int itemKindId;
	private String itemKindName;
	private int payTypeId;
	private String payTypeName;
	private String itemName;
	private int itemPay;
	private String memoRecordId;

	@CreatedDate
	private Instant createDate;
	// @CreatedBy
	private String createUser;
	@LastModifiedDate
	private Instant modifyDate;
	// @LastModifiedBy
	private String modifyUser;

	// 非table欄位, 設定為是否要新增資料為判定條件
	@Transient
	private Boolean isInsert;

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return this.isInsert;
	}



}
