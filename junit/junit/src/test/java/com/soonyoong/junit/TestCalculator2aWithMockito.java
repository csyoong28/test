package com.soonyoong.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestCalculator2aWithMockito {
	
	Calculator calculator = null;

	//using annotation is simpler, but need to use @rule for junit4 or @ExtendWith for junit5
	@Mock
	CalculatorService calculatorService;

	
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
