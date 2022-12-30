package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class DriverSingleton {

    static String username = System.getenv("BROWSERSTACK_USERNAME");
    static String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
    static String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
    static String local = System.getenv("BROWSERSTACK_LOCAL");
    static String localIdentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");

    static DesiredCapabilities capabilities = new DesiredCapabilities();
    static HashMap<String, Object> browserstackOptions = new HashMap<>();

    static WebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() throws MalformedURLException {
        capabilities.setCapability("browserName", "Chrome");
        browserstackOptions.put("os", "Windows");
        browserstackOptions.put("osVersion", "10");
        browserstackOptions.put("sessionName", "BStack Build Name: " + buildName);
        browserstackOptions.put("local", local);
        browserstackOptions.put("localIdentifier", localIdentifier);
        browserstackOptions.put("seleniumVersion", "4.0.0");
        capabilities.setCapability("bstack:options", browserstackOptions);
        driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
