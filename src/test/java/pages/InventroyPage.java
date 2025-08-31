package pages;

import core.TestFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.testng.Assert.assertEquals;


public class InventroyPage {

    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//div[text()='Sauce Labs Bike Light']/ancestor::div[1]/following-sibling::div//button[text()='ADD TO CART']")
    private WebElement btnAddtoCart;

    @FindBy(id = "//div[@id='shopping_cart_container']")
    private WebElement btnShoppingcart;


    public InventroyPage(WebDriver driver) {
        this.driver = driver;
        org.openqa.selenium.support.PageFactory.initElements(driver, this);
    }

    public void selectProduct(String product) {
        try {
            WebElement prod = driver.findElement(By.xpath("//div[text()='"+product+"']/ancestor::div[1]/following-sibling::div//button[text()='Add to cart']"));
            TestFactory.clickElement(driver,prod);
            System.out.println("The Product which has been selected is "+product);
        } catch (Exception e) {
            throw new RuntimeException("The exception displayed is "+e);
        }
    }

    public void selectCart() {
        try {
            TestFactory.clickElement(driver,btnShoppingcart);
            System.out.println("The Cart has been selected");
        } catch (Exception e) {
            throw new RuntimeException("The exception displayed is "+e);
        }
    }

}