package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "step_definitions",
        plugin = {"pretty", "html:target/cucumber-html-report"},
        tags = {"~@manual"}
)
public class RunCukesTest {

}
