package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class Hooks {
    public Testcontext context;

    public Hooks(Testcontext context) {
        this.context = context;
        System.out.println("Driver initialized in Hooks class");
    }

    @Before
    public void setup(Scenario scenario) {
        System.out.println("#########################Execution Starts#########################");
        System.out.println("Scenario: " + scenario.getName());
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        DriverManager.setDriver(driver);
        //driver = DriverManager.getDriver();
        //context.driver = DriverManager.getDriver();
        DriverManager.getDriver().get("https://www.saucedemo.com/");
        System.out.println("Browser launched and navigated to the URL");
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Store the driver in the context for use in step definitions
    }

    @After
    public void afterScenario() {
        System.out.println("This will run after each scenario");
       DriverManager.quitDriver();

    }
}