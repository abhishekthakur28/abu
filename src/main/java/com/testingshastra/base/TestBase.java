package com.testingshastra.base;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.testingshastra.Keyword;
import com.testingshastra.utility.App;

public class TestBase {

	@BeforeMethod
	public void setUp() {
		Keyword keyword = new Keyword();
		keyword.launchBrowser("chrome");
		keyword.launchUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@AfterMethod
	public void tearDown() {
		Keyword.driver.quit();
	}
}
