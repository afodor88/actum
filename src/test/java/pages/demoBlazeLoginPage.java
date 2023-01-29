package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class demoBlazeLoginPage {

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
}
