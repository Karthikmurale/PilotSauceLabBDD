package Steps;

import Hooks.DriverManager;
import Hooks.Testcontext;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutPage;

public class checkoutPagestepDefinition {

    Testcontext context;
    public WebDriver driver;


    public checkoutPagestepDefinition(Testcontext context)
    {

        //driver = (WebDriver) context.driver;
        driver = DriverManager.getDriver();
    }

    public CheckoutPage checkoutpage;


    @When("I write firstname as {string} lastname as {string} Postalcode as {string} and click continue in checkoutpage")
    public void i_enter_my_and(String firstname,String lastname,String postcode) {
        checkoutpage = new CheckoutPage(driver);
        checkoutpage.checkoutForm(firstname,lastname,postcode);
        checkoutpage.clickContinue();
        System.out.println("Pass - Cart has been selected as expected");
    }

    @When("I click finish button in checkout page")
    public void i_enter_my_and() {
        checkoutpage = new CheckoutPage(driver);
        checkoutpage.clickFinish();
        System.out.println("Pass - Finish has been clicked as expected");
    }
}