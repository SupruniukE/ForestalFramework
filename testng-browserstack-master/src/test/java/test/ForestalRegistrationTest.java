package test;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.ForestalHomePage;
import service.UserCreator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ForestalRegistrationTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void initializeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
    }

    @Test
    void registerNewUser(){
        User user = UserCreator.withStandardUsername();
        String pageUrl =
                new ForestalHomePage(driver).openPage()
                        .acceptCookies()
                        .openLoginPage()
                        .openRegisterPage()
                        .fillInputs(user)
                        .openProfilePage()
                        .getPageUrl();

        assertThat(pageUrl, is("https://forestal.com/en/profile"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
        driver.quit();
        driver = null;
    }
}
