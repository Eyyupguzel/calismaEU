package options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

/**
 * TestNG ile Cucumber testlerini çalıştırmak için kullanılan runner sınıfı.
 */
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepdefs"},
        plugin = {"pretty"},
        tags = "@test"
)
public class TestRunner extends AbstractTestNGCucumberTests {

    }

