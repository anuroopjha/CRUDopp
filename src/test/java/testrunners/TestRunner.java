package testrunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", 
		glue = { "stepdefinitions", "hooks" }, 
		plugin = { "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}, 
//				plugin = { "pretty", "html:target/cucumber-reports/cucumber.html"}, 
		monochrome = true, 
		publish = true)

public class TestRunner extends AbstractTestNGCucumberTests {
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
