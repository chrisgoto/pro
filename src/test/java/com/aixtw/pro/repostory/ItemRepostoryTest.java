package com.aixtw.pro.repostory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
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

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ItemRepostoryTest {

	@Autowired
	MemoListRepostory<MemoListEntity> memoListRepostory;

	@Autowired
	ItemKindRepostory<ItemEntity> itemKindRepostory;

	MemoListEntity memoListEntity;

	ItemEntity itemEntity;

	Optional<MemoListEntity> objEntity;

	@Test
	void contextLoads() {

		Calendar calendar = Calendar.getInstance();

//		System.out.println("~~~~~~~~~~~~~");
//		System.out.println("year");
//		System.out.println(calendar.get(Calendar.YEAR));
//		System.out.println("month");
//		System.out.println(calendar.get(Calendar.MONTH) + 1);
//		System.out.println("day");
//		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
	}

	private String testItemId = UUID.randomUUID().toString();
	private String testMemoListId = UUID.randomUUID().toString();


	@DisplayName("刪除 test")
	@Test
	@Order(1)
	void deleteTest() {

	}

	@DisplayName("新增 test")
	@Test
	@Order(2)
	void saveTest() {
		System.out.println("~~~~~~~~~~~~~");

		objEntity = memoListRepostory.findToDayRecord();
		//System.out.println(memoListRepostory.findToDayRecord());
		Calendar c = Calendar.getInstance();

//		System.out.println(String.valueOf(c.get(Calendar.YEAR)).equals(objEntity.get().getYear()));
//		System.out.println(String.valueOf(c.get(Calendar.MONTH) + 1).equals(objEntity.get().getMonth()));
//		System.out.println(String.valueOf(c.get(Calendar.DAY_OF_MONTH)).equals(objEntity.get().getDay()));

		if (!objEntity.isPresent()) {
			memoListRepostory.updateIsTodayToFalse();
			memoListEntity = new MemoListEntity();
			memoListEntity.setId(testMemoListId);
			memoListEntity.setYear(String.valueOf(c.get(Calendar.YEAR)));
			memoListEntity.setMonth(String.valueOf(c.get(Calendar.MONTH) + 1));
			memoListEntity.setDay(String.valueOf(c.get(Calendar.DAY_OF_MONTH)));
			memoListEntity.setIsToday(true);
			memoListEntity.setCreateUser("root");
			memoListEntity.setCreateDate(Calendar.getInstance().toInstant());
			memoListEntity.setIsInsert(true);

			memoListRepostory.save(memoListEntity);
		}

	}

	@DisplayName("更新 test")
	@Test
	@Order(3)
	void updateTest() {

	}

}
