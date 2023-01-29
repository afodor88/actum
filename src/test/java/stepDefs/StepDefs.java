package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import managers.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Log;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static pages.demoBlazeLoginPage.*;
import static utility.RandomString.*;


public class StepDefs {

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
    public void tearDown() {
        Log.info("Closing browser and clearing cache");
        driver.manage().deleteAllCookies();
        driver.quit();
        driver = null;
    }

    @Given("the user navigates to {string}")
    public void the_user_navigates_to(String url) {
        driver.get(url);
        Log.info(driver.getTitle());
        Assert.assertEquals("STORE", driver.getTitle());
    }

    @And("the user is signing up with the user {string} and password {string}")
    public void the_user_is_signing_up_with_the_user_and_password(String username, String password) {
        signUpButton(driver).click();

        signUpUsernameField(driver).sendKeys(username);
        signUpPasswordField(driver).sendKeys(password);
        signUpSubmitButton(driver).click();


    }

    @Then("the sign up was successful")
    public void the_sign_up_was_successful() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        Assert.assertEquals("Sign up successful.", alertMessage);
        alert.accept();

    }


    @Given("the user is signing up with a random username and password")
    public void the_user_is_signing_up_with_a_random_username_and_password() {
        String username = getAlphaNumericString(10);
        String password = getAlphaNumericString(10);

        Log.info("Random user used for sign up " + username);
        Log.info("Random password used for sign up " + password);
        signUpButton(driver).click();
        signUpUsernameField(driver).sendKeys(username);
        signUpPasswordField(driver).sendKeys(password);
        signUpSubmitButton(driver).click();

    }

    @Then("the sign up failed with error {string}")
    public void the_sign_up_failed_with_error(String msg) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        Assert.assertEquals(msg, alertMessage);
        alert.accept();
    }

}
