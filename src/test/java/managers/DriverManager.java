package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    public static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
//            String projectPath = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        }
        return driver;
    }
}
