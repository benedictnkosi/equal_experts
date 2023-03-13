package runner;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@equal_experts_scenario",
        features = "src/test/resources/Feature",
        glue={"stepDefinition"},
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        monochrome = true
)

public class TestRunner {
    @AfterClass
    public static void writeExtentReport() {
        URL res = TestRunner.class.getClassLoader().getResource("extent-config.xml");

    }
}
