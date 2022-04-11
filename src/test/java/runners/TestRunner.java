package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/feature/UIDemo.feature",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:test-output", "json:target/json_output/cucumber.json", "html:target/cucumber-html-report.html"},
        monochrome = true
)
public class TestRunner {
}