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

}
