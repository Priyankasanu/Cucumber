package Cucumber.Cucumber;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class upload {

	public static ChromeDriver driver;
	

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
		
//		driver.findElementByXPath("//a[text()='Open Seperate Multiple Windows']").click();
//		
//		windowhandle("Sakinalium");
		
		WebElement drag1 = driver.findElementByXPath("//span[text()='Draggable 1']");
		WebElement drop = driver.findElementById("mydropzone");
		Actions action = new Actions(driver);
		action.clickAndHold(drag1).moveToElement(drop,595,448).release().build().perform();
		
		
		
		
//		windowhandle("Index");
//		Set<String> windowHandles = driver.getWindowHandles();
//		List<String> a = new ArrayList<String>(windowHandles);
//		String title = driver.switchTo().window("Index").getTitle();
//		System.out.println(title);
//		driver.findElementByXPath("//button[text()='Sign In']").click();
		
		
		
//		List<String> a = new ArrayList<String>(windowHandles);
//		System.out.println(a.size());
//		driver.switchTo().window(a.get(2));
//		
//		driver.findElementByXPath("//button[text()='Sign In']").click();
//		driver.switchTo().window(a.get(1));
//		driver.close();
//		WebTable("raghup@yahoo.com","Test");
	
		
}
	public static void windowhandle(String title) {
	
			String winHandleBefore = driver.getWindowHandle();
			driver.findElementByXPath("//button[@onclick='multiwindow()']").click();

			 
			Set<String> handle= driver.getWindowHandles();
			
			for(String mywindows : handle){
			
			 String myTitle = driver.switchTo().window(mywindows).getTitle();
			 
			  if(myTitle.equals(title)){
			 
					driver.findElementByXPath("//button[text()='Sign In']").click();

			}else if(myTitle.contains(title)){
				driver.close();
			}
			  else{
			    driver.switchTo().window(winHandleBefore);
			}
			}
	}
//	
//	
//	public static void WebTable(String email, String text) throws InterruptedException {
//		
//		WebElement delete = driver.findElementByXPath("//div[text()='"+email+"']//following::button[contains(@class,'danger')]");
//		WebElement editButton = driver.findElementByXPath("//div[text()='"+email+"']//following::button[contains(@class,'custom')]");
//		Actions action = new Actions(driver);
////		action.contextClick(delete).build().perform();
////		WebElement deleteButton = driver.findElementByXPath("//div[text()='"+email+"']//following::button[contains(text(),'Delete')]");
////		deleteButton.click();
//		System.out.println("Delete Button displayed");
//		Thread.sleep(4000);
//		
//		action.doubleClick(editButton).build().perform();
//		
//		List<WebElement> editField = driver.findElementsByXPath("(//input[@type='text'])");
//		
//		editField.get(1).clear();
//		editField.get(1).sendKeys(text);
		
		
//	}

	
		
		



	
}


