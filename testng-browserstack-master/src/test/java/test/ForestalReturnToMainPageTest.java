package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.ForestalHomePage;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ForestalReturnToMainPageTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void initializeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
    }

    @Test
    void returnToMainPage() throws InterruptedException {
        String pageUrl =
                new ForestalHomePage(driver).openPage()
                        .acceptCookies()
                        .openAryonSCPage()
                        .goToMainPage()
                        .getPageUrl();

        System.out.println(pageUrl);
        assertThat(pageUrl, is("https://forestal.com/en/home"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
        driver.quit();
        driver = null;
    }
}
