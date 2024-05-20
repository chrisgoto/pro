package com.aixtw.pro.repostory;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class BlankReposotyTest {

	@Test
	void contextLoads() {

		SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		System.out.println("當月第一天");
		System.out.println(sdft.format(calendar.getTime()));
				
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("當月最後一天");
		System.out.println(sdft.format(calendar.getTime()));
		
		
		Date dd = new Date(124,1,4);
		
		calendar.setTime(dd);
		
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		System.out.println("當月第一天");
		System.out.println(calendar.getTime());
		
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("當月最後一天");
		System.out.println(calendar.getTime());
		
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

	}

	@DisplayName("更新 test")
	@Test
	@Order(3)
	void updateTest() {

	}
}
