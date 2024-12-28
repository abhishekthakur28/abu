package com.testingshastra.locators;

public interface Locators {
	String username = "xpath##//input[@placeholder='Username']";
	String Password = "//input[@placeholder='Password']";
	String login = "//button[normalize-space()='Login']";
	String viewPim="//a[contains(@href,'viewPim')]";
	String employname="//input[@placeholder=\"Type for hints...\"]";
	String add = "//button[text()=' Add ']";
	String admin = "//a[contains(@href,'Admin')]";
	String ess = "//div[@class=\"oxd-select-text-input\"]";
	String firstname ="//input[@name=\"firstName\"]";
	String middlename = "//input[contains(@class,'mi')]";
	String lastname = "//input[@name=\"lastName\"]";
	String save = "//button[text()=\" Save \"]";
	String selectEss="//*[contains(text(), 'ESS')]";
	String namelist ="//*[contains(text(),'salman')]";
}
