package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@CucumberOptions(
        features = "Feature/Testcase.feature",
        glue = {"Steps", "Hooks"},
        tags = "@Alltest",
        plugin = {
                "pretty",
                "html:reports/cucumber-html-report",
                "json:reports/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true
)

@Test
public class TestRunnerTest extends AbstractTestNGCucumberTests {
    // This method is not used by Cucumber, but helps IDEs recognize this as a TestNG test class
    @Test
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {

        return super.scenarios();
    }
}

/*
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
*/




// Rename file to TestRunner.java for IDE recognition
