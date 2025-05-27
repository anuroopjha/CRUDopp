package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", 
		glue = { "stepdefinitions", "hooks" }, 
		plugin = { "pretty", "html:target/cucumber-reports/cucumber.html"}, 
		monochrome = true, 
		publish = true)

public class TestRunner extends AbstractTestNGCucumberTests {
}
