package tutorialspointpackage;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

public class TutorialsPoint {
	public static void main(String[] args) {
		
		// instantiate the driver
		System.setProperty("webdriver.edge.driver", "D:\\Edgedriver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		// wait for 10 seconds before throwing exceptions
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// maximize the browser
		driver.manage().window().maximize();
		
		// launch the website
		driver.navigate().to("http://www.calculator.net/");
		
		// select the percentage calculator from the math calculator
		driver.findElement(By.xpath("//*[@id=\"homelistwrap\"]/div[3]/div[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/table[2]/tbody/tr/td/div[3]/a")).click();
		
		// send values to calculate
		driver.findElement(By.id("cpar1")).sendKeys("10");
		driver.findElement(By.id("cpar2")).sendKeys("50");
		
		// click the calculate button
		driver.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr[2]/td/input[2]")).click();
		
		// get the result and print it
		String result = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText();
		System.out.println("The result is " + result);
		
		// close the browser
		driver.close();
	}
	
}
