package runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
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
        try {
            Reporter.loadXMLConfig(String.valueOf(Paths.get(res.toURI())));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
