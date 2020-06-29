package testRunner;


import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		features = "src/test/java/features",
		glue = "stepDefinition"
		)
public class runner extends AbstractTestNGCucumberTests{

	
}	
