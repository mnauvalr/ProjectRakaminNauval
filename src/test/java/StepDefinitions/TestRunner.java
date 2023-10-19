package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = { "StepDefinitions" }, monochrome = true, plugin = {
		"pretty", "html:target/HtmlReports/index.html" },
//plugin = {"pretty", "json:target/reports/cucumber.json"}
//plugin = {"pretty", "junit:target/reports/cucumber.xml"}
//plugin = {"pretty", "html:target/HtmlReports",
//		"json:targer/JSONReports/report.json",
//		"html:targert/HtmlReports"},

		tags = "@SmokeScenario"
)

public class TestRunner {

}
