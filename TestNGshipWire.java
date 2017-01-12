package com.shipwire;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestNGshipWire {

	private WebDriver driver;
	private String BASE_URL = "https://beta.shipwire.com";
	// Initialize Logger for debugging reports with file "log4jShW.properties",
	// this file should be located in main Java Project
	static Logger log = Logger.getLogger(TestNGshipWire.class);

	@BeforeClass
	public void setUp() throws Exception {
		PropertyConfigurator.configure("log4jShW.properties");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.get(BASE_URL);
		log.info("Brouser Starts..........");
	}

	@Test
	public void support_page_form_test() throws Exception {
		String parentHandle = driver.getWindowHandle();
		PageSearchShipWire.clickOnSingInButton(driver);
		PageSearchShipWire.fillLogInEmailBox(driver);
		PageSearchShipWire.fillPasswordBox(driver);
		PageSearchShipWire.clickOnSubmitLogInButton(driver);
		PageSearchShipWire.clickOnSupportButton(driver);

		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);

				PageSearchShipWire.clickOnContactButton(driver);
				PageSearchShipWire.Select_from_the_WhatWeCanHelpWith(driver);
				PageSearchShipWire.fillCompanyBox(driver);
				PageSearchShipWire.fillNameBox(driver);
				PageSearchShipWire.fillContactEmailBox(driver);
				PageSearchShipWire.fillContactPhounBox(driver);
				PageSearchShipWire.fillMessageBox(driver);

				// Have to wait because submit button doesn't work property
				// until page is completely loaded
				Thread.sleep(10000);
				PageSearchShipWire.clickOnSubmitSupportButton(driver);
				log.info("Observed expected results(Thank you)......");
				PageSearchShipWire.checkIfElementPresent(driver);
				break;
			}
		}
	}

	@AfterClass
	public void afterClass() throws Exception {
		log.info("Brouser Quit..........");
		Thread.sleep(3000);
		driver.quit();
	}
}
