package com.panha.productservice;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void sum(){
		// Arrange
		int a = 1;
		int b = 2;

		// Act
		int result = a+b;

		// Assert
		assertEquals(3, result);

	}

}
