package step_definitions;

import org.junit.runner.RunWith;
import org.w3c.dom.views.AbstractView;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.reporting.CucumberDetailedResults;
import com.github.mkolisnyk.cucumber.runner.AfterSuite;
import com.github.mkolisnyk.cucumber.runner.BeforeSuite;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/*
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
		tags = {}
		
		
		
		
		
		
		)
*/


@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
retryCount = 3,
detailedReport = true,
detailedAggregatedReport = true,
overviewReport = true,
//coverageReport = true,
jsonUsageReport = "target/cucumber-usage.json",
usageReport = true,
toPDF = true,
excludeCoverageTags = {"@flaky" },
includeCoverageTags = {"@passed" },
outputFolder = "target")
@CucumberOptions(plugin = { "html:target/cucumber-html-report",
"json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
"usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml" },
        features = { "D:/cucumberjvm-selenium-class1/src/test/resources/features/BrowserCommands.feature" })

public class RunCukesTest{
	
	
	public static class SampleCucumberTest {
		@BeforeSuite
		public static void setUp() {
			// TODO: Add setup code
		}
		@AfterSuite
		public static void tearDown() throws Exception {
			/* CucumberDetailedResults results = new CucumberDetailedResults();
		        results.setOutputDirectory("target/");
		        results.setOutputName("cucumber-results");
		        results.setSourceFile("./src/test/resources/cucumber.json");
		        results.executeDetailedResultsReport(false, false);*/
		}
	
	
	}}
