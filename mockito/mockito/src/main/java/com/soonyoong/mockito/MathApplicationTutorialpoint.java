package com.soonyoong.mockito;

public class MathApplicationTutorialpoint {
	   private CalculatorServiceTutorialPoint calculatorServiceTutorialPoint;

	   public void setCalculatorServiceTutorialPoint(CalculatorServiceTutorialPoint calculatorServiceTutorialPoint){
	      this.calculatorServiceTutorialPoint = calculatorServiceTutorialPoint;
	   }
	   
	   public double add(double input1, double input2){
	      return calculatorServiceTutorialPoint.add(input1, input2);		
	   }
	   
	   public double subtract(double input1, double input2){
	      return calculatorServiceTutorialPoint.subtract(input1, input2);
	   }
	   
	   public double multiply(double input1, double input2){
	      return calculatorServiceTutorialPoint.multiply(input1, input2);
	   }
	   
	   public double divide(double input1, double input2){
	      return calculatorServiceTutorialPoint.divide(input1, input2);
	   }
}
