package com.aixtw.pro.repostory;


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
