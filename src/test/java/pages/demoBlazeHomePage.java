package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class demoBlazeHomePage {

    private static WebElement element = null;
    private static List<WebElement> elements = null;

    public static WebElement signUpButton(WebDriver driver) {
        element = driver.findElement(By.id("signin2"));
        return element;
    }

    public static WebElement signUpUsernameField(WebDriver driver) {
        element = driver.findElement(By.id("sign-username"));
        return element;
    }

    public static WebElement signUpPasswordField(WebDriver driver) {
        element = driver.findElement(By.id("sign-password"));
        return element;
    }

    public static WebElement signUpSubmitButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[contains(@class, 'btn btn-primary')][ text() = 'Sign up' ]"));
        return element;
    }

    public static WebElement loginButton(WebDriver driver) {
        element = driver.findElement(By.id("login2"));
        return element;
    }

    public static WebElement loginUsernameField(WebDriver driver) {
        element = driver.findElement(By.id("loginusername"));
        return element;
    }

    public static WebElement loginPasswordField(WebDriver driver) {
        element = driver.findElement(By.id("loginpassword"));
        return element;
    }

    public static WebElement loginSubmitButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[contains(@class, 'btn btn-primary')][ text() = 'Log in' ]"));
        return element;
    }

    public static WebElement welcomeExistingUserButton(WebDriver driver) {
        element = driver.findElement(By.id("nameofuser"));
        return element;
    }

    public static WebElement logoutButton(WebDriver driver) {
        element = driver.findElement(By.id("logout2"));
        return element;
    }

    public static WebElement itemToBuy(WebDriver driver, String name) {
        element = driver.findElement(By.xpath("//*[contains(@class, 'card-title')]//*[ text() = '" + name + "' ]"));
        return element;
    }

    public static WebElement itemToBuyPrice(WebDriver driver, String name) {
        element = driver.findElement(By.xpath("//*[contains(@class, 'card-title')]//*[ text() = '" + name + "' ]/parent::*/parent::*/h5"));
        return element;
    }

    public static WebElement addToCartButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[contains(@class, 'btn btn-success btn-lg')][ text() = 'Add to cart' ]"));
        return element;
    }


    public static WebElement cartButton(WebDriver driver) {
        element = driver.findElement(By.id("cartur"));
        return element;
    }

    public static WebElement itemCategoryToChooseFrom(WebDriver driver, String category) {
        element = driver.findElement(By.xpath("//*[@onclick=\"byCat('" + category + "')\"]"));
        return element;
    }

//    public static WebElement notebookCategory(WebDriver driver) {
//        element = driver.findElement(By.xpath("//*[@onclick=\"byCat('notebook')\"]"));
//        return element;
//    }
//
//    public static WebElement monitorCategory(WebDriver driver) {
//        element = driver.findElement(By.xpath("//*[@onclick=\"byCat('monitor')\"]"));
//        return element;
//    }

}
