package cucumber.Options;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/featurefiles",
		glue={"stepDefinitions"},
		tags= {"@deleteplace"},
		plugin= "json:target/jsonReports/cucumber-json-reports.json"
		)
public class TestRunner {

}
