package com.soonyoong.junit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class TestCalculator {
	
	Calculator calculator = null;
	@Mock
	CalculatorService calculatorService;
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	//or 
	//CalculatorService calculatorService = Mockito.mock(CalculatorService.class);
	
	@Before
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
