package com.soonyoong.mockito;

public abstract class Abstract_Class {
	public String sayMock() {
		return "Hii.. " + getName() + symbol();
	}
	
	private String symbol() {
		return "!!";
	}

	protected abstract String getName();
}
