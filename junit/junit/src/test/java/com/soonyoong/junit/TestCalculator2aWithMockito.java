package com.soonyoong.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
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

	@Test
	public void testAddAndSubtract() {
		// add the behavior to add numbers
		when(calculatorService.add(20, 10)).thenReturn(30);
		// subtract the behavior to subtract numbers
		when(calculatorService.subtract(20, 10)).thenReturn(10);
		// test the add functionality
		assertEquals(calculatorService.add(20, 10), 30, 0);
		// test the subtract functionality
		assertEquals(calculatorService.subtract(20, 10), 10, 0);

		// create an inOrder verifier for a single mock
		InOrder inOrder = Mockito.inOrder(calculatorService);
		// following will make sure that add is first called then subtract is called.

		inOrder.verify(calculatorService).add(20, 10);
		inOrder.verify(calculatorService).subtract(20, 10);
	}
	
}
