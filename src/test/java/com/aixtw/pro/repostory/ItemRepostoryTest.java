package com.aixtw.pro.repostory;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aixtw.pro.entity.ItemEntity;
import com.aixtw.pro.entity.ItemKindEntity;
import com.aixtw.pro.entity.MemoListEntity;
import com.aixtw.pro.entity.PayTypeEntity;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ItemRepostoryTest {

	@Autowired
	ItemKindRepostory<ItemKindEntity> itemKindRepostory;

	@Autowired
	PayTypeRepostory<PayTypeEntity> payTypeRepostory;

	@Autowired
	MemoListRepostory<MemoListEntity> memoListRepostory;

	@Autowired
	ItemRepostory<ItemEntity> itemRepostory;

	MemoListEntity memoListEntity;

	ItemEntity itemEntity;

	ItemKindEntity itemKindEntity;

	PayTypeEntity payTypeEntity;

	TestData data;

	Iterable<ItemKindEntity> itemKindIterablel;

	Iterable<PayTypeEntity> payTypeIterable;

	Optional<MemoListEntity> memoListOptional;

	Optional<ItemEntity> itemOptional;

	@Test
	void contextLoads() {

//		Calendar calendar = Calendar.getInstance();
//		System.out.println("~~~~~~~~~~~~~");
//		System.out.println("year");
//		System.out.println(calendar.get(Calendar.YEAR));
//		System.out.println("month");
//		System.out.println(calendar.get(Calendar.MONTH) + 1);
//		System.out.println("day");
//		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
	}

	/***
	 * 回傳 購買物品種類
	 * 
	 * @return ItemKindEntity
	 */
	ItemKindEntity getItemKindEntity() {
		itemKindIterablel = itemKindRepostory.findAll();

		Iterator<ItemKindEntity> iterator = itemKindIterablel.iterator();

		while (iterator.hasNext()) {
			itemKindEntity = iterator.next();
			if (("水果").equals(itemKindEntity.getKindName())) {
				break;
			}

		}
		return itemKindEntity;
	}

	/**
	 * 回傳 付費方式
	 * 
	 * @return PayTypeEntity
	 */
	PayTypeEntity getPayTypeEntity() {

		payTypeIterable = payTypeRepostory.findAll();

		Iterator<PayTypeEntity> iterator = payTypeIterable.iterator();

		while (iterator.hasNext()) {
			payTypeEntity = iterator.next();

			if (("現金").equals(payTypeEntity.getTypeName())) {
				break;
			}

		}

		return payTypeEntity;
	}

	@DisplayName("刪除 test")
	@Test
	@Order(1)
	void deleteTest() {

	}

	@DisplayName("新增 test")
	@Test
	@Order(2)
	void saveTest() {

		memoListOptional = memoListRepostory.findToDayRecord();

		payTypeIterable = payTypeRepostory.findAll();

		data = new TestData();

		if (!memoListOptional.isPresent()) {

			memoListEntity = data.getMemoListEntity();
			memoListEntity.setIsInsert(true);
			memoListRepostory.save(memoListEntity);

			itemEntity = data.getItemEntity(memoListEntity.getId(), getItemKindEntity(), getPayTypeEntity());
			itemEntity.setIsInsert(true);
			itemRepostory.save(itemEntity);
			// itemRepostory.save(new TestData().getItemEntity(recordId));
		} else {

			itemEntity = data.getItemEntity(memoListOptional.get().getId(), getItemKindEntity(), getPayTypeEntity());
			itemEntity.setIsInsert(true);
			itemRepostory.save(itemEntity);
			
		}

	}

	@DisplayName("更新 test")
	@Test
	@Order(3)
	void updateTest() {

	}

}
