package com.testingshastra.error;

public class InvalidBrowserError extends Error {
	private String browserName;

	public InvalidBrowserError(String browserName) {
		this.browserName = browserName;
	}

	@Override
	public String getMessage() {
		return " Invalid Browser name: " + this.browserName;
	}

}
