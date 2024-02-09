package com.yeasin.selenium_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SwagLabs {

	public static void main(String[] args) throws InterruptedException {
		
		// web driver initialization
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		// launch the web site
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		// match the title
		String expectedTitle = "Swag Labs";
		String actualTitle = driver.getTitle();
		System.out.println("Title: " + actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "Title NOT matched!");
		
		// match the URL
		String expectedUrl = "https://www.saucedemo.com/";
		String actualUrl = driver.getCurrentUrl();
		System.out.println("URL: " + actualUrl);
		Assert.assertEquals(actualUrl, expectedUrl, "URL NOT matched!");
		
		// send values to text boxes
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		// click the log-in button
		driver.findElement(By.id("login-button")).click();
		
		// choose a product, add it to the cart, and checkout
		WebElement backpack = driver.findElement(By.className("inventory_item_name"));
		Thread.sleep(2000);
		backpack.click();
		WebElement addToCart = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
		Thread.sleep(2000);
		addToCart.click();
		WebElement cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
		Thread.sleep(2000);
		cart.click();
		WebElement checkout = driver.findElement(By.id("checkout"));
		Thread.sleep(2000);
		checkout.click();
		
		driver.findElement(By.id("first-name")).sendKeys("Prottoy");
		driver.findElement(By.id("last-name")).sendKeys("Yeasin");
		driver.findElement(By.id("postal-code")).sendKeys("1200");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#continue")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#finish")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#back-to-products")).click();
		
		// wait for 3 seconds
		Thread.sleep(3000);
		
		// close the tab
		driver.close();
	}
}