package utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;
	private static ExtentTest test;

	public static ExtentReports getExtentReports() {
		if (extent == null) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
			try {
				spark.loadXMLConfig("src/test/resources/extent-config.xml");
			} catch (IOException e) {
				e.printStackTrace();
			}
			extent.attachReporter(spark);
		}
		return extent;
	}

	public static ExtentTest createTest(String name) {
		test = getExtentReports().createTest(name);
		return test;
	}

	public static ExtentTest getTest() {
		return test;
	}
}
