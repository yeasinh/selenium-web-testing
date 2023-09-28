package bugres9package;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class BugRes {

	public static void main(String[] args) throws InterruptedException {
		
		// Web driver initialization
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
		
		// wait for 3 seconds
		Thread.sleep(3000);
		
		// close the tab
		driver.close();

	}

}
