package com.yeasin.selenium_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class BugResTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void init() {
		// web driver initialization
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
				
		// launch the web site
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();		
	}
	
	@Test(priority=1)
	public void test_title() {
		// match the title
		String expectedTitle = "Swag Labs";
		String actualTitle = driver.getTitle();
		System.out.println("Title: " + actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "Title NOT matched!");
	}
	
	@Test(priority=2)
	public void test_url() {
		// match the URL
		String expectedUrl = "https://www.saucedemo.com/";
		String actualUrl = driver.getCurrentUrl();
		System.out.println("URL: " + actualUrl);
		Assert.assertEquals(actualUrl, expectedUrl, "URL NOT matched!");
	}
}