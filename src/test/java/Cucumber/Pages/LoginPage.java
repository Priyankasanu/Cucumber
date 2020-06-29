package Cucumber.Pages;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends testdriver {

	
	
	public static By username = By.id("login-form-username");
	public static By password = By.id("login-form-password");
	public static By loginBoard = By.xpath("//h3[contains(text(),'Login')]");
	public static By loginButton = By.id("login");
	public static By userProfile = By.xpath("//a[contains(@title,'Priyanka Shanmugam')]");
	
	
	public void openJira() {
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		
		driver_original = new ChromeDriver();
		
		WebdriverListener eventListener = new WebdriverListener();
		
		driver = new EventFiringWebDriver(driver_original);
		driver.register(eventListener);

		
		driver.manage().window().maximize();
		
		waitImplicit(30);
		open("https://jira.perficient.com/secure/Dashboard.jspa");
	}
	public void login(String Username, String Password) {
		
		 waituntilVisible(findElement(loginBoard));
		 findElement(username).sendKeys(Username);
		 findElement(password).sendKeys(Password);
		findElement(loginButton).click();
		
	}
	
	public void verifyLogin() {
		
		waituntilVisible(findElement(userProfile));
        assertTrue("The User has successfully logged in", driver.findElement(userProfile).isDisplayed());
	}
	
	
	
	
	
	
}
