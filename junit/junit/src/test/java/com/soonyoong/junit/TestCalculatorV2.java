package com.soonyoong.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

//unable to work after in idea

//@RunWith attaches a runner with the test class to initialize the test data
//@RunWith(MockitoJUnitRunner.class)
public class TestCalculatorV2 {

	// @InjectMocks annotation is used to create and inject the mock object
	@InjectMocks
	Calculator calculator = null;
	// @Mock annotation is used to create the mock object to be injected
	//@Mock
	CalculatorService calculatorService;

	//@BeforeEach
	public void setup() {
		 calculator = new Calculator(calculatorService);
	}

	//@Test
	/*public void testPerformComplexTask() {
		when(calculatorService.add(2, 3)).thenReturn(5);
		assertEquals(5, calculator.performComplexTask(2, 3));
		// verify that mock object is executed once
		verify(calculatorService).add(2, 3);
	}*/
}
