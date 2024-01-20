package com.soonyoong.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestCalculator2WithMockito {
	
	Calculator calculator = null;
	CalculatorService calculatorService = Mockito.mock(CalculatorService.class);
	
	@BeforeEach
	public void setup() {
		calculator = new Calculator(calculatorService);
	}
	
	@Test
	public void testPerformComplexTask() {
		when(calculatorService.add(2, 3)).thenReturn(5);
		assertEquals(5, calculator.performComplexTask(2, 3));
		//verify that mock object is executed once
		verify(calculatorService).add(2, 3);
	}
	
}
