package pages;

import core.TestFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.testng.Assert.assertEquals;


public class LoginPage {

    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//div[@class='login_logo']")
    private WebElement logoText;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement pwd;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//span[text()='Products']")
    private WebElement txtProducts;




    public LoginPage(WebDriver driver) {
        this.driver = driver;
        org.openqa.selenium.support.PageFactory.initElements(driver, this);
    }

    public void enterUserNamePassword(String username,String password) {
        try {
            TestFactory.writeText(userName, username);
            TestFactory.writeText(pwd, password);
            System.out.println("Username and password entered: " + username + ", " + password);
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter username & Password: " + e.getMessage());
        }
    }

    public void clickLoginButton() {
        try {
            TestFactory.clickElement(driver, loginButton);
        } catch (Exception e) {
            throw new RuntimeException("Failed to click login button: " + e.getMessage());
        }
    }


    public void VerifyLogin()
    {
        try{
           String WebName =  TestFactory.gettext(logoText);
            System.out.println("Pass - The Logo text displayed is "+WebName);
           assertEquals("Swag Labs", WebName, "Login verification Passed");
        }
        catch(Exception e)
        {
            throw new RuntimeException("Login verification failed: " + e.getMessage());
        }

    }

    public void VerifyHomePage()
    {
        try{
            String txtHomepage =  TestFactory.gettext(txtProducts);
            assertEquals("Products", txtHomepage, "Homepage verification Passed");
            System.out.println("Pass - Homepage displayed as expected");
        }
        catch(Exception e)
        {
            throw new RuntimeException("Login verification failed: " + e.getMessage());
        }

    }


}