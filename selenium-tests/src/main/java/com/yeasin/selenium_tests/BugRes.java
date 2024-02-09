package com.yeasin.selenium_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BugRes {

	public static void main(String[] args) throws InterruptedException {
		
		// web driver initialization
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		// launch the web site
		driver.get("https://trytestingthis.netlify.app/");
		driver.manage().window().maximize();
		
		// handle radio buttons
		WebElement optionMale = driver.findElement(By.id("male"));
		optionMale.click();
				
		if(optionMale.isSelected()) {
			System.out.println("'Male' option is selected.");
		} else {
			System.out.println("No option is selected.");
		}
				
		// handle drop-downs
		WebElement dropdown = driver.findElement(By.id("option"));
		Select options = new Select(dropdown);
		options.selectByValue("option 1");
				
		// handle check boxes
		WebElement checkboxoption1 = driver.findElement(By.name("option1"));
		checkboxoption1.click();
		Thread.sleep(1000);
		checkboxoption1.click();
		WebElement checkboxoption2 = driver.findElement(By.name("option2"));
		checkboxoption2.click();
		Thread.sleep(1000);
		checkboxoption2.click();
		WebElement checkboxoption3 = driver.findElement(By.name("option3"));
		checkboxoption3.click();
		Thread.sleep(1000);
		checkboxoption3.click();
		
		// wait for 3 seconds
		Thread.sleep(3000);
		
		// close the tab
		driver.close();
	}
}
