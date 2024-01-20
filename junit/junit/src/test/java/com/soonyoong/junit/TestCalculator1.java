package com.soonyoong.junit;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestCalculator1 {

	Calculator calculator = null;

	@BeforeEach
	public void setup() {
		calculator = new Calculator();
	}

	@Test
	public void testAdd() {
		assertEquals(5, calculator.add(2, 3));
	}

}
