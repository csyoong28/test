package com.soonyoong.mockito;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

public class TEX_02_MathApplicationTester {
	private MathApplicationTutorialpoint mathApplicationTutorialpoint;
	private CalculatorServiceTutorialPoint calculatorServiceTutorialPoint;

	@Before
	public void setUp() {
		mathApplicationTutorialpoint = new MathApplicationTutorialpoint();
		Calculator calculator = new Calculator();
		calculatorServiceTutorialPoint = Mockito.spy(calculator);
		mathApplicationTutorialpoint.setCalculatorServiceTutorialPoint(calculatorServiceTutorialPoint);
	}

	@Test
	public void testAdd() {
		// perform operation on real object
		// test the add functionality
		Assert.assertEquals(mathApplicationTutorialpoint.add(20.0, 10.0), 30.0, 0);
	}

	class Calculator implements CalculatorServiceTutorialPoint {
		public double add(double input1, double input2) {
			return input1 + input2;
		}

		public double subtract(double input1, double input2) {
			throw new UnsupportedOperationException("Method not implemented yet!");
		}

		public double multiply(double input1, double input2) {
			throw new UnsupportedOperationException("Method not implemented yet!");
		}

		public double divide(double input1, double input2) {
			throw new UnsupportedOperationException("Method not implemented yet!");
		}
	}
}
