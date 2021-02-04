package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features",
		glue = "stepDefinitions",
        plugin = {
                "json:target/cucumber.json",
                "html:target/cucumber-reports/",
                "junit:target/junit/junit-report.xml"
                },
        dryRun = false
		)


public class runner {

}
