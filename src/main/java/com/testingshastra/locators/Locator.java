package com.testingshastra.locators;

public class Locator {
	public static String getLocatorType(String locator) {
		return locator.split("##")[0];
	}

	public static String getLocatorValue(String locator) {
		return locator.split("##")[1];

	}
}
