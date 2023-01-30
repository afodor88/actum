package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class demoBlazeCartPage {

    private static WebElement element = null;
    private static List<WebElement> elements = null;

    public static List<WebElement> cartTitles(WebDriver driver) {
        elements = driver.findElements(By.xpath("//*[contains(@class, 'table table-bordered table-hover table-striped')]//td[2]"));
        return elements;
    }

    public static WebElement placeOrderButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[contains(@class, 'btn btn-success')][ text() = 'Place Order' ]"));
        return element;
    }

    public static WebElement placeOrderName(WebDriver driver) {
        element = driver.findElement(By.id("name"));
        return element;
    }

    public static WebElement placeOrderCountry(WebDriver driver) {
        element = driver.findElement(By.id("country"));
        return element;
    }

    public static WebElement placeOrderCity(WebDriver driver) {
        element = driver.findElement(By.id("city"));
        return element;
    }

    public static WebElement placeOrderCreditCard(WebDriver driver) {
        element = driver.findElement(By.id("card"));
        return element;
    }

    public static WebElement placeOrderMonth(WebDriver driver) {
        element = driver.findElement(By.id("month"));
        return element;
    }

    public static WebElement placeOrderYear(WebDriver driver) {
        element = driver.findElement(By.id("year"));
        return element;
    }

    public static WebElement purchase(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[contains(@class, 'btn btn-primary')][ text() = 'Purchase' ]"));
        return element;
    }

    public static WebElement thankYouForPurchaseDialog(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[contains(@class, 'sweet-alert  showSweetAlert visible')]"));
        return element;
    }

}
