package com.testingshastra;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.browsingcontext.Locator;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.testingshastra.base.TestBase;
import com.testingshastra.locators.Locators;
import static com.testingshastra.utility.PropertiesUtility.*;
import static com.testingshastra.utility.Locators.*;
public class AddUserTests extends TestBase {

	@Test
	public void varifyNameOfAlreadyCreatedUserPopulatesInList() throws InterruptedException {
		Keyword keyword = new Keyword();

		keyword.waitForElementToBeVisible((By.xpath("//input[@placeholder='Username']"))).sendKeys("Admin");

		Keyword.driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		Keyword.driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		keyword.waitForElementToBeVisible(By.xpath("//a[contains(@href,'viewPim')]")).click();
		keyword.waitForElementToBeVisible(By.xpath("//button[text()=' Add ']")).click();
		keyword.waitForElementToBeVisible(By.xpath("//input[@name=\"firstName\"]")).sendKeys("salman");

		Keyword.driver.findElement(By.xpath("//input[contains(@class,'mi')]")).sendKeys("khan");
		Keyword.driver.findElement(By.xpath("//input[@name=\"lastName\"]")).sendKeys("tiger");
		Keyword.driver.findElement(By.xpath("//button[text()=\" Save \"]")).click();
		keyword.waitForElementToBeVisible(By.xpath("//a[contains(@href,'Admin')]")).click();
		keyword.waitForElementToBeVisible(By.xpath("//button[text()=' Add ']")).click();
		Thread.sleep(3000);
		Keyword.driver.findElement(By.xpath("//div[@class=\"oxd-select-text-input\"]")).click();
		WebElement ess = Keyword.driver.findElement(By.xpath("//*[contains(text(), 'ESS')]"));
		Actions ac = new Actions(Keyword.driver);
		ac.moveToElement(ess).click().perform();
		keyword.waitForElementToBeVisible(By.xpath("//input[@placeholder=\"Type for hints...\"]")).sendKeys("salman");
		Thread.sleep(5000);
		Boolean found = false;
		List<WebElement> namelist = Keyword.driver.findElements(By.xpath("//*[contains(text(),'salman')]"));
		for (WebElement name : namelist) {
			String s = name.getText();
			System.out.println(s);
			if (name.getText().contains("salman")) {
				found = true;
				break;
			}

		}
		Assert.assertTrue(found);
	}

	@Test
	public void varifyNameOfAlreadyCreatedUserPopulatesInListUsingKeywords() throws InterruptedException {
		Keyword keyword = new Keyword();
		keyword.waitForElementToBeVisible(By.xpath(Locators.username));
		keyword.enterText(Locators.username, "Admin");
		keyword.enterText(Locators.Password, "admin123");
		keyword.clickOn("xpath", Locators.login);
		keyword.waitForElementToBeVisible(By.xpath(Locators.viewPim));
		keyword.clickOn(Locators.viewPim);
		keyword.waitForElementToBeVisible(By.xpath(Locators.add));
		keyword.clickOn(Locators.add);
		keyword.waitForElementToBeVisible(By.xpath(Locators.firstname));
		keyword.enterText(Locators.firstname, "salman");
		keyword.enterText(Locators.middlename, "khan");
		keyword.enterText(Locators.lastname, "tiger");
		keyword.clickOn(Locators.save);
		keyword.waitForElementToBeVisible(By.xpath(Locators.admin));
		keyword.clickOn(Locators.admin);
		keyword.waitForElementToBeVisible(By.xpath(Locators.add));
		keyword.clickOn(Locators.add);
		Thread.sleep(3000);
		keyword.clickOn(Locators.ess);
		WebElement selectEss = Keyword.driver.findElement(By.xpath(Locators.ess));
		Actions ac = new Actions(Keyword.driver);
		ac.moveToElement(selectEss).click().perform();
		keyword.clickOn(Locators.employname, "salman");
		Thread.sleep(5000);
		Boolean found = false;
		List<WebElement> namelist = Keyword.driver.findElements(By.xpath(Locators.namelist));
		for (WebElement name : namelist) {
			String s = name.getText();
			System.out.println(s);
			if (name.getText().contains("salman")) {
				found = true;
				break;
			}

		}
		Assert.assertTrue(found);
	}

// By sing properties file 
	@Test
	public void varifyNameOfAlreadyCreatedUserPopulatesInListUsingKeywordsPropertiesFile() throws InterruptedException {
		Keyword keyword = new Keyword();
		// Before
		keyword.waitForElementToBeVisible(By.xpath(getLocator("username")));
		// After
		// keyword.waitForElementToBeVisible(By.xpath(Locator.getLocator("username")));

		keyword.enterText(getloctor("username"), "Admin");
		keyword.enterText(getloctor("Password"), "admin123");
		keyword.clickOn("xpath", Locators.login);
		keyword.waitForElementToBeVisible(By.xpath(Locators.viewPim));
		keyword.clickOn(Locators.viewPim);
		keyword.waitForElementToBeVisible(By.xpath(Locators.add));
		keyword.clickOn(Locators.add);
		keyword.waitForElementToBeVisible(By.xpath(Locators.firstname));
		keyword.enterText(Locators.firstname, "salman");
		keyword.enterText(Locators.middlename, "khan");
		keyword.enterText(Locators.lastname, "tiger");
		keyword.clickOn(Locators.save);
		keyword.waitForElementToBeVisible(By.xpath(Locators.admin));
		keyword.clickOn(Locators.admin);
		keyword.waitForElementToBeVisible(By.xpath(Locators.add));
		keyword.clickOn(Locators.add);
		Thread.sleep(3000);
		keyword.clickOn(Locators.ess);
		WebElement selectEss = Keyword.driver.findElement(By.xpath(Locators.ess));
		Actions ac = new Actions(Keyword.driver);
		ac.moveToElement(selectEss).click().perform();
		keyword.clickOn(Locators.employname, "salman");
		Thread.sleep(5000);
		Boolean found = false;
		List<WebElement> namelist = Keyword.driver.findElements(By.xpath(Locators.namelist));
		for (WebElement name : namelist) {
			String s = name.getText();
			System.out.println(s);
			if (name.getText().contains("salman")) {
				found = true;
				break;
			}

		}
		Assert.assertTrue(found);
	}

	public void varifyNameOfAlreadyCreatedUserPopulatesInListUsingKeywordsCSS() throws InterruptedException {
		Keyword keyword = new Keyword();
		// Before
		keyword.waitForElementToBeVisible(By.xpath(getLocator("username")));
		// After
		// keyword.waitForElementToBeVisible(By.xpath(Locator.getLocator("username")));

		// keyword.enterText(getLocator("username"), "Admin");
		keyword.enterText("css", "username", "Admin");

		keyword.enterText("css", "password", "admin123");
		keyword.clickOn("css", "login");
		keyword.waitForElementToBeVisible(By.xpath(Locators.viewPim));
		keyword.clickOn(Locators.viewPim);
		keyword.waitForElementToBeVisible(By.xpath(Locators.add));
		keyword.clickOn(Locators.add);
		keyword.waitForElementToBeVisible(By.xpath(Locators.firstname));
		keyword.enterText(Locators.firstname, "salman");
		keyword.enterText(Locators.middlename, "khan");
		keyword.enterText(Locators.lastname, "tiger");
		keyword.clickOn(Locators.save);
		keyword.waitForElementToBeVisible(By.xpath(Locators.admin));
		keyword.clickOn(Locators.admin);
		keyword.waitForElementToBeVisible(By.xpath(Locators.add));
		keyword.clickOn(Locators.add);
		Thread.sleep(3000);
		keyword.clickOn(Locators.ess);
		WebElement selectEss = Keyword.driver.findElement(By.xpath(Locators.ess));
		Actions ac = new Actions(Keyword.driver);
		ac.moveToElement(selectEss).click().perform();
		keyword.clickOn(Locators.employname, "salman");
		Thread.sleep(5000);
		Boolean found = false;
		List<WebElement> namelist = Keyword.driver.findElements(By.xpath(Locators.namelist));
		for (WebElement name : namelist) {
			String s = name.getText();
			System.out.println(s);
			if (name.getText().contains("salman")) {
				found = true;
				break;
			}

		}
		Assert.assertTrue(found);
	}
}
