package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ExtentManager;

public class Hooks {

	@Before
    public void beforeScenario(Scenario scenario) {
        ExtentManager.createTest(scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
        	ExtentManager.getTest().fail("Step Failed");
        } else {
        	ExtentManager.getTest().pass("Step Passed");
        }
    }

    @After
    public void afterScenario() {
    	ExtentManager.getExtentReports().flush();
    }
}
