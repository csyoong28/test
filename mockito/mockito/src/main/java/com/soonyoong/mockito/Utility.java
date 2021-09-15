package com.soonyoong.mockito;

public class Utility {
	public static String staticMethod(String call) {
		return call;
	}

	private String privateMethod(String message) {
		return message;
	}

	public String callPrivateMethod(String message) {
		return privateMethod(message);
	}

	public final String finalMethod(String message) {
		return message;
	}
}
