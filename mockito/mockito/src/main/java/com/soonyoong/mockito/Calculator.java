package com.soonyoong.mockito;

//the class/method we want to test
public class Calculator {
	
	CalculatorService calculatorService;
	
	public Calculator(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}
	
	public int performComplexTask(int i, int j) {
		return calculatorService.add(i, j);
	}
}
