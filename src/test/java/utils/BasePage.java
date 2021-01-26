package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BasePage {
    // ThreadLocal will be used for parameterized testing
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();
    // constructor
    public BasePage(){}
    // to use different browsers
    // get method
    public static WebDriver get(){
        if (driverPool.get() == null) {
            String browserParamFromEnv = System.getProperty("browser");
            String browser = browserParamFromEnv == null ? ConfigReader.getProperty("browser") : browserParamFromEnv;
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    break;
                case "chrome headless":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true))); // ****
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                case "firefox headless":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
                    break;
                default:
                    // if we try to use another browser this will throw exception:
                    throw new RuntimeException("Invalid browser name..!");
            }
        }
        return driverPool.get();
    }
    public static void closeBrowser(){
        driverPool.get().quit();
        driverPool.remove(); // removes all browser instances
    }
}
