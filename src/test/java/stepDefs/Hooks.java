package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Log;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup() {

        Log.info("Setting up webdriver settings...");
        //set DriverManager
        driver = DriverManager.getDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws InterruptedException {
        Log.info("Closing browser and clearing cache");
        driver.manage().deleteAllCookies();
        driver.quit();
        driver = null;
    }
}
