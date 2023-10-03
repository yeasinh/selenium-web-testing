package guru99package;

import java.util.*;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.JavascriptExecutor;

public class Guru99 {

	public static void main(String[] args) throws NoAlertPresentException, InterruptedException {
		
		// instantiate driver object
		System.setProperty("webdriver.edge.driver", "D:\\Edgedriver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		// maximize the window
		driver.manage().window().maximize();
        /**/
        // launch the website
		String baseUrl = "http://demo.guru99.com/test/newtours/";
        driver.get(baseUrl);
        
        // match the title
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        if(actualTitle.contentEquals(expectedTitle)) {
        	System.out.println("Website loaded!");
        } else {
        	System.out.println("Test failed!");
        }
        
        // switch frames
        driver.get("http://demo.guru99.com/selenium/deprecated.html");
        driver.switchTo().frame("classFrame");
        driver.findElement(By.linkText("Deprecated")).click();
        
        // handle alerts
        driver.get("http://jsbin.com/usidix/1");
        driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        driver.switchTo().alert().accept();
        
        // sign-in using dummy email and password in text boxes
        driver.get("https://demo.guru99.com/test/login.html");
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("passwd"));
        WebElement login = driver.findElement(By.id("SubmitLogin"));
        
        // sending values in the text box
        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
        login.submit();
        System.out.println("Log-in done!");
        
        // Deleting values in the text box		
        email.clear();			
        password.clear();			
        System.out.println("Text Field Cleared");
        
        // use radio button
        driver.get("http://demo.guru99.com/test/ajax.html");
        driver.findElement(By.id("no")).click();
        driver.findElement(By.id("buttoncheck")).click();
        
        List<WebElement> elements = driver.findElements(By.name("name"));
        System.out.println("Number of elements: " + elements.size());

        for (int i=0; i<elements.size();i++){
          System.out.println("Radio button text: " + elements.get(i).getAttribute("value"));
        }
        
        // use another radio button
        driver.get("https://demo.guru99.com/test/radio.html");					
        WebElement radio1 = driver.findElement(By.id("vfb-7-1"));							
        WebElement radio2 = driver.findElement(By.id("vfb-7-2"));
        
        radio1.click();			
        System.out.println("Radio Button Option 1 Selected");
        radio2.click();			
        System.out.println("Radio Button Option 2 Selected");
        
        // use check box
        WebElement option1 = driver.findElement(By.id("vfb-6-0"));
        option1.click();
        
        if (option1.isSelected()) {					
            System.out.println("Checkbox is Toggled On");					

        } else {			
            System.out.println("Checkbox is Toggled Off");					
        }
        
        // use another check box
        driver.get("https://demo.guru99.com/test/facebook.html");					
        WebElement checkBox = driver.findElement(By.id("persist_box"));
        
        for (int i = 0; i < 2; i++) {											
        	checkBox.click (); 			
            System.out.println("Facebook Persists Checkbox Status is -  " + checkBox.isSelected());							
        }
        
        // use drop-down
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement dropDownMenu = driver.findElement(By.name("country"));
        Select option = new Select(dropDownMenu);
        option.selectByVisibleText("BANGLADESH");
        
        // check mouse events
        driver.get("http://demo.guru99.com/test/newtours/");
        WebElement home = driver.findElement(By.linkText("Home"));
        WebElement tdhome = driver.findElement(By.xpath("//html/body/div" + "/table/tbody/tr/td"
        + "/table/tbody/tr/td" + "/table/tbody/tr/td" + "/table/tbody/tr"));
        
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder.moveToElement(home).build();
        
        String bgColor = tdhome.getCssValue("background-color");
        System.out.println("Before hover: " + bgColor);        
        mouseOverHome.perform();        
        bgColor = tdhome.getCssValue("background-color");
        System.out.println("After hover: " + bgColor);
        
		// perform multiple actions
        driver.get("http://www.facebook.com/");
        WebElement user = driver.findElement(By.id("email"));

        Actions builder2 = new Actions(driver);
        Action seriesOfActions = builder2
        		.moveToElement(user)
        		.click()
        		.keyDown(user, Keys.SHIFT)
        		.sendKeys(user, "hello")
        		.keyUp(user, Keys.SHIFT)
        		.doubleClick(user)
        		.contextClick()
        		.build();
        	
        seriesOfActions.perform() ;
        
		// upload a file
		driver.get("https://demo.guru99.com/test/upload/");
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

        uploadElement.sendKeys("C:\\Users\\Admin\\Desktop\\Temp.txt");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.name("send")).click();
        
        // download a file
        driver.get("https://demo.guru99.com/test/yahoo.html");
        WebElement download = driver.findElement(By.id("messenger-download"));
        String sourceLocation = download.getAttribute("href");
        String wget_command = "cmd /c C:\\Wget\\wget.exe -P D: --no-check-certificate " + sourceLocation;

        try {
        	Process exec = Runtime.getRuntime().exec(wget_command);
            int exitVal = exec.waitFor();
            System.out.println("Exit value: " + exitVal);
        } 
        catch (InterruptedException | IOException ex) {
            System.out.println(ex.toString());
        }
        
        // handle an alert
		driver.get("https://demo.guru99.com/test/delete_customer.php");
        driver.findElement(By.name("cusid")).sendKeys("53920");	
        driver.findElement(By.name("submit")).submit();
        
        // switch to the alert
        Alert alert = driver.switchTo().alert();
        String alertMessage2 = driver.switchTo().alert().getText();
        System.out.println(alertMessage2);
        Thread.sleep(2000);
        alert.accept();
        
		// handle a pop-up window
		driver.get("https://demo.guru99.com/popup.php");
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		
		// store the main window
		String mainWindow = driver.getWindowHandle();
		// store the newly opened windows
		Set<String> newWindows = driver.getWindowHandles();		
        Iterator<String> items = newWindows.iterator();
        
        while(items.hasNext()) {		
            
            String childWindow = items.next();
        	
            if(!mainWindow.equalsIgnoreCase(childWindow)){
            	// switch to the child window
            	driver.switchTo().window(childWindow);
            	driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");
            	driver.findElement(By.name("btnLogin")).click();
            	// close the child window
            	driver.close();
            }
        }
        
        // switch to the main window
        driver.switchTo().window(mainWindow);
        
        // scroll a page
        driver.get("http://demo.guru99.com/test/guru99home/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        // scroll down at the bottom of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        // scroll by 1000 pixel vertically
        driver.navigate().refresh();
        js.executeScript("window.scrollBy(0,1000)");
        
        // scroll by visibility of an element
        driver.navigate().refresh();
        WebElement element = driver.findElement(By.linkText("Linux"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        
        // scroll horizontally
        driver.get("http://demo.guru99.com/test/guru99home/scrolling.html");
        WebElement element2 = driver.findElement(By.linkText("VBScript"));
        js.executeScript("arguments[0].scrollIntoView();", element2);

        driver.close();
        
	}

}
