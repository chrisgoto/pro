package com.aixtw.pro.repostory;




import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.aixtw.pro.entity.ItemKindEntity;
import com.aixtw.pro.entity.PayTypeEntity;

public class TestData<T> {

	public List<T> dataList() {

		return new ArrayList<T>();

	}

	/**
	 * 取得現在日期時間
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
	public T getItemKindEntity(String itemName) {
		ItemKindEntity data = new ItemKindEntity();
		data.setKindName("水果");
		data.setCreateDate(getCalendar().toInstant());
		data.setCreateUser("root");

		return (T) data;
	}

	/**
	 * 
	 * @param payTypeName 付款方式稱呼
	 * @return
	 */
	public T getPayTypeEntity(String payTypeName) {

		PayTypeEntity data = new PayTypeEntity();
		data.setCreateDate(getCalendar().toInstant());
		data.setCreateUser("root");
		data.setType("CASH");
		data.setTypeName("現金");

		return (T) data;
	}

}