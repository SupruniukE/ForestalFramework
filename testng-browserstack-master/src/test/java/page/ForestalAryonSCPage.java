package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForestalAryonSCPage extends AbstractPage{
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/header/div/div[2]/a")
    private WebElement forestslButton;

    public ForestalAryonSCPage(WebDriver driver) {
        super(driver);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public ForestalHomePage goToMainPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.visibilityOf(forestslButton)).click();
        return new ForestalHomePage(driver);
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("Not needed for this page");
    }
}
