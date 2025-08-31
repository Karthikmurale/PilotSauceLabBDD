package core;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class TestFactory {

   /* WebDriver driver;

    public TestFactory(WebDriver driver) {
      this.driver = driver;
    }*/

        public static void writeText(WebElement element, String text) {
            try {
                if (element != null && text != null) {
                    element.clear();
                    element.sendKeys(text);
                } else {
                    throw new IllegalArgumentException("Element or text cannot be null");
                }
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(e);
            }
        }

    public static void clickElement(WebDriver driver, WebElement element) throws InterruptedException {
        if (element != null) {
         /*   JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);*/
            element.click();
            Thread.sleep(4000); // Adding a sleep to ensure the click is registered

        } else {
            throw new IllegalArgumentException("Element or text cannot be null");
        }
    }

    public static String gettext(WebElement element) {
        try {
            if (element != null) {
                return element.getText();
            } else {
                throw new IllegalArgumentException("Element cannot be null");
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

}