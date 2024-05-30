package com.aixtw.pro.repostory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.boot.test.context.SpringBootTest;

import com.aixtw.pro.entity.ItemEntity;
import com.aixtw.pro.entity.ItemKindEntity;
import com.aixtw.pro.entity.MemoListEntity;
import com.aixtw.pro.entity.PayTypeEntity;

@SpringBootTest
public class TestData {

	public List dataList() {

		return new ArrayList();

	}

	/**
	 * 取得現在日期時間
	 * 
	 * @return
	 */
	public Calendar getCalendar() {

		return Calendar.getInstance();
	}

	/**
	 * 
	 * @param itemName 物品名稱
	 * @return
	 */
	public ItemKindEntity getItemKindEntity(String itemName) {
		ItemKindEntity data = new ItemKindEntity();
		data.setKindName("水果");
		data.setCreateDate(getCalendar().toInstant());
		data.setCreateUser("root");

		return data;
	}

	/**
	 * 
	 * @param payTypeName 付款方式稱呼
	 * @return
	 */
	public PayTypeEntity getPayTypeEntity(String payTypeName) {

		PayTypeEntity data = new PayTypeEntity();
		data.setCreateDate(getCalendar().toInstant());
		data.setCreateUser("root");
		data.setType("CASH");
		data.setTypeName("現金");

		return data;
	}

	/**
	 * 
	 * @return
	 */
	public MemoListEntity getMemoListEntity() {

		MemoListEntity data = new MemoListEntity();
		data.setId(UUID.randomUUID().toString());
		data.setYearRecord(String.valueOf(getCalendar().get(Calendar.YEAR)));
		data.setMonthRecord(String.valueOf(getCalendar().get(Calendar.MONTH) + 1));
		data.setDayRecord(String.valueOf(getCalendar().get(Calendar.DAY_OF_MONTH)));
		data.setIsToday(true);
		data.setCreateUser("root");
		data.setCreateDate(Calendar.getInstance().toInstant());

		return data;
	}
	
	/**
	 * 
	 * @return
	 */
	public Iterable<MemoListEntity> getMemoListEntityList(){
		MemoListEntity data = new MemoListEntity();
		data.setId(UUID.randomUUID().toString());
		data.setYearRecord(String.valueOf(getCalendar().get(Calendar.YEAR)));
		data.setMonthRecord(String.valueOf(getCalendar().get(Calendar.MONTH) + 1));
		data.setDayRecord(String.valueOf(getCalendar().get(Calendar.DAY_OF_MONTH)));
		
		data.setIsToday(true);
		data.setCreateUser("root");
		data.setCreateDate(Calendar.getInstance().toInstant());
		
		return null;
	}
	
	

	/**
	 * 
	 * @param recordId       購買id編號
	 * @param itemKindEntity 購買物品種類
	 * @param payTypeEntity  付費方式
	 * @return ItemEntity 購買物品資料
	 */
	public ItemEntity getItemEntity(String recordId, ItemKindEntity itemKind, PayTypeEntity payType) {

		ItemEntity data = new ItemEntity();
		data.setId(UUID.randomUUID().toString());
		data.setMemoRecordId(recordId);
		data.setCreateUser("root");
		data.setCreateDate(Calendar.getInstance().toInstant());
		data.setItemKindId(itemKind.getId());
		data.setItemKindName(itemKind.getKindName());
		data.setItemName("香焦");
		data.setItemPay(200);
		data.setPayTypeId(payType.getId());
		data.setPayTypeName(payType.getTypeName());

		return data;
	}

}