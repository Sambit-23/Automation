package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( 
		features="src/test/java/features",
		glue="stepDefinitions",
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"json:target/jsonReports/cucumber-report.json",
				"html:target/jsonReports/cucumber-report.html"},
		monochrome=true,
		tags="@PC or @SC or @TC_575")

public class TestRunner{
	
}

