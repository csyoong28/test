package com.soonyoong.junit;

//the class/method we want to test
public class Calculator {

    CalculatorService calculatorService;

    public Calculator(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    
    public Calculator() {
    }

    public int performComplexTask(int i, int j) {
        return calculatorService.add(i, j);
    }

    public int add(int i, int j) {
        return i + j;
    }
}
