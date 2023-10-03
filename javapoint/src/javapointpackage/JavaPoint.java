package javapointpackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

public class JavaPoint {

	public static void main(String[] args) {
		
		// create driver object
		System.setProperty("webdriver.edge.driver", "D:\\Edgedriver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		// launch the website
		driver.navigate().to("https://www.google.com/");
		
		// click on the search box and send a value
		driver.findElement(By.cssSelector("#APjFqb")).sendKeys("selenium java tutorial");
		
		// click on the search button
		driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.gNO89b")).click();
		
		driver.close();
		
		// launch another website
		driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");
		
		// fetch the text from a div
		String sampleText = driver.findElement(By.className("col-md-12")).getText();
		System.out.println(sampleText);
		
		// click on the link
		driver.findElement(By.linkText("This is a link")).click();
		
		// click on the textbox and send an input
		driver.findElement(By.id("fname")).sendKeys("JavaTpoint");
		// clear the input
		driver.findElement(By.id("fname")).clear();
		
		// click on the submit button
		driver.findElement(By.id("idOfButton")).click();
		
		// choose an option in the radio button
		driver.findElement(By.id("male")).click();
		
		// tick the checkbox
		driver.findElement(By.cssSelector("input.Automation")).click();
		
		// choose an option from the drop-down menu
		WebElement testDropDown = driver.findElement(By.id("testingDropdown"));
		Select dropdown = new Select(testDropDown);  
	    dropdown.selectByVisibleText("Automation Testing");
	    
	    // click the button to generate an alert
	    driver.findElement(By.linkText("Generate Alert Box")).click();
	    // switch to the alert
	    Alert alert = (Alert) driver.switchTo().alert();
	    // accept the alert
	    alert.accept();
	    
	    // click the button to generate another alert
	    driver.findElement(By.linkText("Generate Confirm Box")).click();
	    // switch to the alert
	    Alert confirmBox = (Alert) driver.switchTo().alert();
	    // reject the alert
	    confirmBox.dismiss();
	    
	    // select the web element to drag from
	    WebElement from = driver.findElement(By.id("sourceImage"));
	    // select the web element to drop into
	    WebElement to = driver.findElement(By.id("targetDiv"));
	    // Create an Action object to perform composite actions
	    Actions act = new Actions(driver);
	    act.dragAndDrop(from,to).build().perform();
	    
	    // close the browser
	    driver.close();
	    
	}

}
