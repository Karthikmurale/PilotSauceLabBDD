package Steps;

import Hooks.DriverManager;
import Hooks.Testcontext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class loginPagestepDefinition {

    Testcontext context;
    public WebDriver driver;


    public loginPagestepDefinition(Testcontext context)
    {

        //driver = (WebDriver) context.driver;
        driver = DriverManager.getDriver();
    }

    public LoginPage loginPage;

    @Given("I am on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("Execution started for login page");
        loginPage = new LoginPage(driver);
        loginPage.VerifyLogin();
    }
    /*@When("I enter my \"(.*)\" and \"(.*)\"")
    public void I_enter_my_username_and_password(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.enterUserNamePassword(username,password);
        System.out.println("Pass - Username and Password entered: " + username + ", " + password);
    }*/

    @When("I enter my {string} and {string}")
    public void i_enter_my_and(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.enterUserNamePassword(username,password);
        System.out.println("Pass - Username and Password entered: " + username + ", " + password);
    }

    @Given("I click on the login button")
    public void I_click_on_the_login_button() {
        loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        System.out.println("Pass - Login button has been clicked successfully");
    }

    @Given("I should be redirected to the homepage")
    public void I_should_be_redirected_to_the_homepage() {
        loginPage = new LoginPage(driver);
        loginPage.VerifyHomePage();
        System.out.println("Home Page reached successfully");
    }





/*    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        LoginPage loginPage = new LoginPage(hooks.driver);
        TestFactory.writeText(loginPage.userName, "standard_user");
        TestFactory.writeText(loginPage.password, "secret_sauce");
        TestFactory.clickElement(loginPage.loginButton);
    }

    @Then("User should be able to login successfully")
    public void user_should_be_able_to_login_successfully() {
        LoginPage loginPage = new LoginPage(hooks.driver);
        loginPage.VerifyLogin();
    }*/
}