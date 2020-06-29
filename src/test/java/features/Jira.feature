Feature: Jira Application Login


Scenario Outline: Jira Home Page Login
	Given User is at Login Page
	When User Login into Application with <Username> and <Password>
	Then User Dashboard is displayed with sucessful Login
	
		
Examples:
|Username 	| Password |
|P.Shanmugam	| Dream@2406|

Scenario Outline: Create and Manage Dashboards
	Given Dashboard in present on the Home page
	When User Creates a new Dashboard by clicking Manage Dashboard with <pageNameValue> , <pageDescription> and <typeValue>
	And Click on the Created Dashboard
	And Add gadgets to the Created Dashboard
	Then Reorganize and Move gadgets by Dragging and Dropping
	And Add three more Gadgets to the Dashboard
	Then Swap the Added Gadgets in the Dashboard

	
Examples:
|pageNameValue |pageDescription |typeValue |
|Test Dashboard |Test Description |Blank dashboard |

