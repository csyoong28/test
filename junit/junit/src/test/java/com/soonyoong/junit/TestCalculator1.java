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

public class TestCalculator1 {
	
	Calculator calculator = null;
//	@Mock
//	CalculatorService calculatorService;
//	@Rule
//	public MockitoRule mockitoRule = MockitoJUnit.rule();
	//or 
	//CalculatorService calculatorService = Mockito.mock(CalculatorService.class);
	
	@Before
	public void setup() {
		calculator = new Calculator();
	}
	
	@Test
	public void testAdd() {
		assertEquals(5, calculator.add(2, 3));
	}
	
}
