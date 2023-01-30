package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import managers.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Log;


import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static pages.demoBlazeLoginPage.*;
import static pages.demoBlazeCartPage.*;
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

    @Given("the user is doing a login with the username {string} and password {string}")
    public void the_user_is_doing_a_login_with_the_username_and_password(String username, String password) {
        loginButton(driver).click();

        loginUsernameField(driver).sendKeys(username);
        loginPasswordField(driver).sendKeys(password);
        loginSubmitButton(driver).click();
    }

    @Then("the user has logged in successfully")
    public void the_user_has_logged_in_successfully() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout2")));

        Assert.assertTrue(logoutButton(driver).isDisplayed());
    }

    @Then("the login failed with error {string}")
    public void the_login_failed_with_error(String msg) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        Assert.assertEquals(msg, alertMessage);
        alert.accept();
    }

    @Given("the user is adding item called {string} to cart")
    public void the_user_is_adding_item_called_to_cart(String item) {
        itemToBuy(driver, item).click();
        addToCartButton(driver).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        Assert.assertEquals("Product added", alertMessage);
        alert.accept();
    }

    @Then("the user checks if the item {string} is in the cart")
    public void the_user_checks_if_the_item_is_in_the_cart(String item) {
        cartButton(driver).click();
        ArrayList<String> cart = new ArrayList<>();
        for (WebElement cartItem : cartTitles(driver)) {
            cart.add(cartItem.getText());
            Log.info("Cart item: " + cartItem.getText());
        }

        Assert.assertTrue(cart.contains(item));
    }

    @Then("the user is placing an order with the required fields {string}, {string}, {string}, {string}, {int} and {int}")
    public void the_user_is_placing_an_order_with_the_required_fields_and(String name, String country, String city, String creditCard, int month, int year) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBe(By.tagName("h2"), "Products"));



        //check we are on the Products page
        Assert.assertTrue(placeOrderButton(driver).isDisplayed());

        placeOrderButton(driver).click();

        placeOrderName(driver).sendKeys(name);
        placeOrderCountry(driver).sendKeys(country);
        placeOrderCity(driver).sendKeys(city);
        placeOrderCreditCard(driver).sendKeys(creditCard);
        placeOrderMonth(driver).sendKeys(String.valueOf(month));
        placeOrderYear(driver).sendKeys(String.valueOf(year));

        purchase(driver).click();

        String purchaseMessage = thankYouForPurchaseDialog(driver).getText();
        Log.info(purchaseMessage);

        Assert.assertTrue(purchaseMessage.contains("Id:"));
        Assert.assertTrue(purchaseMessage.contains("Amount"));
        Assert.assertTrue(purchaseMessage.contains("Card Number: " + creditCard));
        Assert.assertTrue(purchaseMessage.contains("Name: " + name));
        Assert.assertTrue(purchaseMessage.contains(month + "/" + year));

    }

}
