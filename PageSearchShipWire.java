package com.shipwire;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageSearchShipWire {
	public static WebElement element = null;
	static Logger log = Logger.getLogger(TestNGshipWire.class);

	public static void clickOnSingInButton(WebDriver driver) {
		driver.findElement(By.xpath("//*[contains(@class,'sw-sign-desktop')]//a[@href='/sign-in/']")).click();
		log.info("Click on Sing In Button");
	}

	public static void fillLogInEmailBox(WebDriver driver) {
		driver.findElement(By.xpath(".//*[@id='signin_username']")).sendKeys("shiptest@mailinator.com");
		log.info("Fill email address box");
	}

	public static void fillPasswordBox(WebDriver driver) {
		driver.findElement(By.xpath(".//*[@id='signin_password']")).sendKeys("test1234");
		log.info("Fill password box");
	}

	public static void clickOnSubmitLogInButton(WebDriver driver) {
		driver.findElement(By.xpath(".//*[@id='signin_submit']")).click();
		log.info("Click on Sing In Button");
	}

	public static void clickOnSupportButton(WebDriver driver) {
		driver.findElement(By.xpath(".//*[@id='topnavhelp']/a")).click();
		log.info("Click on Support Button");
	}

	public static void clickOnContactButton(WebDriver driver) {
		driver.findElement(By.xpath(".//a[@href='/contact/']")).click();
		log.info("Click on Contact Us Button");
	}

	public static void Select_from_the_WhatWeCanHelpWith(WebDriver driver) {
		element = driver.findElement(By.xpath("//label[@class='sws-select']"));
		element.click();
		Select sel = new Select(driver.findElement(By.xpath("//label[@class='sws-select']/select")));
		sel.selectByValue("partners");
		log.info("Select inquiry type 'partners'");
	}

	public static void fillCompanyBox(WebDriver driver) {
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys("TestCompanyMK");
		log.info("Fill companyName box");
	}

	public static void fillNameBox(WebDriver driver) {
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("TestFirstName TestLastName");
		log.info("Fill Name box");
	}

	public static void fillContactEmailBox(WebDriver driver) {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("shiptest1@mailinator.com");
		log.info("Fill email box");
	}

	public static void fillContactPhounBox(WebDriver driver) {
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("1234567890");
		log.info("Fill phoun box");
	}

	public static void fillMessageBox(WebDriver driver) {
		driver.findElement(By.xpath("//textarea[@name='question']")).sendKeys("Test Hi how are you :) ?");
		log.info("Fill message box");
	}

	public static void clickOnSubmitSupportButton(WebDriver driver) {
		driver.findElement(By.xpath("//button[@value='SUBMIT']")).click();
		log.info("Click on Submit Button");
	}

	public static void checkIfElementPresent(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//h2[text()='Your email has been sent!']")));
			log.info("Element appeared on the web page");
		} catch (Exception e) {
			log.info("Element not appeared on the web page");
		}
	}

}
