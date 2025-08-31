package pages;

import core.TestFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class CartPage {

    private static final Logger logger = LogManager.getLogger(CartPage.class);

    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//div[@id='shopping_cart_container']")
    private WebElement btnShoppingcart;

    @FindBy(how = How.XPATH, using = "//button[@id='checkout']")
    private WebElement btnCheckout;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        org.openqa.selenium.support.PageFactory.initElements(driver, this);
    }

    public void selectCart() {
        try {
            TestFactory.clickElement(driver,btnShoppingcart);
            logger.info("Info - The Cart has been selected");
            System.out.println("The Cart has been selected");
        } catch (Exception e) {
            throw new RuntimeException("The exception displayed is "+e);
        }
    }

    public void clickCheckout() {
        try {
            TestFactory.clickElement(driver,btnCheckout);
            System.out.println("The Checkout button has been selected");
            logger.info("The Checkout button has been selected");
        } catch (Exception e) {
            throw new RuntimeException("The exception displayed is "+e);
        }
    }

    public void verifyCart(String product) {
        try {
            WebElement prod = driver.findElement(By.xpath("//div[text()='"+product+"']"));
           String data = TestFactory.gettext(prod);
           if(data.equalsIgnoreCase(product))
           {
               System.out.println("The Product displayed in the cart is "+product);
               logger.info("The Product displayed in the cart is "+product);
           }
        } catch (Exception e) {
            throw new RuntimeException("The exception displayed is "+e);
        }
    }

}