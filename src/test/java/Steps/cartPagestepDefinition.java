package Steps;

import Hooks.DriverManager;
import Hooks.Testcontext;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.InventroyPage;

public class cartPagestepDefinition {

    Testcontext context;
    public WebDriver driver;


    public cartPagestepDefinition(Testcontext context)
    {

        //driver = (WebDriver) context.driver;
        driver = DriverManager.getDriver();
    }

    public CartPage Cartpage;


    @When("I select the cart and validate the Product {string}")
    public void i_enter_my_and(String product) {
        Cartpage = new CartPage(driver);
        Cartpage.selectCart();
        Cartpage.verifyCart(product);
        System.out.println("Pass - Cart has been selected as expected");
    }


    @When("I click on the continue button in cart page")
    public void i_click_on_the_continue_button_in_cart() {
        Cartpage = new CartPage(driver);
        Cartpage.clickCheckout();
        System.out.println("Pass - Cart has been selected as expected");
    }



}