package com.aixtw.pro.repostory;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aixtw.pro.entity.PayTypeEntity;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class PayTypeTests {

	@Autowired
	PayTypeRepostory<PayTypeEntity> payTypeRepostory;

	PayTypeEntity payTypeEntity;

	Optional<PayTypeEntity> objEntity;

	@Test
	void contextLoads() {
	}

	Optional<PayTypeEntity> findOne(String kindName) {
		return payTypeRepostory.findByTypeName(kindName);
	}

	@DisplayName("刪除 test")
	@Test
	@Order(1)
	void deleteTest() {

		objEntity = findOne("現金");
		if (objEntity.isPresent()) {
			payTypeRepostory.delete(objEntity.get());
			objEntity = findOne("現金");
			System.out.println("該資料刪除成功");
		} else {
			System.out.println("找不到刪除資料");
		}

	}

	@DisplayName("新增 test")
	@Test
	@Order(2)
	void saveTest() {

		objEntity = findOne("現金");

		if (!objEntity.isPresent()) {

			System.out.println("查無此資料, 準備儲存該資料");
			payTypeEntity = new TestData<PayTypeEntity>().getPayTypeEntity("現金");
			payTypeRepostory.save(payTypeEntity);

			if (findOne("現金").isPresent()) {
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

		objEntity = findOne("現金");
		if (objEntity.isPresent()) {

			objEntity.get().setModifyDate(new TestData<>().getCalendar().toInstant());
			objEntity.get().setModifyUser("modfiyer");

			payTypeRepostory.save(objEntity.get());
			System.out.println("資料更新成功");

		} else {
			System.out.println("查無此資料, 無法更新");
		}

	}

}
