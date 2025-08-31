package pages;

import core.TestFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class CheckoutPage {

    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@id='first-name']")
    private WebElement txtFirstName;

    @FindBy(how = How.XPATH, using = "//input[@id='last-name']")
    private WebElement txtLastName;

    @FindBy(how = How.XPATH, using = "//input[@id='postal-code']")
    private WebElement txtPostalCode;

    @FindBy(how = How.XPATH, using = "//input[@id='continue']")
    private WebElement btnContinue;

    @FindBy(how = How.XPATH, using = "//button[@id='finish']")
    private WebElement btnFinish;



    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        org.openqa.selenium.support.PageFactory.initElements(driver, this);
    }

    public void checkoutForm(String firstname, String lastName, String postcode) {
        try {
            TestFactory.writeText(txtFirstName,firstname);
            TestFactory.writeText(txtLastName,lastName);
            TestFactory.writeText(txtPostalCode,postcode);
            System.out.println("The Firstname, Lastname and Postalcode has been entered"+firstname +lastName +postcode);
        } catch (Exception e) {
            throw new RuntimeException("The exception displayed is "+e);
        }
    }

    public void clickContinue() {
        try {
            TestFactory.clickElement(driver,btnContinue);
            System.out.println("The Continue button has been selected");
        } catch (Exception e) {
            throw new RuntimeException("The exception displayed is "+e);
        }
    }

    public void clickFinish() {
        try {
            TestFactory.clickElement(driver,btnFinish);
            System.out.println("The Finish button has been clicked");
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
           }
        } catch (Exception e) {
            throw new RuntimeException("The exception displayed is "+e);
        }
    }

}