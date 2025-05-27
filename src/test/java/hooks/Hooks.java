package hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ExtentManager;

public class Hooks {

	private static ExtentReports extent = ExtentManager.getInstance();
	private static ExtentTest test;

	@Before
	public void setUp(Scenario scenario) {
		test = extent.createTest(scenario.getName());
		test.log(Status.INFO, "Test Started: " + scenario.getName());
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			test.log(Status.FAIL, "Test Failed: " + scenario.getName());
		} else {
			test.log(Status.PASS, "Test Passed: " + scenario.getName());
		}

		extent.flush();
	}

	public static ExtentTest getTest() {
		return test;
	}
}
