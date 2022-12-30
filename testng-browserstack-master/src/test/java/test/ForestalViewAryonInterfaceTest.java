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

public class ForestalViewAryonInterfaceTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void initializeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
    }

    @Test
    void openHydraPage(){
        String text =
                new ForestalHomePage(driver).openPage()
                        .acceptCookies()
                        .openAryonPage()
                        .viewInterface()
                        .getInterfaceHeader();

        assertThat(text, is("Interface"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
        driver.quit();
        driver = null;
    }
}
