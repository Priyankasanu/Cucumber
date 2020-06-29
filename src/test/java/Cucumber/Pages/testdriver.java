package Cucumber.Pages;

import static org.testng.Assert.assertNull;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jsoup.Connection.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import Cucumber.Pages.excelIntegrationCode;


public class testdriver {
	
	
	public static ChromeDriver driver_original;
	
	public static EventFiringWebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	public String excelFileName = "Gadgets";

	@BeforeClass(alwaysRun = true)
////	public void setupBrowser() {
//	System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
//	
//	driver1 = new ChromeDriver();
//	
//	driver.manage().window().maximize();
//	
//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	
//	}
	
//	public void printError(Object e) {
//		
//		try {
//			test.log(Status.FAIL, e);
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//
//		
//	}
	
	
	public void open(String URL){
		
			try {
				driver.get(URL);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
	}
	
	public void waituntilVisible(WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(ele));
			log.info("The element is visible" +ele);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
	}
	
	public void waitImplicit(int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectDropdownVisibleText(WebElement ele,String text) {
		try {
			Select dropDownSelect = new Select(ele);
			dropDownSelect.selectByVisibleText(text);
			log.info("The Element is selected successfully" +ele);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public WebElement findElement(By by) {
			
			WebElement element = null;
		
			 try {
				 element = driver.findElement(by);

			} catch (Exception e) {
				// TODO Auto-generated catch block
//				printError(e);

			}
			
				return  element;
				

	}
	
	public List<WebElement> findElements(By by) {
		List<WebElement> findElements = null;
		 try {
			findElements = driver.findElements(by);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return findElements;
	}
	
	public static ChromeDriver getDriver() {
		return driver_original;
	}
	
	//Confirmation Alert
	public void alertHandleOk() {
		
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			waitImplicit(40);
			log.info("Accepted the alert");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean isElementPresent(By by){
		try{
			driver.findElement(by);
			
			return true;
		}catch (NoSuchElementException e){
			return false;
		}
	}
	
	//Drag Drop using Move-to-Element
	public void dragAndDropUsingMove(WebElement eleSource, WebElement eleTarget) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(eleSource).clickAndHold(eleSource).build().perform();
			action.moveToElement(eleTarget).build().perform();
			Thread.sleep(4000);
			action.click().release().build().perform();
			log.info(" "+eleSource+" is dragged to "+eleTarget+" ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void dragAndDrop(WebElement sourceEle,WebElement targetEle) {
		try {
			waitImplicit(10);
			Actions action = new Actions(driver);
			action.dragAndDrop(sourceEle, targetEle).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@DataProvider
//	public String[][] getData() throws IOException
//	{
//		excelIntegrationCode data = new excelIntegrationCode();
//		return data.readExcel();
//	}
	
	@DataProvider(name="fetchData")
	public String[][] getData() throws InvalidFormatException, IOException{
		return excelIntegrationCode
				.readExcel(excelFileName);
	}


}
