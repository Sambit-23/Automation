package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/jsonReports/cucumber-report.json","html:target/jsonReports/cucumber-report.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = {"src/test/java/features"},
        glue = {"steps"},
        tags = "@TC_CloudAccessMobile_01-05",
        publish = true,
        monochrome = true

)
public class TestRunner {

}
