package Cucumber.Pages;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class dashBoardPage extends testdriver {
	
	public static By dashBoardBy = By.id("home_link");
	public static By manageDashboard = By.xpath("//a[contains(text(),'Manage Dashboards')]");
	public static By createDashboard = By.id("create_page");
	public static By pageName = By.name("portalPageName");
	public static By description = By.name("portalPageDescription");
	public static By addButton = By.id("edit-entity-submit");
	public static By header = By.xpath("//h1[contains(text(),'Create New Dashboard')]");
	public static By startFromDropdown = By.name("clonePageId");
	public static By created = By.xpath("//div[@class='favourite-item']/a[text()='Test Dashboard']");
	public static By testDashboardHeader = By.xpath("//div[@class='aui-page-header-main']/h1[text()='Test Dashboard']");

	
	public void verifyDashBoardOption() {
		
			try {
					Thread.sleep(7000);
					waituntilVisible(findElement(dashBoardBy));
					assertTrue("The User has successfully logged in", findElement(dashBoardBy).isDisplayed());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					log.error(e);			
				}
			  
	}
	
	public void createNewDashboard(String pageNameValue, String descriptionValue, String typeValue){
		
		
		try {
				findElement(dashBoardBy).click();
				waitImplicit(30);
				findElement(manageDashboard).click();
				waituntilVisible(findElement(createDashboard));
				findElement(createDashboard).click();
				waituntilVisible(findElement(header));
				assertTrue(findElement(header).isDisplayed(), "The Create new Dashboard Header is displayed");
				findElement(pageName).sendKeys(pageNameValue);
				findElement(description).sendKeys(descriptionValue);
				selectDropdownVisibleText(findElement(startFromDropdown), typeValue);
				findElement(addButton).click();
				waituntilVisible(findElement(created));
				assertTrue(findElement(created).isDisplayed(), "The Dashboard is created");
			} catch (Exception e) {
				log.error("The Dashboard is not created" +e );
			}
		
		
	}
	
	
	public static By testDashboard = By.xpath("//h1[contains(text(),'Test Dashboard')]");
	public static By addGadget = By.id("add-gadget");
	public static By loadAllGadgets = By.xpath("//a[contains(text(),'Load all gadgets')]");
	
	
	public void clickDashboard() {
		
			findElement(created).click();
			waituntilVisible(findElement(testDashboard));
			assertTrue(findElement(testDashboard).isDisplayed(), "The User is in the created Dashboard" );
		
		
	}
	
	
	public static By addActivityStream = By.xpath("//button[contains(@data-item-id,'activitystream-gadget.xml')]");
	public static By closeButton = By.xpath("//span[contains(@class,'close-dialog')]");
	public static By activityStreamHeader = By.xpath("//h3[contains(text(),'Activity Stream')]");
	public static By addAGadgetHere = By.xpath("//a[contains(text(),'add a new gadget.')]");
	public static By dragAGadgetHere = By.xpath("//p[contains(text(),'Drag your gadget here.')]");
	public static By addAssignToMe = By.xpath("//div[contains(@data-item-id,'assigned-to-me-gadget.xml')]//button");
	public static By assignedToMeHeader = By.xpath("//h3[contains(text(),'Assigned to Me')]");
	public static By votedGadget = By.xpath("//button[contains(@data-item-id,'voted-gadget')]");
	public static By votedIssuesHeader = By.xpath("//h3[contains(text(),'Voted Issues')]");
	public static By crucibleCharts = By.xpath("//button[contains(@data-item-id,'crucible-charting')]");
	public static By crucibleChartsHeader = By.xpath("//h3[contains(text(),'Crucible Charts')]");
	public static By favouriteFilters = By.xpath("//button[contains(@data-item-id,'favourite-filters')]");
	public static By favouriteFiltersHeader = By.xpath("//h3[contains(text(),'Favorite Filters')]");

	
//	public static By header1 = By.xpath("//h3[contains(text(),'"+Favorite Filters+"')]");
	
	public void addGadget(By gadget1,By gadgetHeader1) {
		findElement(addGadget).click();
		if(isElementPresent(loadAllGadgets)) {
		findElement(loadAllGadgets).click();}
		
		waituntilVisible(findElement(gadget1));
		findElement(gadget1).click();
		findElement(closeButton).click();
		assertTrue(findElement(gadgetHeader1).isDisplayed(), "The gadget has been added to the dashboard ");
		
	}
	
	public void addAGadgetHere(By gadget2,By gadgetHeader2) {
		waitImplicit(30);
		findElements(addAGadgetHere).get(1).click();
		waituntilVisible(findElement(gadget2));
		findElement(gadget2).click();
		findElement(closeButton).click();
		assertTrue(findElement(gadgetHeader2).isDisplayed(),"The gadget has been added to the Dashboard");
	}
	
	public static By moreButton = By.xpath("//span[@class='aui-icon-small aui-iconfont-more']");
	public static By deleteButton = By.xpath("//a[contains(@class,'item-link delete')]");
	
	public static By target = By.xpath("(//li[contains(@class,'empty-text')])");
	
	public static By source = By.xpath("//div[@class='dashboard-item-header']");
	
	
	
//	public static By secondColumn = By.xpath("//ul[@class='column second sortable ui-sortable']");
	
	public void deleteGadget() throws InterruptedException {
		
		findElements(moreButton).get(0).click();
		waitImplicit(30);
		findElements(deleteButton).get(0).click();
		waitImplicit(30);
		alertHandleOk();
		waitImplicit(50);
	
		boolean displayed = driver.findElement(testDashboardHeader).isDisplayed();
		Thread.sleep(9000);
		assertTrue(displayed, "The Created Dashboard is present");
		waitImplicit(9);
		boolean elementNotPresent = isElementPresent(activityStreamHeader);

		assertFalse(elementNotPresent, "False");
	}
	
	public void moveGadget() {
		
		dragAndDrop(findElement(source),findElement(target));
	}
	
	public void swapping(String Source, String Target) throws InterruptedException {
		
				
		
	}
//	public void swapping() {
//		dragAndDropUsingMove(findElement(crucibleChartsHeader),findElement(favouriteFiltersHeader));
//		waitImplicit(9);
//		dragAndDropUsingMove(findElement(assignedToMeHeader), findElement(votedIssuesHeader));
//		waitImplicit(9);
//		dragAndDropUsingMove(findElement(crucibleChartsHeader), findElement(favouriteFiltersHeader));
//	}

	public void swapping(String[][] data) {
		// TODO Auto-generated method stub
		waitImplicit(15);
		dragAndDropUsingMove(driver.findElement(By.xpath("//h3[contains(text(),'"+data+"')]")),driver.findElement(By.xpath("//h3[contains(text(),'"+data+"')]")));

	}

}
