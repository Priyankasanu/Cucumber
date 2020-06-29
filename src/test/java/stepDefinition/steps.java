package stepDefinition;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import Cucumber.Pages.LoginPage;
import Cucumber.Pages.testdriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Cucumber.Pages.dashBoardPage;

public class steps extends testdriver{
	
	LoginPage page = new LoginPage();
	dashBoardPage dashBoardPage = new dashBoardPage();
	
    @Given("^User is at Login Page")
    public void user_is_at_login_page() throws Throwable {
		 page.openJira();
	    }

	 @When("^User Login into Application with (.+) and (.+)$")
	    public void user_login_into_application_with_and(String username, String password) throws Throwable {
	    	page.login(username, password);
	    }

	 @Then("^User Dashboard is displayed with sucessful Login$")
	    public void user_dashboard_is_displayed_with_sucessful_login() throws Throwable {
	    	page.verifyLogin();
	    }

	 @Given("^Dashboard in present on the Home page$")
	    public void dashboard_in_present_on_the_home_page() throws Throwable {
	    	dashBoardPage.verifyDashBoardOption();
	    }

	 @When("^User Creates a new Dashboard by clicking Manage Dashboard with (.+) , (.+) and (.+)$")
	    public void user_creates_a_new_dashboard_by_clicking_manage_dashboard_with_and(String pagenamevalue, String pagedescription, String typevalue) throws Throwable {

	        dashBoardPage.createNewDashboard(pagenamevalue,pagedescription,typevalue);
	    }

	   

	 @And("^Click on the Created Dashboard$")
	    public void click_on_the_created_dashboard() throws Throwable {
	    	dashBoardPage.clickDashboard();
	    }

	    @And("^Add gadgets to the Created Dashboard$")
	    public void add_gadgets_to_the_created_dashboard() throws Throwable {
	        dashBoardPage.addGadget(dashBoardPage.addActivityStream, dashBoardPage.activityStreamHeader);
	        dashBoardPage.addAGadgetHere(dashBoardPage.addAssignToMe,dashBoardPage.assignedToMeHeader);
	    }
	    
	    @Then("^Reorganize and Move gadgets by Dragging and Dropping$")
	    public void reorganize_and_move_gadgets_by_dragging_and_dropping() throws Throwable {
	       dashBoardPage.deleteGadget();
	       dashBoardPage.moveGadget();
	       
	    }
	    public List<HashMap<String,String>> datamap;
	    
	    @Test(dataProvider = "fetchData")
	    @Then("^Swap the Added Gadgets in the Dashboard$")
	    public void swap_the_added_gadgets_in_the_dashboard(String rowindex,String rowindex2) throws Throwable {
	    	Thread.sleep(15000);
	    	
	    
//	    	for(int i = 0;i<=getData().length;i++) {
//	    		Map<String,String> a = new HashMap<String,String>();
//	    		a.putAll(getData());
//	    	
	    	
	    	int index = Integer.parseInt(rowindex)-1;
	          System.out.println("Printing current data set...");
	          for(HashMap h:datamap)
	          {
	              System.out.println(h.keySet());
	              System.out.println(h.values());
	          }
	          
	          int index2 = Integer.parseInt(rowindex2)-1;
	          System.out.println("Printing current data set...");
	          for(HashMap h:datamap)
	          {
	              System.out.println(h.keySet());
	              System.out.println(h.values());
	          }
	          
	          dashBoardPage.swapping(datamap.get(1).get("Gadgets1"), datamap.get(1).get("Gadgets2"));
	    	
	    }
//	    	dashBoardPage.swapping("Crucible Charts","Favorite Filters");
//	    	dashBoardPage.swapping("Assigned to Me","Voted Issues");
//	    	dashBoardPage.swapping("Crucible Charts","Favorite Filters");
	    }

	    @And("^Add three more Gadgets to the Dashboard$")
	    public void add_three_more_gadgets_to_the_dashboard() throws Throwable {
	    	dashBoardPage.addAGadgetHere(dashBoardPage.favouriteFilters, dashBoardPage.favouriteFiltersHeader);
	    	dashBoardPage.addGadget(dashBoardPage.votedGadget, dashBoardPage.votedIssuesHeader);
	    	dashBoardPage.addGadget(dashBoardPage.crucibleCharts, dashBoardPage.crucibleChartsHeader);

	    	
	    }

	    
}
