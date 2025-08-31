package Steps;

import Hooks.DriverManager;
import Hooks.Testcontext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.InventroyPage;
import pages.LoginPage;

public class inventoryPagestepDefinition {

    Testcontext context;
    public WebDriver driver;


    public inventoryPagestepDefinition(Testcontext context)
    {
        //driver = (WebDriver) context.driver;
        driver = DriverManager.getDriver();
    }

    public InventroyPage Inventpage;


    /*@When("I enter my \"(.*)\" and \"(.*)\"")
    public void I_enter_my_username_and_password(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.enterUserNamePassword(username,password);
        System.out.println("Pass - Username and Password entered: " + username + ", " + password);
    }*/

    @When("I choose {string} Product from Inventory page")
    public void i_enter_my_and(String product) {
        Inventpage = new InventroyPage(driver);
        Inventpage.selectProduct(product);
        System.out.println("Pass - Product has been selected as expected");
    }
}