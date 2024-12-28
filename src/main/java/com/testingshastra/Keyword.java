package com.testingshastra;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.testingshastra.error.InvalidBrowserError;

public class Keyword {
	public static RemoteWebDriver driver = null;
	public static FluentWait<WebDriver> wait=null;

	public void launchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			System.out.println("launched chrome browser");
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			System.out.println("launched firefox browser");

		} else if (browserName.equalsIgnoreCase("internetexplorer")) {
			driver = new InternetExplorerDriver();
			System.out.println("launch internetexplorer browser");
		} else {
			throw new InvalidBrowserError(browserName);
		}
		// Create FluentWait object
		wait.withTimeout(Duration.ofSeconds(60)); // Maximum wait time (10 seconds)
		wait.pollingEvery(Duration.ofSeconds(3)); // Polling interval (1 second)
		wait.ignoring(TimeoutException.class); // Exception to ignore during wait

	}

	public void launchUrl(String url) {
		driver.get(url);
	}

	public void enterText(String locator, String value) {
		driver.findElement(By.xpath(locator)).sendKeys(value);
	}

	// entertext ko dynamic kr diya
	public void enterText(String locatorType, String locatorValue, String textToEnter) {
		if (locatorType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorValue)).sendKeys(textToEnter);
		} else if (locatorType.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector(locatorValue)).sendKeys(textToEnter);
		} else if (locatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).sendKeys(textToEnter);

		} else if (locatorType.equalsIgnoreCase("classname")) {
			driver.findElement(By.className(locatorValue)).sendKeys(textToEnter);

		} else if (locatorType.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locatorValue)).sendKeys(textToEnter);
		}

		else if (locatorType.equalsIgnoreCase("tagname"))

		{
			driver.findElement(By.tagName(locatorValue)).sendKeys(textToEnter);

		} else if (locatorType.equalsIgnoreCase("linktext"))

		{
			driver.findElement(By.linkText(locatorValue)).sendKeys(textToEnter);

		} else if (locatorType.equalsIgnoreCase("partiallinktext"))

		{
			driver.findElement(By.partialLinkText(locatorValue)).sendKeys(textToEnter);

		} else {
			throw new InvalidSelectorException(locatorType);
		}
	}

	public WebElement waitForElementToBeVisible(By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return driver.findElement(by);

	}

	/**
	 * use this method to click on {@code WebElement} by its xpath this method
	 * doesn't support other locator stratergies
	 * 
	 * @param locator
	 */
	public void clickOn(String locator) {
		driver.findElement(By.xpath(locator)).click();
	}

	/**
	 * This method can be used to click on element ,you need to provide locator-type
	 * and locator value
	 * 
	 * @param locatortype  that is one of following :
	 *                     id,name,tagname,classname,linktext etc
	 * @param locatorvalue
	 */
	public void clickOn(String locatortype, String locatorvalue) {
		if (locatortype.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorvalue));

		} else if (locatortype.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorvalue));

		} else if (locatortype.equalsIgnoreCase("name")) {
			driver.findElement(By.xpath(locatorvalue));

		} else if (locatortype.equalsIgnoreCase("classname")) {
			driver.findElement(By.xpath(locatorvalue));

		} else if (locatortype.equalsIgnoreCase("css")) {
			driver.findElement(By.xpath(locatorvalue));

		} else if (locatortype.equalsIgnoreCase("tagname")) {
			driver.findElement(By.xpath(locatorvalue));

		} else if (locatortype.equalsIgnoreCase("linktext")) {
			driver.findElement(By.xpath(locatorvalue));

		} else if (locatortype.equalsIgnoreCase("partiallinktext")) {
			driver.findElement(By.xpath(locatorvalue));

		} else {
			// ye vala type apka galat h locator type
			throw new InvalidSelectorException(locatortype);
		}
	}
}
