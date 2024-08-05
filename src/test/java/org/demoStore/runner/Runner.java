package org.demoStore.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags="@all",
		features = "src/test/resources/features",
		plugin = {
				"pretty",
				"html:target/cucumberReports/htmlReport.html",
				"json:target/cucumberReports/jsonReport.json",
				"junit:target/cucumberReports/xmlReport.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:test-output"
				},
		glue = {
				"org/demoStore/stepDefinitions",
				"org/demoStore/hooks"
		}
	)
public class Runner {
}


