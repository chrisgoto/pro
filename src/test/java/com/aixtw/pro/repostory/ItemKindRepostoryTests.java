package com.aixtw.pro.repostory;

import java.util.Calendar;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aixtw.pro.entity.ItemKindEntity;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ItemKindRepostoryTests {

	@Autowired
	private ItemKindRepostory<ItemKindEntity> itemKindRepostory;

	private ItemKindEntity itemKindEntity;

	Optional<ItemKindEntity> objEntity;

	@Test
	void contextLoads() {

		
	}

	Optional<ItemKindEntity> findOne(String kindName) {
		return itemKindRepostory.findByKindName(kindName);
	}

	@DisplayName("刪除 test")
	@Test
	@Order(1)
	void deleteTest() {

		objEntity = findOne("水果");
		if (objEntity.isPresent()) {
			itemKindRepostory.delete(objEntity.get());
			objEntity = itemKindRepostory.findByKindName("水果");
			System.out.println("該資料刪除成功");
		} else {
			System.out.println("找不到刪除資料");
		}

	}

	@DisplayName("新增 test")
	@Test
	@Order(2)
	void saveTest() {

		objEntity = findOne("水果");

		if (!objEntity.isPresent()) {

			System.out.println("查無此資料, 準備儲存該資料");
			itemKindEntity = new TestData().getItemKindEntity("水果");
			itemKindRepostory.save(itemKindEntity);
			if (findOne("水果").isPresent()) {
				System.out.println("新資料儲存成功");
			} else {
				System.out.println("新資料儲存失敗");
			}

		} else {
			System.out.println("已有相同資料存在");
		}

	}

	@DisplayName("更新 test")
	@Test
	@Order(3)
	void updateTest() {
		objEntity = findOne("水果");
		if (objEntity.isPresent()) {

			objEntity.get().setModifyDate(new TestData().getCalendar().toInstant());
			objEntity.get().setModifyUser("modfiyer");

			itemKindRepostory.save(objEntity.get());
			System.out.println("資料更新成功");

		} else {
			System.out.println("查無此資料, 無法更新");
		}
	}

}
